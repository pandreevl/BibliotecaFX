package bibliotecafx.helpers;

import bibliotecafx.MainApp;
import bibliotecafx.models.Biblotecario;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.util.Callback;

/**
 *
 * @author Admin
 */
public class Dialogs {

    public static Alert getDialog(Alert.AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        return alert;
    }

    public static Alert getErrorDialog(AlertType type, String title, String header, String content, Exception ex) {
        Alert alert = Dialogs.getDialog(type, title, header, content);
        String textoDeError = ex.getMessage();

        Label label = new Label("El error es:");

        TextArea textArea = new TextArea(textoDeError);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContenido = new GridPane();
        expContenido.setMaxWidth(Double.MAX_VALUE);
        expContenido.add(label, 0, 0);
        expContenido.add(textArea, 0, 1);

        alert.getDialogPane().setExpandableContent(expContenido);

        return alert;
    }

    public static Dialog getLoginDialog() {
    Dialog<Biblotecario> dialog = new Dialog();
        dialog.setTitle("Iniciar Sesión");
        dialog.setHeaderText("Bienvenido\nPor favor ingresa tus credenciales de autenticacion");

//        ImageView imageLogin = new ImageView(MainApp.class.getResource("resources/images/login.png").toString());
//        imageLogin.setFitHeight(100.0);
//        imageLogin.setFitWidth(100.0);
//        dialog.setGraphic(imageLogin);

        ButtonType loginButtonType = new ButtonType("Iniciar", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Usuario");
        PasswordField password = new PasswordField();
        password.setPromptText("Contraseña");

        grid.add(new Label("Usuario"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Contraseña"), 0, 1);
        grid.add(password, 1, 1);

        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

        username.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                loginButton.setDisable(newValue.trim().isEmpty());
            }

        });

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(new Callback<ButtonType, Biblotecario>() {

            @Override
            public Biblotecario call(ButtonType param) {
                if (param == loginButtonType) {
                    return new Biblotecario(username.getText(), password.getText());
                }
                return null;
            }

        });
        username.requestFocus();

        return dialog;
    }
}
