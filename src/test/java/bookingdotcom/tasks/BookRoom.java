package bookingdotcom.tasks;

import bookingdotcom.actions.Choose;
import bookingdotcom.actions.Pick;
import bookingdotcom.actions.VisitorBook;
import bookingdotcom.ui.SearchBox;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Complaint;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BookRoom implements Task {
    private int noOfRooms;
    private int noOfAdults;
    private int noOfChildren;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String destination;

    public BookRoom(int room, int adults, int children, LocalDateTime startTime, LocalDateTime endTime, String destination){
        this.noOfRooms=room;
        this.noOfAdults=adults;
        this.noOfChildren=children;
        this.startTime=startTime;
        this.endTime=endTime;
        this.destination=destination;
    }

    public static BookRoomBuilder noOfRooms(int noOfRooms) {
        return new BookRoomBuilder(noOfRooms);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Choose.aDestination(this.destination),
            Pick.dateForCheckIn(this.startTime).andDateForCheckOut(endTime),
            VisitorBook.noOfRooms(this.noOfRooms).forAdults(this.noOfAdults).andChildren(this.noOfChildren),
            Click.on(SearchBox.SEARCH_BUTTON)
        );
    }

    public static class BookRoomBuilder{
        private int noOfRoom;
        private int noOfAdult;
        private int noOfChildren;
        private LocalDateTime startDate;
        private LocalDateTime endDate;

        public BookRoomBuilder(int noOfRooms){
            this.noOfRoom=noOfRooms;
        }

        public BookRoomBuilder forAdults(int adults) {
            this.noOfAdult=adults;
            return this;
        }

        public BookRoomBuilder andChildren(int children) {
            this.noOfChildren=children;
            return this;
        }

        public BookRoomBuilder from(LocalDateTime startDate) {
            this.startDate=startDate;
            return this;
        }

        public BookRoomBuilder to(LocalDateTime endDate) {
            this.endDate=endDate;
            return this;
        }

        public BookRoom in(String destination) {
            return instrumented(BookRoom.class, noOfRoom, noOfAdult, noOfChildren, startDate, endDate, destination);
        }
    }
}
