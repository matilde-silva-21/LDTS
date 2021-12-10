
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Arena {

    public int width, height;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    Hero hero;
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            int a = random.nextInt(width - 2) + 1 , b=random.nextInt(height - 2) + 1;
            coins.add(new Coin(a,b));

        }

        return coins;
    }

    private List<Monster> createMonsters(){
        Random random = new Random();
        List<Monster> monsters = new ArrayList<>();
        for(int i=0; i<3 ; i++){
            monsters.add(new Monster(random.nextInt(width - 2) + 1,random.nextInt(height - 2) + 1));
        }
        return monsters;
    }



    Arena(int width, int height){
        this.width = width;
        this.height = height;
        this.walls = createWalls();
        this.hero = new Hero(10,10);
        this.coins = createCoins();
        this.monsters=createMonsters();
    }

    boolean retrieveCoins(Position position){

        Iterator<Coin> it = coins.iterator();
        while(it.hasNext()){
            Coin coin = it.next();
            if(coin.position.equals(position)){
                coins.remove(coin);
                return true;
            }
        }

        return false;
    }

    public boolean verifyMonsterCollisions(){
        for(Monster monster : monsters) {
            if(hero.position.equals(monster.position)){return true;}
        }
        return false;
    }

    public void moveMonsters(){
        for (Monster monster : monsters){
            Position copy = monster.move();
            if(canHeroMove(copy)){
                monster.position.setX(copy.getX());
                monster.position.setY(copy.getY());
            }
        }

    }

    private boolean canHeroMove(Position position){

        for(Wall wall : walls){
            if(wall.position.equals(position)){return false;}
        }
        return true;
    }

    private void moveHero(Position position) {
        if(canHeroMove(position)){hero.setPosition(position);}
        retrieveCoins(position);
        moveMonsters();
    }

    public void processKey(KeyStroke key) throws IOException {
        //System.out.println(key);
        if (key.getKeyType() == KeyType.ArrowLeft){moveHero(hero.moveLeft());}
        else if(key.getKeyType() == KeyType.ArrowRight){moveHero(hero.moveRight());}
        else if(key.getKeyType() == KeyType.ArrowUp){moveHero(hero.moveUp());}
        else if(key.getKeyType() == KeyType.ArrowDown){moveHero(hero.moveDown());}
    }

    public void draw(TextGraphics graphics){
        for (Coin coin: coins){coin.draw(graphics);}
        for (Monster monster : monsters){monster.draw(graphics);}
        for (Wall wall : walls){wall.draw(graphics);}
        hero.draw(graphics);

    }

    public int coinssize(){return coins.size();}

}
