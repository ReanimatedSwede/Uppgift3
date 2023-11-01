import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AdapterMouse extends MouseAdapter {
    private GUI gui;
    private JButton button;
    private ArrayList<JButton> buttons;



    public AdapterMouse(JButton button, GUI gui, ArrayList<JButton> buttons) { //Tar in gui, knappen new game samt knapplistan.
        this.button = button;
        this.gui = gui;
        this.buttons = buttons;
    }

    @Override
    public void mouseClicked(MouseEvent e) { //Fångar vad som händer
        int index = buttons.indexOf(button); //Fångar klicket

        if(button.getText().equals("New game")) { //Om denna så startas ett nytt spel och listan kastas om och ritas ut på nytt.
            this.gui.newGame();
        } else{ //Annars körs metoderna för att flytta på knapparna
            gui.swapButtonsInArray(buttons, gui.findEmptyButton(buttons), index);
        }
    }

}
