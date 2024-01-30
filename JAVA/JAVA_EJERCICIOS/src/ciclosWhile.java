/*Una planta que fabrica perfiles de hierro posee un lote de n piezas.
Confeccionar un programa que pida ingresar por teclado la cantidad de piezas a procesar y luego ingrese la longitud de cada perfil;
sabiendo que la pieza cuya longitud esté comprendida en el rango de 1,20 y 1,30 son aptas. 
Imprimir por pantalla la cantidad de piezas aptas que hay en el lote */
import java.util.Scanner;
public class ciclosWhile {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int x, piezasAptas, cantidad;
        float longitud;
        piezasAptas=0;
        x= 1;
        System.out.println(
            "ingrese cantidad de piezas a procesar: "
        );
        cantidad=teclado.nextInt();
        while(x <= cantidad){
            System.out.println("ingrese la longitud de la pieza"+ x);
            longitud=teclado.nextFloat();
            if (longitud>=1.20 && longitud<=1.30){
                piezasAptas++;
            }
            else;
            x++;
        }
        System.out.println("las piezas aptas son: "+ piezasAptas);
    }
}