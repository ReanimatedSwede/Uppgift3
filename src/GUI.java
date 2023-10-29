import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class GUI extends JFrame {

    JPanel jp = new JPanel(new BorderLayout());

    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();

    JPanel gridPanel = new JPanel(new GridLayout(4, 4));


    JButton nyttSpel = new JButton("Nytt spel");


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

    public void nyttSpel() {
        /*ArrayList<JButton> buttons = new ArrayList<>();
        skapaLista();*/
        ArrayList<JButton> buttons = skapaLista();
        gridPanel.removeAll();
        Collections.shuffle(buttons);
        for (JButton button : buttons) {
            gridPanel.add(button);
        }
        gridPanel.revalidate();
        gridPanel.repaint();
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

        jp.add(northPanel, BorderLayout.NORTH);
        jp.add(southPanel, BorderLayout.SOUTH);
        northPanel.add(nyttSpel);
        southPanel.add(gridPanel);
        ArrayList<JButton> buttons = skapaLista();
        skapaKnappar(buttons);
        //findEmptyButton(buttons); används inte just nu

        nyttSpel.addMouseListener(new AdapterMouse(nyttSpel, this));


        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
