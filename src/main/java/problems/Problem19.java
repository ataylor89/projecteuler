package problems;

/**
 *
 * @author ataylor
 */
public class Problem19 {

    public static final int SUNDAY = 0;
    public static int answer = 0;
    public static final int JANUARY = 0, FEBRUARY = 1, MARCH = 2, APRIL = 3, MAY = 4, JUNE = 5, JULY = 6, AUGUST = 7, SEPTEMBER = 8, OCTOBER = 9, NOVEMBER = 10, DECEMBER = 11;

    public static void main(String[] args) {
        int day_of_week = 1; // Monday, Jan 1, 1901
        for (int year = 1901; year < 2000; year++) {
            for (int month = 0; month < 12; month++) {
                if (day_of_week == SUNDAY) {
                    answer++;
                }

                final int DAYS_IN_MONTH = calculateDaysInMonth(month, year);
                for (int i = 0; i < DAYS_IN_MONTH; i++) {
                    day_of_week = (day_of_week + 1) % 7;
                }
            }
        }
        System.out.println("Number of Sundays that fall on the first of the month: " + answer);
    }

    public static int calculateDaysInMonth(int month, int year) {
        switch (month) {
            case SEPTEMBER:
            case APRIL:
            case JUNE:
            case NOVEMBER:
                return 30;
            case FEBRUARY:
                boolean isLeapYear = false;
                if ((year % 100 == 0)) {
                    if (year % 4 == 0) {
                        isLeapYear = true;
                    }
                } else if (year % 4 == 0) {
                    isLeapYear = true;
                }
                return isLeapYear ? 29 : 28;
            default:
                return 31;
        }
    }
}
