import java.util.Scanner;
public class ciclosFor {
    public static void main(String[] args) {
        System.out.println(
            "ejercicios ciclos "
        );
        Scanner scanner = new Scanner(System.in);
        System.out.println(
            "ingrese un numero: "
        );
        int numero = scanner.nextInt();
        int i;
        for (i=1; i<=10; i++){
            System.out.println(numero +" x "+ i + " = " + (numero*i));}
    }
}