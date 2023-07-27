package migman.proyectomiguel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalControler{

    @FXML public void MB_Registrar(ActionEvent actionEvent) throws IOException {
        Utilidad.abrirVentana(actionEvent,"RegistrarProducto.fxml","Registrar Producto");
    }

    @FXML public void MB_Inventario(ActionEvent actionEvent) throws IOException {
        Utilidad.abrirVentana(actionEvent,"Reporte.fxml","Reporte");
    }
}
