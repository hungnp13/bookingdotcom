package bookingdotcom.actions;

import bookingdotcom.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.time.LocalDateTime;

public class Choose implements Interaction {
    private String destination;

    public static Choose aDestination(String destination) {
        return new Choose(destination);
    }

    public Choose(String destination){
        this.destination = destination;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(destination).into(HomePage.DESTINATION_BOX),
                Click.on(HomePage.SUGGEST_TOP_ITEM)
        );
    }
}
