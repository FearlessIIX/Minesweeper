import java.util.Vector;

public class Tile {
    private int safety;
    private boolean is_mine;
    private int t_number;
    private boolean revealed = false;

    public Tile(boolean it_mine, int num) {
        this.is_mine = it_mine;
        this.t_number = num;
    }
    public void genSur(Vector<Tile> GG, int x, int y) {
        //First need to determine what sides are available for view.
        int m_count = 0;
        // finds the top || also used to flag: top left, top right
        if  (this.t_number <= x) {
            //tl
            if (this.t_number == 1) {
                //check the index 1+, x+, (x+1)+
                Tile current = GG.get(this.t_number);
                if (GG.get(this.t_number).is_mine) m_count++;
                if (GG.get(x).is_mine) m_count++;
                if (GG.get(x + 1).is_mine) m_count++;
            }
            //tr
            else if (this.t_number == x) {
                //check the index - 2, +(x - 1), +(x - 2)
                if (GG.get(this.t_number - 2).is_mine) m_count++;
                if (GG.get((this.t_number + x) - 1).is_mine) m_count++;
                if (GG.get((this.t_number + x) - 2).is_mine) m_count++;
            }
            else {
                //check the index, -2, +x, +(x-1), +(x-2)
                if(GG.get(this.t_number).is_mine) m_count++;
                if(GG.get(this.t_number - 2).is_mine) m_count++;
                if(GG.get(this.t_number + x).is_mine) m_count++;
                if(GG.get(this.t_number + (x - 1)).is_mine) m_count++;
                if(GG.get(this.t_number + (x - 2)).is_mine) m_count++;
            }
        }
        //finds the left side || also used to flag: bottom left
        else if ((this.t_number - 1) % x == 0) {
            //bl
            if (this.t_number == (((x * y) - x) + 1)) {
                //check the index, -x, -(x+1)
                if (GG.get(this.t_number).is_mine) m_count++;
                if (GG.get(this.t_number - x).is_mine) m_count++;
                if (GG.get(this.t_number - (x + 1)).is_mine) m_count++;
            }
            else {
                //check the index, +x, +(x - 1), -x, -(x + 1)
                if (GG.get(this.t_number).is_mine) m_count++;
                if (GG.get(this.t_number + x).is_mine) m_count++;
                if (GG.get(this.t_number + (x - 1)).is_mine) m_count++;
                if (GG.get(this.t_number - x).is_mine) m_count++;
                if (GG.get(this.t_number - (x + 1)).is_mine) m_count++;
            }
        }
        //finds the right side || also used to flag: bottom right
        else if (this.t_number % x == 0) {
            //br
            if (this.t_number == (x * y)) {
                //check the index - 2, -(x + 1), -(x + 2)
                if (GG.get(this.t_number - 2).is_mine) m_count++;
                if (GG.get(this.t_number - (x + 1)).is_mine) m_count++;
                if (GG.get(this.t_number - (x - 2)).is_mine) m_count++;
            }
            else {
                //check the index - 2, -(x + 1), -(x + 2), +(x - 1), +(x - 2)
                if (GG.get(this.t_number - 2).is_mine) m_count++;
                if (GG.get(this.t_number - (x + 1)).is_mine) m_count++;
                if (GG.get(this.t_number - (x + 2)).is_mine) m_count++;
                if (GG.get(this.t_number + (x - 1)).is_mine) m_count++;
                if (GG.get(this.t_number + (x - 2)).is_mine) m_count++;
            }
        }
        //finds the bottom
        else if (this.t_number > ((x * y) - x) && (this.t_number < (x * y))) {
            //check the index, -2, -x, -(x + 1), -(x + 2)
            if (GG.get(this.t_number).is_mine) m_count++;
            if (GG.get(this.t_number - 2).is_mine) m_count++;
            if (GG.get(this.t_number - x).is_mine) m_count++;
            if (GG.get(this.t_number - (x + 1)).is_mine) m_count++;
            if (GG.get(this.t_number - (x + 2)).is_mine) m_count++;
        }
        else {
            //check index, -2, +x, +(x - 1), +(x - 2), -x, -(x + 1), -(x + 2)
            if (GG.get(this.t_number).is_mine) m_count++;
            if (GG.get(this.t_number - 2).is_mine) m_count++;
            if (GG.get(this.t_number + x).is_mine) m_count++;
            if (GG.get(this.t_number + (x - 1)).is_mine) m_count++;
            if (GG.get(this.t_number + (x - 2)).is_mine) m_count++;
            if (GG.get(this.t_number - x).is_mine) m_count++;
            if (GG.get(this.t_number - (x + 1)).is_mine) m_count++;
            if (GG.get(this.t_number - (x + 2)).is_mine) m_count++;
        }
        this.safety = m_count;
    }

    public String toString() {
        if (revealed) {
            if (this.is_mine) return ("*");
            else return Integer.toString(this.safety);
        }
        else return ("#");
    }

    public boolean isMine() {
        return this.is_mine;
    }

    public boolean isRevealed() {
        return this.revealed;
    }

    public void reveal() {
        if (this.revealed) {}
        else this.revealed = true;
    }
}
