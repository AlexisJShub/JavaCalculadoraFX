package org.joaquinsanchez.controller;

import javafx.scene.control.Label;

public class CalculadoraController {

    private String opcion1 = "";
    private String operador = "";
    private String opcion2 = "";
    private boolean calculoTerminado = false;

    public void procesoDeEntrada(String entrada, Label pantalla) {
        
        if (calculoTerminado && (entrada.matches("[0-9]") || entrada.equals("."))) {
            opcion1 = "";
            operador = "";
            opcion2 = "";
            calculoTerminado = false;
        } else if (calculoTerminado) {
            // Si presionamos un operador después de un cálculo este mismo continúa usando el resultado anterior
            calculoTerminado = false;
        }
    }
}