package bookingdotcom.actions;

import bookingdotcom.ui.DateTimePicker;
import bookingdotcom.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;

import java.time.LocalDateTime;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Pick implements Interaction {
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public static DatePickerBuilder dateForCheckIn(LocalDateTime startTime) {
        return new DatePickerBuilder(startTime);
    }

    public Pick(LocalDateTime checkInDate, LocalDateTime checkOutDate){
        this.startTime=checkInDate;
        this.endTime=checkOutDate;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.DATE_BOX),
                Click.on(DateTimePicker.DATE_CHECK_IN(startTime)),
                Click.on(DateTimePicker.DATE_CHECK_OUT(endTime))
        );
    }

    public static class DatePickerBuilder {
        private LocalDateTime startTime;
        public DatePickerBuilder(LocalDateTime startTime) {
            this.startTime=startTime;
        }
        public Pick andDateForCheckOut(LocalDateTime endTime) {
            return instrumented(Pick.class, startTime, endTime);
        }
    }
}
