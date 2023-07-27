package bussinessLogic;

import dataAcces.DBConection;
import doMain.ProductoTienda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAO {
    public void agregarProducto(ProductoTienda producto) {
        DBConection dataBaseConnection = new DBConection();
        try (Connection connection = dataBaseConnection.getConnection()){
            String query = "INSERT INTO mglist VALUES (null,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,producto.getDescription());
            statement.setInt(2,producto.getCantidad());
            statement.setInt(3,producto.getPrecio());

            int resultSet = statement.executeUpdate();
        }catch (SQLException ex){
        } finally {
            dataBaseConnection.cerrarConexion();
        }
    }

    public List<ProductoTienda> generarReporteVentas(){
        DBConection dataBaseConection =new DBConection();
        List<ProductoTienda> reportes= new ArrayList<>();
        try (Connection connection = dataBaseConection.getConnection()) {
            String query = 
                "SELECT mglist.Descripcion,mglist.Cantidad,"+
                "mglist.Precio FROM `mglist` WHERE 1";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reportes.add(getProductoTienda(resultSet));
            }
        } catch (SQLException ex) {
        } finally {
            dataBaseConection.cerrarConexion();
        }
        return reportes;
    }
    private ProductoTienda getProductoTienda(ResultSet resultSet){
        ProductoTienda lista =new ProductoTienda();
        String description ="";
        int cantidad =0;
        int precio =0;

        try {
            description=resultSet.getString("Descripcion");
            cantidad=resultSet.getInt("Cantidad");
            precio=resultSet.getInt("Precio");

            lista.setDescription(description);
            lista.setCantidad(cantidad);
            lista.setPrecio(precio);
        } catch (Exception e) {
        }
        return lista;
    }
}
