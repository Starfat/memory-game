/*
MemoryGameWindow
- skal spesialisere JFrame og implementere ActionListener.
- skal inneholde den indre klassen GameMenubar som spesialiserer JMenuBar.
- skal ha ansvar for å utføre de tre menyvalgene som forberedes i GamePanel.
*/

package gui;

import javax.swing.*;
import java.awt.event.*;

public class MemoryGameWindow extends JFrame implements ActionListener {

    private GamePanel gamePanel; // Spillpanelet
    private JMenuItem play; // Menyvalg "play". Deklareres her for at det skal være tilgjengelig i ActionPerformed

    public MemoryGameWindow() { // Kontruktøren til hovedvinduet
        setTitle("memory game"); // Setter tittel på vinduet
        setJMenuBar(new GameMenubar(this)); // setter opp meny som spesifisert i GameMenubar()
        setSize(600, 600); // Setter størrelse
        setLocationRelativeTo(null); // Setter vinduet på midten
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Gjør at programmet avsluttes når man klikker på krysset øverst i høyre hjørne
        add (gamePanel = new GamePanel()); // instansierer og legger til et GamePanel
        setVisible(true); // Sørger for at viduet vises
    }

    public void actionPerformed(ActionEvent e) {

        String menuItem = e.getActionCommand(); // setter menuItem til å innholde teksten fra menyvalget som blir klikket på

        if (menuItem.equals("new board")) { // sjekker om menyvalget "new board" er valgt og utfører i så fall koden under
            remove(gamePanel); // fjerner spillpanelet
            add (gamePanel = new GamePanel()); // legger til et nytt spillpanel
            gamePanel.updateUI(); // oppdaterer spillpanel (slik at ny versjon vises
            play.setEnabled(true); // gjør menyvalget "play" klikkbart
        }

        if (menuItem.equals("play")) { // sjekker om menyvalget "play" er valgt og utfører i så fall koden under

            gamePanel.setTopPanelColor(gamePanel.randomPanelColor()); // tildeler topPanelColor en tilfeldig farge
            gamePanel.getTopPanel().setBackground(gamePanel.getTopPanelColor()); // setter fargen på toppanelet

            for (int i = 0; i < 9; i++) { // loop gjennom alle panelene
                ColoredPanel[] coloredPanelArray = gamePanel.getColoredPanelArray(); // oppretter lokalt array "coloredPanelArray" og tilordner panelene som er i spill
                if (coloredPanelArray[i].getBackground() == gamePanel.getTopPanelColor()) { // sjekker om fargen på spillpanelet er det samme som på toppanelet
                    gamePanel.setPossiblePicks(gamePanel.getPossiblePicks() + 1); // oppdaterer teller hvis fargen er lik
                }
                coloredPanelArray[i].setNeutralColor(); // setter spillpanelene til grått
            }
            play.setEnabled(false); // gjør menyvalget "play" IKKE klikkbart
        }

        if (menuItem.equals("end program")) { // Lukker programmet
            System.exit(0);
        }
    }

    class GameMenubar extends JMenuBar {

        GameMenubar(MemoryGameWindow memoryGameWindow) { // konstruktør for menysystem. Tar et MemoryGameWindow som argument
            JMenu menu = new JMenu("File"); // Toppmeny
            JMenuItem newBoard = new JMenuItem("new board"); // menyvalg "new board"
            play = new JMenuItem("play"); // menyvalg "play"
            JMenuItem endProgram = new JMenuItem("end program"); // menyvalg "end program"
            menu.add(newBoard); // legger menyvalg til toppmeny
            menu.add(play); // legger menyvalg til toppmeny
            menu.add(endProgram); // legger menyvalg til toppmeny
            add(menu); // legger til menyen

            newBoard.addActionListener(memoryGameWindow); // legger til ActionListener for menyvalg
            play.addActionListener(memoryGameWindow); // legger til ActionListener for menyvalg
            endProgram.addActionListener(memoryGameWindow); // legger til ActionListener for menyvalg
        }
    }
}
