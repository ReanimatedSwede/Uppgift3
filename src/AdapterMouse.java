import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class AdapterMouse extends MouseAdapter {
    private GUI gui;
    private JButton j;

    private ArrayList<JButton> buttons;

    public AdapterMouse(JButton j, GUI gui, ArrayList<JButton> buttons) {
        this.j = j;
        this.gui = gui;
        this.buttons = buttons;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int index = buttons.indexOf(j);

        if(j.getText().equals("Nytt spel")) {
            this.gui.nyttSpel();
        } else{
            gui.swapButtonsInArray(buttons, gui.findEmptyButton(buttons), index);
        }
    }

}
