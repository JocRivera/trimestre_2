 /*Eliminación de Duplicados: Crea un programa que elimine los elementos duplicados de un vector.  */

import java.util.Arrays;

public class Ejercicio7 {
    public static int[] eliminarDuplicado(int[]arreglo){
        int contador= 0;
        for(int i=0; i<arreglo.length; i++){
            boolean esDuplicado=false;
            for (int x=0; x< i; x++){
                if(arreglo[i]==arreglo[x]){
                    esDuplicado=true;
                    break;
                }
            }
            if(esDuplicado==false){
                contador ++;
            }
                }
        int[] arreglosSinDuplicar = new int[contador];
            contador=0;
            for(int i=0; i<arreglo.length; i++){
                boolean esDuplicado=false;
                for(int x=0 ; x<i; x++){
                    if(arreglo[i]==arreglo[x]){
                        esDuplicado=true;
                        break;
                    }
                }
                if (!esDuplicado){
                    arreglosSinDuplicar[contador]=arreglo[i];
                    contador++;
                }
}
        return arreglosSinDuplicar;

    }
    public static void main(String[] args) {
    //int vector[]= new int[5]; otra forma de iniciar un vector
        int[] vector={23, 23, 21 ,22, 24};
        for(int i=0; i < vector.length; i++){
            System.out.println(vector[i]);
        }
        int[] duplicados = eliminarDuplicado(vector);
        System.out.println(Arrays.toString(duplicados));

    }
}
