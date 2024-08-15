import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Time implements InterfaceTime{
    public int numberofhours = 0;
    public String timee() {
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        return time.format(date);
    }
    public int findDifference(String start_date, String end_date) {
        SimpleDateFormat sdf
                = new SimpleDateFormat(
                "HH:mm");
        try {
            Date d1 = sdf.parse(start_date);
            Date d2 = sdf.parse(end_date);

            long difference_In_Time
                    = d2.getTime() - d1.getTime();
            long difference_In_Minutes
                    = (difference_In_Time
                    / (1000 * 60))
                    % 60;
            numberofhours = (int) ((difference_In_Time
                        / (1000 * 60 * 60))
                        % 24);
            if (difference_In_Minutes > 0) {
                numberofhours++;
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return numberofhours;
    }
}
