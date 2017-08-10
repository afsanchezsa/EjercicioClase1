/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Simulador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cliente[] usuarios = new Cliente[10];
        int i = 0;
        String nombre = null;
        int cedula = 0;
        double inversioncdt;
        double interescdt;
        double dinero;
        double deposito;
        double depositocorriente;
        double depositocdt;
        boolean permanecer=true;
        int meses;
        int comodin=0;
        while(permanecer){
        System.out.println("SELECCIONE UNA OPCION");
        System.out.println("1. crear una cuenta");
        System.out.println("2.depositar cuenta de ahorros");
        System.out.println("3. depositar cuenta corriente");
        System.out.println("4.retirar cuenta ahorros");
        System.out.println("5.retirar cuenta corriente");
        System.out.println("6.cerrar cdt");
        System.out.println("7.cambio de mes");
        System.out.println("8.mostrar extracto");
        System.out.println("9.resultados de inversion a largo plazo por meses");
        int a = 0;
        Scanner entrada = new Scanner(System.in);
        a = entrada.nextInt();
        System.out.println("inserte su cedula");
        cedula = entrada.nextInt();
        switch (a) {
            case 1:
                System.out.println("inserte su nombre");
                nombre = entrada.next();

                System.out.println("inserte inversion de cdt");
                inversioncdt = entrada.nextDouble();
                System.out.println("interes cdt");
                interescdt = entrada.nextDouble();
                usuarios[i] = new Cliente(nombre, cedula, inversioncdt, interescdt);
                i++;
                break;
            case 2:

                for (int j = 0; j < i; j++) {
                    if (usuarios[j].Cedula == cedula) {
                        System.out.println("ingrese el dinero que desea depositar");
                        dinero = entrada.nextDouble();
                        usuarios[j].micuenta.miahorro.depositar(dinero);
                    } else {
                        System.out.println("no se encontro la cuenta");
                    }
                }
                break;
            case 3:

                for (int j = 0; j < i; j++) {
                    if (usuarios[j].Cedula == cedula) {
                        System.out.println("ingrese el dinero que desea depositar");
                        dinero = entrada.nextDouble();
                        usuarios[j].micuenta.micorriente.depositar(dinero);
                    } else {
                        System.out.println("no se encontro la cuenta");
                    }
                }
                break;
            case 4:

                for (int j = 0; j < i; j++) {
                    if (usuarios[j].Cedula == cedula) {
                        System.out.println("ingrese el dinero que desea retirar");
                        dinero = entrada.nextDouble();
                        usuarios[j].micuenta.miahorro.retirar(dinero);
                    } else {
                        System.out.println("no se encontro la cuenta");
                    }
                }

                break;
            case 5:

                for (int j = 0; j < i; j++) {
                    if (usuarios[j].Cedula == cedula) {
                        System.out.println("ingrese el dinero que desea retirar");
                        dinero = entrada.nextDouble();
                        usuarios[j].micuenta.micorriente.retirar(dinero);
                    } else {
                        System.out.println("no se encontro la cuenta");
                    }
                }

                break;
            case 6:

                for (int j = 0; j < i; j++) {
                    if (usuarios[j].Cedula == cedula) {

                        usuarios[j].micuenta.micorriente.micdt.cerrar();
                        System.out.println("se ha cerrado el cdt");
                    } else {
                        System.out.println("no se encontro la cuenta");
                    }
                }
                break;
            case 7:

                for (int j = 0; j < i; j++) {
                    if (usuarios[j].Cedula == cedula) {

                        usuarios[j].micuenta.miahorro.descontar_interes();
                        usuarios[j].micuenta.micorriente.micdt.aumentar_cdt();
                        System.out.println("se ha cambiado de mes");
                    } else {
                        System.out.println("no se encontro la cuenta");
                    }
                }
                break;
            case 8:
                for (int j = 0; j < i; j++) {
                    if (usuarios[j].Cedula == cedula) {

                        deposito = usuarios[j].micuenta.miahorro.deposito;
                        depositocorriente = usuarios[j].micuenta.micorriente.deposito;
                        depositocdt = usuarios[j].micuenta.micorriente.micdt.Totalcdt;

                        System.out.println("el saldo en la cuenta de ahorros es " + deposito);
                        System.out.println("el saldo en la cuenta de corriente  es " + depositocorriente);
                        System.out.println("el saldo en cdt es "+depositocdt);
                    } else {
                        System.out.println("no se encontro la cuenta");
                    }
                }
                break;
               case 9:
                   System.out.println("inserte el numero de meses");
                   meses=entrada.nextInt();
                   
                   for(int m=0;m<meses;m++){
                    for (int j = 0; j < i; j++) {
                    if (usuarios[j].Cedula == cedula) {

                        usuarios[j].micuenta.miahorro.descontar_interes();
                        usuarios[j].micuenta.micorriente.micdt.aumentar_cdt();
                        System.out.println("se ha cambiado de mes");
                        comodin=j;
                    } else {
                        System.out.println("no se encontro la cuenta");
                    }
                }
                   }
                   System.out.println("el rendimmiento de la inversion en cdt en "+meses+" meses es "+usuarios[comodin].micuenta.micorriente.micdt.rendimiento());
        } System.out.println("desea permanecer en el simulador (y/n)");
        permanecer=entrada.next().equalsIgnoreCase("y");


    }
    }

}

class Cliente {

    private String Nombre;
    public int Cedula;
    Cuenta micuenta;

    public Cliente(String nombre, int cedula, double inversioncdt, double interescdt) {
        Nombre = nombre;
        Cedula = cedula;
        micuenta = new Cuenta(inversioncdt, interescdt);
    }
}

class Cuenta {

    Ahorro miahorro;
    Corriente micorriente;
    //CDT micdt;

    public Cuenta(double inversioncdt, double interescdt) {

        miahorro = new Ahorro();
        micorriente = new Corriente(inversioncdt, interescdt);
        //   micdt=new CDT(inversioncdt,interescdt);

    }

    class Corriente {

        public double deposito = 0;
        CDT micdt;

        public Corriente(double inversion_, double interes_) {
            micdt = new CDT(inversion_, interes_);
        }

        public void depositar(double dinero) {
            deposito += dinero;
        }

        public void retirar(double dinero) {
            deposito -= dinero;
        }

        class CDT {
            double inversioninicial;
            double inversion;
            double interes;
            double Totalcdt = 0;

            public CDT(double inversion_, double interes_) {
                inversion = inversion_;
                inversioninicial=inversion_;
                interes = interes_;
            }

            public void aumentar_cdt() {
                Totalcdt += inversion + (inversion * interes);
            }

            public void cerrar() {
                deposito += Totalcdt;
                Totalcdt = 0;

            }
            public double rendimiento(){
        return Totalcdt-inversioninicial;
        }
        }
    }
}

class Ahorro {

    public double deposito = 0;

    public void descontar_interes() {
        deposito = deposito - (deposito * 0.006);
    }

    public void depositar(double dinero) {
        deposito += dinero;
    }

    public void retirar(double dinero) {
        deposito -= dinero;
    }
}
