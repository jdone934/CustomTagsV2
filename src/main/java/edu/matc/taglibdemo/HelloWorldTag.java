package edu.matc.taglibdemo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloWorldTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();

        LocalDateTime dateTime = LocalDateTime.now();
        int hour = dateTime.getHour();
        out.println(getTimeOfDayGreeting(hour));

        int month = dateTime.getMonthValue();
        int day = dateTime.getDayOfMonth();

        String message = getDateGreeting(month, day);
        if (message != null) {out.println(message);}
    }

    private String getDateGreeting(int month, int day) {
        if (month == 1 && day == 1) {
            return "Happy New Year!";
        } else if (month == 5 && day == 12) {
            return "Happy Presentation Day!";
        } else if (month == 5 && day == 4) {
            return "Happy Extra Credit Day!";
        } else {
            return null;
        }
    }

    private String getTimeOfDayGreeting(int hour) {
        if (hour >= 6 && hour < 12) {
            return ("Good Morning!");
        } else if (hour >= 12 && hour < 17 ) {
            return ("Good Afternoon!");
        } else if (hour >= 17 && hour < 20) {
            return ("Good Evening!");
        } else {
            return ("Have a Good Night!");
        }
    }
}
