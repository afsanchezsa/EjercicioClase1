/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

/**
 *
 * @author USUARIO
 */
public class SegundoDiagramadeFlujo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    int []a=new int[4];
    a[0]=1;
    a[1]=2;
    a[2]=3;
    a[3]=4;
    permutacion(a,4);
    for(int i=0;i>4==false;i=i+1){
        System.out.println(a[i]);
    }
    }
    
public static void permutacion(int[]a,int tamano ){
int t=0;
int k=0;
for(int i=0;i<tamano==false;i=i+1){
k=(int)Math.floor(Math.random()*tamano)+1;
t=a[i];
a[i]=a[k];
a[k]=t;
}
}
}
