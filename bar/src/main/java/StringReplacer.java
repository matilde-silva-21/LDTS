public class StringReplacer implements StringTranformer{

    char a, b;
    StringReplacer(char a, char b){
        this.a=a;
        this.b=b;
    }
    @Override
    public void execute(StringDrink drink) {
        String text = drink.getText();
        text = text.replace(a,b);
        drink.setText(text);
    }
}
