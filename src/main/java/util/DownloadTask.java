package util;

import cutoutservices.CutOutClient;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import model.DataImage;
import model.datasources.Dr7Gz;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by gram on 29/03/16.
 */
public class DownloadTask extends Task<ObservableList<DataImage>> {
    private static final Logger logger = LogManager.getLogger(DownloadTask.class);
    private final CutOutClient cutOutClient;
    private final File saveLocation;
    private final int width, height;
    // Uses Java 7 diamond operator
    private ReadOnlyObjectWrapper<ObservableList> partialResults =
            new ReadOnlyObjectWrapper<>(this, "partialResults", FXCollections.observableArrayList());

    public DownloadTask(CutOutClient cutOutClient, File saveLocation, int h, int w) {
        this.cutOutClient = cutOutClient;
        this.saveLocation = saveLocation;
        this.height = h;
        this.width = w;
    }

    public final ObservableList<DataImage> getPartialResults() {
        return partialResults.get();
    }

    public final ReadOnlyObjectProperty partialResultsProperty() {
        return partialResults.getReadOnlyProperty();
    }

    @Override
    public ObservableList<DataImage> call() {

        //TODO:check db available
        //checkDb();
        //TODO:check img service working
        if (saveLocation != null /*&& testIMGService()*/) {
            //iterate over scrollable results
            DataManager mgr = new DataManager(Dr7Gz.class);
            mgr.scrollOverResults(scroll -> {
                while (scroll.next() && !isCancelled()) {
                    final Dr7Gz data = (Dr7Gz) scroll.get()[0];
                    Double ra = data.getRa();
                    Double dec = data.getDecl();
                    Float size = (data.getSize() / (float) 4500) * (float) 206.3; //arcsec/pixel = pixelsize/focal length*206.3 (2.5m telescope)
                    Long objid = data.getObjid();
                    Image image = getImage(ra, dec, size);
                    saveImage(image, Long.toString(objid));
                    //TODO: update progress of Task
                    Platform.runLater(() -> partialResults.get().add(
                            new DataImage(image, data)
                    ));
                }
            });
        }
        //TODO: don't let this list grow
        return partialResults.get();

    }

    private Image getImage(double ra, double dec, float size) {
        Image image = null;
        try {
            //TODO: add error handling
            image = cutOutClient.getImage(ra, dec, size, width, height, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    private void saveImage(Image image, String filename) {
        try {
            File file = new File(saveLocation, filename);
            //fileChooser.showSaveDialog(this.getScene().getWindow());
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(image,
                        null), "jpg", file);
                //TODO: save location to database
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}