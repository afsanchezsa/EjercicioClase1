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
        Cliente []usuarios=new Cliente[10];
        int i=0;
        String nombre=null;
        int cedula=0;
        double inversioncdt;
        double interescdt;
        double dinero;
        System.out.println("SELECCIONE UNA OPCION");
        System.out.println("1. crear una cuenta");
        System.out.println("2.depositar cuenta de ahorros");
        System.out.println("3. depositar cuenta corriente");
        System.out.println("4.retirar cuenta ahorros");
        System.out.println("5.retirar cuenta corriente");
        System.out.println("6.cerrar cdt");
        System.out.println("7.cambio de mes");
        int a=0;
        Scanner entrada=new Scanner(System.in);
        a=entrada.nextInt();
        switch(a){
            case 1:
                System.out.println("inserte su nombre");
                nombre=entrada.next();
                 System.out.println("inserte su cedula");
                cedula=entrada.nextInt();
                System.out.println("inserte inversion de cdt");
                inversioncdt=entrada.nextDouble();
                System.out.println("interes cdt");
                interescdt=entrada.nextDouble();
                usuarios[i]=new Cliente(nombre,cedula,inversioncdt,interescdt);
                break;
            case 2:
                System.out.println(" digite su numero de cedula");
                cedula=entrada.nextInt();
                for(int j=0;j<9;j++){
                if(usuarios[j].Cedula==cedula){
                    System.out.println("ingrese el dinero que desea depositar");
                dinero=entrada.nextDouble();
                usuarios[i].micuenta.miahorro.depositar(dinero);
                }else{
                    System.out.println("no se encontro la cuenta");}
                }
                break;
            case 3:
                System.out.println(" digite su numero de cedula");
                cedula=entrada.nextInt();
                for(int j=0;j<9;j++){
                if(usuarios[j].Cedula==cedula){
                    System.out.println("ingrese el dinero que desea depositar");
                dinero=entrada.nextDouble();
                usuarios[i].micuenta.micorriente.depositar(dinero);
                }else{
                    System.out.println("no se encontro la cuenta");}
                }
                break;
            case 4:
                  System.out.println(" digite su numero de cedula");
                cedula=entrada.nextInt();
                for(int j=0;j<9;j++){
                if(usuarios[j].Cedula==cedula){
                    System.out.println("ingrese el dinero que desea retirar");
                dinero=entrada.nextDouble();
                usuarios[i].micuenta.miahorro.retirar(dinero);
                }else{
                    System.out.println("no se encontro la cuenta");}
                }
                
                break;
            case 5:
                
        }
        
    }
    
}
class Cliente{
private String Nombre;
public int Cedula;
Cuenta micuenta;
public Cliente(String nombre, int cedula,double inversioncdt,double interescdt){
Nombre=nombre;
Cedula=cedula;
 micuenta=new Cuenta(inversioncdt,interescdt);
}
}
 
 class Cuenta{
   Ahorro miahorro;
   Corriente micorriente; 
  //CDT micdt;
   public Cuenta(double inversioncdt,double interescdt){
 
        miahorro=new Ahorro();
       micorriente=new Corriente(inversioncdt,interescdt);
    //   micdt=new CDT(inversioncdt,interescdt);
       
   }
    class Corriente{
 public  double deposito=0;
 CDT micdt;
 public Corriente(double inversion_,double interes_){
 micdt=new CDT(inversion_,interes_);
 }
 public void depositar(double dinero){
 deposito+=dinero;
 }
 public void retirar(double dinero){
 deposito-=dinero;
 }
 
 class CDT{
    double inversion;
    double interes;
    double Totalcdt=0;
public CDT(double inversion_,double interes_){
inversion=inversion_;
interes=interes_;
}
public void aumentar_cdt(){
Totalcdt+=inversion+(inversion*interes);
}
public void cerrar(){
deposito+=Totalcdt;
Totalcdt=0;
       
}
}
 } 
}
class Ahorro{
 public double deposito=0;
public void descontar_interes(){
deposito=deposito-(deposito*0.006);
}
public void depositar(double dinero){
 deposito+=dinero;
 }
public void retirar(double dinero){
 deposito-=dinero;
 }
}

 


