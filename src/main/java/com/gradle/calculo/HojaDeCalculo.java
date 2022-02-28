package com.gradle.calculo;

public class HojaDeCalculo
{



  public static void Imprimir(int rows, int cols, String[][] datos){

    int size;
    int max = 0;
    for (int i = 0; i < rows; i++){
      for (int k = 0; k < cols; k++){
        size = datos[i][k].length();
        if (i == 0){
          max = size;
        }
        if (max < size){
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
      for (int k = 0; k < cols; k++){
        System.out.printf("%"+espacioNum+"d|", i+1);
        System.out.printf("%"+max+"s ", datos[i][k]);
      }
      System.out.println();
    }

  }
} //java -jar HojaCalculo-1.0.jar < ../../tests/input006.txt