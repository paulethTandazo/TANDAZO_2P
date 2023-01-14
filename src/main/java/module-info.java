module com.pooespol.tandazopauleth.proyectotandazo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.pooespol.tandazopauleth.proyectotandazo to javafx.fxml;
    exports com.pooespol.tandazopauleth.proyectotandazo;
}
