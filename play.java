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

        String stage = "D_GRID";
        outer:
        while (true) {
            switch (stage) {
                case "D_GRID" -> {
                    //code for displaying the grid to the screen
                    //grid will also include a prompt for the user to input Tile
                    this.SCREEN.display(this.GAME);
                    if (this.lost) {
                        System.out.println("\n \n You hit a mine!!");
                        break outer;
                    }
                    stage = "G_INPUT";
                }
                case "G_INPUT" -> {
                    //code for getting the user input

                    String usr_input = SCREEN.userInput();
                    //no way to validate user input for now
                    try {
                        if (GAME.getInputMethod().equals("index")) {
                            try {
                                this.input = Integer.parseInt(usr_input);
                            }
                            catch (Exception e) {

                            }

                        } else {
                            this.first_in = Integer.parseInt(usr_input);
                            usr_input = SCREEN.userInput();
                            this.second_in = Integer.parseInt(usr_input);
                        }
                    } catch (Exception e) {
                        //skips this iteration
                    }
                    Main.clear();
                    stage = "DO_EXEC";
                }
                case "DO_EXEC" -> {
                    //code for handling the revealing of Tiles
                    //this will also handle wining and losing the game

                    Vector<Tile> grid = GAME.getGrid();
                    if (GAME.getInputMethod().equals("index")) {

                        try {
                            Tile item = grid.get(this.input - 1);
                            if (item.isMine()) this.lost = true;
                            else {
                                item.reveal();
                                if (item.getSafety() == 0) {
                                    //block to be ran when zeros are encountered
                                    Reveal rev = new Reveal(GAME.getGrid());
                                    rev.zeroGrid(this.input - 1, GAME.getWidth());
                                }
                            }
                        } catch (Exception e) {
                            //skips this iteration
                        }
                    } else {

                        try {
                            int first = this.first_in - 1;
                            int second = this.second_in;

                            int tile_index = (first * GAME.getWidth()) + second;

                            Tile item = grid.get(tile_index - 1);
                            if (item.isMine()) this.lost = true;

                            if (item.getSafety() == 0) {
                                //block to be ran when zeros are encountered
                                if ((!item.isRevealed())) {
                                    Reveal rev = new Reveal(GAME.getGrid());
                                    rev.zeroGrid(tile_index - 1, GAME.getWidth());
                                }
                            }
                            item.reveal();
                        } catch (Exception e) {
                            //skips this iteration
                        }
                    }
                    int count_revealed = 0;
                    for (Tile tile : GAME.getGrid()) {
                        if (!(tile.isMine())) {
                            if (tile.isRevealed()) count_revealed++;
                        }
                        if (count_revealed + GAME.getMines() == GAME.getGrid().size()) {
                            System.out.println("You Win!!!!");
                            break outer;
                        }
                    }
                    stage = "D_GRID";
                }
            }
        }
    }
}
