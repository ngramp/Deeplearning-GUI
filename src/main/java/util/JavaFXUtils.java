package util;

import javafx.fxml.FXMLLoader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

/**
 * Created by gram on 27/03/16.
 */
public class JavaFXUtils {
    private static final Logger logger = LogManager.getLogger(JavaFXUtils.class);

    public static void loadFxml(URL fxml, Object context) {

        FXMLLoader fxmlLoader = new FXMLLoader(fxml);
        fxmlLoader.setRoot(context);
        //do not set controller in client.fxml as it creates stack overflow with this pattern.
        fxmlLoader.setController(context);

        try {
            fxmlLoader.load();

        } catch (FileNotFoundException exception) {
            logger.fatal("Failed to find file :" + fxml.toString());
            throw new RuntimeException(exception);
        } catch (IOException exception) {
            logger.fatal("Failed to load fxml in :" + fxml.toString() + " due to " + exception.getCause());
            throw new RuntimeException(exception);
        }
    }
}
