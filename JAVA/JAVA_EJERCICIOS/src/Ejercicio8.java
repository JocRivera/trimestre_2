/*Desarrolla un programa que calcule el promedio de un vector de números */

/*import java.util.Arrays;

public class Ejercicio8 {
    public static int[] calcularPromedio(int[]args){
        int promedio=0;
        int suma=0;
        for(int i=0; i<args.length; i++){
            for (int x= 1; x==args.length; x++){
                suma= args[i]+args[x]/args.length;
            }
                }
        System.out.println(suma);
        return args;
    }
    public static void main(String[] args) {
        int[] vector={2, 3, 3, 4, 8, 12, 2};
        int[] promedio= calcularPromedio(vector);
        System.out.println(Arrays.toString(promedio));
    }
}*/
public class Ejercicio8 {
    public static double calcularPromedio(int[] vector) {
        int suma = 0;
        for (int i = 0; i < vector.length; i++) {
            suma += vector[i];
        }
        double promedio = (double) suma / vector.length;
        return promedio;
    }

    public static void main(String[] args) {
        int[] vector = {2, 3, 3, 4, 8, 12, 2};
        double promedio = calcularPromedio(vector);
        System.out.println("El promedio del vector es: " + promedio);
    }
}
/*Cambios realizados:

Se ha cambiado el tipo de dato del método calcularPromedio a double ya que el promedio podría ser un número decimal.
Se ha eliminado el bucle interno y se ha calculado la suma de los elementos en un solo bucle.
Se ha corregido la fórmula del promedio dividiendo la suma total por la cantidad de elementos del vector.
Se ha cambiado la impresión del promedio en el método main para reflejar el cambio de tipo de dato y para que el resultado sea más legible. */
