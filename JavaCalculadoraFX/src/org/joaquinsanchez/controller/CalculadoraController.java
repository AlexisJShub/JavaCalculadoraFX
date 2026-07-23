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
            limpiarTodo();
        } else if (calculoTerminado) {
            // Si presiona un operador después de un cálculo, continúa usando el resultado anterior
            calculoTerminado = false;
        }

        switch (entrada) {
            case "CLR": //limpiar la pantallita
                limpiarTodo();
                break;
            case "<--": //para borrar ultimo digito
                borrarUltimo();
                break;
            case ".": //para agregar punto
                agregarPunto();
                break;
            case "+": case "-": case "*": case "/": case "^": case "√":
                if (!opcion1.isEmpty()) {
                    operador = entrada;
                }
                break;
            case "=": //Aca se calcula nuestro resultado
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

    private void limpiarTodo() {
        opcion1 = "";
        operador = "";
        opcion2 = "";
        calculoTerminado = false;
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
        
    private void calcularResultado() {
        if (!opcion1.isEmpty() && !operador.isEmpty()) {
            try {
                //Usamos double para que funcionen nuestros decimales
                double num1 = Double.parseDouble(opcion1);
                double resultado = 0;

                if (operador.equals("√")) {
                    resultado = Math.sqrt(num1);
                } else if (!opcion2.isEmpty()) {
                    double num2 = Double.parseDouble(opcion2);

                    switch (operador) {
                        case "+" -> resultado = num1 + num2;
                        case "-" -> resultado = num1 - num2;
                        case "*" -> resultado = num1 * num2;
                        case "/" -> {
                            if (num2 == 0) {
                                opcion1 = "Error";
                                operador = "";
                                opcion2 = "";
                                calculoTerminado = true;
                                return;
                            }
                            resultado = num1 / num2;
                        }
                        case "^" -> resultado = Math.pow(num1, num2); //para nuestras potencias
                    }
                } else {
                    return;
                }
                    //Aca ya funciona CLR para borrar el resultado y nos deje la pantallita en blanco
                formatearResultado(resultado);
                operador = "";
                opcion2 = "";
                calculoTerminado = true;

            } catch (NumberFormatException e) {
                opcion1 = "Error";
            }
        }
    }
    
    //Le faltaba comprobar para poder entregar decimales al momento
    private void formatearResultado(double resultado) {
        if (resultado % 1 == 0) {
            opcion1 = String.valueOf((long) resultado);
        } else {
            opcion1 = String.valueOf(resultado);
        }
    }
        //y para colocar numeros y operadores tambien 
    private void actualizarPantalla(Label pantalla) {
        if (opcion1.equals("Error")) {
            pantalla.setText("Error");
        } else if (operador.isEmpty()) {
            pantalla.setText(opcion1.isEmpty() ? "0" : opcion1);
        } else {
            pantalla.setText(opcion1 + " " + operador + " " + opcion2);
        }
    }
}