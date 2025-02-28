/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_ramonnolasco;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ramon
 */
public class Lab6P1_RamonNolasco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        
        boolean menu = true;
        
        do{
            System.out.println("");
            System.out.println("1 - Transposicion de una matriz");
            System.out.println("2 - Ingresa los ls");
            System.out.println("3 - Tablas de karnough");
            System.out.println("4 - Salir");
            
            System.out.println("Ingrese opcion: ");
            int opcion = input.nextInt();
            
            while (opcion < 1 || opcion > 4){
                System.out.println("Ingrese una opcion valida: ");
                opcion = input.nextInt();
            }
            
            switch (opcion){
                
                case 1: 
                    
                    break;
                    
                case 2: 
                    
                    char [][] tablero = new char [4][4];
                    
                    boolean juego = true;
                    
                    while(juego){
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    }
                    
                    
                    break;
                    
                case 3: 
                    
                    break;
                    
                case 4:                    
                    menu = false;
                    break;               
            }
            
        }while(menu);
                   
    }
    
    //METODOS EJERCICIO 2
    
    public static char[][] generarTableroSolucion(){
        char [][] solucion = new char [4][4];
        int nA;
        Random rand = new Random();
        char lA;
        for (int f = 0; f < 4; f++){
            for(int c = 0; c < 4; c++){
                nA = rand.nextInt(2);
                if (nA == 1){
                    lA = '1';
                }else{
                    lA = 'X';
                }
                solucion [f][c] = lA;
            }
        }
        
        return solucion;
    }
    
    public static void imprimirTablero(char[][] tablero, char[][] solucion){
        
        int n1sF0 = 0;
        int n1sF1 = 0;
        int n1sF2 = 0;
        int n1sF3 = 0;
        
        int n1sC0 = 0;
        int n1sC1 = 0;
        int n1sC2 = 0;
        int n1sC3 = 0;
        
        int n1sF0E = 0;
        int n1sF1E = 0;
        int n1sF2E = 0;
        int n1sF3E = 0;
        
        int n1sC0E = 0;
        int n1sC1E = 0;
        int n1sC2E = 0;
        int n1sC3E = 0;
        
        int n1sTotales = contar1sTotales(solucion);
        int n1sEncontrados = 0;
        
        System.out.println("");
        for (int f = 0; f < 4; f++){
            for(int c = 0; c < 4; c++){
                System.out.print("[" + tablero [f][c] + "]");
                if (c == 3){
                    System.out.print(n1sEncontrados + "/");
                }
            }
            System.out.println("");
        }
    }
    
    public static int contar1sTotales(char[][] solucion){
        int n1sTotales = 0;
        
        for(int f = 0; f < 4; f++){
            for (int c = 0; c < 4; c++){
                if (solucion[f][c] == '1'){
                    n1sTotales += 1;
                }
            }
        }
        
        return n1sTotales;
    }
    
    public static void imprimir(char [][] tablero, char [][] solucion){
        
        for (int i = 0; i < 4; i++){
            System.out.println("");
        }
        
        
        
    }
    
    
    
}
