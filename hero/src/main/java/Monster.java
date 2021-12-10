import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;
import java.util.Random;

public class Monster extends Element{
    private int a,b;
    Position position;
    Monster(int a,int b) {
        super(a, b);
        this.position = new Position(a, b);
    }

    void draw(TextGraphics graphics) {
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");
    }


    public Position move(){
        Random random = new Random();
        Position pos = new Position(position.getX(), position.getY());
        pos.setY(position.getY()+random.nextInt(3)-1);
        pos.setX(position.getX()+random.nextInt(3)-1);
        return pos;
    }


}
