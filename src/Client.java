public class Client extends Member {

    private final double weight, height;
    private final int age;
    private final char sex;
    private final String complexion;

    public Client(String id, String name, String address, int number, double weight, double height, int age, char sex, String complexion) {
        super(id, name, address, number);

        this.weight = weight;
        this.height = height;
        this.age = age;
        this.sex = sex;
        this.complexion = complexion;

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


}
