import java.util.Scanner;

public class Main4 {
    public static void main(String[] ar) {
        Scanner teclado=new Scanner(System.in);
        String apellido1,apellido2;
        System.out.print("Ingrese primer apellido:");
        apellido1=teclado.next();
        System.out.print("Ingrese segundo apellido:");
        apellido2=teclado.next();
        if (apellido1.equals(apellido2)) {
            System.out.print("Los apellidos son iguales");
        } else {
            System.out.print("Los apellidos son distintos");
        }
    }
}
/*Para comparar si el contenido de dos String son iguales no podemos utilizar el operador ==.
Debemos utilizar un método de la clase String llamado equals y pasar como parámetro el String con el que queremos compararlo
if (apellido1.equals(apellido2)) */