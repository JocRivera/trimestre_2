/*Inversión de Vectores: Implementa un programa que invierta el orden de los elementos en un vector */
import java.util.Scanner;
public class Ejercicio5 {
public static int[] invertir(int[]arreglo){
	int[] resultado = new int[arreglo.lenght];
	for(int i=0; i< arreglo.lenght; i++){
		resultado[i]= arreglo[arreglo.lenght -1 -i];
}
	return resultado;
}
    public static void main(String[] args) {
        int venctor[]= new int[10];
	Scanner sc= new Scanner(System.in);
	System.out.println("ingrese un orden numerico de 10 valores: ");
	for(int i=0; i<=vector.lenght-1; i++){
		vector[]=sc.nextInt();
}
	int []vectorInvertido=invertir(vector);
	System.out.println("valores invertidos: "+ Arrays.toString(vectorIrInvertido));
    }
}
