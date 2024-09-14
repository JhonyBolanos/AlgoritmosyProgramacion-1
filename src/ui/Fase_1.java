import java.util.Scanner;

public class Fase_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //<b>Precondición</b>
        //El usuario debe ingresar el nombre y la cedula, no debe esar vacio.
        System.out.println("Ingrese su nombre y digite su cedula");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su cedula: ");
        String cedula = scanner.nextLine();
        System.out.println("Bienvenido a la COP16 " + nombre + " cedula: " + cedula);

        String Ruta = Seleccionruta(scanner);
        Informacionderuta(Ruta);

        System.out.print("Digite la cantidad de participantes: ");
        int participantes = scanner.nextInt();
        System.out.print("Digite la cantidad de guias: ");
        int guias = scanner.nextInt();
        int total_Participantes = (participantes + guias);
        System.out.println("El total de participantes es: " + total_Participantes);

        System.out.print("Ingrese la temperatura en grados centigrados: ");
        double temperatura = scanner.nextDouble();
        System.out.print("Igrese el porcentaje de humedad relativa: ");
        int humedad = scanner.nextInt();
        clima(temperatura, humedad);

        busestotales(participantes + guias);

        //Seguimiento
        System.out.println("EJERCICIO DE SEGUMIENTO.");
        System.out.print("Ingrese la temperatura: ");
        int temp = scanner.nextInt();
        System.out.println(verificarTemperatura(temp));

        System.out.print("Ingrese su nombre: ");
        scanner.nextLine();
        String nombre_organizador = scanner.nextLine();
        //<b>Postcondición</b>
        //Se muestra si el nombre cumple con los requisitos para obtener un regalo.
        obtenerRegalo(nombre_organizador);
        
        scanner.close();

    }
    //Selección de rutas
    /**
     * <b>Precondición</b>
     * El usuario debe ingresar una opción existente de las rutas presentadas.
     * <b>Postcondición</b>
     * El programa devuelve la ruta seleccionada por el usuario.
     * 
     * @param scanner Toma las entradas para que el usuario pueda introducir una linea de texto.
     * @param return retorna la opcion que el usuario ingreso con un tipo de dato String.
     */
    
    public static String Seleccionruta (Scanner scanner){
        System.out.println("Por favor, seleccione una de las siguientes rutas:");
        System.out.println("RUTA 1: Ruta Ladera");
        System.out.println("RUTA 2: Ruta del Oriente");
        System.out.println("RUTA 3: Ruta Farallones");
        return scanner.nextLine();

    }
    
    //Información de las rutas
    /** 
     * <b>Precondición</b>
     * El usuario debe haber seleccionado una ruta válida.
     * <b>Postcondición</b>
     * Se muestra la información detallada de la ruta seleccionada o en casto tal de haber escogido una opcion no valida, se le informa al usuario.
     * @param opcionderuta Seleccionar la ruta.
     * 
    */
    public static void Informacionderuta(String opcionderuta){
        if (opcionderuta.equalsIgnoreCase("Ruta Ladera")){
            System.out.println("Muy bien!! Esta ruta inicia a las 7:00am y termina a la 1:30pm, el punto de encuentro es en el Bulevar del Rio.");
        }
        else if (opcionderuta.equalsIgnoreCase("Ruta del Oriente")){
            System.out.println("Muy bien!! Esta ruta inicia a las 7:00am y termina a la 1:00pm, el punto de encuentro es en el Bulevar del Rio.");
        }
        else if (opcionderuta.equalsIgnoreCase("Ruta Farallones")){
            System.out.println("Muy bien!! Esta ruta inica a las 6:40am y termina a las 2:30pm, el punto de encuentro es en la Universidad del Valle.");
        }
        else {
            System.out.println("Opción no valida");
        }
    }
    
    //Dependiendo de la temperatura y humedad, se sabe si hace un  buen dia o no
    /**
     * <b>Precondiciones</b>
     * La temperatura y la humedad deben estar en el formato adecuado.
     * <b>Postcondiciones</b>
     * El programa evalúa si las condiciones climáticas son adecuadas para la actividad y así mismo informar como está el dia en cuestiones de clima.
     * 
     * @param temperatura La temperatura está o no está dentro de los terminos para salir. 
     * @param humedad La humedad está o no está dentro de los terminos para salir. 
     */
    public static void clima(double temperatura, int humedad){
        if (temperatura >= 20 && temperatura <= 25 && humedad >= 40 && humedad <= 60){
            System.out.println("¡Hace un buen día para caminar por Cali!");
        }
        else{
            System.out.println("El clima no es adecuado para salir");
        }
    }
    //Cantidad de buses para las rutas
    /**
     * <b>Precondición</b>
     * El número total de participantes debe ser un número entero positivo.
     * <b>Postcondición</b>
     * Se calcula y muestra el número de buses necesarios para transportar a los participantes que van a la actividad.
     * <b>Invariante</b>
     * La capacidad de cada bus es siempre de 25 personas.
     * 
     * @param total_Participantes La cantidad de participantes que van para asignar la cantidad de buses. 
     * @param return retorna que buses son necesarios para transportar a todas las personas.
     */
    public static int busestotales(int total_Participantes){
        int capacidadbus = 25;
        int buses = (total_Participantes / capacidadbus);
        if(total_Participantes % capacidadbus != 0){
            buses++;
        }
        System.out.println("Se requieren " + buses + " buses para transportar a las personas.");
        return buses;
    }

    //Segumiento
    /**
     * <b>Precondición</b>
     * La temperatura debe ser un valor numérico válido.
     * <b>Postcondición</b>
     * Se retorna un mensaje con recomendaciones dependiendo de la temperatura ingresada.
     * 
     * @param temperatura Se verifica la temperatura del dia para saber que condiciones cumplir en la caminata.
     * @return retorna un mensaje que indique dependiendo de la temperatura si debe abrigarse, hidratarse o disfrutar de su caminata.
     */
    public static String verificarTemperatura(double temperatura){
        String Mensaje = "Disfrute la caminata";
        if (temperatura < 15){
            Mensaje = ("Lleve chaqueta para protegerse del frio y de la lluvia");
        }
        else if (temperatura > 28){
            Mensaje = ("Lleve termo del agua, beba para hidratarse");
        }
        return Mensaje;
    }   

    /**
     * <b>Precondición</b>
     * El nombre no debe estar vacío.
     * <b>Postcondición</b>
     * Se evalúa si el nombre es apto para obtener un regalo basándose en la primera letra (inicial).
     * 
     * @param nombre Nombre ingresado para saber si cumple las condiciones para la entrada gratuita.
     */
    public static void obtenerRegalo(String nombre){
        char primera_letra = Character.toLowerCase(nombre.charAt(0));

        if (primera_letra == 'a' || primera_letra == 'e' || primera_letra == 'i' || primera_letra == 'o' || primera_letra == 'u'){
            System.out.println("Comuniquese al número 1800456789 para obtener una entrada gratuita a una conferencia del cop16");
        }
        else{
            System.out.println("No entras en la obtención de regalo.");
        }
    }
    
}


    
