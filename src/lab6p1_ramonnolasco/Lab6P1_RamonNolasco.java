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
                    System.out.println("Ingrese el tamanio de la matriz: ");
                    int tamaño = input.nextInt();
                    int[][] matrizOriginal = crearMatrizCuadrada(tamaño);
                    int[][] matrizTranspuesta = crearMatrizTranspuesta(matrizOriginal);
                    int[][] matrizTranspuestaInversa = crearMatrizTranspuestaInversa(matrizOriginal);
    
                    System.out.println("Matriz Original: ");
                    imprimirMatriz(matrizOriginal);
    
                    System.out.println("Matriz Transpuesta: ");
                    imprimirMatriz(matrizTranspuesta);
    
                    System.out.println("Matriz Transpuesta Inversa: ");
                    imprimirMatriz(matrizTranspuestaInversa);
                    
                    break;
                    
                case 2:                    
                    char [][] tablero = new char [4][4];
                    tablero = llenarTablero(tablero);
                    char [][] solucion = generarTableroSolucion();                   
                    Ejercicio2(tablero, solucion);       
                    break;
                    
                case 3: 
                    
                    break;
                    
                case 4:                    
                    menu = false;
                    break;               
            }
            
        }while(menu);
                   
    }
    
    
    
    
    //METODOS EJERCICIO 1
    
    
    
    
    public static int[][] crearMatrizCuadrada(int tamaño){
        Random rand = new Random();
        int[][] matriz = new int[tamaño][tamaño];       
        for (int f = 0; f < tamaño; f++){
            for (int c = 0; c < tamaño; c++){
                matriz[f][c] = rand.nextInt(10);
            }
        }
        return matriz;
    }
    
    public static void imprimirMatriz(int[][] matriz){
        System.out.println("");
        for (int f = 0; f < matriz.length; f++){
            for (int c = 0; c < matriz.length; c++){
                System.out.print("[" + matriz[f][c] + "]");
            }
            System.out.println("");
        }              
    }
    
    public static int[][] crearMatrizTranspuesta(int[][] matriz) {
        int n = matriz.length;
        int[][] transpuesta = new int[n][n];
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transpuesta[j][i] = matriz[i][j]; 
            }
        }
        return transpuesta;
    }
    
    public static int[][] crearMatrizTranspuestaInversa(int[][] matriz) {
        int n = matriz.length;
        int[][] transpuestaInversa = new int[n][n];
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transpuestaInversa[n - j - 1][n - i - 1] = matriz[i][j]; 
            
            }
        }
        return transpuestaInversa;
    }
    
    
    
    //METODOS EJERCICIO 2
    
    
    
    
    public static void Ejercicio2(char[][] tablero, char[][] solucion){
        Scanner input = new Scanner(System.in);
        
        //CONTAR N1S TOTALES Y POR FILA Y COLUMNA
        int n1sTotales = 0; 
        int [] n1sTotalesF = new int [4];
        int [] n1sTotalesC = new int [4];
        int [] n1sEncontradosF = new int [4];
        int [] n1sEncontradosC = new int [4];
        
        for(int f = 0; f < 4; f++){
            for (int c = 0; c < 4; c++){
                if (solucion[f][c] == '1'){
                    n1sTotales += 1;
                    n1sTotalesF [f] += 1;
                    n1sTotalesC [c] += 1;
                }
            }
        }  
        
        //
        //imprimirSolucion(solucion);
        int n1sEncontradas = 0;
        boolean juego = true;
        
        while (juego == true){
            System.out.println("");
            System.out.println("Ingrese una posicion: ");
            String pos = input.next();
            
            int fila = pos.charAt(0) - '0';
            int columna = pos.charAt(2) - '0';
            
            if (solucion[fila][columna] == '1'){
                n1sEncontradas += 1;
                tablero[fila][columna] = '1';
                n1sEncontradosF[fila] += 1;
                n1sEncontradosC[columna] += 1;
                imprimirTablero(tablero, solucion, n1sTotalesF, n1sTotalesC, n1sEncontradosF, n1sEncontradosC);
            }else{
                tablero[fila][columna] = 'X';
                imprimirTablero(tablero, solucion, n1sTotalesF, n1sTotalesC, n1sEncontradosF, n1sEncontradosC);
                System.out.println("");
                System.out.println("Encontro una bomba, ha perdido la partida");
                juego = false;
                break;
            }
            if (n1sEncontradas == n1sTotales){
                imprimirTablero(tablero, solucion, n1sTotalesF, n1sTotalesC, n1sEncontradosF, n1sEncontradosC);
                System.out.println("");
                System.out.println("Ha ganado la partida!");
                juego = false;
                break;
            }
            
            
            
        }
        
        

    }

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
    
    public static void imprimirTablero(char [][] tablero, char [][] solucion, int [] n1sTotalesF, int [] n1sTotalesC, int [] n1sEncontradosF, int [] n1sEncontradosC){
        
        System.out.println("");
        for (int f = 0; f < 4; f++){
            for(int c = 0; c < 4; c++){
                System.out.print("[" + tablero [f][c] + "]");
                if (c == 3){
                    System.out.print(n1sEncontradosF [f] + "/" + n1sTotalesF[f]);
                }
            }
            System.out.println("");
        }
        System.out.print(" " + n1sEncontradosC[0] + "  " + n1sEncontradosC[1] + "  " + n1sEncontradosC[2] + "  " + n1sEncontradosC[3]);
        System.out.println("");
        System.out.print(" " + n1sTotalesC[0] + "  " + n1sTotalesC[1] + "  " + n1sTotalesC[2] + "  " + n1sTotalesC[3]);
        
    }   

    public static char[][] llenarTablero(char [][] tablero){
        
        for (int f = 0; f < 4; f++){
            for(int c = 0; c < 4; c++){
                tablero[f][c] = ' ';
            }
        }        
        return tablero;
    }
    
    public static void imprimirSolucion(char[][] solucion){
        for (int f = 0; f < 4; f++){
            for(int c = 0; c < 4; c++){
                System.out.print("[" + solucion[f][c] + "]");              
            }
            System.out.println("");
        }        
        
    }
    
    
    
    // METODOS EJERCICIO 3
}
