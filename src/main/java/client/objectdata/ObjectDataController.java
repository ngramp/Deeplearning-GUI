package client.objectdata;

import client.objectdata.datatable.DR12TableView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by gram on 22/03/16.
 */
public class ObjectDataController implements Initializable {
    private static final Logger logger = LogManager.getLogger(ObjectDataController.class);
    @FXML
    private ScrollPane objectData;

    public ObjectDataController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resource) {
        objectData.setContent(new DR12TableView());
    }
}
