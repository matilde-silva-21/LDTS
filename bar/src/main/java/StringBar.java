import java.util.ArrayList;
import java.util.List;

public class StringBar extends Bar{

    boolean happyhour;

    StringBar(){}

    public boolean isHappyHour() {return happyhour;}
    public void startHappyHour() {happyhour = true; notifyObservers();}
    public void endHappyHour() {happyhour = false; notifyObservers();}
    public void order(StringDrink drink, StringRecipe recipe){
        recipe.mix(drink);
    }

}
