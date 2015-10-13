/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecafx.models;

import bibliotecafx.helpers.DBHelper;
import bibliotecafx.helpers.Dialogs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author Pablo
 */
public class Book {

    private int idLibro;
    private int ISBN;
    private int idAutor;
    private int Precio;
    private String Nombre;
    private String Editorial;
    private String Genero;

    public Book(int idLibro, int ISBN, int idAutor, int Precio, String Nombre, String Editorial, String Genero) {
        this.idLibro = idLibro;
        this.ISBN = ISBN;
        this.idAutor = idAutor;
        this.Precio = Precio;
        this.Nombre = Nombre;
        this.Editorial = Editorial;
        this.Genero = Genero;
    }

    public Book() {

    }

    public static ObservableList<Book> getBookList() throws SQLException {
        ObservableList<Book> books = FXCollections.observableArrayList();

        try {
            Connection con = DBHelper.getConnection();
            String sql = "SELECT L.idLIbro, L.ISBN, L.NOMBRE, L.idAutor, L.Editorial, L. precio, L.genero"
                    + " FROM Libro AS L";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                Book book = new Book();

                book.setIdLibro(rs.getInt("idLibro"));
                book.setNombre(rs.getString("nombre"));
                book.setISBN(rs.getInt("ISBN"));
                book.setIdAutor(rs.getInt("idAutor"));
                book.setEditorial(rs.getString("Editorial"));
                book.setGenero(rs.getString("genero"));
                book.setPrecio(rs.getInt("precio"));
                books.add(book);
            }
        } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", "Error", "Al obtener la lista de Usuarios", e);
            error.showAndWait();
        }

        return books;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }
    
    public static boolean inputBook(Book newBook){
        
        String insertSQL =  "INSERT INTO Libro (ISBN, Nombre, idAutor, Editorial, Genero, Precio)"
                + "VALUES (?, ?, ?, ?, ?, ?) ";
        try{
            PreparedStatement insertStatement = DBHelper.getConnection().prepareStatement(insertSQL);
            
            insertStatement.setString(1, Integer.toString(newBook.getISBN()));
            insertStatement.setString(2, (newBook.getNombre()));
            insertStatement.setString(3, Integer.toString(newBook.getIdAutor()));
            insertStatement.setString(4, newBook.getEditorial());
            insertStatement.setString(5, newBook.getGenero());
            insertStatement.setString(6, Integer.toString(newBook.getPrecio()));
            
            insertStatement.executeUpdate();
            DBHelper.getConnection().commit();
            
        }catch( SQLException | ClassNotFoundException ex){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Cine", "Error al insertar una pelicula", ex.toString(), ex);
            error.showAndWait();
            return false;
        }
        return true;
    }

    public static boolean deleteBook(Book book) {
        String deleteSQL = "DELETE FROM Libro "
                + "WHERE idLibro = ?";
        try {
            PreparedStatement deleteStatement = DBHelper.getConnection().prepareStatement(deleteSQL);
            deleteStatement.setString(1, Integer.toString(book.getIdLibro()));

            deleteStatement.executeUpdate();
            //DBHelper.getConnection().commit();

        } catch (SQLException | ClassNotFoundException ex) {
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", "Error al eliminar el libro", ex.getMessage(), ex);
            error.showAndWait();
            return false;
        }
        return true;
    }

    public static boolean updateBook(Book newBook) {
        String updateSQL = "UPDATE Libro"
                + " SET ISBN = ? , Nombre = ?, Editorial = ?, Genero = ?, idAutor = ?, precio = ? "
                + "WHERE idLibro = ?";

        try {
            PreparedStatement updateStatement = DBHelper.getConnection().prepareStatement(updateSQL);
            updateStatement.setString(1, Integer.toString(newBook.getISBN()));
            updateStatement.setString(2, (newBook.getNombre()));
            updateStatement.setString(3, newBook.getEditorial());
            updateStatement.setString(4, newBook.getGenero());
            updateStatement.setString(5, Integer.toString(newBook.getIdAutor()));
            updateStatement.setString(6, Integer.toString(newBook.getPrecio()));
            updateStatement.setString(7, Integer.toString(newBook.getIdLibro()));
            
            updateStatement.executeUpdate();
            DBHelper.getConnection().commit();

        } catch (SQLException | ClassNotFoundException ex) {

            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", "Error al actualizar el Libro", ex.getMessage(), ex);
            error.showAndWait();
            return false;
        }

        return true;
    }

}
