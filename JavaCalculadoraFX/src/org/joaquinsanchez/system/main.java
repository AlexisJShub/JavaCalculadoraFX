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
        
       //Tamaño de mi calculadora
        Scene escena = new Scene(calculadora.getView(), 320, 500);
        
        // Configuramos y mostramos la ventana principal
        escenarioPrincipal.setTitle("Calculadora de Joaquín");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }
}