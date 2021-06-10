import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que modela un catalogo o lista de actividades
 *
 * @author Shiftybody
 * @version 0.0.1
 */
public class ActivityList implements Iterable<Activity> {


    /**
     * definimos he instanciamos la interfaz iterrator para recorrer
     * elementos de tipo Activity
     */
    private final ArrayList<Activity> activities = new ArrayList<>();


    /**
     *  Método que agrega una actividad dentro del arrayList
     * @param activity objeto de tipo Activity
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     *Método que sobreescribe la interfaz iterator
     *
     * @return un iterados sobre las instancias de la colección producto.
     */
    @Override
    public Iterator<Activity> iterator() {
        return activities.iterator();
    }
}
