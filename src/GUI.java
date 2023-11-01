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

    LogicClass logic = new LogicClass(this);

    public void createButtons(ArrayList<JButton> buttons) { //Lägger till de skapade knapparna i gridpanelen
        for (JButton button : buttons) {
            gridPanel.add(button);
            button.addMouseListener(new AdapterMouse(button, this, buttons)); //Lägger till lyssnare för varje knapp
        }
    }

    public ArrayList<JButton> newGame() {  //newGame-metoden.
        ArrayList<JButton> buttons = createList(); //Metod för knapplista
        gridPanel.removeAll(); //gridPanel.Remove - tar bort alla element i panelen
        Collections.shuffle(buttons); //Tar listan och kastar om dem med .shuffle metoden i Collections
        for (JButton button : buttons) { //Ritar sedan ut den på panelen
            gridPanel.add(button);
        }
        createButtons(buttons); //Skapar lyssnare för varje knapp
        gridPanel.revalidate(); // Revaliderar panlen
        gridPanel.repaint();  //Ritar ut den på nytt, nu omkastad.
        return buttons;
    }

    public void printListToGridPanel(ArrayList<JButton> buttons) { //ritar om gridpanel varje gång en knapp flyttas i spelet
        gridPanel.removeAll();
        for (JButton button : buttons) {
            gridPanel.add(button);
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    public ArrayList<JButton> createList() { //Skapar en lista med alla knappar.
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

    public int findEmptyButton(ArrayList<JButton> buttons) { //metoden går igenom listan och letar efter index för den tomma knappen.
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().equals(" ")) {
                return i;
            }
        }
        return -1;
    }

    public void swapButtonsInArray(ArrayList<JButton> buttons, int index1, int index2) { // Tar in listan, index 1 (tomma knappen), index2 (klickade knappen)

      if (logic.checkIfSwapIsLegal(buttons, index2)) {     //Kör en check om flytten är godkänd i LogicClass

           Collections.swap(buttons, index1, index2); //Byter plats på knapparna
           printListToGridPanel(buttons); // Ritar om gridpanelen
        }

       /*Collections.swap(buttons, index1, index2);
        printListToGridPanel(buttons);*/ // test för vinstmetoden
        logic.win(buttons); //Metod för att kontrollera om knapparna är i ordning för att avgöra vinst.
    }


    GUI() { //Skapar upp panelerna och knapparna för den grafiska delen av spelet vid uppstart av programmet.
        this.add(jp);
        jp.add(northPanel, BorderLayout.NORTH);
        jp.add(southPanel, BorderLayout.SOUTH);
        northPanel.add(newGameButton);
        southPanel.add(gridPanel);
        ArrayList<JButton> buttons = createList();  //Skapar listan med knappar för första gången
        createButtons(buttons); //Ritar ut listan på gridpanelen för första gången.

        newGameButton.addMouseListener(new AdapterMouse(newGameButton, this, buttons)); // kopplar lyssnare till knappen "New game", Skickar med knappen newGamebutton, knapplistan samt instansen av GUI som är skapat
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        GUI g = new GUI();
    }
}
