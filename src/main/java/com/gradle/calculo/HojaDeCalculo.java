package com.gradle.calculo;

public class HojaDeCalculo
{

  int rows;
  int cols;
  String [][] datos;

  HojaDeCalculo(int rows, int cols, String[][] datos){
    this.rows = rows;
    this.cols = cols;
    this.datos = datos;

  }

  public static void Imprimir(int rows, int cols, String[][] datos){

    int size;
    int max = 0;
    for (int i = 0; i < rows; i++){
      for (int k = 0; k < cols; k++){
        size = datos[i][k].length();
        if (i == 0 && k == 0){
          max = size;
        }
        else if (max < size){
          max = size;
        }
      }
    }

    char [] letras = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    int espacioNum = 3;
    String lineaDivisora = new String(new char[max]).replace("\0", "-");

    System.out.print("   |");
    for (int i = 0; i < cols; i ++){
      System.out.printf("%"+max+"C ", letras[i]);
    }
    System.out.println();
    System.out.print("---+");
    for (int i = 0; i < cols; i ++){
      System.out.printf("%s ", lineaDivisora);
    }
    System.out.println();
    for (int i = 0; i < rows; i ++){
      System.out.printf("%"+espacioNum+"d|", i+1);
      for (int k = 0; k < cols; k++){
        System.out.printf("%"+max+"s ", datos[i][k]);
      }
      System.out.println();
    }

  }

  public static void imprimirConjunto (String nombres, String[] arregloConjuntos){
    System.out.printf("%s -> ", nombres);
    for (int i = 1; i < arregloConjuntos.length; i++){
      System.out.printf("%s ", arregloConjuntos[i]);
    }
  }

} //java -jar HojaCalculo-1.0.jar < ../../tests/input006.txt