/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package Fabrica;

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

        do {
            opcion = mostrarMenuInicial();
        } while (filtrarMenuInicial(opcion));

        codigo = mostrarMenuCodigos();
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

        String codigo = JOptionPane.showInputDialog("""
                                       
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
                                                           """);
        return codigo;
    }

    public static boolean filtrarCodigos(String codigo) {
        return (!codigo.equalsIgnoreCase("m1")
                || codigo.equalsIgnoreCase("p1")
                || codigo.equalsIgnoreCase("t1")
                || codigo.equalsIgnoreCase("m2")
                || codigo.equalsIgnoreCase("t2"));
    }
}
