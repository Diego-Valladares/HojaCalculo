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

  /**
   * Método que ejecuta la lógica del programa.
   */
  public void run() {

    //Variables que indican la cantidad de filas y columnas de la matriz.
    int rows = input.nextInt();
    int cols = input.nextInt();

    //System.out.println(rows +" "+cols);

    input.nextLine();
    input.nextLine();

    //Creación de la matriz que se llena con lo de la entrada estándar por medio
    //de 2 ciclos for.
    String[][] datos = new String[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int k = 0; k < cols; k++) {
        datos[i][k] = input.next();
        //System.out.print(datos[i][k]);
      }
      //System.out.println("");
    }

    //Dos ciclos for que exploran la matriz y reemplazan el carácter ',' por un
    //espacio vacío en cada componente de la matriz.
    for (int i = 0; i < rows; i++) {
      for (int k = 0; k < cols; k++) {
        datos[i][k] = datos[i][k].replace(',',' ');
        datos[i][k] = datos[i][k].replace(" ","");
      }
    }
    input.nextLine();

    //Se establece el delimitador que salte en "(".
    this.input.useDelimiter("[\\n (]");

    //Ciclo while que indica que lo que está en su interior se ejecuta mientras
    //haya una cadena texto.

    String nombres = "Vacio";
    String [] arregloConjuntos = new String[0];

    while (this.input.hasNextLine()) {

      //Variable que indicará cual comando se recibirá.
      String comando = this.input.next();
      //System.out.println(comando);

      //Variable que recibe las posiciones que se van a usar en el comando.
      String posiciones = this.input.next();
      //System.out.println(posiciones);


      //Variables que indicarán la primera y segunda letra de las posiciones
      //usadas por el comando.
      char primerLetra;
      char segundLetra;

      //Variables que indicarán los numeradores y denominadores de los
      //contenidos de las posiciones usadas por el comando.
      String num1;
      String num2;
      String den1;
      String den2;

      //Variables que se usarán para explorar la matriz y sus valores y
      //modificarlos o imprimirlos de acuerdo con el comando indicado.
      int row1;
      int row2;
      int col1;
      int col2;

      //If que indica la celda en donde estará el resultado del próximo comando.
      if (comando.contains(">=CEL")) {

        //Se obtiene el número como String de la celda que se va a modificar.
        primerLetra = posiciones.charAt(1);

        //Se establece la celda con el valor de primeraLetra como int.
        celdaRow = Character.getNumericValue(primerLetra);
        celdaRow = celdaRow - 1;
        //Se obtiene la letra de la celda que se va a modificar.
        primerLetra = posiciones.charAt(0);

        //Se establece la columna de la celda que se va a modificar con lo que
        //hay en "primeraLetra".
        celdaCol = primerLetra;

        //Se obtiene el valor numérico de la letra y se le restan 65 para que
        //quede establecido en la columna de la celda de la matriz que se
        //modifica.
        celdaCol = celdaCol - 65;
      }

      //If que indica que lo que tiene se ejecuta si el comando es ">=CONJUNTO".
      if (comando.contains(">=CONJUNTO")) {
        nombres = posiciones.split(",")[0];
        //System.out.println(nombres);
        //Se eliminan las comas en comando y se cuenta lo que hay.
        int temp = posiciones.split(",").length;
        //Se crea un arreglo de Strings de tamaño "temp".
        arregloConjuntos = new String[temp];
        //Ciclo for que explora arregloConjuntos y elimina las comas del
        //comando.
        for (int index = 1; index < temp; index++) {
          arregloConjuntos[index] = posiciones.split(",")[index];
        }
      }

      //If que indica que lo que tiene se ejecuta si el comando es ">=IMPRIMIR".
      if (comando.contains(">=IMPRIMIR")){
        if (posiciones.contains(nombres)){
          HojaDeCalculo.imprimirConjunto(nombres, arregloConjuntos);
        }
        else {
          //Invocación del método que se usará para imprimir la matriz.
          HojaDeCalculo.Imprimir(rows, cols,datos);
          //Se detiene la ejecución del programa.
          break;
        }
      }


      //If que indica que lo que tiene se ejecuta si el comando es ">=SUMA".
      if (comando.contains(">=SUMA")){
        if (posiciones.contains(nombres)){
          ListaDeFracciones suma = new ListaDeFracciones();
          datos[celdaRow][celdaCol] = suma.sumaConjunto(arregloConjuntos, datos);
        }
        else  {

          //Se obtiene el número como String de la celda en que se va a empezar.
          primerLetra = posiciones.charAt(1);

          //Se establece la variable "row1" con el valor de primeraLetra como
          //int.
          row1 = Character.getNumericValue(primerLetra);
          row1 = row1 - 1;
          //Se obtiene la letra de la celda en que se va a empezar.
          primerLetra = posiciones.charAt(0);

          //Se establece la columna de la celda en que se va a empezar con lo
          //que hay en "primeraLetra".
          col1 = primerLetra;

          //Se obtiene el valor numérico de la letra y se le restan 65 para que
          //quede establecido en la columna de la celda de la matriz que se
          //modifica.
          col1 = col1 - 65;

          //Se obtiene el número como String de la celda en que se va a
          //terminar.
          primerLetra = posiciones.charAt(4);

          //Se establece la variable "row2" con el valor de primeraLetra como
          //int.
          row2 = Character.getNumericValue(primerLetra);
          row2 = row2 - 1;
          //Se obtiene la letra de la celda en que se va a empezar.
          primerLetra = posiciones.charAt(3);

          //Se establece la columna de la celda en que se va a empezar con lo
          //que hay en "primeraLetra".
          col2 = primerLetra;

          //Se obtiene el valor numérico de la letra y se le restan 65 para que
          //quede establecido en la columna de la celda de la matriz que se
          //modifica.
          col2 = col2 - 65;
          //Se establecen "num2" y "den2" como "0".
          num2 = "0";
          den2 = "1";

          //Creación de una nueva instancia de clase Fraccion con "num2" y
          //"den2".
          Fraccion f2 = new Fraccion(num2,den2);

          //Dos ciclos por donde se exploran las celdas de la matriz, se
          //establece que los numeradores y denominadores tienen los valores
          //de números que tienen sin el carácter "/", se crea una nueva
          //instancia de la clase Fraccion con "num1" y "num2" y f2 pasa a tener
          //el valor de lo que se sume entre ella y f1.

          //System.out.println(row1 +" "+ col1 +" | "+row2 +" "+ col2);
          for (int i = row1; i <= row2; i++){
            for (int k = col1; k <= col2; k++){
              num1 = datos[i][k].split("/")[0];
              den1 = datos[i][k].split("/")[1];
              Fraccion f1 = new Fraccion(num1, den1);
              if (i == row1 && k == col1){
                f2 = f1;
              }
              else{
                f2 = f1.sumar(f2);
              }
            }
          }

          //Se establece que en la celda que se modifica, estará el valor de f2.
          datos[celdaRow][celdaCol] = f2.toString();

        }
      }

      if (comando.contains(">=PROMEDIO")) {
      
      }

      //If que indica que lo que tiene se ejecuta si el comando es ">=MULT".
      if (comando.contains(">=MULT")) {
        if (posiciones.contains(nombres)){
          ListaDeFracciones multiplicacion = new ListaDeFracciones();
          datos[celdaRow][celdaCol] = multiplicacion.multConjunto(arregloConjuntos, datos);
        }
        else {
          //Se obtiene el número como String de la celda en que se va a empezar.
          primerLetra = posiciones.charAt(1);

          //Se establece la variable "row1" con el valor de primeraLetra como
          //int.
          row1 = Character.getNumericValue(primerLetra);
          row1 = row1 - 1;
          //Se obtiene la letra de la celda en que se va a empezar.
          primerLetra = posiciones.charAt(0);

          //Se establece la columna de la celda en que se va a empezar con lo
          //que hay en "primeraLetra".
          col1 = primerLetra;

          //Se obtiene el valor numérico de la letra y se le restan 65 para que
          //quede establecido en la columna de la celda de la matriz que se
          //modifica.
          col1 = col1 - 65;

          //Se obtiene el número como String de la celda en que se va a
          //terminar.
          primerLetra = posiciones.charAt(4);

          //Se establece la variable "row2" con el valor de primeraLetra como
          //int.
          row2 = Character.getNumericValue(primerLetra);
          row2 = row2 - 1;
          //Se obtiene la letra de la celda en que se va a empezar.
          primerLetra = posiciones.charAt(3);

          //Se establece la columna de la celda en que se va a empezar con lo
          //que hay en "primeraLetra".
          col2 = primerLetra;

          //Se obtiene el valor numérico de la letra y se le restan 65 para que
          //quede establecido en la columna de la celda de la matriz que se
          //modifica.
          col2 = col2 - 65;

          //Se establecen "num2" y "den2" como "1".
          num2 = "1";
          den2 = "1";

          //Creación de una nueva instancia de clase Fraccion con "num2" y
          //"den2".

          Fraccion f2 = new Fraccion(num2,den2);

          //Dos ciclos dor donde se exploran las celdas de la matriz, se
          //establece que los numeradores y denominadores tienen los valores
          //de números que tienen sin el carácter "/", se crea una nueva
          //instancia de la clase Fraccion con "num1" y "num2" y f2 pasa a tener
          //el valor de lo que se multiplique entre ella y f1.
          for (int i = row1; i <= row2; i++){
            for (int k = col1; k <= col2; k++){
              num1 = datos[i][k].split("/")[0];
              den1 = datos[i][k].split("/")[1];
              Fraccion f1 = new Fraccion(num1, den1);
              if (i == row1 && k == col1){
                f2 = f1;
              }
              else {
                f2 = f1.multiplicar(f2);
              }
            }
          }

          //Se establece que en la celda que se modifica, estará el valor de f2.
          datos[celdaRow][celdaCol] = f2.toString();
        }
      }

      if (comando.contains(">=MEDIANA")) {

      }

      //If que indica que lo que tiene se ejecuta si el comando es ">=MIN".
      if (comando.contains(">=MIN")) {
        //Se obtiene el número como String de la celda en que se va a empezar.
        primerLetra = posiciones.charAt(1);

        //Se establece la variable "row1" con el valor de primeraLetra como
        //int.
        row1 = Character.getNumericValue(primerLetra);

        //Se obtiene la letra de la celda en que se va a empezar.
        primerLetra = posiciones.charAt(0);

        //Se establece la columna de la celda en que se va a empezar con lo
        //que hay en "primeraLetra".
        col1 = primerLetra;

        //Se obtiene el valor numérico de la letra y se le restan 65 para que
        //quede establecido en la columna de la celda de la matriz que se
        //modifica.
        col1 = col1 - 65;

        //Se obtiene el número como String de la celda en que se va a
        //terminar.
        primerLetra = posiciones.charAt(3);

        //Se establece la variable "row2" con el valor de primeraLetra como
        //int.
        row2 = Character.getNumericValue(primerLetra);

        //Se obtiene la letra de la celda en que se va a empezar.
        primerLetra = posiciones.charAt(4);

        //Se establece la columna de la celda en que se va a empezar con lo
        //que hay en "primeraLetra".
        col2 = primerLetra;

        //Se obtiene el valor numérico de la letra y se le restan 65 para que
        //quede establecido en la columna de la celda de la matriz que se
        //modifica.
        col2 = col2 - 65;

        //Variable que almacene el numerador.
        double numerador;

        //Variable que almacene el denominador.
        double denominador;

        //Variable que almacena el valor mínimo de lo que se está analizando.
        String minimo;

        //Variable que se usará para sacar el valor de la fracción que se
        //analiza.
        double total;

        //Contador que aumentará, después de analizar cada fracción.
        int contador = 0;

        //Se crea un arreglo de tipo String de tamaño row2 * col2 para que
        //contenga los valores obtenidos.
        double[] menores = new double[row2 * col2];

        //Se crea un arreglo de tipo String de tamaño row2 * col2 para que
        //contenga las coordenadas de los valores obtenidos.
        String[] cords = new String[row2 * col2];

        //Dos ciclos for donde se obtienen los datos de las celdas que se
        //analizan, se establece el numerador y el denominador, se hace la
        //división para sacar el valor de cada fracción; el valor va al arreglo
        //"menores" y las coordenadas al arreglo "cords" y el contador aumenta.
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

        //Variable que se usará para tener el valor mínimo.
        double min = 0;

        //Variable que se usará para tener el valor del número que se esté
        //revisando en un momento específico.
        double num = 0;

        //Variable que se usará para tener la ubicación de las coordenadas del
        //valor menor en el arreglo "cords".
        int coordenada = 0;

        //Ciclo for que recorre el arreglo "menores", compara si un valor es
        //menor que otro, cuando quede establecido el menor, se establecerá la
        //coordenada con su valor final en el arreglo "cords".
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

        //Variable que tiene la fila de la matriz donde está el dato menor.
        char fila = cords[coordenada].charAt(0);

        //Variable que tiene la columna de la matriz donde está el dato menor.
        char columna = cords[coordenada].charAt(2);

        //Se establece que la celda que se va a modificar tendrá el valor
        //almacenado en datos[fila][columna].
        datos[celdaRow][celdaCol] = datos[fila][columna];

      }

      //If que indica que lo que tiene se ejecuta si el comando es ">=MAX".
      if (comando.contains(">=MAX")) {

        //Se obtiene el número como String de la celda en que se va a empezar.
        primerLetra = posiciones.charAt(1);

        //Se establece la variable "row1" con el valor de primeraLetra como
        //int.
        row1 = Character.getNumericValue(primerLetra);

        //Se obtiene la letra de la celda en que se va a empezar.
        primerLetra = posiciones.charAt(0);

        //Se establece la columna de la celda en que se va a empezar con lo
        //que hay en "primeraLetra".
        col1 = primerLetra;

        //Se obtiene el valor numérico de la letra y se le restan 65 para que
        //quede establecido en la columna de la celda de la matriz que se
        //modifica.
        col1 = col1 - 65;

        //Se obtiene el número como String de la celda en que se va a
        //terminar.
        primerLetra = posiciones.charAt(3);

        //Se establece la variable "row2" con el valor de primeraLetra como
        //int.
        row2 = Character.getNumericValue(primerLetra);

        //Se obtiene la letra de la celda en que se va a empezar.
        primerLetra = posiciones.charAt(4);

        //Se establece la columna de la celda en que se va a empezar con lo
        //que hay en "primeraLetra".
        col2 = primerLetra;

        //Se obtiene el valor numérico de la letra y se le restan 65 para que
        //quede establecido en la columna de la celda de la matriz que se
        //modifica.
        col2 = col2 - 65;

        //Variable que almacene el numerador.
        double numerador;

        //Variable que almacene el denominador.
        double denominador;

        //Variable que almacena el valor mínimo de lo que se está analizando.
        String maximo;

        //Variable que se usará para sacar el valor de la fracción que se
        //analiza.
        double total;

        //Contador que aumentará, después de analizar cada fracción.
        int contador = 0;

        //Se crea un arreglo de tipo String de tamaño row2 * col2 para que
        //contenga los valores obtenidos.
        double[] mayores = new double[row2 * col2];

        //Se crea un arreglo de tipo String de tamaño row2 * col2 para que
        //contenga las coordenadas de los valores obtenidos.
        String[] cords = new String[row2 * col2];

        //Dos ciclos for donde se obtienen los datos de las celdas que se
        //analizan, se establece el numerador y el denominador, se hace la
        //división para sacar el valor de cada fracción; el valor va al arreglo
        //"mayores" y las coordenadas al arreglo "cords" y el contador aumenta.
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

        //Variable que se usará para tener el valor máximo.
        double max = 0;

        //Variable que se usará para tener el valor del número que se esté
        //revisando en un momento específico.
        double num = 0;

        //Variable que se usará para tener la ubicación de las coordenadas del
        //valor menor en el arreglo "cords".
        int coordenada = 0;

        //Ciclo for que recorre el arreglo "mayores", compara si un valor es
        //mayor que otro, cuando quede establecido el menor, se establecerá la
        //coordenada con su valor final en el arreglo "cords".
        for (int index = 0; index < (row2 * col2); index++) {
          num = mayores[index];

          if (num > max) {
            max = num;
            coordenada = index;
          }
        }

        //Variable que tiene la fila de la matriz donde está el dato mayor.
        char fila = cords[coordenada].charAt(0);

        //Variable que tiene la columna de la matriz donde está el dato mayor.
        char columna = cords[coordenada].charAt(2);

        //Se establece que la celda que se va a modificar tendrá el valor
        //almacenado en datos[fila][columna].
        datos[celdaRow][celdaCol] = datos[fila][columna];

      }




    }
    //Se cierra el input.
    input.close();

  }
}
