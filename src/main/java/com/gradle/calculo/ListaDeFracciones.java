package com.gradle.calculo;

public class ListaDeFracciones {

  public String sumaConjunto (String[] arregloConjuntos, String[][] datos) {


    String num = "0";
    String den = "1";
    Fraccion f2 = new Fraccion(num, den);

    for (int i = 1; i < arregloConjuntos.length; i++){
      char Letra = arregloConjuntos[i].charAt(1);
      int row = Character.getNumericValue(Letra);
      row = row - 1;

      Letra = arregloConjuntos[i].charAt(0);
      int col = Letra;
      col = col - 65;

      String num2 = datos[row][col].split("/")[0];
      String den2 = datos[row][col].split("/")[1];
      Fraccion f1 = new Fraccion (num2, den2);
      if (i == 1){
        f2 = f1;
      }
      else {
        f2 = f1.sumar(f2);
      }

    }
    return f2.toString();
  }
  public String multConjunto (String[] arregloConjuntos, String[][] datos) {


    String num = "1";
    String den = "1";
    Fraccion f2 = new Fraccion(num, den);

    for (int i = 1; i < arregloConjuntos.length; i++){
      char Letra = arregloConjuntos[i].charAt(1);
      int row = Character.getNumericValue(Letra);
      row = row - 1;

      Letra = arregloConjuntos[i].charAt(0);
      int col = Letra;
      col = col - 65;

      String num2 = datos[row][col].split("/")[0];
      String den2 = datos[row][col].split("/")[1];
      Fraccion f1 = new Fraccion (num2, den2);
      if (i == 1){
        f2 = f1;
      }
      else {
        f2 = f1.multiplicar(f2);
      }

    }
    return f2.toString();
  }
}
