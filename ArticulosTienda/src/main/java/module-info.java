module com.politecnico.articulostienda {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.politecnico.articulostienda to javafx.fxml;
    exports com.politecnico.articulostienda;
}
