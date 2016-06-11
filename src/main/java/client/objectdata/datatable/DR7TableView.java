package client.objectdata.datatable;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.datasources.Dr7Gz;
import util.JavaFXUtils;

import java.net.URL;
import java.util.ResourceBundle;


public class DR7TableView extends TableView<Dr7Gz> implements Initializable {
    @FXML
    private TableColumn<Dr7Gz, String> idCol;
    @FXML
    private TableColumn<Dr7Gz, String> raCol;
    @FXML
    private TableColumn<Dr7Gz, String> decCol;
    @FXML
    private TableColumn<Dr7Gz, String> sizeCol;
    private ObservableList data;


    public DR7TableView() {
        URL fxml = getClass().getResource("/fxml/table.fxml");
        JavaFXUtils.loadFxml(fxml, this);

    }

    @Override
    public void initialize(URL url, ResourceBundle resource) {
        //    DataManager mgr = new DataManager(Dr7Gz.class);
//        data = mgr.observableList();
//        this.setEditable(true);
//
//        idCol.setMinWidth(200);
//        raCol.setMinWidth(200);
//        decCol.setMinWidth(200);
//        sizeCol.setMinWidth(200);
//        idCol.setCellValueFactory(
//                new PropertyValueFactory<Dr7Gz, String>("objid"));
//        raCol.setCellValueFactory(
//                new PropertyValueFactory<Dr7Gz, String>("ra"));
//        decCol.setCellValueFactory(
//                new PropertyValueFactory<Dr7Gz, String>("decl"));
//        sizeCol.setCellValueFactory(
//                new PropertyValueFactory<Dr7Gz, String>("size"));
//        this.setItems(data);
    }


}