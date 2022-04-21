module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires java.xml.bind;

    opens org.example.presentation to javafx.fxml;
    exports org.example.presentation;
    exports org.example.model;
    exports org.example.repository;
    exports org.example.service;
}
