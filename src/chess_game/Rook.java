package chess_game;

public class Rook extends Pieces {

    public static String getImageSource(String color) {
        if (color.equals("black")) {
            return "C:\\Users\\Kareem Zayed\\Documents\\NetBeansProjects\\Chess_game\\images\\black_rook.png";
        } else {
            return "C:\\Users\\Kareem Zayed\\Documents\\NetBeansProjects\\Chess_game\\images\\white_rook.png";
        }
    }
}
