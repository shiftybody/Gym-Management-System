import java.io.*;
import java.util.*;

public class Gym {

    private static final Scanner stdIn = new Scanner(System.in);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[1;32m";

    public static MemberList members;
    static ActivityList activityList = new ActivityList();

    public Gym() {

    }

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
                }
            }
            System.out.print("]              \n\n");
            System.out.println(ANSI_GREEN + "Actividades cargadas" + ANSI_RESET);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Gym application = new Gym();
        application.menu();

    }

    private int getOptionMenu() {
        do {
            try {

                System.out.print(
                        ANSI_RED + "\n" +
                                "Eliga una opción: \n" +
                                "\n" +
                                "[0] Salir\n" +
                                "[1] Agregar Actividad \n" +  // agregar actividad
                                "[2] Ver información de todas las actividades\n" +
                                "[3] Agregar Miembro \n" +  //agregar miembro
                                "[4] Editar Miembro \n" +  //agregar miembro
                                "[5] Eliminar Miembro \n" +  //agregar miembro
                                "[6] Inscribir miembro a una actividad\n" + //inscribir a un miembro a una actividad
                                "[7] Consultar estado de miembro \n" +  // agregar actividad
                                "[8] Ver información de todas las actividades\n" +

                                "\n" +
                                "Your Choice> " + ANSI_RESET);

                return Integer.parseInt(stdIn.nextLine());

            } catch (NumberFormatException nfe) {
                System.out.println("Error: Incorrect number format. " + nfe.getMessage());
            }
        } while (true);
    }

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

                    break;
                case 4:
                    solicitarMiembro();
                    break;
                case 5:
                    if (members.getNoOfMember() > 0)
                        showMemberInfo();
                    else
                        System.out.println("No members are added.");
                    break;
                case 6:
                    if (members.getNoOfMember() > 0)
                        changeMemberInfo();
                    else
                        System.out.println("No members are added.");
                    break;
                case 7:
                    recordInfo();
                    break;
                case 0:
                    System.out.println("Thank you for using our program. Thank you and have a nice day.");
                    return;
                default:
                    System.out.println("Invalid option. \n");
                    break;
            }
        }
    }

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


    private void recordInfo() {

    }

    private void changeMemberInfo() {

    }

    private void showMemberInfo() {

    }


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

            System.out.println("");

            return new Member(id, name, address, number, mWeight, mHeight, age, sex, complexion, true );

        } catch (NumberFormatException nfe) {
            System.out.println("se esperaba un valor numerico");
        }
        return null;
    }

}
