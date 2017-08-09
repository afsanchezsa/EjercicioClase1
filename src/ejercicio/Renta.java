/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import java.util.Scanner;

/**
 *
 * @author Andres Sanchez
 */
public class Renta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    double Renta,patrimonio;
    int creditos;
        Estudiante []alumnos=new Estudiante[10];
    int numero_alumno=0;    
    System.out.println("Desea Registrar un nuevo estudiante(y/n)");
        Scanner entrada=new Scanner(System.in);
        String agregar=entrada.next();
        boolean registrar=agregar.compareToIgnoreCase("y")==0;
        while(registrar&&numero_alumno<10){
            System.out.println("ingrese por favor la renta ");
            Renta=entrada.nextDouble();
            System.out.println("ingrese el valor del patrimonio");
            patrimonio=entrada.nextDouble();
            System.out.println("ingrese el numero de creditos");
            creditos=entrada.nextInt();
            alumnos[numero_alumno]=new Estudiante(numero_alumno+1,Renta,patrimonio,creditos);
            numero_alumno++;
         System.out.println("Desea Registrar un nuevo estudiante(y/n)");
        agregar=entrada.next();
         registrar=agregar.compareToIgnoreCase("y")==0; 
        }
        System.out.println("desea generar el reporte?(y/n)");
        String reporte=entrada.next();
        if(reporte.compareToIgnoreCase("y")==0){
        System.out.println("CODIGO   COSTO DE MATRICULA");
            for(int i=0;i<numero_alumno;i++){
                System.out.println(alumnos[i].codigo()+"        "+alumnos[i].matricula());
            
            
        }
            double recaudo=0;
            for(int i=0;i<numero_alumno;i++){
                recaudo+=alumnos[i].matricula();
                
            
            
        }
            System.out.println("el recaudo total es "+recaudo);
        }
        

    }
    /**
     * Clase Estudiante para gestionar personal universitario
     */

}

 class Estudiante{
private int Codigo; 
private double Rentaliquida;
private double Patrimonio;
private int Creditos;

    public Estudiante(int codigo,double Renta, double patrimonio,int creditos){
    
    if(codigo>10){
    System.out.println("se ha llegado al numero maximo de estudiantes (10)");
    }else{
    Codigo=codigo;
    Rentaliquida=Renta;
    Patrimonio=patrimonio;
    Creditos=creditos;
    }
    }
    /**
     * 
     * @return retorna el valor de la matricula del estudiante dependiendo
     * su renta liquida y su patrimonio
     */
     
    public double matricula(){
    double valor=0;
        
    valor=ValorCreditos()*Creditos;    
    return valor;
            }
    /**
     * 
     * @return retorna el valor por credito del estudiante  
     */
    private double ValorCreditos(){
    double[] rentaliquida = new double[4];
        double[] patrimonio = new double[4];
        double[] valorCredito = new double[3];
        rentaliquida[0] = 0;
        rentaliquida[1] = 25000;
        rentaliquida[2] = 30000;
        rentaliquida[3] = 40000;
        patrimonio[0] = 100000;
        patrimonio[1] = 100000;
        patrimonio[2] = 150000;
        patrimonio[3] = 210000;
        valorCredito[0] = 130;
        valorCredito[1] = 200;
        valorCredito[2] = 280;
    for(int i=1;i<4;i++){
        if((Rentaliquida<=rentaliquida[i]&&Rentaliquida>rentaliquida[i-1])||(Patrimonio<=patrimonio[i]&&Patrimonio>patrimonio[i-1])){
    return valorCredito[i-1];
    }
    }
   return valorCredito[2];
           
    }
   public int codigo(){
   return Codigo;
   }

            }
