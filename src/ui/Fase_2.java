import java.util.Scanner;

public class Fase_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido voluntario a la aplicación de Gestión de Lugares Biodiversos COP 16 Cali - Colombia.");
        
        // Definir los arrays y las variables
        String[] lugares = new String[30];
        String[] departamentos = new String[30];
        int[] kilometros = new int[30];
        int contador = 0;
        boolean registrar = true;

        while (registrar) {
            System.out.println("Te presentamos las siguientes opciones, ingresa:");
            System.out.println("1. Para registrar un lugar con diversidad biológica");
            System.out.println("2. Para consultar los lugares ordenados de menor a mayor con respecto al área");
            System.out.println("3. Para consultar el departamento que tiene más lugares con diversidad biológica registrados hasta el momento");
            System.out.println("4. Para salir del programa");

            System.out.print("Ingrese la opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if (contador < 30) {
                        // <b>Precondición</b> 
                        // El contador debe ser menor a 30.
                        // <b>Postcondición</b> 
                        // El lugar, departamento y área son registrados correctamente.
                        lugaresBiodiversos(scanner, lugares, departamentos, kilometros, contador);
                        contador++;
                    } else {
                        // <b>Postcondición</b> 
                        // Se muestra un mensaje si la cantidad de lugares ha llegado a su limite.
                        System.out.println("No se pueden registrar más lugares. El límite de 30 ha sido alcanzado.");
                    }
                    break;
                case 2:
                    // <b>Precondición</b> 
                    // Debe haber al menos un lugar registrado.
                    // <b>Postcondición</b> 
                    // Los lugares quedan ordenados de menor a mayor y se muestran.
                    ordenLugares(lugares, departamentos, kilometros, contador);
                    mostrarLugares(lugares, departamentos, kilometros, contador);
                    break;
                case 3:
                    // <b>Precondición</b> 
                    // Debe haber al menos un lugar registrado.
                    // <b>Postcondición</b> 
                    // Se muestra el departamento con más lugares biodiversos.
                    DepartamentoConMasLugares(departamentos, contador);
                    break;
                case 4:
                    // <b>Postcondición</b> 
                    // Se cierra el programa y el usuario ve un mensaje de salida donde le da a enteder que si ha salido del programa.
                    registrar = false;
                    System.out.println("Usted ha salido del programa.");
                    break;
                default:
                    // <b>Postcondición</b> 
                    // Se muestra un mensaje de opción no válida si no se ingresa una opción que pertenezca al menú.
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }
        scanner.close();
    }

    //Registrar los lugares biodiversos
    /**
     * <b>Precondición</b> 
     * El contador seguirá siendo menor a 30.
     * <b>Postcondición</b> 
     * Se almacena un lugar con su departamento y área. 
     * 
     * @param scanner Toma las entradas para que el usuario pueda introducir una linea de texto.
     * @param lugares Se almacena el lugar registrado por el usuario.
     * @param departamentos Se almacena el departamento registrado por el usuario.
     * @param kilometros Se almacenan los kilometros regstrados por el usuario.
     * @param contador La cantidad de veces que el usuario ha registrado lugar, departamento y kilometros.
     */
    public static void lugaresBiodiversos(Scanner scanner, String[] lugares, String[] departamentos, int[] kilometros, int contador) {
        System.out.print("Ingrese el nombre del lugar biodiverso: ");
        lugares[contador] = scanner.nextLine();
        System.out.print("Ingresa el departamento en el cual está el lugar: ");
        departamentos[contador] = scanner.nextLine();
        System.out.print("Ingresa la cantidad de kilómetros cuadrados que abarca el lugar: ");
        kilometros[contador] = scanner.nextInt();
        scanner.nextLine();

        // <b>Postcondición</b> 
        // El lugar queda registrado con exito.
        System.out.println("Lugar registrado con éxito.");
    }

    //Ordenar los lugares
    /**
     * <b>Precondición</b> 
     * El contador debe ser mayor a 0.
     * <b>Postcondición</b> 
     * Los lugares quedan ordenados de menor a mayor por la cantidad de kilometros.
     * <b>Invariante</b> 
     * Los arrays de lugares, departamentos y kilómetros deben tener la misma longitud.
     * 
     * @param lugares se intercambia para ser ordenado de mayor a menor.
     * @param departamentos Cada departamento seguirá asociado al lugar correcto tras el ordenamiento.
     * @param kilometros Pone el orden si kilometros[i] es mayor a kilometros[j] y este hace que intercambie el orden con lugares y departamentos.
     * @param contador El limite del bucle for para que se cuenten solamente los lugares que se registraron
     */
    public static void ordenLugares(String[] lugares, String[] departamentos, int[] kilometros, int contador) {
        for (int i = 0; i < contador - 1; i++) {
            for (int j = i + 1; j < contador; j++) {
                if (kilometros[i] > kilometros[j]) {
                    // Intercambio de kilómetros para ponerlos en orden.
                    int km = kilometros[i];
                    kilometros[i] = kilometros[j];
                    kilometros[j] = km;

                    // Intercambio de departamentos para ponerlos en orden.
                    String dpto = departamentos[i];
                    departamentos[i] = departamentos[j];
                    departamentos[j] = dpto;

                    // Intercambio de lugares para ponerlos en orden.
                    String lug = lugares[i];
                    lugares[i] = lugares[j];
                    lugares[j] = lug;
                }
            }
        }
    }

    //Mostrar los lugares ordenados de menor a mayor
    /**
     * <b>Precondición</b> 
     * Deben haberse registrado los lugares.
     * <b>Postcondición</b> 
     * Los lugares y sus kilometros son mostrados.
     * 
     * @param lugares Contiene los lugares registrados.
     * @param departamentos Contiene el departamento donde están ubicados los lugares.
     * @param kilometros contiene la cantidad de kilometros que tiene su respectivo lugar.
     * @param contador El limite de numeros de lugares que se deben mostrar. 
     */
    public static void mostrarLugares(String[] lugares, String[] departamentos, int[] kilometros, int contador) {
        System.out.println("Lugares ordenados por kilómetros cuadrados (km²):");
        for (int i = 0; i < contador; i++) {
            System.out.println(lugares[i] + ", " + departamentos[i] + " - " + kilometros[i] + " km²");
        }
    }

    //Mostrar los departamentos con mas lugares biodiversos
    /**
     * <b>Precondición</b> 
     * Deben haberse registrado los lugares y los departamentos.
     * <b>Postcondición</b> 
     * Se muestra el departamento con más lugares registrados.
     * 
     * @param departamentos los distintos departamentos registrados para ver cuales se repiten.
     * @param contador se cuenta la cantidad de departamentos registrados.
     */
    public static void DepartamentoConMasLugares(String[] departamentos, int contador) {
        String[] departamentosUnicos = new String[contador];
        int[] contar = new int[contador];
        int numeroDepartamentos = 0;

        // Contar los lugares por departamento registrado
        for (int i = 0; i < contador; i++) {
            int index = -1;
            for (int j = 0; j < numeroDepartamentos; j++) {
                if (departamentosUnicos[j].equals(departamentos[i])) {
                    index = j;
                    break;
                }
            }
            if (index == -1) {
                departamentosUnicos[numeroDepartamentos] = departamentos[i];
                contar[numeroDepartamentos] = 1;
                numeroDepartamentos++;
            } else {
                contar[index]++;
            }
        }

        // <b>Postcondición</b> 
        // Se muestra el departamento con más lugares o un mensaje si no hay departamentos registrados.
        if (numeroDepartamentos > 0) {
            String departamentoconmasLugares = departamentosUnicos[0];
            int maxLugares = contar[0];

            for (int i = 1; i < numeroDepartamentos; i++) {
                if (contar[i] > maxLugares) {
                    maxLugares = contar[i];
                    departamentoconmasLugares = departamentosUnicos[i];
                }
            }

            System.out.println("El departamento con más lugares registrados es " + departamentoconmasLugares + " con " + maxLugares + " lugares.");
        } else {
            System.out.println("No se registraron departamentos.");
        }
    }
}
