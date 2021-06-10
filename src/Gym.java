import java.io.*;
import java.util.*;


public class Gym {

    private static final Scanner stdIn = new Scanner(System.in);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";


    public static void main(String[] args) throws IOException, NumberFormatException {

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
                    new MembersFileUploader().loadMembers("members.dat");
                }
            }
            System.out.print("]              \n");

        } catch (FileNotFoundException fnfe) {

            System.out.print("           ]\n");
            System.out.println(ANSI_RED + "\n             The file doesn´t exist" + ANSI_RESET);
            System.exit(1);

        } catch (DataFormatException dfe) {
            System.out.print("           ]\n");
            System.out.println((ANSI_RED + "  The file contains badly formulated data in line: "
                    + dfe.getMessage() + ANSI_RESET));
            System.exit(1);

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
                                "[0] Quit\n" +
                                "[1] register member \n" +  // registrar a cliente
                                "[2] consult client account \n" + // consultar estado de cliente
                                "[3] consult payment account\n" + // consultar estado de cuenta
                                "[4] make payment\n" + // realizar pago de cuenta accesible también desde opción 3
                                "\n" +
                                "Choice> " + ANSI_RESET);

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
                case 1 -> addModifyMember();
                case 2 -> displayMember();
                case 3 -> displayMemberinfoAccount();
                case 5 -> makePayment();
                case 0 -> {
                    System.out.println(" Proceso finalizado ");
                    return;
                }
                default -> System.out.println("    Invalid option:  " + option);
            }
        }
    }

    private void addModifyMember() {

    }


    private void displayMember() {

    }

    private void displayMemberinfoAccount() {

    }

    private void makePayment() {

    }

}
