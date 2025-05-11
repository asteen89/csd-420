module com.example.javafxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.javafxml to javafx.fxml;
    exports com.example.javafxml;
}
