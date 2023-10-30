import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AdapterMouse extends MouseAdapter {
    private GUI gui;
    private JButton button;
    private ArrayList<JButton> buttons;



    public AdapterMouse(JButton button, GUI gui, ArrayList<JButton> buttons) {
        this.button = button;
        this.gui = gui;
        this.buttons = buttons;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int index = buttons.indexOf(button);

        if(button.getText().equals("New game")) {
            this.gui.newGame();
        } else{
            gui.swapButtonsInArray(buttons, gui.findEmptyButton(buttons), index);
        }
    }

}
