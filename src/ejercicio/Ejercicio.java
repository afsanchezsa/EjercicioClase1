/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import java.util.*;

/**
 *
 * @author Andres
 * @version 1
 * @since 08/08/2017 Ejercicio apicacion de funciones
 */
public class Ejercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner flujoEntrada = new Scanner(System.in);
        //Declaracion variables
        String nombre = null;
        int numeroHoras = 0;
        double valorHora = 0;
        System.out.println("Nombre");
        nombre = flujoEntrada.next();
        System.out.println("Horas");
        numeroHoras = flujoEntrada.nextInt();
        System.out.println("Valor");
        valorHora = flujoEntrada.nextDouble();
        double totalsalario = sueldo(numeroHoras, valorHora);

        System.out.println("el valor a pagar a " + nombre + " es " + calcularSalario(numeroHoras, valorHora));
        System.out.println("Nombre " + nombre + " Salario " + totalsalario);
    }

    /**
     * funcion que permite calcular salario de un trabajador basado en numero de
     * horas y valor de la hora
     *
     * @param horas_trabajadas_semana numero entero que indica la cantidad de
     * horas
     *
     * @param valor_hora numero double que indica el valor de la hora
     * @return numero double que indica el valor total a pagar
     */
    public static double dinero(int horas_trabajadas_semana, double valor_hora) {
        double total = 0;
        int horas_extras = 0;

        int horas_triples = 0;
        if (horas_trabajadas_semana > 40) {
            horas_extras = horas_trabajadas_semana - 40;
            total = (horas_trabajadas_semana - horas_extras) * valor_hora;
        }
        if (horas_extras <= 8) {
            total += horas_extras * valor_hora * 2;
        } else {

            horas_triples = horas_trabajadas_semana - 48;
            total += horas_triples * 3 * valor_hora;
            total += 8 * valor_hora * 2;
        }
        return total;
    }

    public static double calcularSalario(int horas, double valor) {
        double totalSalario = 0;
        int horas_extras = 0;

        int horas_triples = 0;
        if (horas >= 40) {
            horas_extras = horas - 40;
            totalSalario = (horas - horas_extras) * valor;
        } else {
            totalSalario = 40 * horas;

        }
        if (horas_extras < 8) {
            totalSalario += horas_extras * valor * 2;
        } else {

            horas_triples = horas - 48;
            totalSalario += horas_triples * 3 * valor;
            totalSalario += 8 * valor * 2;
        }
        return totalSalario;

    }

    public static double sueldo(int horas, double valor) {
        double totalsalario = 0;
        if (horas <= 40) {
            totalsalario = horas * valor;

        } else {
            int horasextra = horas - 40;
            if (horasextra > 8) {
                totalsalario = (40 * valor);
                totalsalario = totalsalario + (8 * (valor * 2));
                totalsalario = totalsalario + ((horasextra - 8) * valor * 3);

            } else {
                totalsalario = 40 * valor;
                totalsalario += horasextra * (2 * valor);
            }
        }
        return totalsalario;
    }
}
