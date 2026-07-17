package org.joaquinsanchez.view;
 
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
 
public class CalculadoraView {
    private VBox view;
    private Label pantalla;
    private GridPane cuadroBotones;

    public CalculadoraView(){
        view = new VBox (15);
        view.setPadding(new Insets(15));
        view.setAlignment(Pos.CENTER);
        
        // Fondo grisáceo claro (Blanquecino limpio)
        view.setStyle("-fx-background-color: #E9EBF7;");
        
        // Pantalla con el color Morado/Lavanda (#B2B3DC) y texto oscuro para que contraste
        pantalla = new Label ("0");
        pantalla.setFont(Font.font("Consolas", FontWeight.BOLD, 40));
        pantalla.setAlignment(Pos.CENTER_RIGHT);
        pantalla.setPrefSize(235, 60);
        pantalla.setStyle("-fx-background-color: #B2B3DC; -fx-text-fill: #2E2F48; -fx-background-radius: 8px; -fx-padding: 0 10 0 0;");
        
        cuadroBotones = new GridPane(); 
        cuadroBotones.setHgap(12); // Interlineado horizontal
        cuadroBotones.setVgap(12); // Interlineado vertical
        cuadroBotones.setAlignment(Pos.CENTER);

        // BOTONES NUMÉRICOS (Usan el color Lavanda #B2B3DC y texto oscuro #2E2F48)
        Button btnUno = new Button("1");
        btnUno.setPrefSize(50, 50);
        btnUno.setStyle("-fx-background-color: #B2B3DC; -fx-text-fill: #2E2F48; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand;");

        Button btnDos = new Button("2");
        btnDos.setPrefSize(50, 50);
        btnDos.setStyle("-fx-background-color: #B2B3DC; -fx-text-fill: #2E2F48; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand;");
        
        Button btnTres = new Button("3");
        btnTres.setPrefSize(50, 50);
        btnTres.setStyle("-fx-background-color: #B2B3DC; -fx-text-fill: #2E2F48; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand;");
        
        Button btnCuatro = new Button("4");
        btnCuatro.setPrefSize(50, 50);
        btnCuatro.setStyle("-fx-background-color: #B2B3DC; -fx-text-fill: #2E2F48; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand;");
        
        Button btnCinco = new Button("5");
        btnCinco.setPrefSize(50, 50);
        btnCinco.setStyle("-fx-background-color: #B2B3DC; -fx-text-fill: #2E2F48; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand;");

        // 1. Agregamos los botones que creaste a la cuadrícula (GridPane)
        cuadroBotones.add(btnUno, 0, 0);
        cuadroBotones.add(btnDos, 1, 0);
        cuadroBotones.add(btnTres, 2, 0);
        cuadroBotones.add(btnCuatro, 0, 1);
        cuadroBotones.add(btnCinco, 1, 1);

        // 2. Agregamos la pantalla y el cuadro de botones al contenedor principal (VBox)
        view.getChildren().addAll(pantalla, cuadroBotones);
    }

    // 3. Corregimos el método getView() eliminando la excepción y retornando la vista
    public VBox getView() {
        return view;
    }
} 