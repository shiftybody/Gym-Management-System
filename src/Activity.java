import java.time.LocalTime;

/**
 * Clase que modela un curso o actividad dentro del sistema del gimnasio
 *
 * @author Shiftybody
 * @version 0.0.1
 */
public class Activity {


    private final String activityName;
    private final double durationInHours;
    private final double costPerHour;


    /**
     * @param activityName    valor inicial de activityName
     * @param durationInHours valor inicial de durationInHours
     * @param costPerHour     valor inicial de costPerHours
     */
    public Activity(String activityName, double durationInHours, double costPerHour) {

        this.activityName = activityName;
        this.durationInHours = durationInHours;
        this.costPerHour = costPerHour;

    }

    /**
     * Método qué devuelve el valor de la variable de instancia ActivityName
     *
     * @return el valor de la variable de instancia ActivityName
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * Método que devuelve él valor de la variable inicial durationInHours
     *
     * @return el valor de la variable de instancia DurationInHours
     */
    public double getDurationInHours() {
        return durationInHours;
    }


    /**
     * Sobreescribe el método toString
     *
     * @return la representación String de un objeto Activity
     */
    @Override
    public String toString() {
        return activityName +
                "_" + durationInHours +
                "_" + costPerHour;
    }

    /**
     * Método que calcula el costo total de una actividad dada la duración total en horas y el coste por hora
     * NOTA: Una alternativa sería especificar el costo por clase para así poder calcular diferentes tipos de pagos
     *
     * @return una variable Double con el costo total
     */
    public double totalCost() {
        if (costPerHour > 0 && durationInHours > 0) {
            return costPerHour * durationInHours;
        }
        return 0;
    }


}
