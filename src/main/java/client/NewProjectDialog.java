package client;

import javafx.fxml.Initializable;
import javafx.scene.control.TitledPane;
import util.JavaFXUtils;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by gram on 23/03/16.
 */
public class NewProjectDialog extends TitledPane implements Initializable {
    public NewProjectDialog() {
        URL fxml = getClass().getResource("/NewProjectDialog.client.fxml");
        JavaFXUtils.loadFxml(fxml, this);

    }

    @Override
    public void initialize(URL url, ResourceBundle resource) {

    }
}
