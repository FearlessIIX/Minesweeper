import java.util.Vector;

public class Tile {
    private int safety;
    private boolean is_mine;
    private int t_number;
    private int t_index;
    private boolean revealed = false;
    private boolean checked = false;
    private boolean fin_check = false;
    private boolean popped = false;
    private String tile_type;

    public Tile(boolean it_mine, int num) {
        this.is_mine = it_mine;
        this.t_number = num;
        this.t_index = num - 1;
    }
    public void genSur(Vector<Tile> GG, int x, int y) {
        //First need to determine what sides are available for view.
        int m_count = 0;
        // finds the top || also used to flag: top left, top right
        if  (this.t_number <= x) {
            //tl
            if (this.t_number == 1) {
                //check the index 1+, x+, (x+1)+
                // tile: 1; indexes: t_index + 1, t_index + x, t_index + (x + 1)
                // r, br, b
                if (GG.get(this.t_index + 1).is_mine) m_count++;
                if (GG.get(this.t_index + (x + 1)).is_mine) m_count++;
                if (GG.get(this.t_index + x).is_mine) m_count++;

                this.tile_type = "tl";
            }
            //tr
            else if (this.t_number == x) {
                //check the index - 2, +(x - 1), +(x - 2)
                //tile: 4; indexes: t_index + x, t_index + (x - 1), t_index - 1
                //b, bl, l
                if (GG.get(t_index + x).is_mine) m_count++;
                if (GG.get(t_index + (x - 1)).is_mine) m_count++;
                if (GG.get(t_index - 1).is_mine) m_count++;

                this.tile_type = "tr";
            }
            else {
                //check the index, -2, +x, +(x-1), +(x-2)
                //tile: 2; indexes: t_index + 1, t_index + (x + 1), t_index + x, t_index + (x - 1), t_index - 1
                //r, br, b, bl, l
                if (GG.get(t_index + 1).is_mine) m_count++;
                if (GG.get(t_index + (x + 1)).is_mine) m_count++;
                if (GG.get(t_index + x).is_mine) m_count++;
                if (GG.get(t_index + (x - 1)).is_mine) m_count++;
                if (GG.get(t_index - 1).is_mine) m_count++;

                this.tile_type = "t";
            }
        }
        //finds the left side || also used to flag: bottom left
        else if ((this.t_number - 1) % x == 0) {
            //bl
            if (this.t_number == (((x * y) - x) + 1)) {
                //check the index, -x, -(x+1)
                //tile: 20; indexes: t_index - x, t_index - (x - 1), t_index + 1
                if (GG.get(t_index - x).is_mine) m_count++;
                if (GG.get(t_index - (x - 1)).is_mine) m_count++;
                if (GG.get(t_index + 1).is_mine) m_count++;

                this.tile_type = "bl";
            }
            else {
                //check the index, +x, +(x - 1), -x, -(x + 1)
                //tile: 10; indexes: t_index - x, t_index - (x - 1), t_index + 1, t_index + (x + 1), t_index + x
                if (GG.get(t_index - x).is_mine) m_count++;
                if (GG.get(t_index - (x - 1)).is_mine) m_count++;
                if (GG.get(t_index + 1).is_mine) m_count++;
                if (GG.get(t_index + (x + 1)).is_mine) m_count++;
                if (GG.get(t_index + x).is_mine) m_count++;

                this.tile_type = "l";
            }
        }
        //finds the right side || also used to flag: bottom right
        else if (this.t_number % x == 0) {
            //br
            if (this.t_number == (x * y)) {
                //check the index - 2, -(x + 1), -(x + 2)
                //tile: 24; indexes: t_index - 1, t_index - (x + 1), t_index - x
                if (GG.get(t_index - 1).is_mine) m_count++;
                if (GG.get(t_index - (x + 1)).is_mine) m_count++;
                if (GG.get(t_index - x).is_mine) m_count++;

                this.tile_type = "br";
            }
            else {
                //check the index - 2, -(x + 1), -(x + 2), +(x - 1), +(x - 2)
                //tile: 14; indexes: t_index - x, t_index + x, t_index + (x - 1), t_index - 1, t_index - (x + 1)
                if (GG.get(t_index - x).is_mine) m_count++;
                if (GG.get(t_index + x).is_mine) m_count++;
                if (GG.get(t_index + (x - 1)).is_mine) m_count++;
                if (GG.get(t_index - 1).is_mine) m_count++;
                if (GG.get(t_index - (x + 1)).is_mine) m_count++;

                this.tile_type = "r";
            }
        }
        //finds the bottom
        else if (this.t_number > ((x * y) - x) && (this.t_number < (x * y))) {
            //check the index, -2, -x, -(x + 1), -(x + 2)
            //tile: 22; indexes: t_index - x, t_index - (x - 1), t_index + 1, t_index - 1, t_index - (x + 1)
            if (GG.get(t_index - x).is_mine) m_count++;
            if (GG.get(t_index - (x - 1)).is_mine) m_count++;
            if (GG.get(t_index + 1).is_mine) m_count++;
            if (GG.get(t_index - 1).is_mine) m_count++;
            if (GG.get(t_index - (x + 1)).is_mine) m_count++;

            this.tile_type = "b";
        }
        else {
            //check index, -2, +x, +(x - 1), +(x - 2), -x, -(x + 1), -(x + 2)
            //tile: 12; indexes: t_index - x, t_index - (x - 1), t_index + 1, t_index + (x + 1), t_index + x, t_index + (x - 1), t_index - 1, t_index - (x + 1)
            if (GG.get(t_index - x).is_mine) m_count++;
            if (GG.get(t_index - (x - 1)).is_mine) m_count++;
            if (GG.get(t_index + 1).is_mine) m_count++;
            if (GG.get(t_index + (x + 1)).is_mine) m_count++;
            if (GG.get(t_index + x).is_mine) m_count++;
            if (GG.get(t_index + (x - 1)).is_mine) m_count++;
            if (GG.get(t_index - 1).is_mine) m_count++;
            if (GG.get(t_index - (x + 1)).is_mine) m_count++;

            this.tile_type = "m";
        }
        this.safety = m_count;
    }

    public String toString() {
        /*if (checked) {
            return ("@ " + Integer.toString(this.safety) + " " + this.t_number);
        }
        else {
            return ("? " + Integer.toString(this.safety) + " " + this.t_number);
        }
        if (this.is_mine) return "*";
        else return Integer.toString(this.safety);

        */
        if (revealed) {
            if (this.is_mine) return ("*");
            else return Integer.toString(this.safety);
        }
        else return ("#");
    }
    public int getSafety() {
        return this.safety;
    }

    public boolean isMine() {
        return this.is_mine;
    }

    public boolean isRevealed() {
        return this.revealed;
    }

    public String getType() {
        return this.tile_type;
    }

    public int getT_index() {
        return this.t_index;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public boolean finChecked() {
        return this.fin_check;
    }

    public boolean popped() {
        return this.popped;
    }

    public void check() {
        this.checked = true;
    }

    public void uncheck() {
        this.checked = false;
    }

    public void finCheck() {
        this.fin_check = true;
    }

    public void pop() {
        this.popped = true;
    }

    public void reveal() {
        this.revealed = true;
    }
}
