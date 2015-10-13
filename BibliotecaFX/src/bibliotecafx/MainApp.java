/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecafx;

import java.sql.SQLException;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import bibliotecafx.helpers.DBHelper;
import bibliotecafx.models.Biblotecario;
import bibliotecafx.helpers.Dialogs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Pablo
 */
public class MainApp extends Application {

    private Biblotecario biblotecarioAutenticado;

    @Override
    public void start(Stage primaryStage) {
        mostrarLogin();
        StackPane root = new StackPane();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void mostrarLogin() {
        boolean loginExitoso = false;
        do {
            Dialog login = Dialogs.getLoginDialog();
            Optional<Biblotecario> result = login.showAndWait();
            if (result.equals(Optional.empty())) {
                System.exit(0);
            } else if (result.isPresent()) {
                biblotecarioAutenticado = result.get();

                if (biblotecarioAutenticado.getContasena().length() > 0) {
                    DBHelper.setMainApp(this);
                    try {
                        if (!DBHelper.getConnection().isClosed() && getBiblotecarioLogin(biblotecarioAutenticado.getNombre(), biblotecarioAutenticado.getContasena()) == true) {
                            loginExitoso = true;
                            Alert welcome = Dialogs.getDialog(Alert.AlertType.INFORMATION, "Login", null, "Bienvenido al sistema " + biblotecarioAutenticado.getNombre());
                            welcome.showAndWait();
                        } else {
                            loginExitoso = false;
                        }
                    } catch (ClassNotFoundException | SQLException ex) {
                        Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Login", null, "Error al establecer una conexion a la base de datos", ex);
                        error.showAndWait();
                    }
                } else {
                    Alert error = Dialogs.getDialog(Alert.AlertType.ERROR, "Login", null, "Datos incorrectos, debe ingresar una contraseña");
                    error.showAndWait();
                }
            }
        } while (loginExitoso == false);
    }

    public Biblotecario getBiblotecarioAutenticado() {
        return biblotecarioAutenticado;
    }

    public boolean getBiblotecarioLogin(String userName, String password) {
        String sql = "SELECT * FROM Biblotecario"
                + " WHERE nombre = '" + userName + "'";
        try {
            Connection con = DBHelper.getConnection();
            PreparedStatement queryStatement = con.prepareStatement(sql);
            ResultSet rs = queryStatement.executeQuery();

            while (rs.next()) {
                if (rs.getString("contrasena").equals(password)) {
                    return true;
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Bibloteca", "Error", "Usuario y/o contraseña no validos!", ex);
            error.showAndWait();
            return false;
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
