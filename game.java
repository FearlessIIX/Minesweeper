import java.util.Vector;
import java.util.Scanner;
class Game {
    private Vector<Tile> Grid;
    private int width;
    private int height;
    private String method;
    public Game(Vector<Tile> GRID, int wh, int hg) {
        this.Grid = GRID;
        this.width = wh;
        this.height = hg;
    }
    public void changeMethod(String mtd) {
        this.method = mtd;
    }
    public String getInputMethod() {
        return this.method;
    }
    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }
    public Vector<Tile> getGrid() {
        return this.Grid;
    }
}
class Screen {
    private Vector<Tile> GRID;
    private int tile_count = 0;
    Screen() {
    }
    public void display(Game game) {
        int width = game.getWidth();
        this.GRID = game.getGrid();
        System.out.println("Enter the coordinate for which Tile you would like to flip");
        for (int y = 0; y <= width; y++) {
            if (y == width) System.out.println(y);
            else {
                if (y == 1) System.out.print("  ");
                System.out.print(y + " ");
            }
        }
        for (int z = 0; z <= width * 2; z++) {
            if (z == width * 2) System.out.println("_");
            else {
                if (z == 0) System.out.print("   ");
                else System.out.print("_");
            }
        }
        int y_row = 1;
        System.out.print(y_row + " | ");
        y_row++;
        for (int x = 1; x <= GRID.size(); x++) {
            Tile curr_tile = GRID.get(x - 1);

            if (x % width == 0) {
                System.out.println(curr_tile);
                if (y_row - 1 == width) {}
                else System.out.print(y_row + " | ");
                y_row++;
            }
            else System.out.print(curr_tile + " ");
        }
    }

    public String userInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
