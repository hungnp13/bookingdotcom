package bookingdotcom.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import bookingdotcom.ui.BookingDotCom;

public class OpenTheApplication implements Task {

    BookingDotCom bookingDotCom;

    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(bookingDotCom)
        );
    }
}
