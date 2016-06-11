package client.imagefetcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class ImageFetcherView extends Application {
    private static final Logger logger = LogManager.getLogger(ImageFetcherView.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        LogManager.getRootLogger().setLevel(Level.ALL);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        logger.trace("Starting client application");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ImageFetcher.fxml"));
        primaryStage.setTitle("SDSS Image Fetcher");
        Scene scene = new Scene(root, 1000, 800);
        primaryStage.setScene(scene);
        //primaryStage.setMaximized(true);
        primaryStage.show();

    }
}
