package com.gradle.calculo;
import java.util.Scanner;

public class Controlador {

  private Scanner input = new Scanner(System.in);

  public static void main(final String[] args) {

    Controlador controlador = new Controlador();

    controlador.run();

  }

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
      char posicion2 = ' ';
      if (comando.equals(">=CEL")) {
      } else if (comando.equals(">=SUMA")) {
        posicion2 = posiciones.charAt(1);
        if (String.valueOf(posicion2).equals("1")
            || String.valueOf(posicion2).equals("2")
            || String.valueOf(posicion2).equals("3")
            || String.valueOf(posicion2).equals("4")
            || String.valueOf(posicion2).equals("5")
            || String.valueOf(posicion2).equals("6")
            || String.valueOf(posicion2).equals("7")
            || String.valueOf(posicion2).equals("8")
            || String.valueOf(posicion2).equals("9")) {

        }
      } else if (comando.equals(">=PROMEDIO")) {

      } else if (comando.equals(">=MULT")) {
        posicion2 = posiciones.charAt(1);
        if (String.valueOf(posicion2).equals("1")
            || String.valueOf(posicion2).equals("2")
            || String.valueOf(posicion2).equals("3")
            || String.valueOf(posicion2).equals("4")
            || String.valueOf(posicion2).equals("5")
            || String.valueOf(posicion2).equals("6")
            || String.valueOf(posicion2).equals("7")
            || String.valueOf(posicion2).equals("8")
            || String.valueOf(posicion2).equals("9")) {

        }
      } else if (comando.equals(">=MEDIANA")) {
      } else if (comando.equals(">=MIN")) {
      } else if (comando.equals(">=MAX")) {
      } else if (comando.equals(">=CONJUNTO")) {
      }
    }
    
    input.close();

  }



}
