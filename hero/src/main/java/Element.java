import com.googlecode.lanterna.graphics.TextGraphics;

abstract public class Element{
    private int a,b;
    Position position;
    Element(int a, int b){
        this.a=a;
        this.b=b;
        this.position = new Position(a,b);
    }

    abstract void draw(TextGraphics graphics);
}
