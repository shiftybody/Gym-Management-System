import java.io.*;
import java.util.*;

/**
 * Clase que modela el sistema de un Gimnasio
 *
 * @author Shiftybody
 * @version 0.0.1
 */
public class Gym {

    private static final Scanner stdIn = new Scanner(System.in);

    // constantes utilizadas para cambiar el color de la consola
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[1;32m";

    static ActivityList activityList = new ActivityList();
    static MemberList memberList = MemberList.getSingleton();

    private double totalCost;
    private double durationInHours;

    /**
     *
     * Método main de la aplicación, contiene un cartel con un módelo de carga
     * para verificar si existen los archivos necesarios para almacenar los datos
     * de la aplicación
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        try {
            System.out.print(" ________________________________________________ \n" +
                    "|\t______   _______    _______     ____  __ \t|\n" +
                    "|\t|  ____/\\|__   __|  / ____\\ \\   / /  \\/  |\t|\n" +
                    "|\t| |__ /  \\  | |    | |  __ \\ \\_/ /| \\  / |\t|\n" +
                    "|\t|  __/ /\\ \\ | |    | | |_ | \\   / | |\\/| |\t|\n" +
                    "|\t| | / ____ \\| |    | |__| |  | |  | |  | |\t|\n" +
                    "|\t|_|/_/    \\_\\_|     \\_____|  |_|  |_|  |_|\t|\n|" +
                    " _____________________________________________ |\n" +
                    "              searching for files\n" +
                    "            [");

            for (int i = 0; i < 21; i++) {
                System.out.print("\u2588");
                Thread.sleep(200);
                if (i == 15) {
                    activityList = cargarActividades();
                    memberList = cargarMiembros();
                }
            }
            System.out.print("]              \n\n");
            System.out.println(ANSI_GREEN + "Archivos cargados exitosamente" + ANSI_RESET);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Gym application = new Gym();
        application.menu();

    }

    /**
     * Método qué carga desde el archivo MemberList.dat
     * los Miembros almacenados de la aplicación
     *
     * @return un objeto de tipo MemberList
     */
    private static MemberList cargarMiembros() {
        try {
            MemberList memberList = MemberList.getSingleton();
            FileReader file = new FileReader("MemberList.dat");
            BufferedReader fileIn = new BufferedReader(file);
            String line = fileIn.readLine();
            while (line != null) {
                String[] datosMiembro = line.split("_");
                memberList.addMember(new Member(datosMiembro[0],
                        datosMiembro[1], datosMiembro[2],
                        Integer.parseInt(datosMiembro[3]), Double.parseDouble(datosMiembro[4]),
                        Double.parseDouble(datosMiembro[5]), Integer.parseInt(datosMiembro[6]),
                        datosMiembro[7], datosMiembro[8],
                        datosMiembro[9], datosMiembro[10]));


                line = fileIn.readLine(); // cerrar fileIn
            }
            fileIn.close();

            return memberList;
        } catch (IOException ioe) {
            System.out.println("No se puede leer el archivo");
        }
        return null;
    }

    /**
     * Método que carga desde el archivo ActivityList.dat
     * las actividades o cursos previamente almacenadas para la aplicación
     * @return un objeto de tipo ActivityList
     * @throws IOException
     */
    private static ActivityList cargarActividades() throws IOException {
        try {
            ActivityList activityList = new ActivityList();
            FileReader file = new FileReader("ActivityList.dat");
            BufferedReader fileIn = new BufferedReader(file);
            String line = fileIn.readLine();
            while (line != null) {
                String[] datosActividad = line.split("_");
                activityList.addActivity(new Activity(datosActividad[0], Double.parseDouble(datosActividad[1]), Double.parseDouble(datosActividad[2])));
                line = fileIn.readLine(); // cerrar fileIn
            }
            fileIn.close();

            return activityList;
        } catch (IOException ioe) {
            System.out.println("No se puede leer el archivo");
        }
        return null;
    }

    /**
     * Menú que modela las opciones  en el sistema de gimansio
     * @return una variable entera que representa la opción del usuario
     */
    private int getOptionMenu() {
        do {
            try {

                System.out.print(
                        ANSI_RED + "\n" +
                                "Eliga una opción: \n" +
                                "\n" +
                                "[0] Salir\n" +
                                "[1] Agregar Actividad \n" +
                                "[2] Ver información de todas las actividades\n" +
                                "[3] Agregar Miembro \n" +
                                "[4] Eliminar Miembro \n" +
                                "[5] Consultar Miembro \n" +
                                "[6] Calcular pago \n" +

                                "\n" +
                                "Your Choice> " + ANSI_RESET);

                return Integer.parseInt(stdIn.nextLine());

            } catch (NumberFormatException nfe) {
                System.out.println("Error: Incorrect number format. " + nfe.getMessage());
            }
        } while (true);
    }

    /**
     * Menú qué  ejecuta las acciones del modelo de gimansio, en este caso decidí realizarlo todo en un solo switch
     * sin embargo la mejor opcion era crear métodos separados para así conocer su funcionamiento
     *
     * @throws IOException
     */
    private void menu() throws IOException {


        while (true) {
            int option = getOptionMenu();
            switch (option) {
                case 1:
                    Activity newactivity = solicitarActividad();
                    activityList.addActivity(newactivity);
                    guardarActividades(activityList);
                    break;
                case 2:
                    activityList = cargarActividades();
                    for (Activity activity :
                            activityList) {
                        System.out.println(activity);
                    }
                    break;
                case 3:
                    Member newmember = solicitarMiembro();
                    memberList.addMember(newmember);
                    guardarMiembros(memberList);
                    break;
                case 4:
                    System.out.println("ingrese el id del miembro");
                    String id = stdIn.nextLine();
                    if (memberList.removeMember(id)) {
                        System.out.println("miembro eliminado con exito");
                        guardarMiembros(memberList);
                    } else {
                        System.out.println("Ese miembro no se encontraba en la BD");
                    }
                    break;
                case 5:

                    System.out.println("ingrese el id del miembro");
                    id = stdIn.nextLine();
                    Member memb = memberList.getMember(id);
                    System.out.println(memb);

                    break;
                case 6:

                    System.out.println("ingrese el id del miembro");
                    id = stdIn.nextLine();
                    String membe = memberList.getMember(id).getActivity();

                    System.out.println(membe);

                    System.out.println("Ingrese forma de pago:  ");

                    try {

                        System.out.print(
                                ANSI_RED + "\n" +

                                        "Eliga una opción: \n" +
                                        "   [1] Por clase\n" +
                                        "   [2] Semanal \n" +
                                        "   [3] Quincenal \n" +
                                        "   [4] Mensual \n" +
                                        "   [5] Semestral \n" +
                                        "   [6] Anual\n" +

                                        "Your Choice> " + ANSI_RESET);

                        int optionform = Integer.parseInt(stdIn.nextLine());

                        for (Activity activity : activityList) {
                            if (activity.getActivityName().equals(membe)) {
                                this.totalCost = activity.totalCost();
                                this.durationInHours = activity.getDurationInHours();
                            }
                        }

                        switch (optionform) {

                            case 1:
                                new PorClase().calcularPago(totalCost, durationInHours);
                                break;
                            case 2:
                                new Semanal().calcularPago(totalCost, durationInHours);
                                break;
                            case 3:
                                new Quincenal().calcularPago(totalCost, durationInHours);
                                break;
                            case 4:
                                new Mensual().calcularPago(totalCost, durationInHours);
                                break;
                            case 5:
                                new Semestral().calcularPago(totalCost, durationInHours);
                                break;
                            case 6:
                                new Anual().calcularPago(totalCost, durationInHours);
                                break;
                        }


                    } catch (NumberFormatException nfe) {
                        System.out.println("Error: Incorrect number format. " + nfe.getMessage());
                    }
                    break;
                case 0:

                    System.out.println("Gracias por usar el programa.");
                    return;
                default:
                    System.out.println("Opción no valida. \n");
                    break;
            }
        }
    }

    /**
     *Método que almacena en el archivo MemberList loss cambios realizados
     * al agregar un eliminar un miembro.
     *
     * @param memberList
     */
    private void guardarMiembros(MemberList memberList) {
        try {
            FileWriter archivo = new FileWriter("MemberList.dat");
            PrintWriter fileOut = new PrintWriter(archivo);

            for (Member member : memberList) {
                fileOut.println(member.toString());
            }
            fileOut.close();
            System.out.println("\n Miembros actualizados");
        } catch (IOException ioe) {
            System.out.println("No se puede crear o accesar al archivo");
            return;
        }
    }

    /**
     * Método que almacena en ActivityList.dat las actividades del sistema de gimnasio
     *
     * @param activityList
     */
    private void guardarActividades(ActivityList activityList) {
        try {
            FileWriter archivo = new FileWriter("ActivityList.dat");
            PrintWriter fileOut = new PrintWriter(archivo);

            for (Activity activity : activityList) {
                fileOut.println(activity.toString());
            }
            fileOut.close();
            System.out.println("\n Actividad agregada");
        } catch (IOException ioe) {
            System.out.println("No se puede crear o accesar al archivo");
            return;
        }
    }

    /**
     *Método que modela la información necesaria para instanciar un objeto actividad
     * @return la instancia sin referenciar de un objeto de tipo activity
     */
    private Activity solicitarActividad() {
        while (true) {
            try {
                System.out.print("Ingrese el nombre de la actividad: ");
                String activityName = stdIn.nextLine();
                System.out.print("Ingrese la duracion de la actividad (en minutos)");
                double durationInMin = Double.parseDouble(stdIn.nextLine());
                System.out.print("Ingrese el costo por hora de la actividad: ");
                double costPerHour = Double.parseDouble(stdIn.nextLine());

                return new Activity(activityName, durationInMin, costPerHour);

            } catch (NumberFormatException nfe) {
                System.out.println("se esperaba un valor numerico");
            }
        }
    }

    /**
     * Método que modela la información necesaria para instanciar un objeto actividad
     * @return la instancia sin referenciar de un objeto de tipo miembro
     */
    private Member solicitarMiembro() {
        try {
            String id;
            String name;
            String address;
            int number;
            double mWeight, mHeight;
            int age;
            String sex;
            String complexion;

            System.out.print("Enter the member's id: ");
            id = stdIn.nextLine();

            System.out.print("Enter the member's name: ");
            name = stdIn.nextLine();

            System.out.print("Enter the member's address: ");
            address = stdIn.nextLine();

            System.out.print("Enter the member's number: ");
            number = Integer.parseInt(stdIn.nextLine());

            System.out.print("Enter the member's weight (in KG): ");
            mWeight = stdIn.nextDouble();
            stdIn.nextLine();

            while (mWeight <= 0 || mWeight >= 200) {
                System.out.print("Please enter a valid weight!\nEnter again: ");
                mWeight = stdIn.nextDouble();
                stdIn.nextLine();
            }

            System.out.print("Enter the member's height (in M): ");
            mHeight = stdIn.nextDouble();
            stdIn.nextLine();
            while (mHeight <= 0 || mHeight >= 2.5) {
                System.out.print("Please enter a valid height!\nEnter again: ");
                mHeight = stdIn.nextDouble();
                stdIn.nextLine();
            }

            System.out.print("Enter the member's age: ");
            age = Integer.parseInt(stdIn.nextLine());

            System.out.print("Enter the member's sex [H / M] :");
            sex = stdIn.nextLine();

            System.out.print("Enter the member's complexion :");
            complexion = stdIn.nextLine();

            System.out.print("Enter the member's activity :");

            activityList = cargarActividades();
            int num = 0;
            System.out.println();
            for (Activity activity :
                    activityList) {
                System.out.println(" [" + (num += 1) + "] " + activity.getActivityName() + " $" + activity.totalCost());
            }

            System.out.println(" Escoja una actividad > ");
            String activity = stdIn.nextLine();

            System.out.println();

            return new Member(id, name, address, number, mWeight, mHeight, age, sex, complexion, activity, "activo");

        } catch (NumberFormatException | IOException nfe) {
            System.out.println("se esperaba un valor numerico");
        }
        return null;
    }

}
