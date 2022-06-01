package chess_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame {

    private Container contents;
    public Spot[][] arr_of_spots;
    ButtonHandeler buttonHandeler = new ButtonHandeler();

    public Board() {
        contents = getContentPane();
        contents.setLayout(new GridLayout(8, 8));
        setSize(new Dimension(800, 800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        // array of spots to make the board
        arr_of_spots = new Spot[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                arr_of_spots[i][j] = new Spot();
                arr_of_spots[i][j].setCordinate(i, j);
                arr_of_spots[i][j].set_piece();
                arr_of_spots[i][j].setColor();
                if ((j + i) % 2 == 0) {
                    arr_of_spots[i][j].setBackground(new Color(222, 184, 135));
                } else {
                    arr_of_spots[i][j].setBackground(new Color(210, 105, 30));
                }
                contents.add(arr_of_spots[i][j]);
                arr_of_spots[i][j].addActionListener(buttonHandeler);
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i == 0 && j == 0) || (i == 0 && j == 7)) {
                    arr_of_spots[i][j].set_piece(new Rook());
                    arr_of_spots[i][j].setIcon(new ImageIcon(Rook.getImageSource("black")));
                    arr_of_spots[i][j].setColor("black");
                } else if ((i == 0 && j == 1) || (i == 0 && j == 6)) {
                    arr_of_spots[i][j].set_piece(new Knight());
                    arr_of_spots[i][j].setIcon(new ImageIcon(Knight.getImageSource("black")));
                    arr_of_spots[i][j].setColor("black");
                } else if ((i == 0 && j == 2) || (i == 0 && j == 5)) {
                    arr_of_spots[i][j].set_piece(new Bishob());
                    arr_of_spots[i][j].setIcon(new ImageIcon(Bishob.getImageSource("black")));
                    arr_of_spots[i][j].setColor("black");
                } else if (i == 0 && j == 4) {
                    arr_of_spots[i][j].set_piece(new King());
                    arr_of_spots[i][j].setIcon(new ImageIcon(King.getImageSource("black")));
                    arr_of_spots[i][j].setColor("black");
                } else if (i == 0 && j == 3) {
                    arr_of_spots[i][j].set_piece(new Queen());
                    arr_of_spots[i][j].setIcon(new ImageIcon(Queen.getImageSource("black")));
                    arr_of_spots[i][j].setColor("black");
                } else if (i == 1) {
                    arr_of_spots[i][j].set_piece(new Pawn());
                    arr_of_spots[i][j].setIcon(new ImageIcon(Pawn.getImageSource("black")));
                    arr_of_spots[i][j].setColor("black");
                } else if (i == 6) {
                    arr_of_spots[i][j].set_piece(new Pawn());
                    arr_of_spots[i][j].setIcon(new ImageIcon(Pawn.getImageSource("white")));
                    arr_of_spots[i][j].setColor("white");
                } else if ((i == 7 && j == 0) || (i == 7 && j == 7)) {
                    arr_of_spots[i][j].set_piece(new Rook());
                    arr_of_spots[i][j].setIcon(new ImageIcon(Rook.getImageSource("white")));
                    arr_of_spots[i][j].setColor("white");
                } else if ((i == 7 && j == 1) || (i == 7 && j == 6)) {
                    arr_of_spots[i][j].set_piece(new Knight());
                    arr_of_spots[i][j].setIcon(new ImageIcon(Knight.getImageSource("white")));
                    arr_of_spots[i][j].setColor("white");
                } else if ((i == 7 && j == 2) || (i == 7 && j == 5)) {
                    arr_of_spots[i][j].set_piece(new Bishob());
                    arr_of_spots[i][j].setIcon(new ImageIcon(Bishob.getImageSource("white")));
                    arr_of_spots[i][j].setColor("white");
                } else if (i == 7 && j == 4) {
                    arr_of_spots[i][j].set_piece(new King());
                    arr_of_spots[i][j].setIcon(new ImageIcon(King.getImageSource("white")));
                    arr_of_spots[i][j].setColor("white");
                } else if (i == 7 && j == 3) {
                    arr_of_spots[i][j].set_piece(new Queen());
                    arr_of_spots[i][j].setIcon(new ImageIcon(Queen.getImageSource("white")));
                    arr_of_spots[i][j].setColor("white");
                }
            }
        }
    }
    private Pieces piece_in_first_click;//save object type from the first click
    private int x_axis_of_first_click; // save x_axis_of_first_click position in the first click
    private int y_axis_of_first_click; //save y_axis_of_first_click position in the first click
    private boolean flag_of_clicks = false; //this boolen flag_of_clicks Determines first click and secound click
    private boolean flag_of_colors = false;//this boolen flag_of_clicks Determines the colour
    private boolean flag_rook_and_bishob = false; // to check the condition of movement of rook and Bishob
    private String color_of_first_click; //save the color_of_first_click of the piece from the frist click 

    private class ButtonHandeler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //variables to detect the place of first and second clicks
            Object source = e.getSource();
            Object source1 = e.getSource();
            // first click
            if (flag_of_clicks == false) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (source == arr_of_spots[i][j]) {
                            x_axis_of_first_click = arr_of_spots[i][j].getI();
                            y_axis_of_first_click = arr_of_spots[i][j].getJ();
                            arr_of_spots[i][j].get_piece();
                            arr_of_spots[i][j].getColor();
                            if (arr_of_spots[i][j].get_piece() != null) {
                                if (arr_of_spots[i][j].getColor() == "white") {
                                    if (flag_of_colors == false) {
                                        color_of_first_click = "white";
                                        if (arr_of_spots[i][j].get_piece() instanceof Rook) {
                                            piece_in_first_click = new Rook();
                                        } else if (arr_of_spots[i][j].get_piece() instanceof King) {
                                            piece_in_first_click = new King();
                                        } else if (arr_of_spots[i][j].get_piece() instanceof Pawn) {
                                            piece_in_first_click = new Pawn();
                                        } else if (arr_of_spots[i][j].get_piece() instanceof Knight) {
                                            piece_in_first_click = new Knight();
                                        } else if (arr_of_spots[i][j].get_piece() instanceof Bishob) {
                                            piece_in_first_click = new Bishob();
                                        } else if (arr_of_spots[i][j].get_piece() instanceof Queen) {
                                            piece_in_first_click = new Queen();
                                        }
                                        flag_of_colors = true;
                                    } else {
                                        flag_of_colors = true;
                                        break;
                                    }
                                } else if (arr_of_spots[i][j].getColor() == "black") {
                                    if (flag_of_colors == true) {
                                        color_of_first_click = "black";
                                        if (arr_of_spots[i][j].get_piece() instanceof Rook) {
                                            piece_in_first_click = new Rook();
                                        } else if (arr_of_spots[i][j].get_piece() instanceof King) {
                                            piece_in_first_click = new King();
                                        } else if (arr_of_spots[i][j].get_piece() instanceof Pawn) {
                                            piece_in_first_click = new Pawn();
                                        } else if (arr_of_spots[i][j].get_piece() instanceof Knight) {
                                            piece_in_first_click = new Knight();
                                        } else if (arr_of_spots[i][j].get_piece() instanceof Bishob) {
                                            piece_in_first_click = new Bishob();
                                        } else if (arr_of_spots[i][j].get_piece() instanceof Queen) {
                                            piece_in_first_click = new Queen();
                                        }
                                        flag_of_colors = false;
                                    } else {
                                        flag_of_colors = false;
                                        break;
                                    }
                                }
                                flag_of_clicks = true;
                            } else if (arr_of_spots[i][j].get_piece() == null) {
                                flag_of_clicks = false;
                                break;
                            }
                            break;
                        }
                    }
                }
            } // secound click
            else if (flag_of_clicks == true) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (source1 == arr_of_spots[i][j]) {
                            arr_of_spots[i][j].getI();
                            arr_of_spots[i][j].getJ();
                            // if player move to the same button
                            if (x_axis_of_first_click == arr_of_spots[i][j].getI() && y_axis_of_first_click == arr_of_spots[i][j].getJ()) {
                                if (color_of_first_click == "white") {
                                    flag_of_clicks = false;
                                    flag_of_colors = false;
                                } else if (color_of_first_click == "black") {
                                    flag_of_clicks = false;
                                    flag_of_colors = true;
                                }
                            } // if player move to another button
                            else {
                                arr_of_spots[i][j].getColor();
                                // if player move to button have a piece have the same colour
                                if (color_of_first_click == arr_of_spots[i][j].getColor()) {
                                    if (piece_in_first_click instanceof Pawn) {
                                        if (color_of_first_click == "white") {
                                            if (x_axis_of_first_click == 0 && arr_of_spots[i][j].get_piece() instanceof Knight) {
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece(new Knight());
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor("white");
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(new ImageIcon(Knight.getImageSource("white")));
                                            } else if (x_axis_of_first_click == 0 && arr_of_spots[i][j].get_piece() instanceof Bishob) {
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece(new Bishob());
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor("white");
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(new ImageIcon(Bishob.getImageSource("white")));
                                            } else if (x_axis_of_first_click == 0 && arr_of_spots[i][j].get_piece() instanceof Rook) {
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece(new Rook());
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor("white");
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(new ImageIcon(Rook.getImageSource("white")));
                                            } else if (x_axis_of_first_click == 0 && arr_of_spots[i][j].get_piece() instanceof Queen) {
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece(new Queen());
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor("white");
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(new ImageIcon(Queen.getImageSource("white")));
                                            } else {
                                                flag_of_colors = false;
                                                flag_of_clicks = false;
                                                break;
                                            }
                                        } else if (color_of_first_click == "black") {
                                            if (x_axis_of_first_click == 7 && arr_of_spots[i][j].get_piece() instanceof Knight) {
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece(new Knight());
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor("black");
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(new ImageIcon(Knight.getImageSource("black")));
                                            } else if (x_axis_of_first_click == 7 && arr_of_spots[i][j].get_piece() instanceof Bishob) {
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece(new Bishob());
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor("black");
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(new ImageIcon(Bishob.getImageSource("black")));
                                            } else if (x_axis_of_first_click == 7 && arr_of_spots[i][j].get_piece() instanceof Rook) {
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece(new Rook());
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor("black");
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(new ImageIcon(Rook.getImageSource("black")));
                                            } else if (x_axis_of_first_click == 7 && arr_of_spots[i][j].get_piece() instanceof Queen) {
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece(new Queen());
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor("black");
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(new ImageIcon(Queen.getImageSource("black")));
                                            } else {
                                                flag_of_colors = true;
                                                flag_of_clicks = false;
                                                break;
                                            }
                                        }
                                    } else if (piece_in_first_click instanceof King) {
                                        if (color_of_first_click == "white") {
                                            if (x_axis_of_first_click == 7 && y_axis_of_first_click == 4 && arr_of_spots[i][j].get_piece() instanceof Rook) {
                                                if (arr_of_spots[i][j].getI() == 7 && arr_of_spots[i][j].getJ() == 0 && arr_of_spots[7][1].get_piece() == null && arr_of_spots[7][2].get_piece() == null && arr_of_spots[7][3].get_piece() == null) {
                                                    arr_of_spots[7][2].set_piece(new King());
                                                    arr_of_spots[7][2].setColor("white");
                                                    arr_of_spots[7][2].setIcon(new ImageIcon(King.getImageSource("white")));
                                                    arr_of_spots[7][3].set_piece(new Rook());
                                                    arr_of_spots[7][3].setColor("white");
                                                    arr_of_spots[7][3].setIcon(new ImageIcon(Rook.getImageSource("white")));
                                                    arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece();
                                                    arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor();
                                                    arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(null);
                                                    arr_of_spots[i][j].set_piece();
                                                    arr_of_spots[i][j].setColor();
                                                    arr_of_spots[i][j].setIcon(null);
                                                } else if (arr_of_spots[i][j].getI() == 7 && arr_of_spots[i][j].getJ() == 7 && arr_of_spots[7][5].get_piece() == null && arr_of_spots[7][6].get_piece() == null) {
                                                    arr_of_spots[7][6].set_piece(new King());
                                                    arr_of_spots[7][6].setColor("white");
                                                    arr_of_spots[7][6].setIcon(new ImageIcon(King.getImageSource("white")));
                                                    arr_of_spots[7][5].set_piece(new Rook());
                                                    arr_of_spots[7][5].setColor("white");
                                                    arr_of_spots[7][5].setIcon(new ImageIcon(Rook.getImageSource("white")));
                                                    arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece();
                                                    arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor();
                                                    arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(null);
                                                    arr_of_spots[i][j].set_piece();
                                                    arr_of_spots[i][j].setColor();
                                                    arr_of_spots[i][j].setIcon(null);
                                                } else {
                                                    flag_of_colors = false;
                                                    flag_of_clicks = false;
                                                    break;
                                                }
                                            } else {
                                                flag_of_colors = false;
                                                flag_of_clicks = false;
                                                break;
                                            }
                                        } else if (color_of_first_click == "black") {
                                            if (x_axis_of_first_click == 0 && y_axis_of_first_click == 4 && arr_of_spots[i][j].get_piece() instanceof Rook) {
                                                if (arr_of_spots[i][j].getI() == 0 && arr_of_spots[i][j].getJ() == 0 && arr_of_spots[0][1].get_piece() == null && arr_of_spots[0][2].get_piece() == null && arr_of_spots[0][3].get_piece() == null) {
                                                    arr_of_spots[0][2].set_piece(new King());
                                                    arr_of_spots[0][2].setColor("black");
                                                    arr_of_spots[0][2].setIcon(new ImageIcon(King.getImageSource("black")));
                                                    arr_of_spots[0][3].set_piece(new Rook());
                                                    arr_of_spots[0][3].setColor("blacl");
                                                    arr_of_spots[0][3].setIcon(new ImageIcon(Rook.getImageSource("black")));
                                                    arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece();
                                                    arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor();
                                                    arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(null);
                                                    arr_of_spots[i][j].set_piece();
                                                    arr_of_spots[i][j].setColor();
                                                    arr_of_spots[i][j].setIcon(null);
                                                } else if (arr_of_spots[i][j].getI() == 0 && arr_of_spots[i][j].getJ() == 7 && arr_of_spots[0][5].get_piece() == null && arr_of_spots[0][6].get_piece() == null) {
                                                    arr_of_spots[0][6].set_piece(new King());
                                                    arr_of_spots[0][6].setColor("black");
                                                    arr_of_spots[0][6].setIcon(new ImageIcon(King.getImageSource("black")));
                                                    arr_of_spots[0][5].set_piece(new Rook());
                                                    arr_of_spots[0][5].setColor("black");
                                                    arr_of_spots[0][5].setIcon(new ImageIcon(Rook.getImageSource("black")));
                                                    arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece();
                                                    arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor();
                                                    arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(null);
                                                    arr_of_spots[i][j].set_piece();
                                                    arr_of_spots[i][j].setColor();
                                                    arr_of_spots[i][j].setIcon(null);
                                                } else {
                                                    flag_of_colors = true;
                                                    flag_of_clicks = false;
                                                    break;
                                                }
                                            } else {
                                                flag_of_colors = true;
                                                flag_of_clicks = false;
                                                break;
                                            }
                                        }
                                    }//when player choose wrong option that dosen`t obey the rule of the game
                                    else {
                                        if (color_of_first_click == "white") {
                                            flag_of_colors = false;
                                            flag_of_clicks = false;
                                            break;
                                        } else {
                                            flag_of_colors = true;
                                            flag_of_clicks = false;
                                        }
                                    }
                                } else if (color_of_first_click != arr_of_spots[i][j].getColor()) {
                                    if (piece_in_first_click instanceof Rook) {
                                        int x1 = x_axis_of_first_click;
                                        int y1 = y_axis_of_first_click;
                                        int x2 = x_axis_of_first_click;
                                        int y2 = y_axis_of_first_click;
                                    //in rook we have 4 options
                                        //first option
                                        if (x_axis_of_first_click < arr_of_spots[i][j].getI() && y_axis_of_first_click == arr_of_spots[i][j].getJ()) {
                                            if (x_axis_of_first_click + 1 == arr_of_spots[i][j].getI()) {
                                                flag_rook_and_bishob = true;
                                            } else {
                                                for (; x_axis_of_first_click < arr_of_spots[i][j].getI();) {
                                                    if (x_axis_of_first_click + 1 == arr_of_spots[i][j].getI()) {
                                                        for (; x1 < arr_of_spots[i][j].getI() - 1;) {
                                                            if (arr_of_spots[x1 + 1][y1].get_piece() == null) {
                                                                flag_rook_and_bishob = true;
                                                            } else {
                                                                flag_rook_and_bishob = false;
                                                                break;
                                                            }
                                                            x1++;
                                                        }
                                                    } else {
                                                        flag_rook_and_bishob = false;
                                                    }
                                                    x_axis_of_first_click++;
                                                }
                                            }
                                        }//secound option
                                        else if (x_axis_of_first_click > arr_of_spots[i][j].getI() && y_axis_of_first_click == arr_of_spots[i][j].getJ()) {
                                            if (x_axis_of_first_click - 1 == arr_of_spots[i][j].getI()) {
                                                flag_rook_and_bishob = true;
                                            } else {
                                                for (; x_axis_of_first_click > arr_of_spots[i][j].getI();) {
                                                    if (x_axis_of_first_click - 1 == arr_of_spots[i][j].getI()) {
                                                        for (; x1 > arr_of_spots[i][j].getI() + 1;) {
                                                            if (arr_of_spots[x1 - 1][y1].get_piece() == null) {
                                                                flag_rook_and_bishob = true;
                                                            } else {
                                                                flag_rook_and_bishob = false;
                                                                break;
                                                            }
                                                            x1--;
                                                        }
                                                    } else {
                                                        flag_rook_and_bishob = false;
                                                    }
                                                    x_axis_of_first_click--;
                                                }
                                            }
                                        } //third option
                                        else if (x_axis_of_first_click == arr_of_spots[i][j].getI() && y_axis_of_first_click < arr_of_spots[i][j].getJ()) {
                                            if (y_axis_of_first_click + 1 == arr_of_spots[i][j].getJ()) {
                                                flag_rook_and_bishob = true;
                                            } else {
                                                for (; y_axis_of_first_click < arr_of_spots[i][j].getJ();) {
                                                    if (y_axis_of_first_click + 1 == arr_of_spots[i][j].getJ()) {
                                                        for (; y1 < arr_of_spots[i][j].getJ() - 1;) {
                                                            if (arr_of_spots[x1][y1 + 1].get_piece() == null) {
                                                                flag_rook_and_bishob = true;
                                                            } else {
                                                                flag_rook_and_bishob = false;
                                                                break;
                                                            }
                                                            y1++;
                                                        }
                                                    } else {
                                                        flag_rook_and_bishob = false;
                                                    }
                                                    y_axis_of_first_click++;
                                                }
                                            }
                                        } //fourth option
                                        else if (x_axis_of_first_click == arr_of_spots[i][j].getI() && y_axis_of_first_click > arr_of_spots[i][j].getJ()) {
                                            if (y_axis_of_first_click - 1 == arr_of_spots[i][j].getJ()) {
                                                flag_rook_and_bishob = true;
                                            } else {
                                                for (; y_axis_of_first_click < arr_of_spots[i][j].getJ();) {
                                                    if (y_axis_of_first_click - 1 == arr_of_spots[i][j].getJ()) {
                                                        for (; y1 > arr_of_spots[i][j].getJ() + 1;) {
                                                            if (arr_of_spots[x1][y1 - 1].get_piece() == null) {
                                                                flag_rook_and_bishob = true;
                                                            } else {
                                                                flag_rook_and_bishob = false;
                                                                break;
                                                            }
                                                            y1--;
                                                        }
                                                    } else {
                                                        flag_rook_and_bishob = false;
                                                    }
                                                    y_axis_of_first_click--;
                                                }
                                            }
                                        } else {
                                            if (color_of_first_click == "white") {
                                                flag_of_clicks = false;
                                                flag_of_colors = false;
                                                break;
                                            } else if (color_of_first_click == "black") {
                                                flag_of_clicks = false;
                                                flag_of_colors = true;
                                                break;
                                            }
                                        }
                                        // we detect that the rook move rightly and set the new place of the rook
                                        if (flag_rook_and_bishob == true) {
                                            if (color_of_first_click == "white") {
                                                arr_of_spots[i][j].set_piece(new Rook());
                                                arr_of_spots[i][j].setIcon(new ImageIcon(Rook.getImageSource("white")));
                                                arr_of_spots[i][j].setColor("white");
                                                arr_of_spots[x2][y2].set_piece();
                                                arr_of_spots[x2][y2].setColor();
                                                arr_of_spots[x2][y2].setIcon(null);
                                            } else if (color_of_first_click == "black") {
                                                arr_of_spots[i][j].set_piece(new Rook());
                                                arr_of_spots[i][j].setIcon(new ImageIcon(Rook.getImageSource("black")));
                                                arr_of_spots[i][j].setColor("black");
                                                arr_of_spots[x2][y2].set_piece();
                                                arr_of_spots[x2][y2].setColor();
                                                arr_of_spots[x2][y2].setIcon(null);
                                            }
                                        } else if (flag_rook_and_bishob == false) {
                                            if (color_of_first_click == "white") {
                                                flag_of_clicks = false;
                                                flag_of_colors = false;
                                                break;
                                            } else if (color_of_first_click == "black") {
                                                flag_of_clicks = false;
                                                flag_of_colors = true;
                                                break;
                                            }
                                        }
                                    } else if (piece_in_first_click instanceof King) {
                                        if (x_axis_of_first_click + 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click == arr_of_spots[i][j].getJ() || x_axis_of_first_click - 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click == arr_of_spots[i][j].getJ() || x_axis_of_first_click == arr_of_spots[i][j].getI() && y_axis_of_first_click + 1 == arr_of_spots[i][j].getJ() || x_axis_of_first_click == arr_of_spots[i][j].getI() && y_axis_of_first_click - 1 == arr_of_spots[i][j].getJ() || x_axis_of_first_click + 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click + 1 == arr_of_spots[i][j].getJ() || x_axis_of_first_click - 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click - 1 == arr_of_spots[i][j].getJ() || x_axis_of_first_click - 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click + 1 == arr_of_spots[i][j].getJ() || x_axis_of_first_click + 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click - 1 == arr_of_spots[i][j].getJ()) {
                                            if (color_of_first_click == "white") {
                                                arr_of_spots[i][j].set_piece(new King());
                                                arr_of_spots[i][j].setIcon(new ImageIcon(King.getImageSource("white")));
                                                arr_of_spots[i][j].setColor("white");
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece();
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor();
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(null);
                                            } else if (color_of_first_click == "black") {
                                                arr_of_spots[i][j].set_piece(new King());
                                                arr_of_spots[i][j].setIcon(new ImageIcon(King.getImageSource("black")));
                                                arr_of_spots[i][j].setColor("black");
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece();
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor();
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(null);
                                            }
                                        } else {
                                            if (color_of_first_click == "white") {
                                                flag_of_clicks = false;
                                                flag_of_colors = false;
                                                break;
                                            } else if (color_of_first_click == "white") {
                                                flag_of_clicks = false;
                                                flag_of_colors = true;
                                                break;
                                            }
                                        }
                                    } else if (piece_in_first_click instanceof Pawn) {
                                        if (arr_of_spots[i][j].get_piece() == null) {
                                            if (color_of_first_click == "white") {
                                                if (x_axis_of_first_click == 6 && y_axis_of_first_click == 0 || x_axis_of_first_click == 6 && y_axis_of_first_click == 1 || x_axis_of_first_click == 6 && y_axis_of_first_click == 2 || x_axis_of_first_click == 6 && y_axis_of_first_click == 3 || x_axis_of_first_click == 6 && y_axis_of_first_click == 4 || x_axis_of_first_click == 6 && y_axis_of_first_click == 5 || x_axis_of_first_click == 6 && y_axis_of_first_click == 6 || x_axis_of_first_click == 6 && y_axis_of_first_click == 7) {
                                                    if (arr_of_spots[i][j].getI() == x_axis_of_first_click - 1 && arr_of_spots[i][j].getJ() == y_axis_of_first_click) {
                                                        arr_of_spots[i][j].set_piece(new Pawn());
                                                        arr_of_spots[i][j].setIcon(new ImageIcon(Pawn.getImageSource("white")));
                                                        arr_of_spots[i][j].setColor("white");
                                                        arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece();
                                                        arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor();
                                                        arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(null);
                                                    } else if (arr_of_spots[i][j].getI() == x_axis_of_first_click - 2 && arr_of_spots[i][j].getJ() == y_axis_of_first_click && arr_of_spots[x_axis_of_first_click - 1][y_axis_of_first_click].get_piece() == null) {
                                                        arr_of_spots[i][j].set_piece(new Pawn());
                                                        arr_of_spots[i][j].setIcon(new ImageIcon(Pawn.getImageSource("white")));
                                                        arr_of_spots[i][j].setColor("white");
                                                        arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece();
                                                        arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor();
                                                        arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(null);
                                                    } else {
                                                        flag_of_clicks = false;
                                                        flag_of_colors = false;
                                                        break;
                                                    }
                                                } else {
                                                    if (arr_of_spots[i][j].getI() == x_axis_of_first_click - 1 && arr_of_spots[i][j].getJ() == y_axis_of_first_click) {
                                                        arr_of_spots[i][j].set_piece(new Pawn());
                                                        arr_of_spots[i][j].setIcon(new ImageIcon(Pawn.getImageSource("white")));
                                                        arr_of_spots[i][j].setColor("white");
                                                        arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece();
                                                        arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor();
                                                        arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(null);
                                                    } else {
                                                        flag_of_clicks = false;
                                                        flag_of_colors = false;
                                                        break;
                                                    }
                                                }
                                            } else if (color_of_first_click == "black") {
                                                if (x_axis_of_first_click == 1 && y_axis_of_first_click == 0 || x_axis_of_first_click == 1 && y_axis_of_first_click == 1 || x_axis_of_first_click == 1 && y_axis_of_first_click == 2 || x_axis_of_first_click == 1 && y_axis_of_first_click == 3 || x_axis_of_first_click == 1 && y_axis_of_first_click == 4 || x_axis_of_first_click == 1 && y_axis_of_first_click == 5 || x_axis_of_first_click == 1 && y_axis_of_first_click == 6 || x_axis_of_first_click == 1 && y_axis_of_first_click == 7) {
                                                    if (arr_of_spots[i][j].getI() == x_axis_of_first_click + 1 && arr_of_spots[i][j].getJ() == y_axis_of_first_click) {
                                                        arr_of_spots[i][j].set_piece(new Pawn());
                                                        arr_of_spots[i][j].setIcon(new ImageIcon(Pawn.getImageSource("black")));
                                                        arr_of_spots[i][j].setColor("black");
                                                        arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece();
                                                        arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor();
                                                        arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(null);
                                                    } else if (arr_of_spots[i][j].getI() == x_axis_of_first_click + 2 && arr_of_spots[i][j].getJ() == y_axis_of_first_click && arr_of_spots[x_axis_of_first_click + 1][y_axis_of_first_click].get_piece() == null) {
                                                        arr_of_spots[i][j].set_piece(new Pawn());
                                                        arr_of_spots[i][j].setIcon(new ImageIcon(Pawn.getImageSource("black")));
                                                        arr_of_spots[i][j].setColor("black");
                                                        arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece();
                                                        arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor();
                                                        arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(null);
                                                    } else {
                                                        flag_of_clicks = false;
                                                        flag_of_colors = true;
                                                        break;
                                                    }
                                                } else {
                                                    if (arr_of_spots[i][j].getI() == x_axis_of_first_click + 1 && arr_of_spots[i][j].getJ() == y_axis_of_first_click) {
                                                        arr_of_spots[i][j].set_piece(new Pawn());
                                                        arr_of_spots[i][j].setIcon(new ImageIcon(Pawn.getImageSource("black")));
                                                        arr_of_spots[i][j].setColor("black");
                                                        arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece();
                                                        arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor();
                                                        arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(null);
                                                    } else {
                                                        flag_of_clicks = false;
                                                        flag_of_colors = true;
                                                        break;
                                                    }
                                                }
                                            }
                                        } else if (arr_of_spots[i][j].get_piece() != null) {
                                            if (color_of_first_click == "white") {
                                                if (arr_of_spots[i][j].getI() == x_axis_of_first_click - 1 && arr_of_spots[i][j].getJ() == y_axis_of_first_click - 1 || arr_of_spots[i][j].getI() == x_axis_of_first_click - 1 && arr_of_spots[i][j].getJ() == y_axis_of_first_click + 1) {
                                                    arr_of_spots[i][j].set_piece(new Pawn());
                                                    arr_of_spots[i][j].setIcon(new ImageIcon(Pawn.getImageSource("white")));
                                                    arr_of_spots[i][j].setColor("white");
                                                    arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece();
                                                    arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor();
                                                    arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(null);
                                                } else {
                                                    flag_of_clicks = false;
                                                    flag_of_colors = false;
                                                    break;
                                                }
                                            } else if (color_of_first_click == "black") {
                                                if (arr_of_spots[i][j].getI() == x_axis_of_first_click + 1 && arr_of_spots[i][j].getJ() == y_axis_of_first_click - 1 || arr_of_spots[i][j].getI() == x_axis_of_first_click + 1 && arr_of_spots[i][j].getJ() == y_axis_of_first_click + 1) {
                                                    arr_of_spots[i][j].set_piece(new Pawn());
                                                    arr_of_spots[i][j].setIcon(new ImageIcon(Pawn.getImageSource("black")));
                                                    arr_of_spots[i][j].setColor("black");
                                                    arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece();
                                                    arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor();
                                                    arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(null);
                                                } else {
                                                    flag_of_clicks = false;
                                                    flag_of_colors = true;
                                                    break;
                                                }
                                            }
                                        }
                                    } else if (piece_in_first_click instanceof Knight) {
                                        if (arr_of_spots[i][j].getI() == x_axis_of_first_click + 1 && arr_of_spots[i][j].getJ() == y_axis_of_first_click + 2 || arr_of_spots[i][j].getI() == x_axis_of_first_click + 1 && arr_of_spots[i][j].getJ() == y_axis_of_first_click - 2 || arr_of_spots[i][j].getI() == x_axis_of_first_click - 1 && arr_of_spots[i][j].getJ() == y_axis_of_first_click - 2 || arr_of_spots[i][j].getI() == x_axis_of_first_click - 1 && arr_of_spots[i][j].getJ() == y_axis_of_first_click + 2 || arr_of_spots[i][j].getI() == x_axis_of_first_click + 2 && arr_of_spots[i][j].getJ() == y_axis_of_first_click + 1 || arr_of_spots[i][j].getI() == x_axis_of_first_click + 2 && arr_of_spots[i][j].getJ() == y_axis_of_first_click - 1 || arr_of_spots[i][j].getI() == x_axis_of_first_click - 2 && arr_of_spots[i][j].getJ() == y_axis_of_first_click + 1 || arr_of_spots[i][j].getI() == x_axis_of_first_click - 2 && arr_of_spots[i][j].getJ() == y_axis_of_first_click - 1) {
                                            if (color_of_first_click == "white") {
                                                arr_of_spots[i][j].set_piece(new Knight());
                                                arr_of_spots[i][j].setIcon(new ImageIcon(Knight.getImageSource("white")));
                                                arr_of_spots[i][j].setColor("white");
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece();
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor();
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(null);
                                            } else if (color_of_first_click == "black") {
                                                arr_of_spots[i][j].set_piece(new Knight());
                                                arr_of_spots[i][j].setIcon(new ImageIcon(Knight.getImageSource("black")));
                                                arr_of_spots[i][j].setColor("black");
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].set_piece();
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setColor();
                                                arr_of_spots[x_axis_of_first_click][y_axis_of_first_click].setIcon(null);
                                            }
                                        } else {
                                            if (color_of_first_click == "white") {
                                                flag_of_clicks = false;
                                                flag_of_colors = false;
                                                break;
                                            } else if (color_of_first_click == "black") {
                                                flag_of_clicks = false;
                                                flag_of_colors = true;
                                                break;
                                            }
                                        }
                                    } else if (piece_in_first_click instanceof Bishob) {
                                        int x1 = x_axis_of_first_click;
                                        int y1 = y_axis_of_first_click;
                                        int x2 = x_axis_of_first_click;
                                        int y2 = y_axis_of_first_click;
                                    //in bishob we have 4 options
                                        //first option
                                        if (x_axis_of_first_click < arr_of_spots[i][j].getI() && y_axis_of_first_click < arr_of_spots[i][j].getJ()) {
                                            if (x_axis_of_first_click + 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click + 1 == arr_of_spots[i][j].getJ()) {
                                                flag_rook_and_bishob = true;
                                            } else {
                                                for (; x_axis_of_first_click < arr_of_spots[i][j].getI() && y_axis_of_first_click < arr_of_spots[i][j].getJ();) {
                                                    if (x_axis_of_first_click + 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click + 1 == arr_of_spots[i][j].getJ()) {
                                                        for (; x1 < arr_of_spots[i][j].getI() - 1 && y1 < arr_of_spots[i][j].getJ() - 1;) {
                                                            if (arr_of_spots[x1 + 1][y1 + 1].get_piece() == null) {
                                                                flag_rook_and_bishob = true;
                                                            } else {
                                                                flag_rook_and_bishob = false;
                                                                break;
                                                            }
                                                            x1++;
                                                            y1++;
                                                        }
                                                    } else {
                                                        flag_rook_and_bishob = false;
                                                    }
                                                    x_axis_of_first_click++;
                                                    y_axis_of_first_click++;
                                                }
                                            }
                                        } //secound option
                                        else if (x_axis_of_first_click > arr_of_spots[i][j].getI() && y_axis_of_first_click > arr_of_spots[i][j].getJ()) {
                                            if (x_axis_of_first_click - 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click - 1 == arr_of_spots[i][j].getJ()) {
                                                flag_rook_and_bishob = true;
                                            } else {
                                                for (; x_axis_of_first_click > arr_of_spots[i][j].getI() && y_axis_of_first_click > arr_of_spots[i][j].getJ();) {
                                                    if (x_axis_of_first_click - 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click - 1 == arr_of_spots[i][j].getJ()) {
                                                        for (; x1 > arr_of_spots[i][j].getI() + 1 && y1 > arr_of_spots[i][j].getJ() + 1;) {
                                                            if (arr_of_spots[x1 - 1][y1 - 1].get_piece() == null) {
                                                                flag_rook_and_bishob = true;
                                                            } else {
                                                                flag_rook_and_bishob = false;
                                                                break;
                                                            }
                                                            x1--;
                                                            y1--;
                                                        }
                                                    } else {
                                                        flag_rook_and_bishob = false;
                                                    }
                                                    x_axis_of_first_click--;
                                                    y_axis_of_first_click--;
                                                }
                                            }
                                        } //third option
                                        else if (x_axis_of_first_click > arr_of_spots[i][j].getI() && y_axis_of_first_click < arr_of_spots[i][j].getJ()) {
                                            if (x_axis_of_first_click - 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click + 1 == arr_of_spots[i][j].getJ()) {
                                                flag_rook_and_bishob = true;
                                            } else {
                                                for (; x_axis_of_first_click > arr_of_spots[i][j].getI() && y_axis_of_first_click < arr_of_spots[i][j].getJ();) {
                                                    if (x_axis_of_first_click - 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click + 1 == arr_of_spots[i][j].getJ()) {
                                                        for (; x1 > arr_of_spots[i][j].getI() + 1 && y1 < arr_of_spots[i][j].getJ() - 1;) {
                                                            if (arr_of_spots[x1 - 1][y1 + 1].get_piece() == null) {
                                                                flag_rook_and_bishob = true;
                                                            } else {
                                                                flag_rook_and_bishob = false;
                                                                break;
                                                            }
                                                            x1--;
                                                            y1++;
                                                        }
                                                    } else {
                                                        flag_rook_and_bishob = false;
                                                    }
                                                    x_axis_of_first_click--;
                                                    y_axis_of_first_click++;
                                                }
                                            }
                                        }//fourth option
                                        else if (x_axis_of_first_click < arr_of_spots[i][j].getI() && y_axis_of_first_click > arr_of_spots[i][j].getJ()) {
                                            if (x_axis_of_first_click + 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click - 1 == arr_of_spots[i][j].getJ()) {
                                                flag_rook_and_bishob = true;
                                            } else {
                                                for (; x_axis_of_first_click > arr_of_spots[i][j].getI() && y_axis_of_first_click < arr_of_spots[i][j].getJ();) {
                                                    if (x_axis_of_first_click + 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click - 1 == arr_of_spots[i][j].getJ()) {
                                                        for (; x1 < arr_of_spots[i][j].getI() - 1 && y1 > arr_of_spots[i][j].getJ() + 1;) {
                                                            if (arr_of_spots[x1 + 1][y1 - 1].get_piece() == null) {
                                                                flag_rook_and_bishob = true;
                                                            } else {
                                                                flag_rook_and_bishob = false;
                                                                break;
                                                            }
                                                            x1++;
                                                            y1--;
                                                        }
                                                    } else {
                                                        flag_rook_and_bishob = false;
                                                    }
                                                    x_axis_of_first_click++;
                                                    y_axis_of_first_click--;
                                                }
                                            }
                                        } else {
                                            if (color_of_first_click == "white") {
                                                flag_of_clicks = false;
                                                flag_of_colors = false;
                                                break;
                                            } else if (color_of_first_click == "black") {
                                                flag_of_clicks = false;
                                                flag_of_colors = true;
                                                break;
                                            }
                                        }
                                        if (flag_rook_and_bishob == true) {
                                            if (color_of_first_click == "white") {
                                                arr_of_spots[i][j].set_piece(new Bishob());
                                                arr_of_spots[i][j].setIcon(new ImageIcon(Bishob.getImageSource("white")));
                                                arr_of_spots[i][j].setColor("white");
                                                arr_of_spots[x2][y2].set_piece();
                                                arr_of_spots[x2][y2].setColor();
                                                arr_of_spots[x2][y2].setIcon(null);
                                            } else if (color_of_first_click == "black") {
                                                arr_of_spots[i][j].set_piece(new Bishob());
                                                arr_of_spots[i][j].setIcon(new ImageIcon(Bishob.getImageSource("black")));
                                                arr_of_spots[i][j].setColor("black");
                                                arr_of_spots[x2][y2].set_piece();
                                                arr_of_spots[x2][y2].setColor();
                                                arr_of_spots[x2][y2].setIcon(null);
                                            }
                                        } else {
                                            if (color_of_first_click == "white") {
                                                flag_of_clicks = false;
                                                flag_of_colors = false;
                                                break;
                                            } else if (color_of_first_click == "black") {
                                                flag_of_clicks = false;
                                                flag_of_colors = true;
                                                break;
                                            }
                                        }
                                    } else if (piece_in_first_click instanceof Queen) {
                                        int x1 = x_axis_of_first_click;
                                        int y1 = y_axis_of_first_click;
                                        int x2 = x_axis_of_first_click;
                                        int y2 = y_axis_of_first_click;
                                        //Queen has 8 options
                                        //frist option
                                        if (x_axis_of_first_click < arr_of_spots[i][j].getI() && y_axis_of_first_click == arr_of_spots[i][j].getJ()) {
                                            if (x_axis_of_first_click + 1 == arr_of_spots[i][j].getI()) {
                                                flag_rook_and_bishob = true;
                                            } else {
                                                for (; x_axis_of_first_click < arr_of_spots[i][j].getI();) {
                                                    if (x_axis_of_first_click + 1 == arr_of_spots[i][j].getI()) {
                                                        for (; x1 < arr_of_spots[i][j].getI() - 1;) {
                                                            if (arr_of_spots[x1 + 1][y1].get_piece() == null) {
                                                                flag_rook_and_bishob = true;
                                                            } else {
                                                                flag_rook_and_bishob = false;
                                                                break;
                                                            }
                                                            x1++;
                                                        }
                                                    } else {
                                                        flag_rook_and_bishob = false;
                                                    }
                                                    x_axis_of_first_click++;
                                                }
                                            }
                                        } //secound option
                                        else if (x_axis_of_first_click > arr_of_spots[i][j].getI() && y_axis_of_first_click == arr_of_spots[i][j].getJ()) {
                                            if (x_axis_of_first_click - 1 == arr_of_spots[i][j].getI()) {
                                                flag_rook_and_bishob = true;
                                            } else {
                                                for (; x_axis_of_first_click > arr_of_spots[i][j].getI();) {
                                                    if (x_axis_of_first_click - 1 == arr_of_spots[i][j].getI()) {
                                                        for (; x1 > arr_of_spots[i][j].getI() + 1;) {
                                                            if (arr_of_spots[x1 - 1][y1].get_piece() == null) {
                                                                flag_rook_and_bishob = true;
                                                            } else {
                                                                flag_rook_and_bishob = false;
                                                                break;
                                                            }
                                                            x1--;
                                                        }
                                                    } else {
                                                        flag_rook_and_bishob = false;
                                                    }
                                                    x_axis_of_first_click--;
                                                }
                                            }
                                        } //third option
                                        else if (x_axis_of_first_click == arr_of_spots[i][j].getI() && y_axis_of_first_click < arr_of_spots[i][j].getJ()) {
                                            if (y_axis_of_first_click + 1 == arr_of_spots[i][j].getJ()) {
                                                flag_rook_and_bishob = true;
                                            } else {
                                                for (; y_axis_of_first_click < arr_of_spots[i][j].getJ();) {
                                                    if (y_axis_of_first_click + 1 == arr_of_spots[i][j].getJ()) {
                                                        for (; y1 < arr_of_spots[i][j].getJ() - 1;) {
                                                            if (arr_of_spots[x1][y1 + 1].get_piece() == null) {
                                                                flag_rook_and_bishob = true;
                                                            } else {
                                                                flag_rook_and_bishob = false;
                                                                break;
                                                            }
                                                            y1++;
                                                        }
                                                    } else {
                                                        flag_rook_and_bishob = false;
                                                    }
                                                    y_axis_of_first_click++;
                                                }
                                            }
                                        } //fourth option
                                        else if (x_axis_of_first_click == arr_of_spots[i][j].getI() && y_axis_of_first_click > arr_of_spots[i][j].getJ()) {
                                            if (y_axis_of_first_click - 1 == arr_of_spots[i][j].getJ()) {
                                                flag_rook_and_bishob = true;
                                            } else {
                                                for (; y_axis_of_first_click < arr_of_spots[i][j].getJ();) {
                                                    if (y_axis_of_first_click - 1 == arr_of_spots[i][j].getJ()) {
                                                        for (; y1 > arr_of_spots[i][j].getJ() + 1;) {
                                                            if (arr_of_spots[x1][y1 - 1].get_piece() == null) {
                                                                flag_rook_and_bishob = true;
                                                            } else {
                                                                flag_rook_and_bishob = false;
                                                                break;
                                                            }
                                                            y1--;
                                                        }
                                                    } else {
                                                        flag_rook_and_bishob = false;
                                                    }
                                                    y_axis_of_first_click--;
                                                }
                                            }
                                        } //fifth option
                                        else if (x_axis_of_first_click < arr_of_spots[i][j].getI() && y_axis_of_first_click < arr_of_spots[i][j].getJ()) {
                                            if (x_axis_of_first_click + 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click + 1 == arr_of_spots[i][j].getJ()) {
                                                flag_rook_and_bishob = true;
                                            } else {
                                                for (; x_axis_of_first_click < arr_of_spots[i][j].getI() && y_axis_of_first_click < arr_of_spots[i][j].getJ();) {
                                                    if (x_axis_of_first_click + 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click + 1 == arr_of_spots[i][j].getJ()) {
                                                        for (; x1 < arr_of_spots[i][j].getI() - 1 && y1 < arr_of_spots[i][j].getJ() - 1;) {
                                                            if (arr_of_spots[x1 + 1][y1 + 1].get_piece() == null) {
                                                                flag_rook_and_bishob = true;
                                                            } else {
                                                                flag_rook_and_bishob = false;
                                                                break;
                                                            }
                                                            x1++;
                                                            y1++;
                                                        }
                                                    } else {
                                                        flag_rook_and_bishob = false;
                                                    }
                                                    x_axis_of_first_click++;
                                                    y_axis_of_first_click++;
                                                }
                                            }
                                        } //sixth option
                                        else if (x_axis_of_first_click > arr_of_spots[i][j].getI() && y_axis_of_first_click > arr_of_spots[i][j].getJ()) {
                                            if (x_axis_of_first_click - 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click - 1 == arr_of_spots[i][j].getJ()) {
                                                flag_rook_and_bishob = true;
                                            } else {
                                                for (; x_axis_of_first_click > arr_of_spots[i][j].getI() && y_axis_of_first_click > arr_of_spots[i][j].getJ();) {
                                                    if (x_axis_of_first_click - 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click - 1 == arr_of_spots[i][j].getJ()) {
                                                        for (; x1 > arr_of_spots[i][j].getI() + 1 && y1 > arr_of_spots[i][j].getJ() + 1;) {
                                                            if (arr_of_spots[x1 - 1][y1 - 1].get_piece() == null) {
                                                                flag_rook_and_bishob = true;
                                                            } else {
                                                                flag_rook_and_bishob = false;
                                                                break;
                                                            }
                                                            x1--;
                                                            y1--;
                                                        }
                                                    } else {
                                                        flag_rook_and_bishob = false;
                                                    }
                                                    x_axis_of_first_click--;
                                                    y_axis_of_first_click--;
                                                }
                                            }
                                        } //seventh option
                                        else if (x_axis_of_first_click > arr_of_spots[i][j].getI() && y_axis_of_first_click < arr_of_spots[i][j].getJ()) {
                                            if (x_axis_of_first_click - 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click + 1 == arr_of_spots[i][j].getJ()) {
                                                flag_rook_and_bishob = true;
                                            } else {
                                                for (; x_axis_of_first_click > arr_of_spots[i][j].getI() && y_axis_of_first_click < arr_of_spots[i][j].getJ();) {
                                                    if (x_axis_of_first_click - 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click + 1 == arr_of_spots[i][j].getJ()) {
                                                        for (; x1 > arr_of_spots[i][j].getI() + 1 && y1 < arr_of_spots[i][j].getJ() - 1;) {
                                                            if (arr_of_spots[x1 - 1][y1 + 1].get_piece() == null) {
                                                                flag_rook_and_bishob = true;
                                                            } else {
                                                                flag_rook_and_bishob = false;
                                                                break;
                                                            }
                                                            x1--;
                                                            y1++;
                                                        }
                                                    } else {
                                                        flag_rook_and_bishob = false;
                                                    }
                                                    x_axis_of_first_click--;
                                                    y_axis_of_first_click++;
                                                }
                                            }
                                        } // option number 8
                                        else if (x_axis_of_first_click < arr_of_spots[i][j].getI() && y_axis_of_first_click > arr_of_spots[i][j].getJ()) {
                                            if (x_axis_of_first_click + 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click - 1 == arr_of_spots[i][j].getJ()) {
                                                flag_rook_and_bishob = true;
                                            } else {
                                                for (; x_axis_of_first_click > arr_of_spots[i][j].getI() && y_axis_of_first_click < arr_of_spots[i][j].getJ();) {
                                                    if (x_axis_of_first_click + 1 == arr_of_spots[i][j].getI() && y_axis_of_first_click - 1 == arr_of_spots[i][j].getJ()) {
                                                        for (; x1 < arr_of_spots[i][j].getI() - 1 && y1 > arr_of_spots[i][j].getJ() + 1;) {
                                                            if (arr_of_spots[x1 + 1][y1 - 1].get_piece() == null) {
                                                                flag_rook_and_bishob = true;
                                                            } else {
                                                                flag_rook_and_bishob = false;
                                                                break;
                                                            }
                                                            x1++;
                                                            y1--;
                                                        }
                                                    } else {
                                                        flag_rook_and_bishob = false;
                                                    }
                                                    x_axis_of_first_click++;
                                                    y_axis_of_first_click--;
                                                }
                                            }
                                        }// when the queen moves wrong
                                        else {
                                            if (color_of_first_click == "white") {
                                                flag_of_clicks = false;
                                                flag_of_colors = false;
                                                break;
                                            } else if (color_of_first_click == "black") {
                                                flag_of_clicks = false;
                                                flag_of_colors = true;
                                                break;
                                            }
                                        }
                                        // when queen moves rightly and set the new place
                                        if (flag_rook_and_bishob == true) {
                                            if (color_of_first_click == "white") {
                                                arr_of_spots[i][j].set_piece(new Queen());
                                                arr_of_spots[i][j].setIcon(new ImageIcon(Queen.getImageSource("white")));
                                                arr_of_spots[i][j].setColor("white");
                                                arr_of_spots[x2][y2].set_piece();
                                                arr_of_spots[x2][y2].setColor();
                                                arr_of_spots[x2][y2].setIcon(null);
                                            } else if (color_of_first_click == "black") {
                                                arr_of_spots[i][j].set_piece(new Queen());
                                                arr_of_spots[i][j].setIcon(new ImageIcon(Queen.getImageSource("black")));
                                                arr_of_spots[i][j].setColor("black");
                                                arr_of_spots[x2][y2].set_piece();
                                                arr_of_spots[x2][y2].setColor();
                                                arr_of_spots[x2][y2].setIcon(null);
                                            }
                                        } else {
                                            if (color_of_first_click == "white") {
                                                flag_of_clicks = false;
                                                flag_of_colors = false;
                                                break;
                                            } else if (color_of_first_click == "black") {
                                                flag_of_clicks = false;
                                                flag_of_colors = true;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        } else {
                            continue;
                        }
                    }
                }
                flag_of_clicks = false;
            }
        }
    }
}
