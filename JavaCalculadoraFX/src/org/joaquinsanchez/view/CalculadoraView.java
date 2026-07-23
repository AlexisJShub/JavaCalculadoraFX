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

    //Estilo de mi pantalla de calculos
    public CalculadoraView(){
        view = new VBox(15);
        view.setPadding(new Insets(15));
        view.setAlignment(Pos.CENTER);
        
        view.setStyle("-fx-background-color: #EBE5CE;");
         
        pantalla = new Label("0");
        pantalla.setFont(Font.font("Consolas", FontWeight.BOLD, 40));
        pantalla.setAlignment(Pos.CENTER_RIGHT);
        pantalla.setPrefSize(276, 60);
        pantalla.setStyle("-fx-background-color: #8A9A86; -fx-text-fill: #242822; -fx-background-radius: 8px; -fx-padding: 0 10 0 0;");
         
        cuadroBotones = new GridPane(); 
        cuadroBotones.setHgap(12);
        cuadroBotones.setVgap(12);
        cuadroBotones.setAlignment(Pos.CENTER);

        //Hice un poco mas grande los numeros y operadores para que se vea mejor aprovechado los espacios de los cuadros
        //Tambien use el metodo DRY (lo encontre investigando) para no tener que repetir las lineas de estilo en cada boton si no que solamente
        //referenciarlas en los botones que sean necesarias para el momento de cambiar el estilo de las teclas sea mas facil
        //refactorizar estas mismas <- Es un comentario mio aunque no se crea, estoy cocinando.. 🗣
        String estiloNumeros = "-fx-background-color: #DCD7C9; -fx-text-fill: #2C363F; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand; -fx-font-size: 22px; -fx-padding: 10px;";
        String estiloOperadores = "-fx-background-color: #797A7E; -fx-text-fill: #FFFFFF; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand; -fx-font-size: 22px; -fx-padding: 10px;";
        String estiloDelete = "-fx-background-color: #C84B31; -fx-text-fill: #FFFFFF; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand; -fx-font-size: 22px; -fx-padding: 10px;";
        String estiloIgual = "-fx-background-color: #2EA071; -fx-text-fill: #FFFFFF; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand; -fx-font-size: 22px; -fx-padding: 10px;";
        
        //BOTONES NUMERICOS
        Button btnUno = new Button("1");
        btnUno.setPrefSize(60, 60);
        btnUno.setStyle(estiloNumeros);

        Button btnDos = new Button("2");
        btnDos.setPrefSize(60, 60);
        btnDos.setStyle(estiloNumeros);
        
        Button btnTres = new Button("3");
        btnTres.setPrefSize(60, 60);
        btnTres.setStyle(estiloNumeros);
        
        Button btnCuatro = new Button("4");
        btnCuatro.setPrefSize(60, 60);
        btnCuatro.setStyle(estiloNumeros);
        
        Button btnCinco = new Button("5");
        btnCinco.setPrefSize(60, 60);
        btnCinco.setStyle(estiloNumeros);
        
        Button btnSeis = new Button("6");
        btnSeis.setPrefSize(60, 60);
        btnSeis.setStyle(estiloNumeros);

        Button btnSiete = new Button("7");
        btnSiete.setPrefSize(60, 60);
        btnSiete.setStyle(estiloNumeros);

        Button btnOcho = new Button("8");
        btnOcho.setPrefSize(60, 60);
        btnOcho.setStyle(estiloNumeros);

        Button btnNueve = new Button("9");
        btnNueve.setPrefSize(60, 60);
        btnNueve.setStyle(estiloNumeros);

        Button btnCero = new Button("0");
        btnCero.setPrefSize(60, 60);
        btnCero.setStyle(estiloNumeros);
    
        //OPERADORES
        Button btnDelete = new Button("<--");
        btnDelete.setPrefSize(60, 60);
        btnDelete.setStyle(estiloDelete);
        
        Button btnSuma = new Button("+");
        btnSuma.setPrefSize(60, 60);
        btnSuma.setStyle(estiloOperadores);
        
        Button btnResta = new Button("-");
        btnResta.setPrefSize(60, 60);
        btnResta.setStyle(estiloOperadores);
        
        Button btnMult = new Button("*");
        btnMult.setPrefSize(60, 60);
        btnMult.setStyle(estiloOperadores);
        
        Button btnDiv = new Button("/");
        btnDiv.setPrefSize(60, 60);
        btnDiv.setStyle(estiloOperadores);
        
        Button btnIgual = new Button("=");
        btnIgual.setPrefSize(60, 60);
        btnIgual.setStyle(estiloIgual);
        
        Button btnPotencia = new Button("^");
        btnPotencia.setPrefSize(60, 60);
        btnPotencia.setStyle(estiloOperadores);
        
         Button btnRaiz = new Button("√");
        btnRaiz.setPrefSize(60, 60);
        btnRaiz.setStyle(estiloOperadores);
               
        //Posiciones de teclas
        cuadroBotones.add(btnUno, 0, 3);
        cuadroBotones.add(btnDos, 1, 3);
        cuadroBotones.add(btnTres, 2, 3);
        cuadroBotones.add(btnCuatro, 0, 2);
        cuadroBotones.add(btnCinco, 1, 2);
        cuadroBotones.add(btnSeis, 2, 2);
        cuadroBotones.add(btnSiete, 0, 1);
        cuadroBotones.add(btnOcho, 1, 1);
        cuadroBotones.add(btnNueve, 2, 1);
        cuadroBotones.add(btnCero, 1, 4);
        
        cuadroBotones.add(btnDelete, 2, 0);
        cuadroBotones.add(btnIgual, 3,4 );
        cuadroBotones.add(btnPotencia, 1, 0);
        cuadroBotones.add(btnRaiz, 0, 0);
        cuadroBotones.add(btnDiv, 3, 0);
        cuadroBotones.add(btnMult, 3, 1);   
        cuadroBotones.add(btnResta, 3, 2);
        cuadroBotones.add(btnSuma, 3, 3);
        
        
     
        
// Agregamos la pantalla y el cuadro de botones al contenedor principal (VBox)
        view.getChildren().addAll(pantalla, cuadroBotones);
    }

    public VBox getView() {
        return view;
    }
}