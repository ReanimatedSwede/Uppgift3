import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class AdapterMouse extends MouseListenerClass{
    JButton jb = new JButton();
    AdapterMouse(JButton jb){
        this.jb = jb;
    }
    @Override
    public void mouseClicked(MouseEvent e) {



    }
}
