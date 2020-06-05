package bookingdotcom.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
    public static Target DESTINATION_BOX = Target.the("destination box").locatedBy("//input[@type=\"search\"]");
    public static Target SUGGEST_TOP_ITEM = Target.the("suggest top item").locatedBy("//ul[starts-with(@class, \"autocomplete\") or @data-list]/li[1]");
    public static Target DATE_BOX = Target.the("date box").locatedBy("//div[@class='xp__dates-inner']");
    public static Target ROOM_BOX = Target.the("room box").locatedBy("//div[@class='xp__input-group xp__guests']");
}
