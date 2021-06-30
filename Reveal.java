import java.util.Vector;
public class Reveal {
    private Vector<Tile> GRID;
    private Vector<Tile> STACK;
    static int iteration_count;
    private boolean popped = false;

    public Reveal(Vector<Tile> Vec) {
        this.GRID = Vec;
        this.STACK = new Vector<>();
        iteration_count = 0;
    }

    public void zeroGrid(int start, int x) {
        try {
            Tile current_tile = this.GRID.get(start);
            //if the initial tile not been fin_checked
            if (!(current_tile.finChecked())) {
                String t_type;
                Tile picked_tile;
                STACK.add(current_tile);

                //while loop; controlled by the amount of items in the STACK; breaks when empty
                //TODO: figure out if this is broken or not
                while (!(STACK.isEmpty())) {
                    if (!(current_tile.finChecked())) {
                        /* each case checks different surrounding tiles
                         * when a tile is found to contain a zero, it will be added to stack -> continue;
                         * the loop will rerun for each time that a new tile is pushed to stack;
                         * when the tile enters the loop, it's checked field is set to true;
                         * when a tile that's "checked" is found to contain a zero, it will be skipped;
                         * when all the tiles surrounding a specific tile have been checked. . .
                         *   the tiles fin_checked field is set to true;
                         * that tile will also be removed from the stack;
                         * if the loop finds a tile that is fin_checked, it will be skipped;
                         * the loop will run until the Vector is emptied completely;
                         */
                        t_type = current_tile.getType();
                        current_tile.check();
                        //using switch statement to check a different way for each tile type
                        switch (t_type) {
                            case "t" -> {
                                //tile is on the top
                                if (GRID.get(current_tile.getT_index() + 1).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + 1);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() + (x + 1)).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + (x + 1));
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() + x).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + x);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() + (x - 1)).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + (x - 1));
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() - 1).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - 1);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                current_tile.finChecked();
                                STACK.remove(STACK.size() - 1);
                                if (!(STACK.isEmpty())) {
                                    current_tile = STACK.get(STACK.size() - 1);
                                }
                            }
                            case "tr" -> {
                                //tile is on the top right
                                if (GRID.get(current_tile.getT_index() + x).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + x);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() + (x - 1)).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + (x - 1));
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() - 1).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - 1);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                current_tile.finChecked();
                                STACK.remove(STACK.size() - 1);
                                if (!(STACK.isEmpty())) {
                                    current_tile = STACK.get(STACK.size() - 1);
                                }
                            }
                            case "tl" -> {
                                //tile is on the top left
                                if (GRID.get(current_tile.getT_index() + 1).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + 1);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() + (x + 1)).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + (x + 1));
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() + x).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + x);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                current_tile.finChecked();
                                STACK.remove(STACK.size() - 1);
                                if (!(STACK.isEmpty())) {
                                    current_tile = STACK.get(STACK.size() - 1);
                                }
                            }
                            case "r" -> {
                                //tile is on the right
                                if (GRID.get(current_tile.getT_index() - x).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - x);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() + x).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + x);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() + (x - 1)).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + (x - 1));
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() - 1).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - 1);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() - (x + 1)).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - (x + 1));
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                current_tile.finChecked();
                                STACK.remove(STACK.size() - 1);
                                if (!(STACK.isEmpty())) {
                                    current_tile = STACK.get(STACK.size() - 1);
                                }
                            }
                            case "l" -> {
                                //tile is on the left
                                if (GRID.get(current_tile.getT_index() - x).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - x);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() - (x - 1)).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - (x - 1));
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() + 1).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + 1);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() + (x + 1)).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + (x + 1));
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() + x).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + x);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                current_tile.finChecked();
                                STACK.remove(STACK.size() - 1);
                                if (!(STACK.isEmpty())) {
                                    current_tile = STACK.get(STACK.size() - 1);
                                }
                            }
                            case "br" -> {
                                //tile is on the bottom right
                                if (GRID.get(current_tile.getT_index() - 1).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - 1);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() - (x + 1)).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - (x + 1));
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() - x).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - x);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                current_tile.finChecked();
                                STACK.remove(STACK.size() - 1);
                                if (!(STACK.isEmpty())) {
                                    current_tile = STACK.get(STACK.size() - 1);
                                }
                            }
                            case "bl" -> {
                                //tile is on the bottom left
                                if (GRID.get(current_tile.getT_index() - x).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - x);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() - (x - 1)).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - (x - 1));
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() + 1).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + 1);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                current_tile.finChecked();
                                STACK.remove(STACK.size() - 1);
                                if (!(STACK.isEmpty())) {
                                    current_tile = STACK.get(STACK.size() - 1);
                                }
                            }
                            case "b" -> {
                                //tile is on the bottom
                                if (GRID.get(current_tile.getT_index() - x).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - x);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() - (x - 1)).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - (x - 1));
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() + 1).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + 1);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() - 1).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - 1);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() - (x + 1)).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - (x + 1));
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                current_tile.finChecked();
                                STACK.remove(STACK.size() - 1);
                                if (!(STACK.isEmpty())) {
                                    current_tile = STACK.get(STACK.size() - 1);
                                }
                            }
                            case "m" -> {
                                //tile is on the middle
                                if (GRID.get(current_tile.getT_index() - x).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - x);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() - (x - 1)).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - (x - 1));
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() + 1).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + 1);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() + (x + 1)).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + (x + 1));
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() + x).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + x);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() + (x - 1)).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() + (x - 1));
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() - 1).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - 1);
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                if (GRID.get(current_tile.getT_index() - (x + 1)).getSafety() == 0) {
                                    picked_tile = GRID.get(current_tile.getT_index() - (x + 1));
                                    picked_tile.reveal();
                                    if (!(picked_tile.isChecked() || picked_tile.finChecked())) {
                                        STACK.add(picked_tile);
                                        current_tile = picked_tile;
                                        continue;
                                    }
                                }
                                current_tile.finChecked();
                                STACK.remove(STACK.size() - 1);
                                if (!(STACK.isEmpty())) {
                                    current_tile = STACK.get(STACK.size() - 1);
                                }
                            }
                        }
                    } else {
                        this.STACK.remove(this.STACK.size() - 1);
                        if (!(this.STACK.isEmpty())) {
                            current_tile = STACK.get(this.STACK.size() - 1);
                        }
                    }
                }
            }
            else {
                //exits the method
                this.STACK.remove(0);
            }
        }
        catch (Exception e) {
            //stops execution and returns to @class Play @method execute
            System.out.println("AN EXCEPTION OCCURRED: " + e);
        }
    }

}
