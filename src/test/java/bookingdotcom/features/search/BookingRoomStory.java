package bookingdotcom.features.search;

import bookingdotcom.questions.SearchResultPage;
import bookingdotcom.tasks.BookRoom;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import bookingdotcom.tasks.OpenTheApplication;

import java.time.LocalDateTime;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class BookingRoomStory {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void booking_2_rooms_for_4_adults_3_children_for_3_days_in_PhuQuoc(){
        givenThat(anna).wasAbleTo(openTheApplication);
        LocalDateTime startDate = LocalDateTime.now().plusDays(7);
        LocalDateTime endDate = startDate.plusDays(3);
        when(anna).attemptsTo(
                BookRoom
                        .noOfRooms(2)
                        .forAdults(4)
                        .andChildren(3)
                        .from(startDate)
                        .to(endDate)
                        .in("Phú Quốc")
        );
        then(anna).should(
                eventually(seeThat("The number of matched rooms", SearchResultPage.totalRooms(), equalTo(452)))
        );
    }
}