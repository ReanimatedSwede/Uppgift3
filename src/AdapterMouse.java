import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class AdapterMouse extends MouseAdapter {
    GUI gui;
    JButton j;


    public AdapterMouse(JButton j, GUI gui) {
        this.j = j;
        this.gui = gui;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(j.getText().equals("Nytt spel"))
        {
            this.gui.nyttSpel();
        }
    }

}
