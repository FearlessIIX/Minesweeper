import java.util.*;
class Main {
    public static void main(String[] args) {

        Begin SETUP = new Begin();
        int mines = SETUP.fetch("mines");
        int width = SETUP.fetch("width");
        int height = SETUP.fetch("height");

        Generate GEN = new Generate(width, height, mines);
        Vector<String> MINES = GEN.getMines();



    }
}
