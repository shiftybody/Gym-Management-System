import java.time.LocalTime;

public class Activity {

    private String activityName;
    private double durationInHours;
    private double costPerHour;

    public Activity(String activityName, double durationInHours, double costPerHour) {

            this.activityName = activityName;
            this.durationInHours = durationInHours;
            this.costPerHour = costPerHour;

    }

    public String getActivityName() {
        return activityName;
    }

    public void setDurationInHours(double durationInHours) {
        this.durationInHours = durationInHours;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    @Override
    public String toString() {
        return        activityName +
                "_" + durationInHours +
                "_" + costPerHour ;
    }

    public double totalCost(){
        if (costPerHour > 0 && durationInHours > 0){
            return costPerHour * durationInHours;
        }
        return 0;
    }


}
