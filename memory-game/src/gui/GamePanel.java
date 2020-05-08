/*
GamePanel
- skal spesialisere JPanel
- skal inneholde den indre klassen TheMouseListener som spesialiserer MouseAdapter.
- skal overlevere en instans av TheMouseListener til hver instans av ColoredPanel.
- skal finne på en farge til hver instans av ColoredPanel og levere den til instansen.
- skal ha ansvar for å reagere når spilleren klikker på en farge.
*/

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel {

    private int possiblePicks = 0; // Holder tallet for hvor mange mulige rette svar som finnes i et enkelt spill
    private int correctPicks = 0; // Holder tallet for hvor mange rette valg man har gjort et spill
    private ColoredPanel[] coloredPanelArray = new ColoredPanel[9]; // et array som holder de 9 fargede panelene
    private JPanel topPanel = new ColoredPanel(null, Color.LIGHT_GRAY); // Panelet på toppen som viser hvilken farge som skal huskes ("null" som første argument for å ikke få med en mouseListener)
    private Color topPanelColor; // Fargen på topp-panelet
    private JLabel messageLabel = new JLabel(""); // en label som viser om man har vunnet eller ikke

    GamePanel() { // Konstruktøren til spillpanelet
        setLayout(new BorderLayout(0,4)); // Setter en borderlayout
        add (topPanel, BorderLayout.NORTH); // legger topp-panelet på toppen
        topPanel.add(messageLabel); // plasserer tekst-labelen på topp-panelet
        JPanel gridPanel = new JPanel(new GridLayout(3, 3, 2, 2)); // oppretter et panel med grid-layout som skal holde på de 9 fargede panelene
        add(gridPanel, BorderLayout.CENTER); // legger gridpanelet i midten (havner på bunn)

        for (int i = 0; i < 9; i++ ) { // fyller gridpanelet med 9 fargede paneler
            Color panelColor = randomPanelColor(); // variablen "panelcolor" får en tilfeldig farge av metoden "randomPanelColor()
            coloredPanelArray[i] = new ColoredPanel(new TheMouseListener(), panelColor); // oppretter farget panel
            gridPanel.add(coloredPanelArray[i]); // legger til farget panel i gridPanel
        }
    }

    Color randomPanelColor() { // metode som returnerer en av tre farger, tilfeldig valgt
        Random r = new Random();
        Color[] colorArray = {Color.ORANGE, Color.GREEN, Color.MAGENTA};
        int colorArrayIndex = r.nextInt(colorArray.length);
        return colorArray[colorArrayIndex];
    }

    ColoredPanel[] getColoredPanelArray() { // returnerer arrayet som inneholder de 9 fargede panelene
        return this.coloredPanelArray;
    }

    int getPossiblePicks() { // returnerer tallet for hvor mange mulige rette svar som finnes i et enkelt spill
        return this.possiblePicks;
    }

    void setPossiblePicks(int possiblePicks) { // oppdaterer antall mulige riktige farger
        this.possiblePicks = possiblePicks;
    }

    JPanel getTopPanel() { // returnerer topPanel
        return this.topPanel;
    }

    Color getTopPanelColor() { // returnerer fargen på topPanel
        return this.topPanelColor;
    }

    void setTopPanelColor(Color topPanelColor) { // setter fargen på topPanel
        this.topPanelColor = topPanelColor;
    }

    class TheMouseListener extends MouseAdapter { // mouseListener

        public void mousePressed(MouseEvent e) { // mousePressed fungerer bedre enn mouseClicked

            if(topPanel.getBackground() != Color.LIGHT_GRAY) { // sørger for at mouseListener ikke fungerer hvis topPanel er grått

                ColoredPanel source = (ColoredPanel) e.getComponent(); // setter "source" til å inneholde det fargede panelet som har blitt klikket på
                source.setAssignedColor(); // endrer fargen på det fargede panelet fra grått til opprinnelig farge

                if (source.getAssignedColor() != topPanelColor) { // sjekker om man har klikket på feil farge
                    messageLabel.setText("Game Over!"); // setter en tekst på det øverste panelet
                    for (int i = 0; i < 9; i++) { // setter alle panelene til opprinnelig farge
                       coloredPanelArray[i].setAssignedColor();
                    }
                }

                if (source.getAssignedColor() == topPanelColor) { // sjekker om man har klikket på riktig farge og kjører koden under hvis det har skjedd
                    correctPicks++; // oppdaterer tallet for hvor mange riktige valg som er gjort
                    source.removeMouseListener(this); // fjerner muselytteren fra panelet
                    if(correctPicks == possiblePicks) { // sjekker om man har valgt alle de ritige panelene og går i såfall videre til koden under
                        messageLabel.setText("You Won!"); // setter en tekst på det øverste panelet
                        for (int i = 0; i < 9; i++) { // setter alle panelene til opprinnelig farge
                            coloredPanelArray[i].setAssignedColor();
                        }
                    }
                }
            }
        }
    }
}