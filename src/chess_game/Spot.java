package chess_game;

import javax.swing.*;
import java.awt.*;

public class Spot extends JButton {

    int i;
    int j;
    String color;
    Pieces p;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setColor() {
        this.color = null;
    }

    public void setCordinate(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public Pieces get_piece() {
        return p;
    }

    public void set_piece(Pieces p) {
        this.p = p;
    }

    public void set_piece() {
        this.p = null;
    }
}
