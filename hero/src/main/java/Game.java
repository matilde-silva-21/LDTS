import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;


import java.io.IOException;

public class Game {

    Screen screen;
    Arena arena;

    Game() throws IOException {
        arena = new Arena(40,20);
        TerminalSize terminalSize = new TerminalSize(arena.width, arena.height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);

    }


    void draw() throws IOException {
        screen.startScreen();
        //screen.doResizeIfNecessary();
	    screen.clear();
        arena.draw(screen.newTextGraphics());
	    screen.refresh();
    }


	void run() throws IOException {
        while(!arena.verifyMonsterCollisions() && arena.coinssize()!=0){
            draw();
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.EOF){break;}
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){screen.close(); System.out.print("You quit the game :(");break;}
            processKey(key);
        }
        screen.close();
        if(arena.coinssize()==0) System.out.print("Congratulations, you won!");
        else if(arena.verifyMonsterCollisions()) System.out.print("Oh no, you lost!");
	}


    private void processKey(KeyStroke key) throws IOException {
        arena.processKey(key);
    }



}
