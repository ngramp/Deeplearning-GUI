package client.imagefetcher;

import cutoutservices.CutOutClient;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import model.DataImage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import util.DownloadTask;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

/**
 * Created by gram on 22/03/16.
 */
public class ImageFetcherController implements Initializable {
    private static final Logger logger = LogManager.getLogger(ImageFetcherController.class);
    @FXML
    private ScrollPane imageFetcher;
    @FXML
    private Label info;
    @FXML
    private ImageView imageP;
    @FXML
    private RadioButton radioIMG;
    @FXML
    private RadioButton radioFITS;
    @FXML
    private ToggleGroup sourceToggle;
    @FXML
    private ChoiceBox selectIMG;
    @FXML
    private Button openFITS;
    @FXML
    private ComboBox selectFITS;
    @FXML
    private TextField imgHeightText, imgWidthText;
    @FXML
    private TextField savePath;
    @FXML
    private Button openSaveLoc;
    @FXML
    private CheckBox testCheck;
    @FXML
    private Label raLab, declLab, sizeLab;
    @FXML
    private ProgressBar progress;
    @FXML
    private Button stopBut;
    @FXML
    private Button resetBut;
    @FXML
    private Button startBut;
    private File saveLocation;
    private DownloadTask task;
    private Preferences prefs;

    public ImageFetcherController() {
        prefs = Preferences.userRoot().node("com/gc/images");

    }

    @Override
    public void initialize(URL url, ResourceBundle resource) {

        //handle save location
        savePath.setText(prefs.get("savepath", "/media/new/"));
        savePath.setEditable(false);
        saveLocation = new File(savePath.getText());
        openSaveLoc.setOnAction(e -> openFileLocation());

        //handle download tasks
        startBut.setOnAction(e -> startDownload());
        stopBut.setOnAction(e -> stopDownload());
        resetBut.setOnAction(e -> resetDownload());
        openFITS.setOnAction(e -> loadFITSImage());
        //TODO: get compatible img services
        selectIMG.getItems().add("Casjobs DR7");
        selectIMG.setValue(selectIMG.getItems().get(0));

        imgWidthText.setText(Integer.toString(prefs.getInt("imgwidth", 400)));
        imgHeightText.setText(Integer.toString(prefs.getInt("imgheight", 400)));
        //update prefs on change
        imgHeightText.textProperty().addListener((observable, oldValue, newValue) -> {
            prefs.putInt("imgheight", Integer.parseInt(newValue));
        });
        imgWidthText.textProperty().addListener((observable, oldValue, newValue) -> {
            prefs.putInt("imgwidth", Integer.parseInt(newValue));
        });

    }

    private void loadFITSImage() {
    }

    private void openFileLocation() {
        try {
            DirectoryChooser chooser = new DirectoryChooser();
            chooser.setTitle("Select Save Location");
            //TODO:get project base directory
            chooser.setInitialDirectory(new File("/media/"));
            File file = chooser.showDialog(imageFetcher.getScene().getWindow());
            if (file != null) {
                saveLocation = file;
                savePath.setText(file.toPath().toString());
                prefs.put("savepath", savePath.getText());

            }

            return;

        } catch (Exception e) {
            info.setText(e.getMessage());
            e.printStackTrace();
        }

    }

    private void resetDownload() {

    }

    private void stopDownload() {
        task.cancel();
        settingLock(false);

    }

    private void startDownload() {
        System.out.println("fired");
        CutOutClient cutOutClient = new CutOutClient();
        int width = Integer.parseInt(imgWidthText.getText());
        int height = Integer.parseInt(imgHeightText.getText());
        task = new DownloadTask(cutOutClient, saveLocation, width, height);
        //lock UI elements;
        settingLock(true);
        task.getPartialResults().addListener((ListChangeListener<? super DataImage>) (c) -> {
                    while (c.next()) {
                        if (c.wasPermutated()) {
                        } else if (c.wasUpdated()) {
                            //update item
                        } else {
                            for (DataImage remitem : c.getRemoved()) {
                            }
                            for (DataImage additem : c.getAddedSubList()) {
                                imageP.setImage(additem.getImage());
                                raLab.setText(additem.getData().getRa().toString());
                                declLab.setText(additem.getData().getDecl().toString());
                                sizeLab.setText(additem.getData().getSize().toString());
                            }
                        }
                    }
                }
        );
        new Thread(task).start();

    }


    private void settingLock(boolean set) {
        radioIMG.setDisable(set);
        radioFITS.setDisable(set);
        selectIMG.setDisable(set);
        openFITS.setDisable(set);
        selectFITS.setDisable(set);
        imgHeightText.setDisable(set);
        imgWidthText.setDisable(set);
        savePath.setDisable(set);
        openSaveLoc.setDisable(set);
        testCheck.setDisable(set);
        startBut.setDisable(set);

    }


    public void updateImgInfo(Long objid, double ra, double dec, float size, Image image) {
        declLab.setText(Double.toString(dec));
        raLab.setText(Double.toString(ra));
        sizeLab.setText(Float.toString(size));
        info.setText("Got objid " + Long.toString(objid));
        imageP.setImage(image);
    }

}
