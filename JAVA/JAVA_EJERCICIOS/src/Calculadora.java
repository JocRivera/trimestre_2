import java.util.Scanner;

public class Calculadora {

    // Método para sumar dos números
    public static double sumar(double numero1, double numero2) {
        return numero1 + numero2;
    }

    // Método para restar dos números
    public static double restar(double numero1, double numero2) {
        return numero1 - numero2;
    }

    // Método para multiplicar dos números
    public static double multiplicar(double numero1, double numero2) {
        return numero1 * numero2;
    }

    // Método para dividir dos números
    public static double dividir(double numero1, double numero2) {
        if (numero2 != 0) {
            return numero1 / numero2;
        } else {
            System.out.println("Error: No se puede dividir por cero.");
            return Double.NaN; // NaN (Not a Number) representa un valor indeterminado o indefinido.
        }
    }

    public static void menu() {
      Scanner scanner = new Scanner(System.in);
      char op;
      double resultado, numero1, numero2;
      System.out.print("Ingrese un numero: ");
      numero1 = scanner.nextDouble();
      System.out.print("Ingrese operacion + - * % ");
      op = scanner.next().charAt(0);
      System.out.print("Ingrese un numero: ");
      numero2 = scanner.nextDouble();
      resultado = numero1 + numero2;

      if (op == '+') {
        System.out.print("la Suma da: " + sumar(numero1, numero2));
      } else if (op == '-') {
        System.out.print("la Resta da: " + restar(numero1, numero2));
      } else if (op == '*') {
        System.out.print("la multiplicacion da: " + multiplicar(numero1, numero2));
      } else if (op == '%') {
        System.out.print("la division da: " + dividir(numero1, numero2));
      } else {
        System.out.print("Debe especificar la operacion");
      }
      System.out.print("\n");
      scanner.close();
    }


    public static void main(String[] args) {
        // Ejemplo de uso de los métodos
        menu();
    }
}
