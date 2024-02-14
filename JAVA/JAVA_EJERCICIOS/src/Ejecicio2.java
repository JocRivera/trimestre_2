/*2:  Hacer un programa que pida ingresar 5 números por teclado y almacenarlo en un vector con su valor elevado al cuadrado  
import java.util.Scanner;
public class Ejecicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeros[];
        numeros = new int [5];
        for (int i=0; i<=numeros.length-1 ;i++){
            System.out.println("ingrese un numero: ");
            numeros[i]= sc.nextInt();
            for(int f=0; f <= 5; f++){
                System.out.println(numeros[i]);
            }            
        }
    }
}*/
import java.util.Scanner;

public class Ejecicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeros[] = new int[5]; // Declaración y creación del vector para almacenar los números

        // Solicitar al usuario que ingrese los números y almacenarlos en el vector
        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese un número: ");
            numeros[i] = sc.nextInt();
        }

        // Elevar al cuadrado cada número en el vector
        for (int i = 0; i < 5; i++) {
            numeros[i] = numeros[i] * numeros[i];
        }

        // Imprimir los valores elevados al cuadrado
        System.out.println("Los números elevados al cuadrado son:");
        for (int i = 0; i < 5; i++) {
            System.out.println(numeros[i]);
        }
        sc.close();

    }
}
