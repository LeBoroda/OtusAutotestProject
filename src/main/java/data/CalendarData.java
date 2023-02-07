package data;

public enum CalendarData {
    JANUARY("января", "01"),
    FEBRUARY("февраля", "02"),
    MARCH("марта", "03"),
    APRIL("апреля","04"),
    MAY("мая","05"),
    JUNE("июня","06"),
    JULY("июля","07"),
    AUGUST("августа","08"),
    SEPTEMBER("сентября","09"),
    OCTOBER("октября","10"),
    NOVEMBER("ноября","11"),
    DECEMBER("декабря","12");

    private final String monthName;
    private final String monthNumber;

    CalendarData(String monthName, String monthNumber){
        this.monthName = monthName;
        this.monthNumber = monthNumber;
    }

    public String getName() {
        return monthName;
    }

    public String getNumber() {
        return monthNumber;
    }
}
