/**
 *
 * Interfaz que declara un metodo para calcular un pago dado
 * el costo y la hora
 * @author Shiftybody
 * @version 0.0.1
 */
public interface PaymentMetod {

    /**
     * Método implementado desde la clase pricipal Gym
     *
     * @param costo
     * @param hours
     */
    void calcularPago(Double costo, Double hours);

}
