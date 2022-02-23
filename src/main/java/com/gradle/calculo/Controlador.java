package com.gradle.calculo;
import java.util.Scanner;

public class Controlador {

  public static void main(final String[] args) {

    Controlador controlador = new Controlador();

    controlador.run();

  }

  public void run() {

    Scanner input = new Scanner(System.in);

    int rows = input.nextInt();
    int cols = input.nextInt();
    input.nextLine();

    String[][] datos = new String[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int k = 0; k < cols; k++) {
        datos[i][k] = input.next();
      }
    }

    
    input.close();

  }



}
