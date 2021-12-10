import java.util.List;

public class StringTransformerGroup implements StringTranformer{
    List<StringTranformer> transformers;

    public StringTransformerGroup(List<StringTranformer> transformers) {
        this.transformers=transformers;
    }

    public void execute(StringDrink drink) {
        for(StringTranformer t: transformers){
            t.execute(drink);
        }
    }
}
