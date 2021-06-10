public class Member {

    private final String id;
    private final String name;
    private final String address;
    private final int number;

    public Member(String id, String name, String address, int number) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public String getId() {
        return id;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", number=" + number +
                '}';
    }
}