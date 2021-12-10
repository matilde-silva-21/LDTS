public class StringInverter implements StringTranformer{

    StringInverter(){}

    public void execute(StringDrink drink) {
        String text = drink.getText(), dummy="";
        for(int i=text.length()-1; i>-1; i--){
            char c = text.charAt(i);
            dummy += c;
        }
        drink.setText(dummy);
    }


}
