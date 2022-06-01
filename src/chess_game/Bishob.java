package chess_game;

public class Bishob extends Pieces {

    private String image_source;

    public static String getImageSource(String color) {
        if (color.equals("black")) {
            return "C:\\Users\\Kareem Zayed\\Documents\\NetBeansProjects\\Chess_game\\images\\black_bishob.png";
        } else {
            return "C:\\Users\\Kareem Zayed\\Documents\\NetBeansProjects\\Chess_game\\images\\white_bishob.png";
        }
    }
}
