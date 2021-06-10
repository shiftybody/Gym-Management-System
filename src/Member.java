public class Member {

    private final String id;
    private final String nombre;
    private final String address;
    private final int number;
    private final double weight, height;
    private final int age;
    private final String sex;
    private final String complexion;
    private final boolean estado;
    private final ActivityList listOfActivities;

    private double totalCost;


    public Member(String id, String name, String address, int number, double weight, double height, int age, String sex, String complexion, boolean estado) {
        this.id = id;
        this.nombre = name;
        this.address = address;
        this.number = number;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.sex = sex;
        this.complexion = complexion;
        this.estado = estado; //activo/true inactivo/false

        this.listOfActivities = new ActivityList();
        this.totalCost = 0.0;

    }

    public String getNombre() {
        return nombre;
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

    public String getSex() {
        return sex;
    }

    public String getComplexion() {
        return complexion;
    }

    public ActivityList getListOfActivities() {
        return listOfActivities;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void increaseTotalCost(double cost) {
        totalCost += cost;
    }

    @Override
    public String toString() {
        return "Member" +
                "_" + nombre +
                "_" + address +
                "_" + number +
                "_" + weight +
                "_" + height +
                "_" + age +
                "_" + sex +
                "_" + complexion;
    }

}