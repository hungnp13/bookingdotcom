package bookingdotcom.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class DateTimePicker {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static Target DATE_CHECK_IN(LocalDateTime startTime) {
        Target START_DATE = Target.the("start date").locatedBy("//td[@data-date=\""+startTime.format(formatter)+"\"]");
        return START_DATE;
    }

    public static Target DATE_CHECK_OUT(LocalDateTime endTime) {
        Target END_DATE = Target.the("start date").locatedBy("//td[@data-date=\""+endTime.format(formatter)+"\"]");
        return END_DATE;
    }
}
