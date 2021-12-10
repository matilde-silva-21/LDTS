public class RomulanClient extends AlienClient{
    @Override
    protected OrderingStrategy createOrderingStrategy() {
        return null;
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        bar.order(drink, recipe);
    }
}
