/*1: Hacer un programa que ingrese en un vector de 10 posiciones los múltiplos de 3
se debe imprimir el vector.  */
public class Ejercicio1 {
    public static void main(String[] args) {
        int m[];
        m = new int[10];
        int x = 3;
        for (int i=0; i<=9; i++){  
            m[i]= x;
            x+=3;
            }
        for (int f=0; f <= m.length -1; f++){
            System.out.println(m[f]);
        }        }
}
