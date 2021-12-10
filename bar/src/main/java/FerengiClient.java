public class FerengiClient extends AlienClient{

    private StringDrink drink;
    private StringRecipe recipe;
    private StringBar bar;


    @Override
    protected OrderingStrategy createOrderingStrategy() {

        return null;
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        this.bar=bar;
        this.recipe=recipe;
        this.drink=drink;

        if(bar.isHappyHour()){bar.order(drink,recipe);}
    }

    @Override
    public void happyHourStarted(Bar bar) {
        if(bar.isHappyHour()){
            this.bar.order(this.drink,this.recipe);
        }
    }
}
