module co.edu.uniquindio.poo.actividad_veterinaria {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.actividad_veterinaria to javafx.fxml;
    exports co.edu.uniquindio.poo.actividad_veterinaria;
    exports co.edu.uniquindio.poo.actividad_veterinaria.Controller;
    opens co.edu.uniquindio.poo.actividad_veterinaria.Controller to javafx.fxml;
}