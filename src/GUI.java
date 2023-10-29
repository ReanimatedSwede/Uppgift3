import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class GUI extends JFrame {

    JPanel jp = new JPanel(new BorderLayout());
    JPanel gridPanel = new JPanel(new GridLayout(4, 4));
    JButton jb = new JButton();

    public ArrayList<JButton> skapaLista() {
        ArrayList<JButton> buttons = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            JButton button;
            if (i == 0) {
                button = new JButton(" ");
            } else {
                button = new JButton("" + i);
            }
            buttons.add(button);
        }
        return buttons;
    }
    public void skapaKnappar(ArrayList<JButton> buttons) {
        for (JButton button : buttons) {
            gridPanel.add(button);
        }
    }

    public void nyttSpel(ArrayList<JButton> buttons) {
        gridPanel.removeAll();
        Collections.shuffle(buttons);
        for (JButton button : buttons) {
            gridPanel.add(button);
        }
    }

    public JButton findEmptyButton(ArrayList<JButton> buttons) {
        for (JButton button : buttons) {
            if (button.getText().equals(" ")) {
                return button;
            }
        }
        return null;
    }

    public void swapButtonsInArray(ArrayList<JButton> buttons, int index1, int index2) {
        JButton temp = buttons.get(index1);
        JButton button2 = buttons.get(index2);
        buttons.set(index1, button2);
        buttons.set(index2, temp);
        //revalidate(buttons);
    }

    GUI() {
        this.add(jp);
        jp.add(gridPanel, BorderLayout.SOUTH);
        ArrayList<JButton> buttons = skapaLista();
        skapaKnappar(buttons);
        findEmptyButton(buttons);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
