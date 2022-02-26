package com.gradle.calculo;
import java.util.Scanner;

public class Controlador {

  private Scanner input = new Scanner(System.in);

  public static void main(final String[] args) {

    Controlador controlador = new Controlador();

    controlador.run();

  }


  static int celdaRow = 0;
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

      char primerLetra = ' ';
      char segundLetra = ' ';
      String num1 = " ";
      String num2 = " ";
      String den1 = " ";
      String den2 = " ";
      int row1 = 0;
      int row2 = 0;
      int col1 = 0;
      int col2 = 0;


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

      if (comando.equals(">=CONJUNTO")) {
        int temp = comando.split(",").length;
        String[] arregloConjuntos = new String[temp];
        for (int index = 1; index< temp; index++) {
          arregloConjuntos[index] = comando.split(",")[index];
        }
      }

      if (comando.equals(">=SUMA")){
        if (posiciones.contains("conj")){

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
          col2 = col1 - 65;

          num2 = "0";
          den2 = "0";
          Fraccion f2 = new Fraccion(num2,den2);

          for (int i = row1; i <= row2; i++){
            for (int k = col1; k <= col2; k++){
              num1 = datos[row1][col1].split("/")[0];
              den1 = datos[row1][col1].split("/")[1];
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
        if (posiciones.contains("conj")){

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
          col2 = col1 - 65;

          num2 = "1";
          den2 = "1";
          Fraccion f2 = new Fraccion(num2,den2);

          for (int i = row1; i <= row2; i++){
            for (int k = col1; k <= col2; k++){
              num1 = datos[row1][col1].split("/")[0];
              den1 = datos[row1][col1].split("/")[1];
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

      }

      else if (comando.equals(">=MAX")) {

      }




    }

    input.close();

  }
}
