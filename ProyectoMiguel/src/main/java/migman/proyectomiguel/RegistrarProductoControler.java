package migman.proyectomiguel;

import bussinessLogic.InventarioDAO;
import doMain.ProductoTienda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegistrarProductoControler {
    @FXML private TextField tf_Descripcion;
    @FXML private TextField tf_Cantidad;
    @FXML private TextField tf_Costo;

    @FXML
    public void RPB_Regresar(ActionEvent actionEvent) throws IOException {
        Utilidad.regresarMenuPrincipal(actionEvent);
    }

    @FXML
    public void RPB_Registrar(ActionEvent actionEvent) {
        ProductoTienda productotienda= new ProductoTienda();
        InventarioDAO inventarioDAO= new InventarioDAO();

        productotienda.setDescription(tf_Descripcion.getText());
        productotienda.setCantidad(Integer.parseInt(tf_Cantidad.getText()));
        productotienda.setPrecio(Integer.parseInt(tf_Costo.getText()));

        inventarioDAO.agregarProducto(productotienda);
        resetTextField();
    }

    public void resetTextField(){
        tf_Descripcion.setText("");
        tf_Cantidad.setText("");
        tf_Costo.setText("");
    }
}
