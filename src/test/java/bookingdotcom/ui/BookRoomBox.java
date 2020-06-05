package bookingdotcom.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BookRoomBox {
    public static Target NUMBER_OF_ADULT = Target.the("default number of adult").locatedBy("(//span[@class=\"bui-stepper__display\"])[1]");
    public static Target DECREASE_NUMBER_OF_ADULT = Target.the("decrease number of adult").locatedBy("(//button[@aria-describedby=\"group_adults_desc\"])[1]");
    public static Target INCREASE_NUMBER_OF_ADULT = Target.the("increase number of adult").locatedBy("(//button[@aria-describedby=\"group_adults_desc\"])[2]");
    public static Target NUMBER_OF_CHILDREN = Target.the("default number of children").locatedBy("(//span[@class=\"bui-stepper__display\"])[2]");
    public static Target DECREASE_NUMBER_OF_CHILDREN =  Target.the("decrease number of children").locatedBy("(//button[@aria-describedby=\"group_children_desc\"])[1]");
    public static Target INCREASE_NUMBER_OF_CHILDREN =  Target.the("increase number of children").locatedBy("(//button[@aria-describedby=\"group_children_desc\"])[2]");
    public static Target NUMBER_OF_ROOM = Target.the("default number of room").locatedBy("(//span[@class=\"bui-stepper__display\"])[3]");
    public static Target DECREASE_NUMBER_OF_ROOM = Target.the("decrease number of room").locatedBy("(//button[@aria-describedby=\"no_rooms_desc\"])[1]");
    public static Target INCREASE_NUMBER_OF_ROOM = Target.the("increase number of room").locatedBy("(//button[@aria-describedby=\"no_rooms_desc\"])[2]");
}
