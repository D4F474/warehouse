package gui.Calendar;

public enum Month {
    January(1, "January"),
    February(2, "February"),
    March(3, "March"),
    April(4, "April"),
    May(5, "May"),
    June(6, "June"),
    July(7, "July"),
    August(8, "August"),
    September(9, "September"),
    October(10, "October"),
    November(11, "November"),
    December(12, "December");

    private int value = 0;
    private String Text;

    private Month(int value, String text) {
        this.value = value;
        this.Text = text;
    }

    public String getText() {
        return Text;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Text;
    }
}
