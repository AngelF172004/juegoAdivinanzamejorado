Métodos
Paradigmas de programación

Jorge Eduardo Vázquez Villagrán                     
Moran Hernández Ángel Fernando                                                
Daniel Enrique Cortes Santos

ESCUELA SUPERIOR DE COMPUTO

¿De qué trata la práctica?
Consiste en cambiar el código de las 3 practicas anteriores para adaptarlas al uso de los métodos de Java (Tipo Static).
Los métodos son un conjunto de instrucciones que se pueden ejecutar mediante su nombre. Los métodos pueden aceptar datos o parámetros, mismos que usan para devolver un valor.
Ya que realizan tareas específicas con nombres propios, cambian la estructura de los códigos, se explicarán los cambios realizados más adelante.
Un método tipo Static es aquel que pertenece a una clase y no a un objeto, por lo cual solo existe una instancia del método independientemente de cuántos objetos de la clase se creen.

¿Cómo se implementó?
Primera práctica:
Se creo una clase que muestra un menú interactivo. Agrega, muestra, busca, elimina y guarda contactos. Carga desde un archivo y los guarda antes de salir.
Se creo una clase contacto con nombre, teléfono y correo, que se sobrescribe.
La clase de GestorContactos tiene una lista de contactos, una función AgregarContacto. MostrarContacto. BuscarContacto (Por nombre). EliminarContacto (Por nombre). GuardarContacto. Y CargarContacto.
Segunda práctica:
Se movieron las funciones de gestión hacia una clase llamada Métodos.
RegistrarEstudiante: Maneja la entrada de datos y creación de estudiantes.
MostrarEstudiantes: Muestra la lista de estudiantes registrados.
BuscarEstudiante: Permite buscar un estudiante por matrícula.
EliminarEstudiante: Elimina estudiantes del arreglo y actualiza la información.
Main ahora delega la lógica a los métodos.
Scanner ahora funciona como parámetro.
Tercera práctica:
Se movieron los métodos aleatorio y pistas a una clase llamada Métodos.
Ya que los métodos están en otra clase, se llaman con Métodos.aleatorio() y Métodos.pistas().
Ahora JuegoAdivinanza solo se encarga de la lógica, mientras que Métodos tiene las funciones auxiliares.

Instrucciones para ejecutar el programa:
Para ejecutar el programa en Visual Studio Code es importante tener la extensión de Java (Java Extension Pack).
Una vez hecho, tienes que abrir el archivo que tiene el código fuente.
Y con la instrucción para ejecutar (Ctrl + Shift + B) se abrirá una terminar donde funciona el programa.

Problemas encontrados:
Ningún problema encontrado.

Solución a los problemas:
Ninguna solución necesitada.

Enlace al GitHub:
https://github.com/AngelF172004/Practicaunomejorada

https://github.com/AngelF172004/gestodeestudantesmejora

https://github.com/AngelF172004/juegoAdivinanzamejorado


Enlace al Microsoft Planner:
A



Codigo anterior:
import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinanzaJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("\n\n\t\t-----Juego de Adivinanza de un Número-----\n");
        System.out.println("Se generará un número aleatorio entre 1 y 100, y tú deberás adivinarlo");
        System.out.println("Ingresa el número de intentos permitidos para adivinar:");
        int intentos = scanner.nextInt(); // Se ingresa el número de intentos
        
        // Se genera el número aleatorio
        int min = 1;
        int max = 100;
        int numeroaleatorio = random.nextInt(max - min + 1) + min;

        int contador = 0; // El contador de intentos
        int opcion; // El intento de adivinar

        while (contador < intentos) { // El ciclo del funcionamiento principal
            System.out.println("\n\nIngresa el número de tu intento " + (contador + 1) + ":");
            opcion = scanner.nextInt();

            // Comparación del número ingresado con el aleatorio
            if (opcion == numeroaleatorio) {
                System.out.println("\n\n\t\t\t\tADIVINASTE!!!\n\n\t\t\t\tFELICIDADES!!!");
                break;
            } else if (opcion > numeroaleatorio) {
                System.out.println("El número a adivinar es menor :(");
            } else {
                System.out.println("El número a adivinar es mayor :(");
            }

            contador++;
        }

        if (contador >= intentos) {
            System.out.println("\n\n\t\t\t\tNO ADIVINASTE :(");
        }

        scanner.close();
    }
}

