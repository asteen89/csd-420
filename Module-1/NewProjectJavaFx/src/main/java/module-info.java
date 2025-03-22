module com.example.newprojectjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.newprojectjavafx to javafx.fxml;
    exports com.example.newprojectjavafx;
}