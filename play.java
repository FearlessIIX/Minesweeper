import java.util.Vector;
class Play {
    private Game GAME;
    private Screen SCREEN;
    private int input;
    private int first_in;
    private int second_in;
    private boolean lost = false;

    public Play(Game game, Screen screen) {
        this.GAME = game;
        this.SCREEN = screen;
    }

    public void execute() {
        if (this.GAME.getInputMethod().equals("index")) {
            System.out.println("Your input method is 'index', select the Tile by Tile number");
        }
        else System.out.println("Your input method is 'cord', select the Tile by x, and y coordinate");

        //TODO: put Java sleep Method here

        //Main.clear();
        boolean done = false;
        String stage = "D_GRID";
        while (!(done)) {
            if (stage.equals("D_GRID")) {
                //code for displaying the grid to the screen
                //grid will also include a prompt for the user to input Tile
                this.SCREEN.display(this.GAME);
                if (this.lost) {
                    System.out.println("\n \n You hit a mine!!");
                    break;
                }
                stage = "G_INPUT";

            }
            else if (stage.equals("G_INPUT")) {
                //code for getting the user input
                //char[] alpha = "abcdefghijklmnopqrstuvwxyz`~!@#$%^&*()_+[{]}\\|;:'\",<.>/?".toCharArray();

                String usr_input = SCREEN.userInput();
                //no way to validate user input for now
                if (GAME.getInputMethod() == "index") {
                    this.input = Integer.parseInt(usr_input);
                }
                else {
                    this.first_in = Integer.parseInt(usr_input);
                    usr_input = SCREEN.userInput();
                    this.second_in = Integer.parseInt(usr_input);
                }
                Main.clear();
                stage = "DO_EXEC";
            }
            else if (stage.equals("DO_EXEC")) {
                //code for handling the revealing of Tiles
                //this will also handle wining and losing the game

                Vector<Tile> grid = GAME.getGrid();
                if (GAME.getInputMethod().equals("index")) {

                    try {
                        Tile item = grid.get(this.input - 1);
                        if (item.isMine()) this.lost = true;
                        else item.reveal();
                    } catch (Exception e) {
                        //skips this iteration
                    }
                }
                else {

                    try {
                        int first = this.first_in - 1;
                        int second = this.second_in;

                        int tile_index = (first * GAME.getWidth()) + second;

                        Tile item = grid.get(tile_index - 1);
                        if (item.isMine()) this.lost = true;
                        item.reveal();
                    }
                    catch (Exception e) {
                        //skips this iteration
                    }
                }
                stage = "D_GRID";
            }
        }
    }
}
