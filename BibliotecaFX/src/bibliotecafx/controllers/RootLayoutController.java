/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecafx.controllers;

import bibliotecafx.MainApp;
import bibliotecafx.models.Book;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Usuario
 */
public class RootLayoutController {
    private MainApp mainApp;
    @FXML
    public TableView<Book> tbvBooks;
    @FXML
    public TableColumn<Book, String> tbcISBN;
    @FXML
    public TableColumn<Book, String> tbcName;
   
    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
        tbvBooks.setItems(mainApp.getBookList());
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        tbcISBN.setCellValueFactory(new PropertyValueFactory<Book, String>("ISBN"));
        tbcName.setCellValueFactory(new PropertyValueFactory<Book, String>("Name"));

        tbvBooks.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        
    }
            
}
