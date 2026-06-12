package org.joaquinsanchez.system;
 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class main extends Application {
    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        
        //nodos
        VBox root = new VBox(); 
        
        //escena
        Scene escena = new Scene(root); 
        
        //cargar escena y mostrar escenario principal
        escenarioPrincipal.setTitle("Calculadora de Joaquin");
        escenarioPrincipal.setScene(escena); 
        escenarioPrincipal.show();
        
    }
    
       public static void main(String[] args) {
        System.out.println("Hola mundo, esta es mi calculadora en JavaFX"); 
        launch(args); 
    }
       
}