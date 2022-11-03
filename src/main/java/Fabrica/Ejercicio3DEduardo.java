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
        double materiaPrima, manoObra, costeProduccion;
       
       do{
        opcion = mostrarMenuInicial();
         if(opcion.equalsIgnoreCase("calcular")){
          codigo = mostrarMenuCodigos();
          if(codigo.equalsIgnoreCase("m1")
                || codigo.equalsIgnoreCase("p1")
                || codigo.equalsIgnoreCase("t1")
                || codigo.equalsIgnoreCase("m2")
                || codigo.equalsIgnoreCase("t2")){
              materiaPrima = materiaPrima();
              if(leerMateriaPrima()){   
              }
              manoObra = manoDeObra();
               if(leerManoDeObra()){   
              }
               costeProduccion = costeProduccion();
               JOptionPane.showMessageDialog(null, """
                                                   Con la mano de obra de %.2f y la materia prima de %2.f
                                                   EL coste de producción es de %.2f €
                                                   """.formatted(manoObra,materiaPrima,costeProduccion));
              
          }
        }
    }while(!opcion.equalsIgnoreCase("salir"));
       

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

    //Pedir la materia prima 
    public static double materiaPrima() {
        double materiaPrima = 0;
      
        do {
            try {
                materiaPrima = Double.parseDouble(JOptionPane.showInputDialog("Introduce la materia prima que va ha solicitar: "));
                break;
            } catch (InputMismatchException ime) {
                JOptionPane.showMessageDialog(null,
                        "Has introducido incorrectamente la materia prima, vuelve a intentarlo");
            }
        } while (true);
        return materiaPrima;
    }

    //La materia prima tiene que entrar en los perimetros
    public static boolean leerMateriaPrima() {
        final double MINIMO = 0.1, MAXIMO = 1;
        return (materiaPrima() >= MINIMO && materiaPrima() <= MAXIMO);

    }
    //Pedir la mano de obra
    public static double manoDeObra() {
        double manoObra = 0;
      
        do {
            try {
                manoObra = Double.parseDouble(JOptionPane.showInputDialog("Introduce la mano de obra que va ha solicitar: "));
                break;
            } catch (InputMismatchException ime) {
                JOptionPane.showMessageDialog(null,
                        "Has introducido incorrectamente la mano de obra, vuelve a intentarlo");
            }
        } while (true);
        return manoObra;
    }   
    //La mano de obra tiene que entrar en los perimetros
    public static boolean leerManoDeObra() {
        final double MINIMO = 0.5, MAXIMO = 0.9;
        return (manoDeObra() >= MINIMO && manoDeObra() <= MAXIMO);
    }
    
    public static double costeProduccion(){
        double costeProduccion = materiaPrima() + manoDeObra();
        return costeProduccion;
    }
    
}
