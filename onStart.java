import java.util.*;
//@class Begin is a Initialization class
class Begin {

    private Scanner scan = new Scanner(System.in);
    private int width = 0;
    private int height = 0;
    private int mines = 0;
    private int maximum = 0;

    //constructor handles getting all the input from the user
    public Begin() {
        boolean break_out = false;
        //runs until the user confirms their choices
        while (!break_out) {
                //runs until the user enters valid dimensions
                while(this.width * this.height < 4) {
                    this.width = getInput("What width do you want?");
                    this.height = getInput("What height do you want?");
                    if (this.width * this.height < 9 || (this.width < 3 || this.height < 3)) System.out.println("NOT ENOUGH TILES!! Minimum is 3 by 3");
                }
                this.mines = getInput("How many mines do you want?");
                determineMaxMines(this.width, this.height);
            
                //runs until the user enters a valid mine count
                while (!verifyMines(this.mines, this.maximum)) {
                    if (this.mines <= 0) this.mines = getInput("NOT ENOUGH MINES!! Enter a valid amount of mines");
                    else this.mines = getInput("TOO MANY MINES!! Enter a valid amount of mines");
                }

                System.out.println("You wanted a " + this.width + " by " + this.height + " grid. With " + this.mines + " mines?");
                System.out.println("Yes, or No??");
                scan.nextLine();
                String input = scan.nextLine().toLowerCase();
                if (input.equals("yes") || input.equals("y")) break_out = true;
            }
        }
    //validated method, runs until it is able to return an integer
    public int getInput(String prompt) {
        System.out.println(prompt);
        while (true) {

            try {
                return scan.nextInt();
            }
            catch (Exception e) {
                System.out.println("EXPECTED A NUMBER!!");
                System.out.println(prompt);
                String n = scan.nextLine();  //consumes the leftover "\n" in the scan from the last prompt
            }
        }
    }
    //method returns the maximum number of mines allowed
    public void determineMaxMines(int w, int h) {
        this.maximum = (int)((w * h) * 0.9);
    }
    //returns whether or not the mines fall within allowed ranges
    public boolean verifyMines(int mines, int max) {
        if (mines >= max || mines <= 0) {
            return false;
        }
        else {
            return true;
        }
    }
    //used to return several of the @class Begin items for use in @Main
    public int fetch(String item_name) {
        if (item_name.equals("mines")) return this.mines;
        else if (item_name.equals("width")) return this.width;
        else return this.height;
    }
}
//@class Generate is used to generate mine location indexes
class Generate {
    private int width = 0;
    private int height = 0;
    private int mines = 0;

    private Vector<String> MINES = new Vector<>();
    //constructor is used to Initialize @class Begin values needed for mine generation
    public Generate(int w, int h, int m) {
        this.width = w;
        this.height = h;
        this.mines = m;
        this.MINES.setSize(0);
        genMines();
    }
    //method is used to generate the amount of mines that the user has suggested
    public void genMines() {
        int m_count = this.mines;
        int h_bound = ((this.width * this.height));  //Goes off of array index
        int comp_mines = 0;
        int potential_mine;
        boolean found = false;
        Random rand = new Random();
        //runs until comp_mines is equal
        while (comp_mines <= m_count - 2) {
            potential_mine = rand.nextInt(h_bound) + 1;  //randomizes mine index

            //if structure only runs for the first potential_mine to be added
            if (this.MINES.isEmpty()) this.MINES.add(Integer.toString(potential_mine));
            //checks each item in the MINES Vector to ensure that there are no repeats
            else {
                for (int index = 0; index < this.MINES.size(); index++) {
                    if (Integer.toString(potential_mine).equals(this.MINES.get(index))) {
                        //sets a flag boolean, then breaks execution of the current for loop
                        found = true;
                        break;
                    }
                }

                if (found) found = false;  //unsets the flag boolean, then does nothing else for this iteration
                //adds the unique mine to the MINES Vector, then increments the counter comp_mines
                else {
                    this.MINES.add(Integer.toString(potential_mine));
                    comp_mines++;
                }
            }
        }
        if (m_count == 1) {
            potential_mine = rand.nextInt(h_bound) + 1;
            this.MINES.add(Integer.toString(potential_mine));
        }
    }
    //method returns a Vector of mines generated by @class Generate method genMines
    public Vector<String> getMines() {
        return this.MINES;
    }
}
