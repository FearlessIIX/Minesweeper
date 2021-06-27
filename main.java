import java.util.*;
import javax.swing.*;
public class Main {

    public static void clear() {
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }

    public static void main(String[] args) {

        // this is manually changed. Options are: 'index' , and 'cord'
        String method = "cord";

        Begin SETUP = new Begin();

        System.out.println("\n \n \n \n \n \n \n \n \n \n ");
        //clear();  //clears the console after startup

        int mines = SETUP.fetch("mines");
        int width = SETUP.fetch("width");
        int height = SETUP.fetch("height");

        Generate GEN = new Generate(width, height, mines);
        Vector<String> MINES = GEN.getMines();

        TileGen GEN_CON = new TileGen(MINES, width, height);
        Vector<Tile> STORE = GEN_CON.getRet();

        Game GAME = new Game(STORE, width, height);
        GAME.changeMethod(method);
        Screen SCREEN = new Screen();

        Play PLAY = new Play(GAME, SCREEN);
        PLAY.execute();
    }
}
