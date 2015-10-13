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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    public TableColumn<Book, Integer> tbcISBN;
    @FXML
    public TableColumn<Book, String> tbcName;
    @FXML
    public TableColumn<Book, Integer> tbcAuthor;
    @FXML
    public TableColumn<Book, String> tbcType;
    @FXML
    public TableColumn<Book, Integer> tbcPrice;
    @FXML
    public TableColumn<Book, String> tbcEditorial;
    @FXML
    public TextField txtName;
    @FXML
    public TextField txtISBN;
    @FXML
    public TextField txtAuthor;
    @FXML
    public TextField txtType;
    @FXML
    public TextField txtPrice;
    @FXML
    public TextField txtEditorial;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        cargarListaLibros();
    }

    public void cargarListaLibros() {
        tbvBooks.setItems(mainApp.getBookList());
        tbcISBN.setCellValueFactory(new PropertyValueFactory<Book, Integer>("ISBN"));
        tbcName.setCellValueFactory(new PropertyValueFactory<Book, String>("Nombre"));
        tbcAuthor.setCellValueFactory(new PropertyValueFactory<Book, Integer>("idAutor"));
        tbcEditorial.setCellValueFactory(new PropertyValueFactory<Book, String>("Editorial"));
        tbcType.setCellValueFactory(new PropertyValueFactory<Book, String>("Genero"));
        tbcPrice.setCellValueFactory(new PropertyValueFactory<Book, Integer>("Precio"));

        tbvBooks.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tbvBooks.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Book>() {


            @Override
            public void changed(ObservableValue<? extends Book> observable, Book oldValue, Book newValue) {
                ShowBookDetails(newValue);
            }
        });
    }
    
    public void ShowBookDetails(Book book){
        if (book == null){
            txtName.setText("");
            txtAuthor.setText("");
            txtEditorial.setText("");
            txtISBN.setText("");
            txtType.setText("");
            txtPrice.setText("");
        } else {
            txtName.setText(book.getNombre());
            txtAuthor.setText("" + book.getIdAutor() + "");
            txtEditorial.setText(book.getEditorial());
            txtISBN.setText("" + book.getISBN() + "");
            txtType.setText(book.getGenero());
            txtPrice.setText("" + book.getPrecio() + "");
        }
    }
    
    private void refreshBookList() {
        int selectedIndex = tbvBooks.getSelectionModel().getSelectedIndex();
        tbvBooks.setItems(null);
        tbvBooks.layout();
        tbvBooks.setItems(mainApp.getBookList());
        tbvBooks.getSelectionModel().select(selectedIndex);
    }
    
    @FXML
    public void addToDB(){
        
    }
    
    @FXML
    public void deleteToDB(){
        
    }
    
    @FXML
    public void updateToDB(){
        
    }
            
            
}