Condigo mejorado:
import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinanzaJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n\t\t-----Juego de Adivinanza de un Número-----\n");
        System.out.println("Se generará un número aleatorio entre 1 y 100, y tú deberás adivinarlo");
        System.out.println("Ingresa el número de intentos permitidos para adivinar:");
        int intentos = scanner.nextInt(); //Se ingresa el número de intentos
        int numeroaleatorio = Metodos.aleatorio(); //Usando el método aleatorio se genera el número
        int contador = 0; //El contador de intentos
        int opcion; //El intento de adivinar

        while (contador < intentos) { //El ciclo del funcionamiento principal
            opcion = 0;
            System.out.println("\n\nIngresa el número de tu intento " + (contador+1) + ":");
            opcion = scanner.nextInt();

            if (Metodos.pistas(opcion, numeroaleatorio)) { //Se compara el numero ingresado con el random 
                break;                
            }
            
            contador++;
        }
        if (contador >= intentos){
            System.out.println("\n\n\t\t\t\tNO ADIVINASTE :(");
        }
        scanner.close();
        return;
    }
}

class Metodos{
    //Se genera el numero random
    public static int aleatorio(){ 
        Random random = new Random();
        int min = 1;
        int max = 100;
        int randomNumber = random.nextInt(max - min + 1) + min;
        return randomNumber;
    }
    //El metodo que compara los numeros para dar una pista si es menor o mayor
    public static boolean pistas(int opcion, int numeroaleatorio){
        if (opcion == numeroaleatorio) {
            System.out.println("\n\n\t\t\t\tADIVINASTE!!!\n\n\t\t\t\tFELICIDADES!!!");
            return true;
        }
        else if (opcion > numeroaleatorio) {
            System.out.println("El numero a adivinar es menor :(");
            return false;
        }
        else {
            System.out.println("El numero a adivinar es mayor :(");
            return false;
        }
    }
}

conclusion :
1. Modularidad 🚀
Dividir el código en clases y métodos hace que sea más fácil de entender y mantener.

En tu versión, Metodos encapsula la lógica de generación del número aleatorio (aleatorio()) y las pistas (pistas()), lo que mantiene main más limpio y organizado.

En mi versión (todo en main), todo está mezclado, lo que puede hacer que el código se vuelva caótico si crece.

Ejemplo:
Si en el futuro quisieras cambiar la forma en que se generan los números (por ejemplo, hacer que sean del 1 al 500 en lugar de 1 al 100), en tu versión solo tendrías que modificar aleatorio(). En mi versión tendrías que buscar el código dentro de main y modificarlo allí, lo que es menos eficiente.

2. Reutilización de Código 🔄
Tus métodos aleatorio() y pistas() pueden usarse en otros programas sin necesidad de copiarlos y pegarlos.

Si más adelante quisieras hacer otro juego basado en números aleatorios, podrías reutilizar Metodos.aleatorio().

En mi versión, al estar todo dentro de main, tendrías que copiar y pegar el código si quisieras usarlo en otro lado, lo que no es eficiente.

Ejemplo:
Si quisieras hacer un juego donde el jugador adivina un número entre 1 y 500, solo necesitarías llamar Metodos.aleatorio() con un pequeño ajuste.

3. Mantenibilidad 🛠
Tu código es más fácil de modificar y mejorar sin romper otras partes.

Si quieres mejorar la lógica de pistas (por ejemplo, agregar más información o hacer que el juego dé consejos después de cierto número de intentos), puedes modificar pistas() sin afectar main.

En mi versión, cualquier cambio requiere modificar main, lo que puede hacer que sea más difícil de depurar si algo sale mal.

Ejemplo:
Si decides que el programa debe decir "Estás muy cerca" cuando el jugador está a menos de 5 números del correcto, solo modificarías pistas(). En mi versión, tendrías que modificar el while en main, haciendo el código más desordenado.

4. Legibilidad y Organización 📖
El código en tu versión está más ordenado y es más fácil de leer.

main solo se encarga de la lógica general del juego, mientras que Metodos maneja los detalles.

En mi versión, todo está mezclado, lo que puede hacer que alguien que lea el código por primera vez se confunda.

Ejemplo:
Si alguien más quiere entender tu código, le será más fácil porque verá que Metodos tiene funciones con nombres claros (aleatorio() y pistas()), en lugar de tener que leer un main gigante.

Conclusión 🏆
✅ Tu versión es más modular, reutilizable, mantenible y legible.
✅ Si en el futuro quieres hacer cambios o agregar nuevas funciones, será mucho más fácil.
✅ Para proyectos más grandes, este enfoque es el mejor, ya que separa responsabilidades y facilita la depuración.

