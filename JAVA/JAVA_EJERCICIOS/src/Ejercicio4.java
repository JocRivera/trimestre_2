/*4: Mínimo y Máximo: Desarrolla un programa que encuentre el valor mínimo y máximo en un vector dado.   */
import java.util.Scanner;
public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vector[]= new int[5];
        for(int i=0; i<= vector.length -1; i++){
            System.out.println("ingrese un numero: ");
            vector[i] = sc.nextInt();
        }
    
        for(int k=0;k<vector.length;k++) {
            for(int f=0;f<vector.length-1-k;f++) {
                if (vector[f]<vector[f+1]) {
                    int auxnota;
                    auxnota=vector[f];
                    vector[f]=vector[f+1];
                    vector[f+1]=auxnota;
                }
            }
    }
        
        for (int i=0; i<vector.length;i++){
            System.out.println("mayor a menor: "+vector[i]);
        }   
    }
}
