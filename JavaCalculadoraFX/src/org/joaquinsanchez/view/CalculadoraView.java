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
        view.setStyle("-fx-background-color: #E9EBAFF7;");
        
       // MIS COLORES DE PANTALLA Y LA PANTALLA DE CALCULOS
        pantalla = new Label ("0");
        pantalla.setFont(Font.font("Consolas", FontWeight.BOLD, 40));
        pantalla.setAlignment(Pos.CENTER_RIGHT);
        pantalla.setPrefSize(235, 60);
        pantalla.setStyle("-fx-background-color: #B2B3DC; -fx-text-fill: #2E2F48; -fx-background-radius: 8px; -fx-padding: 0 10 0 0;");
        
        cuadroBotones = new GridPane(); 
        cuadroBotones.setHgap(12); // Interlineado horizontal
        cuadroBotones.setVgap(12); // Interlineado vertical
        cuadroBotones.setAlignment(Pos.CENTER);

        // MIS BOTONES NUMÉRICOS 
        Button btnUno = new Button("1");
        btnUno.setPrefSize(60, 60);
        btnUno.setStyle("-fx-background-color: #B2B3DC; -fx-text-fill: #2E2F48; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand;");

        Button btnDos = new Button("2");
        btnDos.setPrefSize(60, 60);
        btnDos.setStyle("-fx-background-color: #B2B3DC; -fx-text-fill: #2E2F48; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand;");
        
        Button btnTres = new Button("3");
        btnTres.setPrefSize(60, 60);
        btnTres.setStyle("-fx-background-color: #B2B3DC; -fx-text-fill: #2E2F48; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand;");
        
        Button btnCuatro = new Button("4");
        btnCuatro.setPrefSize(60, 60);
        btnCuatro.setStyle("-fx-background-color: #B2B3DC; -fx-text-fill: #2E2F48; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand;");
        
        Button btnCinco = new Button("5");
        btnCinco.setPrefSize(60, 60);
        btnCinco.setStyle("-fx-background-color: #B2B3DC; -fx-text-fill: #2E2F48; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand;");
        
        Button btnSeis = new Button("6");
        btnSeis.setPrefSize(60, 60);
        btnSeis.setStyle("-fx-background-color: #B2B3DC; -fx-text-fill: #2E2F48; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand;");

        Button btnSiete = new Button("7");
        btnSiete.setPrefSize(60, 60);
        btnSiete.setStyle("-fx-background-color: #B2B3DC; -fx-text-fill: #2E2F48; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand;");

        Button btnOcho = new Button("8");
        btnOcho.setPrefSize(60, 60);
        btnOcho.setStyle("-fx-background-color: #B2B3DC; -fx-text-fill: #2E2F48; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand;");

        Button btnNueve = new Button("9");
        btnNueve.setPrefSize(60, 60);
        btnNueve.setStyle("-fx-background-color: #B2B3DC; -fx-text-fill: #2E2F48; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand;");

        Button btnCero = new Button("0");
        btnCero.setPrefSize(60, 60);
        btnCero.setStyle("-fx-background-color: #B2B3DC; -fx-text-fill: #2E2F48; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand;");


        //Agregamos los botones que creaste a la cuadrícula (GridPane)
        cuadroBotones.add(btnUno, 0, 0);
        cuadroBotones.add(btnDos, 1, 0);
        cuadroBotones.add(btnTres, 2, 0);
        cuadroBotones.add(btnCuatro, 0, 1);
        cuadroBotones.add(btnCinco, 1, 1);
        cuadroBotones.add(btnSeis, 2, 1);
        cuadroBotones.add(btnSiete, 0, 2);
        cuadroBotones.add(btnOcho, 1, 2);
        cuadroBotones.add(btnNueve, 2, 2);
        cuadroBotones.add(btnCero, 1, 3);

        //Agregamos la pantalla y el cuadro de botones al contenedor principal (VBox)
        view.getChildren().addAll(pantalla, cuadroBotones);
    }

    public VBox getView() {
        return view;
    }
} 