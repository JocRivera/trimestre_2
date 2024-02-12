/*Búsqueda de Elemento: Escribe un programa que busque la posición de un elemento dado en un vector.  */
import java.util.Scanner;
public class Ejercicio9 {
        // Método para expandir la capacidad del vector duplicándola
    public static int[] expandirVector(int[] vector) {
        int nuevaCapacidad = vector.length * 2;
        int[] nuevoVector = new int[nuevaCapacidad];
        System.arraycopy(vector, 0, nuevoVector, 0, vector.length);
        return nuevoVector;
    };


    public static int buscarPosicion(int[]vector, int elemento){
        for(int i=0; i<vector.length; i++){
            if (vector[i]==elemento){
                return i;
            }
        }

        return -1;
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantidadNumeros= 0;
        int[] vector = new int [3];
        System.out.println("Ingrese una serie de numeros, ingrese 0 para salir: ");
        while(true){
            int input = sc.nextInt();
            if(input==0){
                break;//salir
            }
            
            if(cantidadNumeros==vector.length){
                vector=expandirVector(vector);

            }
            vector[cantidadNumeros]=input;
            cantidadNumeros++;
        } 
        System.out.println("ingrese el numero que desea buscar");
        int elementoInput =sc.nextInt();
        int posición=buscarPosicion(vector, elementoInput);
        if(posición==-1){
            System.out.println("numero no encontrado");
        }
        else{
            System.out.println("el elemento "+elementoInput +" se encuentra en la posicion: "+ (posición+1));
        }
        sc.close();
        
    }
}
