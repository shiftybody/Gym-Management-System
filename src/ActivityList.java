import java.util.ArrayList;
import java.util.Iterator;

public class ActivityList implements Iterable<Activity> {

    private final ArrayList<Activity> activities = new ArrayList<>();

    ActivityList(){

    }

    // Adds activity into arraylist
    public void addActivity(Activity activity) {
        activities.add(activity);
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Activity> iterator() {
        return activities.iterator();
    }


    public Activity getActivity() {
        return (Activity) activities.iterator();
    }
}
