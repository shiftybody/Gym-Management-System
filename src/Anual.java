/**
 *
 * Clase que implementa la interfaz PaymentMetod
 * sobreescribiendo el método calcularPago
 *
 * @author Shiftybody
 * @version 0.0.1
 */
public class Anual implements PaymentMetod {
    /**
     *
     * Método que sobreescribe calcularPago,
     * dado costo y horas totales intenta calcular
     * el número de pagos necesarios para pagar una
     * actividad en 1 año
     * @param costo
     * @param hours
     */
    @Override
    public void calcularPago(Double costo, Double hours) {
        System.out.println("El pago por año es de > " + costo / hours);
    }

}
