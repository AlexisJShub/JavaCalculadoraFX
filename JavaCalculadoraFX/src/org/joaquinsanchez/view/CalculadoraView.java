package org.joaquinsanchez.view;
 
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.joaquinsanchez.controller.CalculadoraController;
 
public class CalculadoraView {
    private VBox view;
    private Label pantalla;
    private GridPane cuadroBotones;
    private CalculadoraController controlador = new CalculadoraController();

    //Estilo de mi pantalla de calculos
    public CalculadoraView(){
        view = new VBox(15);
        view.setPadding(new Insets(15));
        view.setAlignment(Pos.CENTER);
        
        view.setStyle("-fx-background-color: #EBE5CE;");
         
        pantalla = new Label("0");
        pantalla.setFont(Font.font("Consolas", FontWeight.BOLD, 40));
        pantalla.setAlignment(Pos.CENTER_RIGHT);
        pantalla.setPrefSize(290, 80);
        pantalla.setStyle("-fx-background-color: #8A9A86; -fx-text-fill: #242822; -fx-background-radius: 8px; -fx-padding: 0 10 0 0;");
         
        cuadroBotones = new GridPane(); 
        cuadroBotones.setHgap(12);
        cuadroBotones.setVgap(12);
        cuadroBotones.setAlignment(Pos.CENTER);

        //Hice un poco mas grande los numeros y operadores para que se vea mejor aprovechado los espacios de los cuadros
        //Tambien use el metodo DRY (lo encontre investigando) para no tener que repetir las lineas de estilo en cada boton si no que solamente
        //referenciarlas en los botones que sean necesarias para el momento de cambiar el estilo de las teclas sea mas facil
        //refactorizar estas mismas <- Es un comentario mio aunque no se crea, estoy cocinando.. 🗣
        String estiloNumeros = "-fx-background-color: #DCD7C9; "
                + "-fx-text-fill: #2C363F; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand; -fx-font-size: 22px; -fx-padding: 10px;";
        String estiloOperadores = "-fx-background-color: #797A7E; "
                + "-fx-text-fill: #FFFFFF; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand; -fx-font-size: 22px; -fx-padding: 10px;";
        String estiloDelete = "-fx-background-color: #C84B31; "
                + "-fx-text-fill: #FFFFFF; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand; -fx-font-size: 22px; -fx-padding: 10px;";
        String estiloIgual = "-fx-background-color: #2EA071; "
                + "-fx-text-fill: #FFFFFF; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand; -fx-font-size: 22px; -fx-padding: 10px;";
       
        
        //Estilo de presionado para cada de mis botones
        String presionadoNumeros = "-fx-background-color: #BDB7A9; -fx-text-fill: #2C363F; -fx-background-radius: 8px; "
                + "-fx-font-weight: bold; -fx-cursor: hand; -fx-font-size: 22px; -fx-padding: 10px;";
        
        String presionadoOperadores = "-fx-background-color: #5C5C5F; "
                + "-fx-text-fill: #FFFFFF; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand; -fx-font-size: 22px; -fx-padding: 10px;";
        
        String presionadoDelete = "-fx-background-color: #993824; "
                + "-fx-text-fill: #FFFFFF; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand; -fx-font-size: 22px; -fx-padding: 10px;";
        
        String presionadoIgual = "-fx-background-color: #1F7551; "
                + "-fx-text-fill: #FFFFFF; -fx-background-radius: 8px; -fx-font-weight: bold; -fx-cursor: hand; -fx-font-size: 22px; -fx-padding: 10px;";
        
        String estiloParentesis = "-fx-background-color: #5C6BC0; "
                + "-fx-text-fill: white; "+ "-fx-font-size: 20px; -fx-font-weight: bold; -fx-background-radius: 10;";
        
        String presionadoParentesis = "-fx-background-color: #3949AB; "
                + "-fx-text-fill: white; -fx-font-size: 20px; -fx-font-weight: bold; -fx-background-radius: 10;";
        
        
        //BOTONES NUMERICOS
        Button btnUno = new Button("1");
        btnUno.setPrefSize(60, 60);
        btnUno.setStyle(estiloNumeros);
        btnUno.setOnAction(e -> controlador.procesoDeEntrada("1", pantalla));
        btnUno.setOnMousePressed(e -> { btnUno.setStyle(presionadoNumeros); btnUno.setTranslateY(2); });
        btnUno.setOnMouseReleased(e -> { btnUno.setStyle(estiloNumeros); btnUno.setTranslateY(0); });

        Button btnDos = new Button("2");
        btnDos.setPrefSize(60, 60);
        btnDos.setStyle(estiloNumeros);
        btnDos.setOnAction(e -> controlador.procesoDeEntrada("2", pantalla));
        btnDos.setOnMousePressed(e -> { btnDos.setStyle(presionadoNumeros); btnDos.setTranslateY(2); });
        btnDos.setOnMouseReleased(e -> { btnDos.setStyle(estiloNumeros); btnDos.setTranslateY(0); });
        
        Button btnTres = new Button("3");
        btnTres.setPrefSize(60, 60);
        btnTres.setStyle(estiloNumeros);
        btnTres.setOnAction(e -> controlador.procesoDeEntrada("3", pantalla));
        btnTres.setOnMousePressed(e -> { btnTres.setStyle(presionadoNumeros); btnTres.setTranslateY(2); });
        btnTres.setOnMouseReleased(e -> { btnTres.setStyle(estiloNumeros); btnTres.setTranslateY(0); });
        
        Button btnCuatro = new Button("4");
        btnCuatro.setPrefSize(60, 60);
        btnCuatro.setStyle(estiloNumeros);
        btnCuatro.setOnAction(e -> controlador.procesoDeEntrada("4", pantalla));
        btnCuatro.setOnMousePressed(e -> { btnCuatro.setStyle(presionadoNumeros); btnCuatro.setTranslateY(2); });
        btnCuatro.setOnMouseReleased(e -> { btnCuatro.setStyle(estiloNumeros); btnCuatro.setTranslateY(0); });
        
        Button btnCinco = new Button("5");
        btnCinco.setPrefSize(60, 60);
        btnCinco.setStyle(estiloNumeros);
        btnCinco.setOnAction(e -> controlador.procesoDeEntrada("5", pantalla));
        btnCinco.setOnMousePressed(e -> { btnCinco.setStyle(presionadoNumeros); btnCinco.setTranslateY(2); });
        btnCinco.setOnMouseReleased(e -> { btnCinco.setStyle(estiloNumeros); btnCinco.setTranslateY(0); });
        
        Button btnSeis = new Button("6");
        btnSeis.setPrefSize(60, 60);
        btnSeis.setStyle(estiloNumeros);
        btnSeis.setOnAction(e -> controlador.procesoDeEntrada("6", pantalla));
        btnSeis.setOnMousePressed(e -> { btnSeis.setStyle(presionadoNumeros); btnSeis.setTranslateY(2); });
        btnSeis.setOnMouseReleased(e -> { btnSeis.setStyle(estiloNumeros); btnSeis.setTranslateY(0); });

        Button btnSiete = new Button("7");
        btnSiete.setPrefSize(60, 60);
        btnSiete.setStyle(estiloNumeros);
        btnSiete.setOnAction(e -> controlador.procesoDeEntrada("7", pantalla));
        btnSiete.setOnMousePressed(e -> { btnSiete.setStyle(presionadoNumeros); btnSiete.setTranslateY(2); });
        btnSiete.setOnMouseReleased(e -> { btnSiete.setStyle(estiloNumeros); btnSiete.setTranslateY(0); });

        Button btnOcho = new Button("8");
        btnOcho.setPrefSize(60, 60);
        btnOcho.setStyle(estiloNumeros);
        btnOcho.setOnAction(e -> controlador.procesoDeEntrada("8", pantalla));
        btnOcho.setOnMousePressed(e -> { btnOcho.setStyle(presionadoNumeros); btnOcho.setTranslateY(2); });
        btnOcho.setOnMouseReleased(e -> { btnOcho.setStyle(estiloNumeros); btnOcho.setTranslateY(0); });

        Button btnNueve = new Button("9");
        btnNueve.setPrefSize(60, 60);
        btnNueve.setStyle(estiloNumeros);
        btnNueve.setOnAction(e -> controlador.procesoDeEntrada("9", pantalla));
        btnNueve.setOnMousePressed(e -> { btnNueve.setStyle(presionadoNumeros); btnNueve.setTranslateY(2); });
        btnNueve.setOnMouseReleased(e -> { btnNueve.setStyle(estiloNumeros); btnNueve.setTranslateY(0); });

        Button btnCero = new Button("0");
        btnCero.setPrefSize(60, 60);
        btnCero.setStyle(estiloNumeros);
        btnCero.setOnAction(e -> controlador.procesoDeEntrada("0", pantalla));
        btnCero.setOnMousePressed(e -> { btnCero.setStyle(presionadoNumeros); btnCero.setTranslateY(2); });
        btnCero.setOnMouseReleased(e -> { btnCero.setStyle(estiloNumeros); btnCero.setTranslateY(0); });
    
        //OPERADORES Y SUS ACCIONES
        Button btnDelete = new Button("<--");
        btnDelete.setPrefSize(60, 60);
        btnDelete.setStyle(estiloDelete);
        btnDelete.setOnAction(e -> controlador.procesoDeEntrada("<--", pantalla));
        btnDelete.setOnMousePressed(e -> { btnDelete.setStyle(presionadoDelete); btnDelete.setTranslateY(2); });
        btnDelete.setOnMouseReleased(e -> { btnDelete.setStyle(estiloDelete); btnDelete.setTranslateY(0); });
        
        Button btnSuma = new Button("+");
        btnSuma.setPrefSize(60, 60);
        btnSuma.setStyle(estiloOperadores);
        btnSuma.setOnAction(e -> controlador.procesoDeEntrada("+", pantalla));
        btnSuma.setOnMousePressed(e -> { btnSuma.setStyle(presionadoOperadores); btnSuma.setTranslateY(2); });
        btnSuma.setOnMouseReleased(e -> { btnSuma.setStyle(estiloOperadores); btnSuma.setTranslateY(0); });
        
        Button btnResta = new Button("-");
        btnResta.setPrefSize(60, 60);
        btnResta.setStyle(estiloOperadores);
        btnResta.setOnAction(e -> controlador.procesoDeEntrada("-", pantalla));
        btnResta.setOnMousePressed(e -> { btnResta.setStyle(presionadoOperadores); btnResta.setTranslateY(2); });
        btnResta.setOnMouseReleased(e -> { btnResta.setStyle(estiloOperadores); btnResta.setTranslateY(0); });
        
        Button btnMult = new Button("*");
        btnMult.setPrefSize(60, 60);
        btnMult.setStyle(estiloOperadores);
        btnMult.setOnAction(e -> controlador.procesoDeEntrada("*", pantalla));
        btnMult.setOnMousePressed(e -> { btnMult.setStyle(presionadoOperadores); btnMult.setTranslateY(2); });
        btnMult.setOnMouseReleased(e -> { btnMult.setStyle(estiloOperadores); btnMult.setTranslateY(0); });
        
        Button btnDiv = new Button("/");
        btnDiv.setPrefSize(60, 60);
        btnDiv.setStyle(estiloOperadores);
        btnDiv.setOnAction(e -> controlador.procesoDeEntrada("/", pantalla));
        btnDiv.setOnMousePressed(e -> { btnDiv.setStyle(presionadoOperadores); btnDiv.setTranslateY(2); });
        btnDiv.setOnMouseReleased(e -> { btnDiv.setStyle(estiloOperadores); btnDiv.setTranslateY(0); });
        
        Button btnIgual = new Button("=");
        btnIgual.setPrefSize(60, 60);
        btnIgual.setStyle(estiloIgual);
        btnIgual.setOnAction(e -> controlador.procesoDeEntrada("=", pantalla));
        btnIgual.setOnMousePressed(e -> { btnIgual.setStyle(presionadoIgual); btnIgual.setTranslateY(2); });
        btnIgual.setOnMouseReleased(e -> { btnIgual.setStyle(estiloIgual); btnIgual.setTranslateY(0); });
        
        Button btnPotencia = new Button("X^");
        btnPotencia.setPrefSize(60, 60);
        btnPotencia.setStyle(estiloOperadores);
        btnPotencia.setOnAction(e -> controlador.procesoDeEntrada("^", pantalla));
        btnPotencia.setOnMousePressed(e -> { btnPotencia.setStyle(presionadoOperadores); btnPotencia.setTranslateY(2); });
        btnPotencia.setOnMouseReleased(e -> { btnPotencia.setStyle(estiloOperadores); btnPotencia.setTranslateY(0); });
        
        Button btnRaiz = new Button("√");
        btnRaiz.setPrefSize(60, 60);
        btnRaiz.setStyle(estiloOperadores);
        btnRaiz.setOnAction(e -> controlador.procesoDeEntrada("√", pantalla));
        btnRaiz.setOnMousePressed(e -> { btnRaiz.setStyle(presionadoOperadores); btnRaiz.setTranslateY(2); });
        btnRaiz.setOnMouseReleased(e -> { btnRaiz.setStyle(estiloOperadores); btnRaiz.setTranslateY(0); });
        
        Button btnPorcentaje = new Button("%");
        btnPorcentaje.setPrefSize(60, 60);
        btnPorcentaje.setStyle(estiloOperadores);
        btnPorcentaje.setOnAction(e -> controlador.procesoDeEntrada("%", pantalla));
        btnPorcentaje.setOnMousePressed(e -> { btnPorcentaje.setStyle(presionadoOperadores); btnPorcentaje.setTranslateY(2); });
        btnPorcentaje.setOnMouseReleased(e -> { btnPorcentaje.setStyle(estiloOperadores); btnPorcentaje.setTranslateY(0); });
        
        Button btnPunto = new Button(".");
        btnPunto.setPrefSize(60, 60);
        btnPunto.setStyle(estiloOperadores);
        btnPunto.setOnAction(e -> controlador.procesoDeEntrada(".", pantalla));
        btnPunto.setOnMousePressed(e -> { btnPunto.setStyle(presionadoOperadores); btnPunto.setTranslateY(2); });
        btnPunto.setOnMouseReleased(e -> { btnPunto.setStyle(estiloOperadores); btnPunto.setTranslateY(0); });
        
        Button btnClr = new Button("CE");
        btnClr.setPrefSize(60, 60);
        btnClr.setStyle(estiloOperadores);
        btnClr.setOnAction(e -> controlador.procesoDeEntrada("CE", pantalla));
        btnClr.setOnMousePressed(e -> { btnClr.setStyle(presionadoOperadores); btnClr.setTranslateY(2); });
        btnClr.setOnMouseReleased(e -> { btnClr.setStyle(estiloOperadores); btnClr.setTranslateY(0); });
        
        Button btnC = new Button("C");
        btnC.setPrefSize(60, 60);
        btnC.setStyle(estiloOperadores);
        btnC.setOnAction(e -> controlador.procesoDeEntrada("C", pantalla));
        btnC.setOnMousePressed(e -> { btnC.setStyle(presionadoOperadores); btnC.setTranslateY(2); });
        btnC.setOnMouseReleased(e -> { btnC.setStyle(estiloOperadores); btnC.setTranslateY(0); });
        
        Button btnParentesis1 = new Button("(");
        btnParentesis1.setPrefSize(60, 60);
        btnParentesis1.setStyle(estiloParentesis);
        btnParentesis1.setOnAction(e -> controlador.procesoDeEntrada("(", pantalla));
        btnParentesis1.setOnMousePressed(e -> { btnParentesis1.setStyle(presionadoParentesis); btnParentesis1.setTranslateY(2); });
        btnParentesis1.setOnMouseReleased(e -> { btnParentesis1.setStyle(estiloParentesis); btnParentesis1.setTranslateY(0); });
        
        Button btnParentesis2 = new Button(")");
        btnParentesis2.setPrefSize(60, 60);
        btnParentesis2.setStyle(estiloParentesis);
        btnParentesis2.setOnAction(e -> controlador.procesoDeEntrada(")", pantalla));
        btnParentesis2.setOnMousePressed(e -> { btnParentesis2.setStyle(presionadoParentesis); btnParentesis2.setTranslateY(2); });
        btnParentesis2.setOnMouseReleased(e -> { btnParentesis2.setStyle(estiloParentesis); btnParentesis2.setTranslateY(0); });
        
   
      
        //Posiciones de teclas
        cuadroBotones.add(btnUno, 1, 1);
        cuadroBotones.add(btnDos, 2, 1);
        cuadroBotones.add(btnTres, 3, 1);
        cuadroBotones.add(btnCuatro, 1, 2);
        cuadroBotones.add(btnCinco, 2, 2);
        cuadroBotones.add(btnSeis, 3, 2);
        cuadroBotones.add(btnSiete, 1, 3);
        cuadroBotones.add(btnOcho, 2, 3);
        cuadroBotones.add(btnNueve, 3, 3);
        cuadroBotones.add(btnCero, 2, 4);
        
        cuadroBotones.add(btnDelete, 3, 0);
        cuadroBotones.add(btnIgual, 4,4 );
        cuadroBotones.add(btnPotencia, 0, 1);
        cuadroBotones.add(btnRaiz, 0, 3);
        cuadroBotones.add(btnPorcentaje, 0, 2);
        cuadroBotones.add(btnDiv, 4, 0);
        cuadroBotones.add(btnMult, 4, 1);   
        cuadroBotones.add(btnResta, 4, 2);
        cuadroBotones.add(btnSuma, 4, 3);
        cuadroBotones.add(btnPunto, 3, 4);
        cuadroBotones.add(btnClr, 1, 0);
        cuadroBotones.add(btnC, 2,0);
        cuadroBotones.add(btnParentesis1, 0, 4);
        cuadroBotones.add(btnParentesis2, 1, 4);
        
     
        
//Agregamos la pantalla y el cuadro de botones al contenedor principal (VBox)
        view.getChildren().addAll(pantalla, cuadroBotones);
    }

    public VBox getView() {
        return view;
    }
}

       
 
//Es arte diosmio