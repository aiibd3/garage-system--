package parking;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Duration {

    private String startTime;
    private String endTime;

    private Date current;
    private Date saveStartDate;
    private Date saveEndDate;

    private int totalHours;

    private final SimpleDateFormat Format = new SimpleDateFormat("dd/MM/yyyy hh:mm a");

    //     function to calculate
   //     minutes between start and end time

    public int timeSpent() {

        long diffMs = saveEndDate.getTime() - saveStartDate.getTime();
        long diffSec = diffMs / 1000;
        long difMin = diffSec / 60;
        totalHours = (int) difMin / 60;

        // check if there is a remainder
        if (difMin % 60 != 0) {
            totalHours++;
        }
        return totalHours;
    }

    //      setters and getters

    public void setStartTime() {
        current = new Date();
        saveStartDate = current;
        this.startTime = Format.format(current);
    }

    public void setEndTime() {
        current = new Date();
        saveEndDate = current;
        this.endTime = Format.format(current);
    }

    public String startTime() {
        return startTime;
    }

    public String endTime() {
        return endTime;
    }

    public int totalHours() {
        return totalHours;
    }

}
