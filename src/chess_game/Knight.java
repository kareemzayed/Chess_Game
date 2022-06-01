package chess_game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Knight extends Pieces {

    public static String getImageSource(String color) {
        if (color.equals("black")) {
            return "C:\\Users\\Kareem Zayed\\Documents\\NetBeansProjects\\Chess_game\\images\\black_knight.png";
        } else {
            return "C:\\Users\\Kareem Zayed\\Documents\\NetBeansProjects\\Chess_game\\images\\white_knight.png";
        }
    }
}
