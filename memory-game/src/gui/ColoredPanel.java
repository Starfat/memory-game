/*
ColoredPanel
- skal spesialisere JPanel.
- skal huske sin tildelte farge
- skal ha metoder som kan sette bakgrunnen til nøytral (for eksempel lysegrå) og til den fargen den har fått tildelt.
- skal kunne ta i mot en MouseListener
*/

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class ColoredPanel extends JPanel  {

    private Color assignedColor; // holder på fargen til panelet

    ColoredPanel (MouseListener mouseListener, Color panelColor) { // konstruktøren til panelet. Tar MouseListener og Color som argument
        addMouseListener(mouseListener); // legger til muselytter
        setBackground(panelColor); // setter fargen
        assignedColor = panelColor; // kopierer fargen over til "assignedColor"
    }

    void setNeutralColor() { // metode for å sette panelfargen til grått
        setBackground(Color.LIGHT_GRAY);
    }

    Color getAssignedColor() { // metode for å hente ut fargen på panelet
        return this.assignedColor;
    }

    void setAssignedColor() { // metode for a sette fargen på panelet
        setBackground(assignedColor);
    }
}