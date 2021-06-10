public class Member {

    private final String name;
    private final String address;
    private final int number;
    private final double weight, height;
    private final int age;
    private final char sex;
    private final String complexion;
    private ActivityList listOfActivities, tempList;
    private double totalCost, totalCaloriesBurned;

    public Member(String name, String address, int number, double weight, double height, int age, char sex, String complexion) {


        this.name = name;
        this.address = address;
        this.number = number;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.sex = sex;
        this.complexion = complexion;

        this.listOfActivities = new ActivityList();
        this.tempList = new ActivityList();

        this.totalCost = totalCost;
        this.totalCaloriesBurned = totalCaloriesBurned;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getNumber() {
        return number;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }

    public String getComplexion() {
        return complexion;
    }

    public ActivityList getListOfActivities() {
        return listOfActivities;
    }

    public ActivityList getTempList() {
        return tempList;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getTotalCaloriesBurned() {
        return totalCaloriesBurned;
    }

    public void increaseTotalCost(double cost) {
        totalCost += cost;
    }

    @Override
    public String toString() {
        return "Member" +
                "_" + name +
                "_" + address +
                "_" + number +
                "_" + weight +
                "_" + height +
                "_" + age +
                "_" + sex +
                "_" + complexion ;
    }

    // Clone list
    public ActivityList cloneList(ActivityList act) {

        tempList.addActivity(act.getActivity());

        return tempList;
    }

    public ActivityList getActivityList() {
        return listOfActivities;
    }
}