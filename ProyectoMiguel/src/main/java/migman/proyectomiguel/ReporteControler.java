package migman.proyectomiguel;

import bussinessLogic.InventarioDAO;
import doMain.ProductoTienda;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class ReporteControler implements Initializable {

    @FXML
    private TableView<ProductoTienda> tb_database;
    @FXML private TableColumn<ProductoTienda, String> tf_descripcion;
    @FXML private TableColumn<ProductoTienda, String> tf_cantidad;
    @FXML private TableColumn<ProductoTienda, String> tf_costo;

    public InventarioDAO inventarioDAO = new InventarioDAO();
    public List<ProductoTienda> productostienda;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            consulta();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void consulta() throws SQLException{
        productostienda=inventarioDAO.generarReporteVentas();
        ObservableList<ProductoTienda> listaProductoTienda= FXCollections.observableArrayList();
        listaProductoTienda.addAll(productostienda);
        configurarElementosTabla(listaProductoTienda);
    }

    public void configurarElementosTabla(ObservableList<ProductoTienda> productosTienda){
        this.tf_descripcion.setCellValueFactory(cellDataFeatures -> new ReadOnlyObjectWrapper(cellDataFeatures.getValue().getDescription()));
        this.tf_cantidad.setCellValueFactory(cellDataFeatures -> new ReadOnlyObjectWrapper(cellDataFeatures.getValue().getCantidad()));
        this.tf_costo.setCellValueFactory(cellDataFeatures -> new ReadOnlyObjectWrapper(cellDataFeatures.getValue().getPrecio()));
        this.tb_database.setItems(productosTienda);
    }

    public void RB_Regresar(ActionEvent actionEvent) throws IOException {
        Utilidad.regresarMenuPrincipal(actionEvent);

    }
}
