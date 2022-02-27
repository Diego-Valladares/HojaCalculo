package com.gradle.calculo;
import java.util.*;

/**
 * Clase que maneja el programa; desde ella se llama a los métodos y se hacen
 * instancias otras clases.
 */
public class Controlador {

  /**
   * Instancia de clase Scanner que recibe los datos de la entrada estándar.
   */
  private final Scanner input = new Scanner(System.in);

  /**
   * Método que arranca el programa.
   *
   * @param args Argumentos del programa.
   */
  public static void main(final String[] args) {

    //Creación de una instancia de clase Controlador.
    Controlador controlador = new Controlador();
    //Invocación del método run.
    controlador.run();

  }

  //Variable que contiene la fila en que actualizará la información.
  static int celdaRow = 0;
  //Variable que contiene la columna en que actualizará la información.
  static int celdaCol = 0;

  public void run() {

    int rows = input.nextInt();
    int cols = input.nextInt();
    input.nextLine();

    String[][] datos = new String[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int k = 0; k < cols; k++) {
        datos[i][k] = input.next();
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int k = 0; k < cols; k++) {
        datos[i][k] = datos[i][k].replace(',',' ');
      }
    }

    char parentesis = '(';

    this.input.useDelimiter(String.valueOf(parentesis));

    while (this.input.hasNext()) {
      String comando = this.input.next();

      String posiciones = this.input.next();

      char primerLetra;
      char segundLetra;
      String num1;
      String num2;
      String den1;
      String den2;
      int row1;
      int row2;
      int col1;
      int col2;


      if (comando.equals(">=CEL")) { // Para conseguir la celda que se va a reemplazar
        primerLetra = posiciones.charAt(1);
        celdaRow = Character.getNumericValue(primerLetra);
        primerLetra = posiciones.charAt(0);
        celdaCol = primerLetra;
        celdaCol = celdaCol - 65;
      }

      if (comando.equals(">=IMPRIMIR")){
        //Llamar a metodo de impresion
      }

      String nombres = comando.split(",")[0];

      if (comando.equals(">=CONJUNTO")) {
        int temp = comando.split(",").length;
        String[] arregloConjuntos = new String[temp];
        for (int index = 1; index< temp; index++) {
          arregloConjuntos[index] = comando.split(",")[index];
        }
      }

      if (comando.equals(">=SUMA")){
        if (posiciones.contains(nombres)){

        }
        else {
          primerLetra = posiciones.charAt(1);
          row1 = Character.getNumericValue(primerLetra);
          primerLetra = posiciones.charAt(0);
          col1 = primerLetra;
          col1 = col1 - 65;

          primerLetra = posiciones.charAt(3);
          row2 = Character.getNumericValue(primerLetra);
          primerLetra = posiciones.charAt(4);
          col2 = primerLetra;
          col2 = col2 - 65;

          num2 = "0";
          den2 = "0";
          Fraccion f2 = new Fraccion(num2,den2);

          for (int i = row1; i <= row2; i++){
            for (int k = col1; k <= col2; k++){
              num1 = datos[i][k].split("/")[0];
              den1 = datos[i][k].split("/")[1];
              Fraccion f1 = new Fraccion(num1, den1);
              f2 = f2.sumar(f1);
            }
          }

          datos[celdaRow][celdaCol] = f2.toString();

        }
      }

      else if (comando.equals(">=PROMEDIO")) {
      
      }

      else if (comando.equals(">=MULT")) {
        if (posiciones.contains(nombres)){

        }
        else {
          primerLetra = posiciones.charAt(1);
          row1 = Character.getNumericValue(primerLetra);
          primerLetra = posiciones.charAt(0);
          col1 = primerLetra;
          col1 = col1 - 65;

          primerLetra = posiciones.charAt(3);
          row2 = Character.getNumericValue(primerLetra);
          primerLetra = posiciones.charAt(4);
          col2 = primerLetra;
          col2 = col2 - 65;

          num2 = "1";
          den2 = "1";
          Fraccion f2 = new Fraccion(num2,den2);

          for (int i = row1; i <= row2; i++){
            for (int k = col1; k <= col2; k++){
              num1 = datos[i][k].split("/")[0];
              den1 = datos[i][k].split("/")[1];
              Fraccion f1 = new Fraccion(num1, den1);
              f2 = f2.multiplicar(f1);
            }
          }

          datos[celdaRow][celdaCol] = f2.toString();
        }
      }

      else if (comando.equals(">=MEDIANA")) {

      }

      else if (comando.equals(">=MIN")) {
        primerLetra = posiciones.charAt(1);
        row1 = Character.getNumericValue(primerLetra);
        primerLetra = posiciones.charAt(0);
        col1 = primerLetra;
        col1 = col1 - 65;

        primerLetra = posiciones.charAt(3);
        row2 = Character.getNumericValue(primerLetra);
        primerLetra = posiciones.charAt(4);
        col2 = primerLetra;
        col2 = col2 - 65;

        double numerador;
        double denominador;
        String minimo;
        double total;
        int contador = 0;
        double[] menores = new double[row2 * col2];
        String[] cords = new String[row2 * col2];
        for (int i = row1; i <= row2; i++){
          for (int k = col1; k <= col2; k++){
            minimo = datos[i][k].split("/")[0];
            numerador = Double.parseDouble(minimo);
            minimo = datos[i][k].split("/")[1];
            denominador = Double.parseDouble(minimo);
            total = numerador / denominador;
            menores[contador] = total;
            cords[contador] = i +" "+ k;
            contador++;
          }
        }
        double min = 0;
        double num = 0;
        int coordenada = 0;
        for (int index = 0; index < (row2 * col2); index++) {
          num = menores[index];
          if (index == 0) {
            min = num;
          }

          if (num < min) {
            min = num;
            coordenada = index;
          }
        }

        char fila = cords[coordenada].charAt(0);
        char columna = cords[coordenada].charAt(2);

        datos[celdaRow][celdaCol] = datos[fila][columna];

      }

      else if (comando.equals(">=MAX")) {

        primerLetra = posiciones.charAt(1);
        row1 = Character.getNumericValue(primerLetra);
        primerLetra = posiciones.charAt(0);
        col1 = primerLetra;
        col1 = col1 - 65;

        primerLetra = posiciones.charAt(3);
        row2 = Character.getNumericValue(primerLetra);
        primerLetra = posiciones.charAt(4);
        col2 = primerLetra;
        col2 = col2 - 65;

        double numerador;
        double denominador;
        String maximo;
        double total;
        int contador = 0;
        double[] mayores = new double[row2 * col2];
        String[] cords = new String[row2 * col2];
        for (int i = row1; i <= row2; i++){
          for (int k = col1; k <= col2; k++){
            maximo = datos[i][k].split("/")[0];
            numerador = Double.parseDouble(maximo);
            maximo = datos[i][k].split("/")[1];
            denominador = Double.parseDouble(maximo);
            total = numerador / denominador;
            mayores[contador] = total;
            cords[contador] = i +" "+ k;
            contador++;
          }
        }
        double max = 0;
        double num = 0;
        int coordenada = 0;
        for (int index = 0; index < (row2 * col2); index++) {
          num = mayores[index];

          if (num > max) {
            max = num;
            coordenada = index;
          }
        }

        char fila = cords[coordenada].charAt(0);
        char columna = cords[coordenada].charAt(2);

        datos[celdaRow][celdaCol] = datos[fila][columna];

      }




    }

    input.close();

  }
}
