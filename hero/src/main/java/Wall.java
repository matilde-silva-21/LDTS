import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

import javax.management.loading.ClassLoaderRepository;
import java.util.List;
public class Wall extends Element{

    private int a;
    private int b;

    Position position;

    public Wall(int a, int b){
        super(a,b);
        this.position = new Position(a,b);
    }

    void draw(TextGraphics graphics){

        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "*");
    }
}
