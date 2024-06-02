package clase.pkg2;

import java.util.Random;

/**
 *
 * @author Rodolfo Morales 202010033
 */
public class Clase2 {

    public static void main(String[] args) {
        // ARREGLOS UNIDIMENSIONALES
        // Creación arreglo unidimensional de numeros enteros con 5 elementos
        int[] arregloEnteros = new int[5];

        // Visualizar el contenido del arreglo unidimensional
        // nombre_de_nuestro_vector.length -> La funcion length nos retornara el largo de nuestro vector (En este caso seria 5)
        for (int i = 0; i < arregloEnteros.length; i++) {
            System.out.println("Elemento en la posicion " + i + ": " + arregloEnteros[i]);
        }

        // Asignacion de valores a los elementos del arreglo
        arregloEnteros[0] = 10;
        arregloEnteros[1] = 20;
        arregloEnteros[2] = 30;
        arregloEnteros[3] = 40;
        arregloEnteros[4] = 50;

        System.out.println("-----------------------------------------------------");
        // Visualizar el contenido del arreglo unidimensional
        for (int i = 0; i < arregloEnteros.length; i++) {
            System.out.println("Elemento en la posición " + i + ": " + arregloEnteros[i]);
        }

        // Otra forma de declarar un arreglo unidimensional
        int[] arregloEnteros2 = {1, 2, 3, 4, 5};

        // Visualizar valores del vector usando for-each
        System.out.println("-----------------------------------------------------");
        for (int elemento : arregloEnteros2) {
            System.out.println("Elemento: " + elemento);
        }

        // ARREGLOS BIDIMIENSIONALES
        // Creacion matriz 8x8
        int[][] matriz = new int[8][8];

        // Asignar valores a los elementos de la matriz usando bucles for
        int contador = 1;
        // El primer for nos sirve para el manejo de filas
        // El segundo for nos sirve para el manejo de columnas
        for (int i = 0; i < matriz.length; i++) { // matriz.length -> 8 filas
            for (int j = 0; j < matriz[i].length; j++) { // matriz[i].length -> 8 columnas
                matriz[i][j] = contador;
                contador++;
            }
        }

        System.out.println("-----------------------------------------------------");
        // Imprimir matriz usando for-each
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < matriz.length; i++) { // matriz.length -> 8 filas
            for (int j = 0; j < matriz[i].length; j++) { // matriz[i].length -> 8 columnas
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // Otra forma de declarar una matriz
        int[][] matriz2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        // Imprimir los valores que conforman la diagonal de la matriz2
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < matriz2.length; i++) {
            System.out.println(matriz2[i][i] + " ");
        }

        // Convertir un string en un vector de chars y luego imprimir este vector
        // Para la práctica uno ver la siguiente página que tiene la tabla unicode: https://agostudio.es/tabla-unicode/
        // Tomar en cuenta que cada caracter tiene un valor Unicode
        System.out.println("-----------------------------------------------------");
        String texto = "IPC1 - A";
        char[] vectorTexto = texto.toCharArray();
        for (char letra : vectorTexto) {
            if (letra == 65) { // Si el caracter actual es una A, entonces como su valor unicode en decimal es 65, nos dará true
                System.out.println("Sección A");
            } else {
                System.out.println(letra);
            }
        }

        // LLAMADA DE PROCEDIMIENTO SIN PARÁMETROS
        printMenu();

        // LLAMADA DE PROCEDIMIENTO CON PARÁMETROS
        printNewMenu("5. Mostrar tabla de multiplicación");

        // LLAMADA DE FUNCIÓN SIN PARÁMETROS
        System.out.println("El número aleatorio es: " + getNumber());

        // LLAMADA DE FUNCIÓN CON PARÁMETROS
        int resultadoSuma = Suma(5, 4);
        System.out.println("El resultado de la suma es: " + resultadoSuma);
    }

    // PROCEDIMIENTO SIN PARÁMETROS
    static void printMenu() {
        System.out.println("========================");
        System.out.println("MAIN MENU");
        System.out.println("1. Realizar suma");
        System.out.println("2. Realizar resta");
        System.out.println("3. Realizar multiplicacion");
        System.out.println("4. Realizar division");
        System.out.println("========================");
    }

    // PROCEDIMIENTO CON PARÁMETROS
    static void printNewMenu(String newOption) {
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("MAIN MENU");
        System.out.println("1. Realizar suma");
        System.out.println("2. Realizar resta");
        System.out.println("3. Realizar multiplicacion");
        System.out.println("4. Realizar division");
        System.out.println(newOption);
        System.out.println("++++++++++++++++++++++++++++++++++++");
    }

    // FUNCIÓN SIN PARÁMETROS
    static int getNumber() {
        // Crear una instancia de la clase Random
        Random random = new Random();
        // Generar un número aleatorio en un rango específico(por ejemplo, entre 1 y 100)
        int numeroEnRango = random.nextInt(100) + 1;
        return numeroEnRango;
    }

    // FUNCIÓN CON PARÁMETROS
    static int Suma(int n1, int n2) {
        return (n1 + n2);
    }
}
