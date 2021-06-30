import java.util.*;

class TileGen {
    private int gdx;
    private int gdy;
    private Vector<Tile> RET;

    public TileGen(Vector MINES, int grid_x, int grid_y) {
        this.gdx = grid_x;
        this.gdy = grid_y;
        Vector<Tile> GAME_GRID = new Vector<>();
        //creates each tile object, then adds it to the vector
        for (int t_am = 1; t_am < grid_x * grid_y + 1; t_am++) {
            boolean m_tag = false;
            for (Object mine : MINES) {
                if (Integer.toString(t_am).equals(mine)) m_tag = true;
            }
            Tile tile_made = new Tile(m_tag, t_am);
            GAME_GRID.addElement(tile_made);
        }
        //System.out.println(GAME_GRID);
        appendTileSur(GAME_GRID);

        this.RET = GAME_GRID;
    }

    private void appendTileSur(Vector<Tile> GG) {
        for (int countZ = 0; countZ < GG.size(); countZ++) {
            GG.get(countZ).genSur(GG, this.gdx, this.gdy);
        }
    }
    public void pr(Vector<Tile> vec, int start, int xc) {
        for (int x = start; x < xc; x++) {
            System.out.print(vec.get(x) + " ");
        }
        System.out.print("\n");
    }
    public Vector getRet() {
        return this.RET;
    }
}
