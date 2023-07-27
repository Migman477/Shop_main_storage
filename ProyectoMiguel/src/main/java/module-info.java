module migman.proyectomiguel {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens migman.proyectomiguel to javafx.fxml;
    exports migman.proyectomiguel;
}