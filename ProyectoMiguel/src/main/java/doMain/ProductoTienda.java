package doMain;

public class ProductoTienda {
    private String description;
    private int cantidad;
    private int precio;

    public ProductoTienda() {
    }

    public ProductoTienda(String description, int cantidad, int precio) {
        this.description = description;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Miguel [cantidad=" + cantidad + ", description=" + description + ", precio=" + precio + "]";
    }    
    
}
