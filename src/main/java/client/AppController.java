package client;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Graham Perry on 18/04/16.
 */
public class AppController implements Initializable {
    private static final Logger logger = LogManager.getLogger(AppController.class);
    @FXML
    private TabPane content;
    @FXML
    private TitledPane dsPane;
    @FXML
    private TitledPane cvPane;
    @FXML
    private TitledPane trPane;
    @FXML
    private Accordion sidebar;

    @Override
    public void initialize(URL url, ResourceBundle resource) {
        assert dsPane != null : "dsPane has not been loaded";
        assert cvPane != null : "cvPane has not been loaded";
        assert trPane != null : "trPane has not been loaded";
        assert sidebar != null : "sidebar has not been loaded";
        assert content != null : "content has not been loaded";

        sidebar.setExpandedPane(cvPane);
        this.content.getSelectionModel().clearSelection();
        // By default, select first tab and load its content.
        this.content.getSelectionModel().selectFirst();


        dsPane.setContent(getDataSidebar());
        cvPane.setContent(getConvSidebar());
        trPane.setContent(getTrainSidebar());


    }

    //set up sidebar menus
    private VBox getDataSidebar(){
        VBox configItems = new VBox();
        SidebarItem item1 = new SidebarItem(this, "SDSS Training Data", "/fxml/TrainingData.fxml");
        SidebarItem item2 = new SidebarItem(this, "SDSS Object Data", "/fxml/ObjectData.fxml");
        SidebarItem item3 = new SidebarItem(this, "SDSS Image Fetcher", "/fxml/ImageFetcher.fxml");
        configItems.getChildren().addAll(item1,item2,item3);
        return configItems;
    }
    private VBox getConvSidebar(){
        VBox configItems = new VBox();
        SidebarItem item1 = new SidebarItem(this, "Design View", "/fxml/CnnConfig.fxml");
        configItems.getChildren().addAll(item1);
        return configItems;
    }
    private VBox getTrainSidebar(){
        VBox configItems = new VBox();
        SidebarItem item1 = new SidebarItem(this, "Training Setup", "/fxml/TrainingSetup.fxml");
        configItems.getChildren().addAll(item1);
        return configItems;
    }

    //add tabs to content area
    public void addTab(String title, Parent content) {
        Tab tab = new Tab(title, content);
        this.content.getTabs().add(tab);
        this.content.getSelectionModel().select(tab);

    }

}
