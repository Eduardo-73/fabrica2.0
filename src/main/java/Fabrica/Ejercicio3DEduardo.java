/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package Fabrica;

import java.util.InputMismatchException;
import javax.swing.JOptionPane;

/**
 *
 * @author eduardo
 */
public class Ejercicio3DEduardo {

    public static void main(String[] args) {
        /*
        Método mostrarMenuInicial
        Método leerCodigos
        Método filtrarCódigo
        Método leerMateriaprima
        Método filtrarmateriaPrima
        Método leerManoObra
        Método filtraManoObra
        Método costeProduccion
        Método precioUnitario
        Método unidadesBenefico
         */
        String opcion;
        String codigo;
        double materiaPrima, manoObra, costeProduccion, precioUnitario;
        int unidadesObjetivo;

        do {
            opcion = mostrarMenuInicial();
            if (opcion.equalsIgnoreCase("calcular")) {
                do {
                    codigo = mostrarMenuCodigos();
                } while (filtrarCodigos(codigo));

                materiaPrima = calculoMateriaPrima();

                manoObra = calculoManoDeObra();

                costeProduccion = calculoCosteProduccion(materiaPrima, manoObra);

                precioUnitario = calculoPrecioUnitario(costeProduccion, codigo);

                unidadesObjetivo = calculoUnidadesAlcanzarBeneficio(precioUnitario, costeProduccion);
                
                String mensajeFinal = """
                      Con la mano de obra de %.2f y la materia prima de %.2f.
                      El coste de producción es de %.2f € y el precio de venta unitario es de %.2f.
                      Para alcanzar los 2500 de beneficio tenemos que vender %d unidades.
         """.formatted(manoObra, materiaPrima, costeProduccion, precioUnitario, unidadesObjetivo);

                JOptionPane.showMessageDialog(null, mensajeFinal);

            }
        } while (!opcion.equalsIgnoreCase("salir"));

    }

    public static String mostrarMenuInicial() {

        String txt = """
                         1.Para iniciar el programa inserte --> 'CALCULAR'
                         2.Para terminar el programa inserte --> 'SALIR'
                         """;
        String opcion = JOptionPane.showInputDialog(txt);
        return opcion;
    }

    public static boolean filtrarMenuInicial(String opcion) {
        return (!(opcion.equalsIgnoreCase("calular")
                || opcion.equalsIgnoreCase("salir")));
    }

    public static String mostrarMenuCodigos() {

        String txt = """
                                       
                                         INTRODUCE EL CÓDIGO DEL PRODUCTO            
                                       ------------------------------------
                                                PRODUCTOS
                                            1ºMantecados de Limón (M1)
                                            2ºPolvorones (P1)
                                            3ºTurrón de chocolate (T1)
                                            4ºTurrón clásica (T2)
                                            5ºMazapanes (M2)
                                         --------------------------------
                                             PARA TERMINAR EL PROGRAMA
                                             INTRODUZCA 'SALIR'
                                         --------------------------------           
                                       -------------------------------------  
                                                           """;
        String codigo = JOptionPane.showInputDialog(txt);
        return codigo;
    }

    public static boolean filtrarCodigos(String codigo) {
        return (!(codigo.equalsIgnoreCase("m1")
                || codigo.equalsIgnoreCase("p1")
                || codigo.equalsIgnoreCase("t1")
                || codigo.equalsIgnoreCase("m2")
                || codigo.equalsIgnoreCase("t2")));
    }

    public static double calculoMateriaPrima() {

        final double MINIMO = 0.1, MAXIMO = 1;
        double materiaPrima = 0;
        String mensaje = "Introduce el coste de la materia prima,"
                + "que debe de estar entre 0.1 y 1: ";
        do {
            try {
                materiaPrima = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Introduzca un número no una letra ");
            }
        } while (!(materiaPrima >= MINIMO && materiaPrima <= MAXIMO));
        return materiaPrima;
    }

    //Pedir la mano de obra
    public static double calculoManoDeObra() {
        double manoObra = 0;
        final double MAXIMO = 0.9, MINIMO = 0.5;
        String mensaje = "Introduce el precio de mano de obra que se encuentre entre 0.5 y 0.9: ";
        do {
            try {
                manoObra = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Introduzca un número no una letra ");
            }

        } while (!(manoObra >= MINIMO && manoObra <= MAXIMO));

        return manoObra;
    }

    public static double calculoCosteProduccion(double materiaPrima, double manoObra) {

        return materiaPrima + manoObra;
    }

    public static double calculoPrecioUnitario(double costeProduccion, String codigo) {

        double precioUnitario = 0;
        final double PORCENTAJE1 = 0.5, PORCENTAJE2 = 0.65;

        if (codigo.equalsIgnoreCase("m1")
                || codigo.equalsIgnoreCase("p1")
                || codigo.equalsIgnoreCase("m2")) {

            precioUnitario = costeProduccion + (costeProduccion * PORCENTAJE1);
        } else {
            precioUnitario = costeProduccion + (costeProduccion * PORCENTAJE2);
        }
        return precioUnitario;
    }

    public static int calculoUnidadesAlcanzarBeneficio(double precioUnitario, double costeProduccion) {
        final int OBJETIVO = 2500;
        int unidades;

        unidades = (int) Math.ceil(OBJETIVO / (precioUnitario - costeProduccion));
        return unidades;
    }
}
