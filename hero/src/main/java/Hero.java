import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero extends Element {

    Position position;

    Hero(int a, int b) {
        super(a, b);
        this.position = new Position(a,b);
    }

    public void setPosX(int x) {
        position.setX(x);
    }

    public int getPosY() {
        return position.getY();
    }

    public void setPosY(int y) {
        position.setY(y);
    }

    public int getPosX() {
        return position.getX();
    }


    public Position moveUp() {return new Position(position.getX(), position.getY()-1);}
    public Position moveDown(){return new Position(position.getX(), position.getY()+1);}
    public Position moveLeft(){return new Position(position.getX()-1, position.getY());}
    public Position moveRight(){return new Position(position.getX()+1, position.getY());}

    public void setPosition(Position position1){
        position.setX(position1.getX());
        position.setY(position1.getY());
    }


    void draw(TextGraphics graphics) {
        graphics.putString(new TerminalPosition(getPosX(), getPosY()),"X");
    }

}