package client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by gram on 23/03/16.
 */
public class SidebarItem extends HBox implements Initializable {
    private static final Logger logger = LogManager.getLogger(SidebarItem.class);
    @FXML
    private Label titleText;
    @FXML
    private Label statusText;
    @FXML
    private Button settings;
//    @FXML
//    private BorderPane app;
//    @FXML
//    private AppController appController;

    private AppController controller;
    private String contentFXML;
    private Status status;
    private String title;


    public SidebarItem(AppController controller, String title, String contentFxml) {
        this.status = Status.NOT_CONFIGURED;
        this.contentFXML = contentFxml;
        this.title = title;
        this.controller = controller;

        URL fxml = getClass().getResource("/fxml/sidebaritem.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxml);
        fxmlLoader.setRoot(this);
        //do not set controller in client.contentFXML as it creates stack overflow with this pattern.
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();

        } catch (FileNotFoundException exception) {
            logger.fatal("Failed to find file :" + contentFXML);
        } catch (IOException exception) {
            logger.fatal("Failed to load FXML in :" + contentFXML+ " due to " + exception.getCause());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resource) {
        //assert appController != null : "it'snull";
        setTitle(title);
        setStatus(status);
        settings.setOnAction(e -> {
            controller.addTab(this.getTitle(),this.getContent());
        });
    }



    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title=title;
        this.titleText.setText(title);
    }

    public String getStatus() {
        return this.status.toString();
    }

    public void setStatus(Status status) {
        this.status = status;
        this.statusText.setText(status.toString());
    }


    public Parent getContent() {
        Parent content = null;
        try {
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(contentFXML));
        content = FXMLLoader.load(getClass().getResource(contentFXML));
        //fxmlLoader.setRoot(context);
        //do not set controller in client.contentFXML as it creates stack overflow with this pattern.
        //fxmlLoader.setController(context);

        } catch (IOException exception) {
            logger.fatal("Failed to load FXML in : " + contentFXML+ " due to " + exception.getCause());
            throw new RuntimeException(exception);
        }
        return content;
    }


}
