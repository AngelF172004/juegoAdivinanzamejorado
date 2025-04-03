import java.util.Random;

public class Metodos {
    // Método para generar un número aleatorio entre 1 y 100
    public static int aleatorio() {
        Random random = new Random();
        int min = 1;
        int max = 100;
        return random.nextInt(max - min + 1) + min;
    }

    // Método que compara los números y da pistas
    public static boolean pistas(int opcion, int numeroAleatorio) {
        if (opcion == numeroAleatorio) {
            System.out.println("\n\n\t\t\t\tADIVINASTE!!!\n\n\t\t\t\tFELICIDADES!!!");
            return true;
        } else if (opcion > numeroAleatorio) {
            System.out.println("El número a adivinar es menor :(");
        } else {
            System.out.println("El número a adivinar es mayor :(");
        }
        return false;
    }
}

