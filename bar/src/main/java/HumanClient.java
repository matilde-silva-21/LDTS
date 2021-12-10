import java.util.List;

public class HumanClient implements Client{

    private ImpatientStrategy ImpatientStrategy;
    private SmartStrategy SmartStrategy;

    private StringDrink drink;
    private StringRecipe recipe;
    private StringBar bar;


    HumanClient(ImpatientStrategy ImpatientStrategy){
        this.ImpatientStrategy=ImpatientStrategy;
    }
    HumanClient(SmartStrategy SmartStrategy){
        this.SmartStrategy=SmartStrategy;
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {

        this.bar=bar;
        this.recipe=recipe;
        this.drink=drink;

        if(ImpatientStrategy!=null){
            bar.order(drink,recipe);
        }

        else if(SmartStrategy!=null){
            if(bar.isHappyHour()){bar.order(drink,recipe);}
        }
    }

    @Override
    public void happyHourStarted(Bar bar) {
        if(bar.isHappyHour()){
            this.bar.order(this.drink,this.recipe);
        }
    }

    @Override
    public void happyHourEnded(Bar bar) {

    }
}
