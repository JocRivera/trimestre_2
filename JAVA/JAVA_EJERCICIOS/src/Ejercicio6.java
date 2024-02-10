/*Contador de Elementos Pares: Escribe un programa que cuente y muestre la cantidad de números pares en un vector */
import java.util.Scanner;

public class Ejercicio6 {
    // Método para contar la cantidad de números pares en un vector
    public static int contarPares(int[] arreglo) {
        int contador = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] % 2 == 0) { // Comprueba si el número es par
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario el tamaño del vector
        System.out.print("Ingrese el tamaño del vector: ");
        int tamaño = scanner.nextInt();

        // Crear un vector del tamaño especificado por el usuario
        int[] vector = new int[tamaño];

        // Solicitar al usuario que ingrese los elementos del vector
        System.out.println("Ingrese los elementos del vector:");
        for (int i = 0; i < tamaño; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vector[i] = scanner.nextInt();
        }

        // Contar la cantidad de números pares en el vector
        int cantidadPares = contarPares(vector);

        // Mostrar la cantidad de números pares en el vector
        System.out.println("La cantidad de números pares en el vector es: " + cantidadPares);

        scanner.close();
    }
}

