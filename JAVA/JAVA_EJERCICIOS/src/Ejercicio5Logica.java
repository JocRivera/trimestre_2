import java.util.Scanner;

public class Ejercicio5Logica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el tamaño del vector:");
        int tamaño = scanner.nextInt();

        int[] vector = new int[tamaño];

        System.out.println("Ingrese los valores del vector:");
        for (int i = 0; i < tamaño; i++) {
            vector[i] = scanner.nextInt();
        }

        // Invertir el orden de los elementos
        for (int i = 0; i < tamaño / 2; i++) {
            int temp = vector[i];
            vector[i] = vector[tamaño - 1 - i];
            vector[tamaño - 1 - i] = temp;
        }

        System.out.println("El vector invertido es:");
        for (int i = 0; i < tamaño; i++) {
            System.out.println("Valor en la posición " + i + ": " + vector[i]);
        }

        scanner.close();
    }
}