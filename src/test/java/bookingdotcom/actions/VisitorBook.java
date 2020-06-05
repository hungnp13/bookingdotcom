package bookingdotcom.actions;

import bookingdotcom.tasks.BookRoom;
import bookingdotcom.ui.BookRoomBox;
import bookingdotcom.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class VisitorBook implements Interaction {
    private final int noOfRoom;
    private final int noOfAdult;
    private final int noOfChildren;

    public static VisitorBookRoomBuilder noOfRooms(int noOfRooms) {
        return new VisitorBookRoomBuilder(noOfRooms);
    }

    public VisitorBook(int noOfRoom, int noOfAdult, int noOfChildren){
        this.noOfRoom = noOfRoom;
        this.noOfAdult = noOfAdult;
        this.noOfChildren = noOfChildren;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Click.on(HomePage.ROOM_BOX);
        //Adult
        int numberOfAdult = Integer.parseInt(Text.of(BookRoomBox.NUMBER_OF_ADULT).toString());
        if(numberOfAdult>noOfAdult)
        {
            for(int i =numberOfAdult; i>noOfAdult; i--)
            {
                Click.on(BookRoomBox.DECREASE_NUMBER_OF_ADULT);
            }
        }
        else if(noOfAdult> numberOfAdult)
        {
            for(int i =numberOfAdult; i<noOfAdult; i++)
            {
                Click.on(BookRoomBox.INCREASE_NUMBER_OF_ADULT);
            }
        }

        //Children
        int numberOfChildren = Integer.parseInt(Text.of(BookRoomBox.NUMBER_OF_CHILDREN).toString());
        if(numberOfChildren> noOfChildren)
        {
            for(int i=noOfChildren; i<numberOfChildren; i++)
            {
                Click.on(BookRoomBox.DECREASE_NUMBER_OF_CHILDREN);
            }
        }
        else if(numberOfChildren<noOfChildren)
        {
            for(int i=numberOfChildren; i<noOfChildren; i++)
            {
                Click.on(BookRoomBox.INCREASE_NUMBER_OF_CHILDREN);
            }
        }

        //Room
        int numberOfRoom = Integer.parseInt(Text.of(BookRoomBox.NUMBER_OF_ROOM).toString());
        if(numberOfRoom> noOfRoom)
        {
            for(int i=noOfRoom; i<numberOfRoom; i++)
            {
                Click.on(BookRoomBox.DECREASE_NUMBER_OF_ROOM);
            }
        }
        else if(numberOfRoom<noOfRoom)
        {
            for(int i=numberOfRoom; i<noOfRoom; i++)
            {
                Click.on(BookRoomBox.INCREASE_NUMBER_OF_ROOM);
            }
        }

    }

    public static class VisitorBookRoomBuilder {
        private int room;
        private int adults;

        public VisitorBookRoomBuilder(int noOfRooms) {
            this.room = noOfRooms;
        }

        public VisitorBookRoomBuilder forAdults(int noOfAdults) {
            this.adults = noOfAdults;
            return this;
        }

        public VisitorBook andChildren(int noOfChildren) {
            return instrumented(VisitorBook.class, room, adults, noOfChildren);
        }
    }
}
