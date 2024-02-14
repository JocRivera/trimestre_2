public class Ejercicio10 {
    // Método para ordenar el vector en orden ascendente
    public static void ordenarAscendente(int[] vector) {
        for (int i = 0; i < vector.length - 1; i++) {
            for (int j = 0; j < vector.length - i - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    // Intercambiar elementos si el actual es mayor que el siguiente
                    int temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                }
            }
        }
    }

    // Método para ordenar el vector en orden descendente
    public static void ordenarDescendente(int[] vector) {
        for (int i = 0; i < vector.length - 1; i++) {
            for (int j = 0; j < vector.length - i - 1; j++) {
                if (vector[j] < vector[j + 1]) {
                    // Intercambiar elementos si el actual es menor que el siguiente
                    int temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] vector = {4, 2, 7, 1, 3}; // Vector de ejemplo

        // Orden ascendente
        ordenarAscendente(vector);
        System.out.print("Vector ordenado ascendente: ");
        imprimirVector(vector);

        // Orden descendente
        ordenarDescendente(vector);
        System.out.print("Vector ordenado descendente: ");
        imprimirVector(vector);
    }

    // Método auxiliar para imprimir el vector
    public static void imprimirVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }
}

