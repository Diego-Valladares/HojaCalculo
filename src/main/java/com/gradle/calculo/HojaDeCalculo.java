package com.gradle.calculo;

/**
 * Clase que crea objetos relacionados con hojas de cálculo e imprime.
 */
public class HojaDeCalculo
{
  /**
   * Filas de la clase.
   */
  int rows;

  /**
   * Columnas de la clase.
   */
  int cols;

  /**
   * Matriz que tiene los datos de la clase.
   */
  String [][] datos;

  /**
   * Constructor de la clase.
   *
   * @param rows Recibe una variable de tipo {@code int} que tiene la cantidad
   *             de filas de la clase.
   * @param cols Recibe una variable de tipo {@code int} que tiene la cantidad
   *             de columnas de la clase.
   * @param datos Recibe una matriz de tipo {@code String[][]} que tiene los
   *              datos guardados para la clase.
   */
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
    String lineaDivisora = new String(new char[max]).replace("\0",
        "-");

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

  public static void imprimirConjunto (String nombres,
                                       String[] arregloConjuntos,
                                       String[][] datos){
    System.out.printf("%s -> ", nombres);
    for (int i = 1; i < arregloConjuntos.length; i++){
      char row = arregloConjuntos[i].charAt(1);
      int row1 = Character.getNumericValue(row);
      row1 = row1 - 1;
      int col1 = arregloConjuntos[i].charAt(0);
      col1 = col1 - 65;

      System.out.printf("%s ", datos[row1][col1]);
    }
    System.out.println("");
  }

} //java -jar HojaCalculo-1.0.jar < ../../tests/input006.txt