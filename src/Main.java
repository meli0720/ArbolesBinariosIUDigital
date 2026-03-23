import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("ARBOLES BINARIOS EN JAVA");

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Insertar un número");
            System.out.println("2. Mostrar recorrido Inorden");
            System.out.println("3. Buscar un número");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        if(arbol.raiz == null){
                            System.out.println("El árbol está vacío. Ingrese la raiz del árbol:");
                            int numInsertar = scanner.nextInt();
                            arbol.insertar(numInsertar);
                            System.out.println("Número " + numInsertar + " insertado correctamente.");
                            break;
                        }else{
                            System.out.print("Ingrese el número entero que desea insertar: ");
                            int numInsertar = scanner.nextInt();
                            arbol.insertar(numInsertar);
                            System.out.println("Número " + numInsertar + " insertado correctamente.");
                            break;
                        }


                    case 2:
                        System.out.print("Recorrido Inorden (datos ordenados): ");
                        arbol.inorden();
                        break;

                    case 3:
                        System.out.print("Ingrese el número que desea buscar: ");
                        int numBuscar = scanner.nextInt();
                        boolean encontrado = arbol.buscar(numBuscar);

                        if (encontrado) {
                            System.out.println("El número " + numBuscar + " SI existe en el árbol.");
                        } else {
                            System.out.println("El número " + numBuscar + " NO existe en el árbol.");
                        }
                        break;

                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción no válida. Por favor, seleccione un número del 1 al 4.");
                }
            } else {
                System.out.println("Error: Por favor, ingrese un número entero válido.");
                scanner.next(); // Limpia la entrada incorrecta del escáner
            }

        } while (opcion != 4);

        scanner.close();



    }

}