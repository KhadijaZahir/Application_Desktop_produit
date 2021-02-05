module ma.youcode {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens ma.youcode to javafx.fxml;
    exports ma.youcode;

    opens  ma.youcode.controllers to javafx.fxml;
    exports ma.youcode.controllers;

    //




    requires javafx.graphics;
    requires java.desktop;
    requires javafx.base;
    requires java.management;

    opens ma.youcode.model to javafx.fxml;
    exports ma.youcode.model;

}