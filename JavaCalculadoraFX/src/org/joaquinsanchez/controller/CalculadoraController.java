package org.joaquinsanchez.controller;

import javafx.scene.control.Label;

public class CalculadoraController {

    private String opcion1 = "";
    private String operador = "";
    private String opcion2 = "";
    private boolean calculoTerminado = false;

    public void procesoDeEntrada(String entrada, Label pantalla) {
        // Si ya se completó un cálculo y se presiona un número o un punto, se reinicia la calculadora
        if (calculoTerminado && (entrada.matches("[0-9]") || entrada.equals("."))) {
            opcion1 = "";
            operador = "";
            opcion2 = "";
            calculoTerminado = false;
        } else if (calculoTerminado) {
            // Si presiona un operador después de un cálculo, continúa usando el resultado anterior
            calculoTerminado = false;
        }

        switch (entrada) {
            case "CLR":
                opcion1 = "";
                operador = "";
                opcion2 = "";
                break;
            case "<--":
                borrarUltimo();
                break;
            case ".":
                agregarPunto();
                break;
            case "+": case "-": case "*": case "/": case "^":
                if (!opcion1.isEmpty()) {
                    operador = entrada;
                }
                break;
            case "√":
                // La raíz cuadrada se calcula inmediatamente sobre el primer número
                if (!opcion1.isEmpty() && operador.isEmpty()) {
                    double val = Math.sqrt(Double.parseDouble(opcion1));
                    formatearResultado(val);
                    calculoTerminado = true;
                }
                break;
            case "=":
                calcularResultado();
                break;
            default:
                // Manejo de números del 0 al 9
                if (entrada.matches("[0-9]")) {
                    if (operador.isEmpty()) {
                        opcion1 += entrada;
                    } else {
                        opcion2 += entrada;
                    }
                }
                break;
        }
        
        actualizarPantalla(pantalla);
    }
        
    //Esta es la opcion de delete para eliminar un numero si nos equivocamos
    private void borrarUltimo() {
            if (!opcion2.isEmpty()) {
                opcion2 = opcion2.substring(0, opcion2.length() - 1);
            } else if (!operador.isEmpty()) {
                operador = "";
            } else if (!opcion1.isEmpty()) {
                opcion1 = opcion1.substring(0, opcion1.length() - 1);
            }
        }

        //para agregar punto para operaciones decimales
        private void agregarPunto() {
            if (operador.isEmpty()) {
                // Solo agrega el punto si no existe ya uno en opcion1
                if (!opcion1.contains(".")) {
                    opcion1 += opcion1.isEmpty() ? "0." : ".";
                }
            } else {
                // Solo agrega el punto si no existe ya uno en opcion2
                if (!opcion2.contains(".")) {
                    opcion2 += opcion2.isEmpty() ? "0." : ".";
                }
            }
        }