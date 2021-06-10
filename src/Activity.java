import java.time.LocalTime;

public class Activity {

    private String activityName;
    private double durationInHours;
    private double costPerHour;


    public Activity(){

    }

    public Activity(String activityName, double MET, double durationInHours, double costPerHour) {

            this.activityName = activityName;
            this.durationInHours = durationInHours;
            this.durationInHours = 0.0;
            this.costPerHour = costPerHour;
            this.costPerHour = 0.0;

    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public double getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(double durationInHours) {
        this.durationInHours = durationInHours;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    @Override
    public String toString() {
        return "Activity_" +
                "_" + activityName +
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
