public class StringCaseChanger implements StringTranformer{

    @Override
    public void execute(StringDrink drink) {
        String text= drink.getText();
        StringBuilder dummy = new StringBuilder();
        for(int i=0; i < text.length() ; i++){
            char c = text.charAt(i);
            if(Character.isLowerCase(c)){c = Character.toUpperCase(c);}
            else{c = Character.toLowerCase(c);}
            dummy.append(c);
        }

        drink.setText(dummy.toString());
    }
}
