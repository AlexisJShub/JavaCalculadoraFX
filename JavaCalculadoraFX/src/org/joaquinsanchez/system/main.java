package org.joaquinsanchez.system;
  
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.joaquinsanchez.view.CalculadoraView;

public class main extends Application {

    public static void main(String[] args) {
        System.out.println("hola mundo");
        launch(args);
    }
 
    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        // Cargar vista de la calculadora 
        CalculadoraView calculadora = new CalculadoraView();
        
        // --- AQUÍ SE CAMBIÓ EL TAMAÑO ---
        // Pasamos de 266x390 a un tamaño más amplio de 320x480
        Scene escena = new Scene(calculadora.getView(), 320, 480);
        
        // Configuramos y mostramos la ventana principal
        escenarioPrincipal.setTitle("Calculadora de Joaquín");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }
}