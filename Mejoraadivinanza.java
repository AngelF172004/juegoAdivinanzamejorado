import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n\t\t-----Juego de Adivinanza de un Número-----\n");
        System.out.println("Se generará un número aleatorio entre 1 y 100, y tú deberás adivinarlo");
        System.out.println("Ingresa el número de intentos permitidos para adivinar:");
        int intentos = scanner.nextInt(); // Se ingresa el número de intentos
        int numeroAleatorio = Metodos.aleatorio(); // Se genera el número aleatorio
        int contador = 0; // Contador de intentos
        int opcion; // El intento de adivinar

        while (contador < intentos) { // Ciclo principal del juego
            System.out.println("\n\nIngresa el número de tu intento " + (contador + 1) + ":");
            opcion = scanner.nextInt();

            if (Metodos.pistas(opcion, numeroAleatorio)) { // Se compara el número ingresado con el aleatorio
                break;
            }
            
            contador++;
        }
        
        if (contador >= intentos) {
            System.out.println("\n\n\t\t\t\tNO ADIVINASTE :(");
        }

        scanner.close();
    }
}

