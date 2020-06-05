package bookingdotcom.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchBox {
    public static Target SEARCH_BUTTON = Target.the("search button").locatedBy("button[class='sb-searchbox__button ']");
}
