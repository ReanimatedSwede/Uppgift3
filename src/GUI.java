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

    public ArrayList<JButton> nyttSpel() {
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
        return buttons;
    }

    public int findEmptyButton(ArrayList<JButton> buttons) {
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().equals(" ")){
                return i;
            }
        }
        return -1;
    }

    public void swapButtonsInArray(ArrayList<JButton> buttons, int index1, int index2) {
        JButton temp = buttons.get(index1);
        JButton button2 = buttons.get(index2);
        String temp1 = buttons.get(index1).getText();
        buttons.get(index1).setText(buttons.get(index2).getText());
        buttons.get(index2).setText(temp1);

        gridPanel.revalidate();
        gridPanel.repaint();
    }

    public void addMouseListeners(ArrayList<JButton> buttons){
        int index = findEmptyButton(buttons);
        if(index > 0){
            buttons.get(index+4).addMouseListener(new AdapterMouse(buttons.get(index+4), this, buttons));
            buttons.get(index+1).addMouseListener(new AdapterMouse(buttons.get(index+1), this, buttons));
            buttons.get(index-1).addMouseListener(new AdapterMouse(buttons.get(index-1), this, buttons));
            if (index > 4){
                buttons.get(index+4).addMouseListener(new AdapterMouse(buttons.get(index+4), this, buttons));
                buttons.get(index+1).addMouseListener(new AdapterMouse(buttons.get(index+1), this, buttons));
                buttons.get(index-1).addMouseListener(new AdapterMouse(buttons.get(index-1), this, buttons));
                buttons.get(index-4).addMouseListener(new AdapterMouse(buttons.get(index-4), this, buttons));
            }
        }
    }

    GUI() {
        this.add(jp);
        jp.add(northPanel, BorderLayout.NORTH);
        jp.add(southPanel, BorderLayout.SOUTH);
        northPanel.add(nyttSpel);
        southPanel.add(gridPanel);
        ArrayList<JButton> buttons = skapaLista();
        skapaKnappar(buttons);
        findEmptyButton(buttons);

        nyttSpel.addMouseListener(new AdapterMouse(nyttSpel, this, buttons));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
