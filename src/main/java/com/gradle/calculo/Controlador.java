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


      if (comando.equals(">=SUMA")){
        if (posiciones.contains("conj")){

        }
        else {
        
        }
      }

      else if (comando.equals(">=PROMEDIO")) {

      }

      else if (comando.equals(">=MULT")) {
        if (posiciones.contains("conj")){

        }
        else {

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
