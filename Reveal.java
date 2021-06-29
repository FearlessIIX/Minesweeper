import java.util.Vector;
public class Reveal {
    private Vector<Tile> GRID;
    private Vector<Tile> STACK;
    private boolean popped = false;
    public Reveal(Vector<Tile> Vec) {
        this.GRID = Vec;
        this.STACK = new Vector<>();
    }

    public void zeroGrid(int tileIndex, int width) {
        int count = 0;
        try {
            Tile currentTile = GRID.get(tileIndex);
            String t_type;
            this.STACK.add(currentTile);

            while (!(STACK.isEmpty())) {
                if (count >= 50) {
                    break;
                }
                else {
                    System.out.println(STACK);
                    count++;
                }
                t_type = currentTile.getType();
                System.out.print(currentTile.getT_number());

                currentTile.reveal();
                if (!(currentTile.isChecked() && currentTile.finChecked())) {
                    currentTile.check();
                    if (t_type.equals("m")) {
                        //if the tile is in the middle
                        if (GRID.get(currentTile.getT_number() - (width + 1)).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - (width + 1)).isChecked())) {
                                currentTile = GRID.get(currentTile.getT_number() - (width + 1));
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() - width).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - width).isChecked())) {
                                currentTile = GRID.get(currentTile.getT_number() - width);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number()).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number()).isChecked())) {
                                currentTile = GRID.get(currentTile.getT_number());
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() + width).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() + width).isChecked())) {
                                currentTile = GRID.get(currentTile.getT_number() + width);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() + (width - 1)).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() + (width - 1)).isChecked())) {
                                currentTile = GRID.get(currentTile.getT_number() + (width - 1));
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() + (width - 2)).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() + (width - 2)).isChecked())) {
                                currentTile = GRID.get(currentTile.getT_number() + (width - 2));
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() - 2).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - 2).isChecked())) {
                                currentTile = GRID.get(currentTile.getT_number() - 2);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() - (width + 2)).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - (width + 2)).isChecked())) {
                                currentTile = GRID.get(currentTile.getT_number() - (width + 2));
                                this.STACK.add(currentTile);
                            }
                            else {
                                currentTile.finCheck();
                                //currentTile.check();
                                this.STACK.remove(STACK.size() - 1);
                                if (!(STACK.isEmpty())) {
                                    this.STACK.get(this.STACK.size() - 1).uncheck();
                                    currentTile = this.STACK.get(this.STACK.size() - 1);
                                }
                            }
                        } else {
                            currentTile.finCheck();
                            //currentTile.check();
                            this.STACK.remove(STACK.size() - 1);
                            if (!(STACK.isEmpty())) {
                                this.STACK.get(this.STACK.size() - 1).uncheck();
                                currentTile = this.STACK.get(this.STACK.size() - 1);
                            }
                        }
                    } else if (t_type.equals("tl")) {
                        if (GRID.get(currentTile.getT_number()).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number()).isChecked())) {
                                currentTile = GRID.get(currentTile.getT_number());
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(width + 1).getSafety() == 0) {
                            if (!(GRID.get(width + 1).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(width).getSafety() == 0) {
                            if (!(GRID.get(width).isChecked())) {
                                currentTile = GRID.get(width);
                                this.STACK.add(currentTile);
                            }
                            else {
                                currentTile.finCheck();
                                //currentTile.check();
                                this.STACK.remove(STACK.size() - 1);
                                if (!(STACK.isEmpty())) {
                                    this.STACK.get(this.STACK.size() - 1).uncheck();
                                    currentTile = this.STACK.get(this.STACK.size() - 1);
                                }
                            }
                        } else {
                            currentTile.finCheck();
                            //currentTile.check();
                            this.STACK.remove(STACK.size() - 1);
                            if (!(STACK.isEmpty())) {
                                this.STACK.get(this.STACK.size() - 1).uncheck();
                                currentTile = this.STACK.get(this.STACK.size() - 1);
                            }
                        }
                    } else if (t_type.equals("tr")) {
                        if (GRID.get(currentTile.getT_number() - 2).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - 2).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get((currentTile.getT_number() + width) - 2).getSafety() == 0) {
                            if (!(GRID.get((currentTile.getT_number() + width) - 2).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get((currentTile.getT_number() + width) - 1).getSafety() == 0) {
                            if (!(GRID.get((currentTile.getT_number() + width) - 1).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                            }
                            else {
                                currentTile.finCheck();
                                //currentTile.check();
                                this.STACK.remove(STACK.size() - 1);
                                if (!(STACK.isEmpty())) {
                                    this.STACK.get(this.STACK.size() - 1).uncheck();
                                    currentTile = this.STACK.get(this.STACK.size() - 1);
                                }
                            }
                        } else {
                            currentTile.finCheck();
                            //currentTile.check();
                            this.STACK.remove(STACK.size() - 1);
                            if (!(STACK.isEmpty())) {
                                this.STACK.get(this.STACK.size() - 1).uncheck();
                                currentTile = this.STACK.get(this.STACK.size() - 1);
                            }
                        }
                    } else if (t_type.equals("t")) {
                        if (GRID.get(currentTile.getT_number()).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number()).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() - 2).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - 2).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() + width).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() + width).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() + (width - 1)).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() + (width - 1)).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() + (width - 2)).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() + (width - 2)).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                            }
                            else {
                                currentTile.finCheck();
                                //currentTile.check();
                                this.STACK.remove(STACK.size() - 1);
                                if (!(STACK.isEmpty())) {
                                    this.STACK.get(this.STACK.size() - 1).uncheck();
                                    currentTile = this.STACK.get(this.STACK.size() - 1);
                                }
                            }
                        } else {
                            currentTile.finCheck();
                            //currentTile.check();
                            this.STACK.remove(STACK.size() - 1);
                            if (!(STACK.isEmpty())) {
                                this.STACK.get(this.STACK.size() - 1).uncheck();
                                currentTile = this.STACK.get(this.STACK.size() - 1);
                            }
                        }
                    } else if (t_type.equals("l")) {
                        if (GRID.get(currentTile.getT_number()).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number()).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() + width).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() + width).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() + (width - 1)).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() + (width - 1)).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() - width).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - width).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() - (width + 1)).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - (width + 1)).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                            }
                            else {
                                currentTile.finCheck();
                                //currentTile.check();
                                this.STACK.remove(STACK.size() - 1);
                                if (!(STACK.isEmpty())) {
                                    this.STACK.get(this.STACK.size() - 1).uncheck();
                                    currentTile = this.STACK.get(this.STACK.size() - 1);
                                }
                            }
                        } else {
                            currentTile.finCheck();
                            //currentTile.check();
                            this.STACK.remove(STACK.size() - 1);
                            if (!(STACK.isEmpty())) {
                                this.STACK.get(this.STACK.size() - 1).uncheck();
                                currentTile = this.STACK.get(this.STACK.size() - 1);
                            }
                        }
                    } else if (t_type.equals("r")) {
                        if (GRID.get(currentTile.getT_number() + (width - 2)).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() + (width - 2)).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() + (width - 1)).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() + (width - 1)).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() - 2).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - 2).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() - (width + 1)).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - (width + 1)).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() - (width + 2)).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - (width + 2)).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                            }
                            else {
                                currentTile.finCheck();
                                //currentTile.check();
                                this.STACK.remove(STACK.size() - 1);
                                if (!(STACK.isEmpty())) {
                                    this.STACK.get(this.STACK.size() - 1).uncheck();
                                    currentTile = this.STACK.get(this.STACK.size() - 1);
                                }
                            }
                        } else {
                            currentTile.finCheck();
                            //currentTile.check();
                            this.STACK.remove(STACK.size() - 1);
                            if (!(STACK.isEmpty())) {
                                this.STACK.get(this.STACK.size() - 1).uncheck();
                                currentTile = this.STACK.get(this.STACK.size() - 1);
                            }
                        }
                    } else if (t_type.equals("bl")) {
                        if (GRID.get(currentTile.getT_number()).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number()).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() - (width + 1)).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - (width + 1)).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() - width).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - width).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                            }
                            else {
                                currentTile.finCheck();
                                //currentTile.check();
                                this.STACK.remove(STACK.size() - 1);
                                if (!(STACK.isEmpty())) {
                                    this.STACK.get(this.STACK.size() - 1).uncheck();
                                    currentTile = this.STACK.get(this.STACK.size() - 1);
                                }
                            }
                        } else {
                            currentTile.finCheck();
                            //currentTile.check();
                            this.STACK.remove(STACK.size() - 1);
                            if (!(STACK.isEmpty())) {
                                this.STACK.get(this.STACK.size() - 1).uncheck();
                                currentTile = this.STACK.get(this.STACK.size() - 1);
                            }
                        }
                    } else if (t_type.equals("br")) {
                        if (GRID.get(currentTile.getT_number() - 2).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - 2).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() - (width + 2)).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - (width + 2)).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() - (width + 1)).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - (width + 1)).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                            }
                            else {
                                currentTile.finCheck();
                                //currentTile.check();
                                this.STACK.remove(STACK.size() - 1);
                                if (!(STACK.isEmpty())) {
                                    this.STACK.get(this.STACK.size() - 1).uncheck();
                                    currentTile = this.STACK.get(this.STACK.size() - 1);
                                }
                            }
                        } else {
                            currentTile.finCheck();
                            //currentTile.check();
                            this.STACK.remove(STACK.size() - 1);
                            if (!(STACK.isEmpty())) {
                                this.STACK.get(this.STACK.size() - 1).uncheck();
                                currentTile = this.STACK.get(this.STACK.size() - 1);
                            }
                        }
                    } else if (t_type.equals("b")) {
                        if (GRID.get(currentTile.getT_number() - 2).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - 2).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() - (width + 2)).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - (width + 2)).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() - (width + 1)).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - (width + 1)).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number() - width).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number() - width).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                                continue;
                            }
                        }
                        if (GRID.get(currentTile.getT_number()).getSafety() == 0) {
                            if (!(GRID.get(currentTile.getT_number()).isChecked())) {
                                currentTile = GRID.get(width + 1);
                                this.STACK.add(currentTile);
                            }
                            else {
                                currentTile.finCheck();
                                //currentTile.check();
                                this.STACK.remove(STACK.size() - 1);
                                if (!(STACK.isEmpty())) {
                                    this.STACK.get(this.STACK.size() - 1).uncheck();
                                    currentTile = this.STACK.get(this.STACK.size() - 1);
                                }
                            }
                        } else {
                            currentTile.finCheck();
                            //currentTile.check();
                            this.STACK.remove(STACK.size() - 1);
                            if (!(STACK.isEmpty())) {
                                this.STACK.get(this.STACK.size() - 1).uncheck();
                                currentTile = this.STACK.get(this.STACK.size() - 1);
                            }
                        }
                    }
                } else {
                    this.STACK.remove(STACK.size() - 1);
                    if (!(STACK.isEmpty())) {
                        this.STACK.get(this.STACK.size() - 1).uncheck();
                        currentTile = this.STACK.get(this.STACK.size() - 1);
                    }
                }
            }
        }
        catch (Exception e) {
            //allows the program to return from this method without failing when an Exception occurs
        }
    }
}
