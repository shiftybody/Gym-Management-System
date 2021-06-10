import java.util.ArrayList;
import java.util.Iterator;

public abstract class ActivityList implements Iterable<Activity> {

    private final ArrayList<Activity> activities = new ArrayList<>();
    ActivityList(){

    }

    // Adds activity into array
    public boolean addActivity (Activity activity) {
        activities.add(activity);
        return false;
    }



    // Finds and returns activity based on given name
    public Activity findActivity(String name) {

        for (Activity act :
                activities) {
            if (act.getActivityName().equalsIgnoreCase(name)) {
                return act;
            }
        }
        return null;
    }

    // Calculate the average MET in the array


    // Return all activities in the list
    public String getAll() {

        String message = "Activities :- \n";
        for (Activity act:
             activities) {
            message += act.toString() + "\n";
        }
        return null;
    }

    // Returns all available activities member can join
    public String getActivityList() {
        String message = "Available activities :\n";

        for (Activity act :
                activities) {
            message += ". " + act.getActivityName() + "\n";

        }
        return null;
    }

    // Returns number of activities stored
    public int getActivityCount() {
        return activities.size();
    }

    public void removeActivity(Activity activity){
        activities.remove(activity);
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
