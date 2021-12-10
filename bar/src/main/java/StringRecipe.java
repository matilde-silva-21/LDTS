import java.util.List;

public class StringRecipe {
    List<StringTranformer> f;


    StringRecipe(List<StringTranformer> f){
        this.f = f;
    }


    public void mix(StringDrink drink) {
        for(StringTranformer r: f){
            r.execute(drink);
        }
    }
}

