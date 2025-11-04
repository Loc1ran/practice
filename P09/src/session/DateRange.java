package P09.src.session;

/**
 * Tracks tutoring sessions
 * @author Loc Tran
 * @version 1.0
 * @since 1.0
 */

public class DateRange {
    private String date;
    private String startTime;
    private String endTime;

    /**
     * Constructor with date and time
     * @param date YYYY:MM:DD
     * @param startTime HH:MM
     * @param endTime HH:MM
     */

    public DateRange(String date, String startTime, String endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Constructor calculates end time given duration
     * @param date YYYY:MM:DD
     * @param startTime HH:MM
     * @param duration MM
     */
    public DateRange(String date, String startTime, long duration) {
        this.date = date;
        this.startTime = startTime;

        String[] time = startTime.split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);

        long total = hours * 60 + minutes + duration;

        int totalH = (int)(total / 60);
        int totalM = (int)(total % 60);

        this.endTime = String.format("%02d:%02d", totalH, totalM);


    }

    /**
     * Calculates duration
     * @return duration in long
     */

    public long duration() {
        String[] time = startTime.split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int total = hours * 60 + minutes;

        String[] duration = endTime.split(":");
        int endH = Integer.parseInt(duration[0]);
        int endM = Integer.parseInt(duration[1]);
        int endTotal = endH * 60 + endM;

        return endTotal - total;
    }

    /**
     * return string of DateRange
     * @return a string of date, time and duration
     */

    @Override
    public String toString() {
        return date + " " + startTime + " (" + duration() + " minutes)";
    }
}
