import java.io.*;
import java.util.*;

public class Gym {

    private static final Scanner stdIn = new Scanner(System.in);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static MemberList members;

    private Gym(){

    }

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
                                "Choose an option: \n" +
                                "\n" +
                                "[0] Quit\n" +
                                "[1] add activity \n" +  // agregar actividad
                                "[2] View all activities information \n" +
                                "[3] Update activity's information \n" +
                                "[4] add member \n" +  //agregar miembro
                                "[5] View all member's information\n" +
                                "[6] Update member´s information\n" +
                                "[7] Record activities for member\n" + //inscribir a un miembro a una actividad
                                "\n" +
                                "Your Choice> " + ANSI_RESET);

                return Integer.parseInt(stdIn.nextLine());

            } catch (NumberFormatException nfe) {
                System.out.println("Error: Incorrect number format. " + nfe.getMessage());
            }
        } while (true);
    }

    private void menu() throws IOException {

        ActivityList act = new ActivityList();    //array of max 5 activities
        members = new MemberList();   //array of max 10 members

        while (true) {
            int option = getOptionMenu();
            switch (option) {
                case 1: addActivity(act); break;
                case 2: viewActivityInformation(act); break;
                case 3: updateActivityInformation(act); break;
                case 4: addMember(); break;
                case 5: if (members.getNoOfMember() > 0)
                    showMemberInfo();
                else
                    System.out.println("No members are added.");
                    break;
                case 6: if (members.getNoOfMember() > 0)
                    changeMemberInfo();
                else
                    System.out.println("No members are added.");
                    break;
                case 7: recordInfo(act); break;
                case 0: System.out.println("Thank you for using our program. Thank you and have a nice day."); return;
                default: System.out.println("Invalid option. \n"); break;
            }
        }
    }

    private void recordInfo(ActivityList act) {
        String activity;
        Activity found;
        System.out.print("Enter the name of member to record: ");
        String name = stdIn.nextLine();

        // input cannot be blank
        while (name.equals("")) {
            System.out.print("Name cannot be blank! Enter again: ");
            name = stdIn.nextLine();
        }

        Member recorded = members.findMember(name);

        //member not found
        if (recorded == null)
            System.out.println("No such member exists");
        else {
            int choice;
            ActivityList tempList = recorded.cloneList(act);
            do {
                System.out.println("");
                System.out.println("1. Add activity for member");
                System.out.println("3. View total cost of all activities");
                System.out.println("5. View activities member has joined");
                System.out.println("0. Quit");
                System.out.print("Your choice: ");
                choice = stdIn.nextInt();
                stdIn.nextLine();
                System.out.println("");

                switch (choice) {
                    case 1:
                        if (tempList.getActivityCount() == 0)
                            System.out.println("No more available activities");
                        else {
                            System.out.println(tempList.getActivityList());
                            System.out.print("Enter activity name: ");
                            activity = stdIn.nextLine();
                            System.out.println("");

                            // input cannot be blank
                            while (activity.equals(""))
                            {
                                System.out.println("No input.");
                                System.out.print("Please re-enter the activity's name: ");
                                activity = stdIn.nextLine();
                            }
                            found = act.findActivity(activity);

                            //activity not found
                            if (found == null)
                                System.out.println("No such activity exists");
                            else {
                                recorded.getActivityList().addActivity(found);
                                System.out.println("Activity recorded! \n");
                                tempList.removeActivity(found);

                                // calculate cost for this activity
                                double cost = found.totalCost();
                                // sum up cost
                                recorded.increaseTotalCost(cost);

                                // calculate calories burned for this activity


                            } // end of nested else
                        } // end of else

                        break;
                    case 3:
                        System.out.printf("The total cost of all activities: RM%.2f\n"
                                ,recorded.getTotalCost());
                        break;
                    case 5:
                        System.out.printf("This member %s has joined: ", recorded.getName());
                        System.out.println("");
                        System.out.println(recorded.getActivityList().getAll());
                        break;
                    case 0:
                        System.out.println("End.");
                        break;
                    default:
                        System.out.println("Invalid choice. \n");
                        break;
                }
            } while (choice != 0); //end of do-while loop

        }
    } // end of recordInfo method


    private void changeMemberInfo() {

    }

    private void showMemberInfo() {
        System.out.println(members.getAll());
    }

    private void addMember() {

        String name;
        String address;
        int number;
        double mWeight, mHeight;
        int age;
        char sex;
        String complexion;

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
        sex = stdIn.nextLine().charAt(0);

        System.out.print("Enter the member's complexion :");
        complexion = stdIn.nextLine();

        System.out.println("");

        Member newMember = new Member(name, address, number, mWeight, mHeight, age, sex, complexion);

            System.out.println(newMember.toString() + " has succesfully been added.");

    }

    private void updateActivityInformation(ActivityList a) {
        System.out.print("Which activity's information you wish to change? ");
        String wantedActivity = stdIn.nextLine();

        //input cannot be blank
        while (wantedActivity.equals(""))
        {
            System.out.println("No input.");
            System.out.print("Please re-enter the activity's name: ");
            wantedActivity = stdIn.nextLine();
        }

        Activity foundAct = a.findActivity(wantedActivity);

        //no activity found
        if (foundAct == null)
        {
            System.out.printf("This activity %s has not yet stored in the system.", foundAct.getActivityName());
            System.out.println("\n");
        }
        else
        {
            System.out.println("Activity found: " + foundAct.getActivityName());
            System.out.println("");
            System.out.println("Please choose to proceed");
            System.out.println("1.  Change duration");
            System.out.println("2.  Change cost");
            System.out.print("Your choice? ");
            int choice = stdIn.nextInt();

            if (choice == 1)
            {
                System.out.print("Enter new duration: ");
                double duration = stdIn.nextDouble();

                while (duration <= 0 || duration >= 750)
                {
                    System.out.println("Invalid value.");
                    System.out.print("Please re-enter the activity's new duration: ");
                    duration = stdIn.nextDouble();
                }
                //set new duration
                double betterDuration = duration / 60;
                foundAct.setDurationInHours(betterDuration);
                System.out.println("");
            }
            else if (choice == 2)
            {
                System.out.print("Enter new cost: ");
                double cost = stdIn.nextDouble();
                while (cost <= 0 || cost >= 1000)
                {
                    System.out.println("Invalid value.");
                    System.out.print("Please re-enter the activity's new cost: ");
                    cost = stdIn.nextDouble();
                }
                //set new cost
                foundAct.setCostPerHour(cost);
                System.out.println("");
            }
            else
                System.out.println("Invalid choice. \n");
        }
    }

    private void viewActivityInformation(ActivityList act) {
        //display all activities' information
        System.out.println(act.getAll());
    }

    public void addActivity(ActivityList a) {
        System.out.print("Enter the activity's name: ");
        String activityName = stdIn.nextLine();
        Activity similarActivity = a.findActivity(activityName);

        //if no similar activity stored in the program
        if (similarActivity == null) {
            //input cannot leave blank
            while (activityName.equals("")) {
                System.out.println("No input.");
                System.out.print("Please re-enter the activity's name: ");
                activityName = stdIn.nextLine();
            }

            System.out.print("Enter the MET value for " + activityName + " activity: ");
            double MET = stdIn.nextDouble();
            while (MET <= 0 || MET >= 25) {
                System.out.println("Invalid value.");
                System.out.print("Please re-enter the activity's MET: ");
                MET = stdIn.nextDouble();
            }

            System.out.print("Enter the duration of " + activityName + " activity done (in minutes): ");
            double durationInMin = stdIn.nextDouble();
            while (durationInMin <= 0 || durationInMin >= 750) {
                System.out.println("Invalid value.");
                System.out.print("Please re-enter the activity's duration: ");
                durationInMin = stdIn.nextDouble();
            }
            double durationInHours = (durationInMin / 60);

            System.out.print("Enter the cost per hour for this " + activityName + " activity: ");
            double costPerHour = stdIn.nextDouble();
            while (costPerHour <= 0 || costPerHour >= 1000) {
                System.out.println("Invalid value.");
                System.out.print("Please re-enter the activity's cost per hour: ");
                costPerHour = stdIn.nextDouble();
            }

            Activity act = new Activity(activityName, MET, durationInHours, costPerHour);

        }
    }
}
