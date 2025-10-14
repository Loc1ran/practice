package P07.src.session;

public class DateRange {
    private String date;
    private String startTime;
    private String endTime;

    public DateRange(String date, String startTime, String endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

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

    @Override
    public String toString() {
        return date + " " + startTime + " (" + duration() + " minutes)";
    }
}
