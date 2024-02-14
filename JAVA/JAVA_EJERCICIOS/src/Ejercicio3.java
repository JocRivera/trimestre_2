/*3: Suma de Vectores: Escribe un programa que sume dos vectores de igual longitud y muestre el resultado.  */

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vector1[] = new int[3];
        int vector2[] = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese un número: ");
            vector1[i] = sc.nextInt();
        }
        for (int i= 0; i<3; i++) {
            System.out.println("ingrese un numero: ");
            vector2[i]=sc.nextInt();
       }
       for (int i=0; i<vector1.length; i++){
        System.out.println(vector1[i]+vector2[i]);
       }


    }

}
