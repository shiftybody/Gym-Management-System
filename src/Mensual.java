/**
 *
 * @author Shiftybody
 * @version 0.0.1
 */
public class Mensual implements PaymentMetod {

/**
 * Método que sobreescribe calcularPago,
 * dado costo y horas totales intenta calcular
 * el número de pagos necesarios para pagar una
 * actividad en 1 mes
 *
 **/
    @Override
    public void calcularPago(Double costo, Double hours) {
        System.out.println("El pago por mes es de > " + costo / hours);
    }
}
