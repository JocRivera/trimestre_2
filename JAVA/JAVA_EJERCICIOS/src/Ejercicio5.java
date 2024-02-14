<<<<<<< HEAD
public class Ejercicio5 {
    
}
=======
import java.util.Scanner;
import java.util.Arrays; // Necesario para usar Arrays.toString()

public class Ejercicio5 {
    public static int[] invertir(int[] arreglo) {
        int[] resultado = new int[arreglo.length]; // La propiedad es "length", no "lenght"
        for (int i = 0; i < arreglo.length; i++) {
            resultado[i] = arreglo[arreglo.length - 1 - i];
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] vector = new int[10]; // La variable es "vector", no "venctor"
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un orden numérico de 10 valores: ");
        for (int i = 0; i < vector.length; i++) { // La propiedad es "length", no "lenght"
            vector[i] = sc.nextInt();
        }
        int[] vectorInvertido = invertir(vector);
        System.out.println("Valores invertidos: " + Arrays.toString(vectorInvertido));
    }
}

>>>>>>> origin/main
