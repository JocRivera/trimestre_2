/*progrma que lea las ventas de un mes y muestre cuales y cuantas son mayores
que 20000*/
import java.util.Scanner;
public class ejercicio_3 {
	public static void main(string[]args)
	{
		double ventas[]=new double[30];
		scanner sc=new Scanner(System.in);
			System.out.println("ingrese las 30 ventas del mes");
			for(int i=0;i<ventas.length;i++) //i=2...
			{
				System.out.println("venta "+(i+1));
				ventas[i]=sc.nextDouble();
			}
			int k=0;
			int contador=0
			while (k<30)
			{
				if(ventas[k]>=2000)
					System.out.println(ventas[k]);
				total++;
					k++;
			}		
	}
}
