public class fibonacci {
    public static void main(String[] args) {
        System.out.println("secuencia fibonacci en JAVA");
	int n=10, a= 0, b= 1, c;
	for (int i= 0 ; i<n ; i++){
	System.out.println(a);
	c = a + b;
	a=b;
	b=c;
}
    }
}
