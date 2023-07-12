module br.com.senac.supfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.com.senac.supfx to javafx.fxml;
    exports br.com.senac.supfx;
}