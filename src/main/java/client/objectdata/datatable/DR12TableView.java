package client.objectdata.datatable;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.datasources.Dr12;
import util.JavaFXUtils;

import java.net.URL;
import java.util.ResourceBundle;


public class DR12TableView extends TableView<Dr12> implements Initializable {
    @FXML
    private TableColumn<Dr12, String> idCol;
    @FXML
    private TableColumn<Dr12, String> raCol;
    @FXML
    private TableColumn<Dr12, String> decCol;
    @FXML
    private TableColumn<Dr12, String> sizeCol;
    private ObservableList data;


    public DR12TableView() {
        URL fxml = getClass().getResource("/fxml/table.fxml");
        JavaFXUtils.loadFxml(fxml, this);

    }

    @Override
    public void initialize(URL url, ResourceBundle resource) {
        //   DataManager mgr = new DataManager(Dr12.class);
//        data = mgr.observableList();
//        this.setEditable(true);
//
//        idCol.setMinWidth(200);
//        raCol.setMinWidth(200);
//        decCol.setMinWidth(200);
//        sizeCol.setMinWidth(200);
//        idCol.setCellValueFactory(
//                new PropertyValueFactory<Dr12, String>("objid"));
//        raCol.setCellValueFactory(
//                new PropertyValueFactory<Dr12, String>("ra"));
//        decCol.setCellValueFactory(
//                new PropertyValueFactory<Dr12, String>("decl"));
//        sizeCol.setCellValueFactory(
//                new PropertyValueFactory<Dr12, String>("size"));
//        this.setItems(data);
    }


}