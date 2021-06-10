/**
 * @author Shiftybody
 * @version 0.0.1
 */
public class Member {

    private final String id;
    private final String nombre;
    private final String address;
    private final int number;
    private final double weight, height;
    private final int age;
    private final String sex;
    private final String complexion;
    private final String activity;
    private final String estadoCuenta; //activo/true inactivo/false

    /**
     * Método constructor de la clase Member
     *
     * @param id valor inicial de id
     * @param name valor inicial de name
     * @param address valor inicial de address
     * @param number valor inicial de number
     * @param weight valor inicial de weight
     * @param height valor inicial de height
     * @param age valor inicial de height
     * @param sex valor inicial de sex
     * @param complexion valor inicial de complexion
     * @param activity valor inicial de activity
     * @param estado valor inicial de estado
     */
    public Member(String id, String name, String address, int number, double weight, double height, int age, String sex, String complexion, String activity, String estado) {
        this.id = id;
        this.nombre = name;
        this.address = address;
        this.number = number;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.sex = sex;
        this.complexion = complexion;
        this.activity = activity;
        this.estadoCuenta = estado;

    }

    /**
     * Método consulto del id de un objeto Member
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *Método consulto de la actividad de un objeto Member
     * @return
     */
    public String getActivity() {
        return activity;
    }

    /**
     * Sobreescribe el método toString
     * @return un modelo tipo String del objeto Member
     */
    @Override
    public String toString() {
        return id +
                "_" + nombre +
                "_" + address +
                "_" + number +
                "_" + weight +
                "_" + height +
                "_" + age +
                "_" + sex +
                "_" + complexion +
                "_" + activity +
                "_" + estadoCuenta;
    }
}