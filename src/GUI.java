import javax.swing.*;
import java.awt.*;
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
            button.addMouseListener(new AdapterMouse(button, this, buttons));
        }
    }

    public ArrayList<JButton> nyttSpel() {
        ArrayList<JButton> buttons = skapaLista();
        gridPanel.removeAll();
        Collections.shuffle(buttons);
        for (JButton button : buttons) {
            gridPanel.add(button);
        }
        skapaKnappar(buttons);
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

    public void printListToGridPanel(ArrayList<JButton> buttons){
        gridPanel.removeAll();
        for (JButton button : buttons) {
            gridPanel.add(button);
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    public void swapButtonsInArray(ArrayList<JButton> buttons, int index1, int index2) {
        if (checkIfSwapIsLegal(buttons, index2)) {

            Collections.swap(buttons, index1, index2);

            printListToGridPanel(buttons);
        }
        Collections.swap(buttons, index1, index2);
        printListToGridPanel(buttons);
        LogicClass logic = new LogicClass();
        logic.win(buttons);
    }

    public boolean checkIfSwapIsLegal(ArrayList<JButton> buttons, int index2){
        int emptyButton = findEmptyButton(buttons);
        int clickedButton = index2;

        int emptyRow = emptyButton / 4;
        int emptyCol = emptyButton % 4;

        int clickedRow = clickedButton / 4;
        int clickedCol = clickedButton % 4;

        if( (emptyRow - clickedRow ) >= -1 && (emptyRow - clickedRow) <=1
        && (emptyCol - clickedCol ) >= -1 && (emptyCol - clickedCol) <=1 )
        {
            if ((emptyRow - clickedRow) + (emptyCol - clickedCol) == 1 || (emptyRow - clickedRow) + (emptyCol - clickedCol) == -1){

            return true;
            }
        }

        else
        {
            return false;
        }
        return false;
    }

    GUI() {
        this.add(jp);
        jp.add(northPanel, BorderLayout.NORTH);
        jp.add(southPanel, BorderLayout.SOUTH);
        northPanel.add(nyttSpel);
        southPanel.add(gridPanel);
        ArrayList<JButton> buttons = skapaLista();
        skapaKnappar(buttons);




        nyttSpel.addMouseListener(new AdapterMouse(nyttSpel, this, buttons));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
