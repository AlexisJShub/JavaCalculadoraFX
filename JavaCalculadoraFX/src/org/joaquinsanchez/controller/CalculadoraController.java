package org.joaquinsanchez.controller;

import javafx.scene.control.Label;

public class CalculadoraController {

    private String opcion1 = "";
    private String operador = "";
    private String opcion2 = "";
    private boolean calculoTerminado = false;

    public void procesoDeEntrada(String entrada, Label pantalla) {
        // Agregamos los paréntesis a la regla de reinicio
        if (calculoTerminado && (entrada.matches("[0-9]") || entrada.equals(".") || entrada.equals("(") || entrada.equals(")"))) {
            limpiarTodo();
        } else if (calculoTerminado) {
            // Si presiona un operador después de un cálculo, continúa usando el resultado anterior
            calculoTerminado = false;
        }

        switch (entrada) {
            case "CE": 
            case "C": 
                limpiarTodo();
                break;
            case "<--": 
                borrarUltimo();
                break;
            case ".": 
                agregarPunto();
                break;
            case "+": case "-": case "*": case "/": case "^": case "√":
                if (!opcion1.isEmpty()) {
                    operador = entrada;
                }
                break;
            case "=": 
                calcularResultado();
                break;
            default:
                // Aceptamos números del 0 al 9 Y paréntesis
                if (entrada.matches("[0-9]") || entrada.equals("(") || entrada.equals(")")) {
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
                // Eliminamos los paréntesis temporalmente solo para que Java pueda hacer la conversión matemática
                String num1Limpio = opcion1.replace("(", "").replace(")", "");
                double num1 = Double.parseDouble(num1Limpio);
                double resultado = 0;

                if (operador.equals("√")) {
                    resultado = Math.sqrt(num1);
                } else if (operador.equals("%")) {
                    resultado = num1 / 100.0;
                } else if (!opcion2.isEmpty()) {
                    
                 // Hacemos lo mismo con la opcion2
                    String num2Limpio = opcion2.replace("(", "").replace(")", "");
                    double num2 = Double.parseDouble(num2Limpio);

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
                        case "^" -> resultado = Math.pow(num1, num2); 
                    }
                } else {
                    return;
                }
                
                formatearResultado(resultado);
                operador = "";
                opcion2 = "";
                calculoTerminado = true;

            } catch (NumberFormatException e) {
                opcion1 = "Error";
            }
        }
    } private void formatearResultado(double resultado) {
        if (resultado % 1 == 0) {
            opcion1 = String.valueOf((long) resultado);
        } else {
            opcion1 = String.valueOf(resultado);
        }
    }
        
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