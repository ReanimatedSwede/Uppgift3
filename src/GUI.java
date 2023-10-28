import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class GUI extends JFrame {

    JPanel jp = new JPanel(new BorderLayout());
    JPanel gridPanel = new JPanel(new GridLayout(4, 4));
    JButton jb = new JButton();

    public void revalidate(ArrayList<JButton> buttons) {
        gridPanel.removeAll();
        for (JButton button : buttons) {
            gridPanel.add(button);
        }
        Collections.shuffle(buttons);
    }

    public void addMouseListeners(ArrayList<JButton> buttons){
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().equals(" ")){
                buttons.get(i-1).addMouseListener(new AdapterMouse(jb));
                buttons.get(i-4).addMouseListener(new AdapterMouse(jb));
                buttons.get(i+1).addMouseListener(new AdapterMouse(jb));
                buttons.get(i+4).addMouseListener(new AdapterMouse(jb));
            }
        }
    }

    public ArrayList<JButton> skapaLista() {
        ArrayList<JButton> buttons = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            JButton button;
            if (i == 0) {
                button = new JButton("");
            } else {
                button = new JButton("" + i);
            }
            buttons.add(button);
        }
        return buttons;
    }

    GUI() {
        this.add(jp);
        jp.add(gridPanel, BorderLayout.SOUTH);
        ArrayList<JButton> buttons = skapaLista();
        revalidate(buttons);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
