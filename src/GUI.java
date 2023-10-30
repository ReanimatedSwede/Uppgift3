import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class GUI extends JFrame {

    private final JPanel jp = new JPanel(new BorderLayout());
    private final  JPanel northPanel = new JPanel();
    private final  JPanel southPanel = new JPanel();
    private final  JPanel gridPanel = new JPanel(new GridLayout(4, 4));
    private final  JButton newGameButton = new JButton("New game");

    private final  LogicClass logic = new LogicClass(this);

    public void createButtons(ArrayList<JButton> buttons) {
        for (JButton button : buttons) {
            gridPanel.add(button);
            button.addMouseListener(new AdapterMouse(button, this, buttons));
        }
    }

    public ArrayList<JButton> newGame() {
        ArrayList<JButton> buttons = createList();
        gridPanel.removeAll();
        Collections.shuffle(buttons);
        for (JButton button : buttons) {
            gridPanel.add(button);
        }
        createButtons(buttons);
        gridPanel.revalidate();
        gridPanel.repaint();
        return buttons;
    }

    public void printListToGridPanel(ArrayList<JButton> buttons) {
        gridPanel.removeAll();
        for (JButton button : buttons) {
            gridPanel.add(button);
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    public ArrayList<JButton> createList() {
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

    public int findEmptyButton(ArrayList<JButton> buttons) {
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().equals(" ")) {
                return i;
            }
        }
        return -1;
    }

    public void swapButtonsInArray(ArrayList<JButton> buttons, int index1, int index2) {

       if (logic.checkIfSwapIsLegal(buttons, index2)) {
            Collections.swap(buttons, index1, index2);
            printListToGridPanel(buttons);
        }

       /* Collections.swap(buttons, index1, index2);
        printListToGridPanel(buttons);  test för vinstmetoden  */
        logic.win(buttons);
    }


    GUI() {
        this.add(jp);
        jp.add(northPanel, BorderLayout.NORTH);
        jp.add(southPanel, BorderLayout.SOUTH);
        northPanel.add(newGameButton);
        southPanel.add(gridPanel);
        ArrayList<JButton> buttons = createList();
        createButtons(buttons);

        newGameButton.addMouseListener(new AdapterMouse(newGameButton, this, buttons));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        GUI g = new GUI();
    }
}
