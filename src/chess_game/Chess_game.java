package chess_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chess_game {

    JFrame frame = new JFrame("Strat menue");

    public Chess_game() {
        ImageIcon happy = new ImageIcon("C:\\Users\\Kareem Zayed\\Documents\\NetBeansProjects\\Chess_game\\images\\bishop_happywhite.png");
        Image happyimage = happy.getImage();
        Image modify = happyimage.getScaledInstance(60, 60, 60);
        happy = new ImageIcon(modify);
        ImageIcon saad = new ImageIcon("C:\\Users\\Kareem Zayed\\Documents\\NetBeansProjects\\Chess_game\\images\\rook sad black.png");
        Image saadimage = saad.getImage();
        Image modif = saadimage.getScaledInstance(60, 60, 60);
        saad = new ImageIcon(modif);
        ImageIcon team = new ImageIcon("C:\\Users\\Kareem Zayed\\Documents\\NetBeansProjects\\Chess_game\\images\\team.png");
        Image teamimage = team.getImage();
        Image modifteam = teamimage.getScaledInstance(50, 50, 60);
        team = new ImageIcon(modifteam);
        ImageIcon instact = new ImageIcon("C:\\Users\\Kareem Zayed\\Documents\\NetBeansProjects\\Chess_game\\images\\taagb.jpg");
        Image instactimage = instact.getImage();
        Image modifinstact = instactimage.getScaledInstance(100, 50, 60);
        instact = new ImageIcon(modifinstact);
        frame.setSize(new Dimension(450, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.BLACK);
        JPanel panal = new JPanel(new GridLayout(4, 4));
        panal.setBackground(Color.BLACK);
        frame.add(panal);
        GridBagConstraints c = new GridBagConstraints();
        JButton newGame = new JButton("New game");
        newGame.setBounds(100, 100, 250, 100);
        newGame.setFont(new Font("Comic Sans", Font.BOLD, 30));
        newGame.setForeground(new Color(210, 105, 30));
        newGame.setBackground(Color.BLACK);
        newGame.setBorder(BorderFactory.createEtchedBorder());
        newGame.setIcon(happy);
        newGame.setFocusable(false);
        c.gridy = 1;
        panal.add(newGame, c);
        newGameButton n = new newGameButton();
        newGame.addActionListener(n);
        JButton Instractions = new JButton("Instructions");
        Instractions.setBounds(100, 100, 250, 100);
        Instractions.setFont(new Font("Comic Sans", Font.BOLD, 30));
        Instractions.setForeground(new Color(210, 105, 30));
        Instractions.setBackground(Color.BLACK);
        Instractions.setBorder(BorderFactory.createEtchedBorder());
        Instractions.setIcon(instact);
        Instractions.setFocusable(false);
        instractions i = new instractions();
        Instractions.addActionListener(i);
        c.gridy = 2;
        panal.add(Instractions, c);
        JButton aboutTeam = new JButton("About team");
        aboutTeam.setBounds(100, 100, 250, 100);
        aboutTeam.setFont(new Font("Comic Sans", Font.BOLD, 30));
        aboutTeam.setForeground(new Color(210, 105, 30));
        aboutTeam.setBackground(Color.BLACK);
        aboutTeam.setBorder(BorderFactory.createEtchedBorder());
        aboutTeam.setIcon(team);
        aboutTeam.setFocusable(false);
        AboutTeam t = new AboutTeam();
        aboutTeam.addActionListener(t);
        c.gridy = 3;
        panal.add(aboutTeam, c);
        JButton Quit = new JButton("Quit");
        Quit.setBounds(100, 100, 250, 100);
        Quit.setFont(new Font("Comic Sans", Font.BOLD, 30));
        Quit.setForeground(new Color(210, 105, 30));
        Quit.setBackground(Color.BLACK);
        Quit.setBorder(BorderFactory.createEtchedBorder());
        Quit.setFocusable(false);
        Quit.setIcon(saad);
        c.gridy = 4;
        panal.add(Quit, c);
        Quit q = new Quit();
        Quit.addActionListener(q);
    }

    public class newGameButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.setVisible(false);
            new Board();
        }
    }

    public class instractions implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Object source = ae.getSource();
            frame.setVisible(false);
            JFrame ins_frame = new JFrame("Instractions");
            ins_frame.setSize(new Dimension(300, 300));
            ins_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ins_frame.setVisible(true);
            ins_frame.setResizable(false);
            ins_frame.setLocationRelativeTo(null);
            ins_frame.setBackground(Color.BLACK);
            JPanel pan = new JPanel(new GridLayout(1, 1));
            ins_frame.add(pan);
            JButton b = new JButton();
            pan.add(b);
            //b.setText("The white player must start playing by moving one of the white pieces in the places designated for each piece");
            ImageIcon instrac = new ImageIcon("C:\\Users\\Kareem Zayed\\Documents\\NetBeansProjects\\Chess_game\\images\\instrac.jpeg");
            Image instracimage = instrac.getImage();
            Image modify = instracimage.getScaledInstance(240, 240, 240);
            instrac = new ImageIcon(modify);
            b.setIcon(instrac);
            b.setFont(new Font("Comic Sans", Font.BOLD, 19));
            b.setForeground(new Color(210, 105, 30));
            b.setBackground(Color.BLACK);
            b.setFocusable(false);
            return_back r = new return_back(ins_frame);
            b.addActionListener(r);
        }
    }

    public class return_back implements ActionListener {

        JFrame f;

        public return_back(JFrame f) {
            this.f = f;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            f.setVisible(false);
            new Chess_game();
        }
    }

    public class Quit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.exit(0);
        }
    }

    public class AboutTeam implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.setVisible(false);
            ImageIcon zayed = new ImageIcon("C:\\Users\\Kareem Zayed\\Documents\\NetBeansProjects\\Chess_game\\images\\zayed.jpeg");
            Image zayedimage = zayed.getImage();
            Image modifyzayed = zayedimage.getScaledInstance(160, 160, 60);
            zayed = new ImageIcon(modifyzayed);

            ImageIcon usama = new ImageIcon("C:\\Users\\Kareem Zayed\\Documents\\NetBeansProjects\\Chess_game\\images\\usama.jpg");
            Image usamaimage = usama.getImage();
            Image modifyusama = usamaimage.getScaledInstance(150, 150, 60);
            usama = new ImageIcon(modifyusama);

            ImageIcon doc = new ImageIcon("C:\\Users\\Kareem Zayed\\Documents\\NetBeansProjects\\Chess_game\\images\\doc.jpg");
            Image docimage = doc.getImage();
            Image modifydoc = docimage.getScaledInstance(180, 180, 60);
            doc = new ImageIcon(modifydoc);

            ImageIcon mariam = new ImageIcon("C:\\Users\\Kareem Zayed\\Documents\\NetBeansProjects\\Chess_game\\images\\mariam.jpg");
            Image mariamimage = mariam.getImage();
            Image modifymariam = mariamimage.getScaledInstance(170, 170, 60);
            mariam = new ImageIcon(modifymariam);

            ImageIcon maroAhmed = new ImageIcon("C:\\Users\\Kareem Zayed\\Documents\\NetBeansProjects\\Chess_game\\images\\marwan ahmed.jpg");
            Image maroAhmedimage = maroAhmed.getImage();
            Image modifymaroAhmed = maroAhmedimage.getScaledInstance(160, 160, 60);
            maroAhmed = new ImageIcon(modifymaroAhmed);

            ImageIcon maroMo = new ImageIcon("C:\\Users\\Kareem Zayed\\Documents\\NetBeansProjects\\Chess_game\\images\\marwan mohamed.jpg");
            Image maroMoimage = maroMo.getImage();
            Image maroMozayed = maroMoimage.getScaledInstance(170, 170, 60);
            maroMo = new ImageIcon(maroMozayed);

            JFrame aboutUs = new JFrame("About Us");
            aboutUs.setSize(new Dimension(1000, 1050));
            aboutUs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            aboutUs.setVisible(true);
            aboutUs.setResizable(false);
            aboutUs.setLocationRelativeTo(null);
            JPanel p = new JPanel(new GridLayout(7, 7));
            aboutUs.add(p);
            JButton button[] = new JButton[7];
            for (int x = 0; x <= 6; x++) {
                button[x] = new JButton();
                button[x].setBackground(Color.BLACK);
                button[x].setFocusable(false);
                p.add(button[x]);
            }
            button[0].setIcon(doc);
            button[0].setText("  Mohamed Ahmed Abd El-Sayed Abd El-Hady,  section: 8,  ID:  20191700495");
            button[0].setFont(new Font("Comic Sans", Font.BOLD, 19));
            button[0].setForeground(new Color(210, 105, 30));
            button[1].setIcon(zayed);
            button[1].setText("               Kareem Zayed Abd El-Kereem Boraay,  section: 13,  ID: 20191700451");
            button[1].setFont(new Font("Comic Sans", Font.BOLD, 19));
            button[1].setForeground(new Color(210, 105, 30));
            button[2].setIcon(maroMo);
            button[2].setText("    Marwan Mohamed Abd El- Halem El Sayed,  section: 12,  ID: 20191700620");
            button[2].setFont(new Font("Comic Sans", Font.BOLD, 19));
            button[2].setForeground(new Color(210, 105, 30));
            button[3].setIcon(maroAhmed);
            button[3].setText("                   Marwan Ahmed Mohamed Hafez,  section: 12,  ID:  20191700615");
            button[3].setFont(new Font("Comic Sans", Font.BOLD, 19));
            button[3].setForeground(new Color(210, 105, 30));
            button[4].setIcon(usama);
            button[4].setText("               Mohamed Osama Abd El-Rady Afefy,  section: 9,  ID: 20191700501");
            button[4].setFont(new Font("Comic Sans", Font.BOLD, 19));
            button[4].setForeground(new Color(210, 105, 30));
            button[5].setIcon(mariam);
            button[5].setText("                         Mariam Moures Arian Atallah,  section: 12,  ID: 20191700636");
            button[5].setFont(new Font("Comic Sans", Font.BOLD, 19));
            button[5].setForeground(new Color(210, 105, 30));
            button[6].setText("                    <===== Press here to back to start menu..                       ");
            button[6].setFont(new Font("Comic Sans", Font.BOLD, 22));
            button[6].setForeground(new Color(255, 0, 0));
            return_back r = new return_back(aboutUs);
            button[6].addActionListener(r);
        }
    }

    public static void main(String[] args) {
        new Chess_game();
    }
}
