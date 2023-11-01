import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class LogicClass {

    private final ArrayList<JButton> checkList = createCheckList();

    private final GUI gui;

    LogicClass(GUI gui){
        this.gui = gui;
    } //tar in instansen av det startade gui:t

    public void win(ArrayList <JButton> buttons){ //Metod för att avgöra vinst. Jämför två listor mot varandra och kontrollerar
        boolean isWinner = true;
        for (int i = 0; i < buttons.size(); i++) {
            JButton buttonInList = buttons.get(i);
            JButton buttonInChecklist = createCheckList().get(i);
            if (!buttonInList.getText().equals(buttonInChecklist.getText())) {
                isWinner = false;
                break;
            }
        }
        if (isWinner) { // Skriver ut om bägge listor matchar varandra
            JOptionPane.showMessageDialog(null, "Congratulations you've won!");
        }
    }
    public ArrayList<JButton> createCheckList(){ //Skapar en checklista som spelet kontrollerar mot för vinst.
        ArrayList<JButton> checkList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            JButton button;
            if (i == 15) {
                button = new JButton(" ");
            } else {
                button = new JButton("" + (i+1));
            }
            checkList.add(button);
        }
        return checkList;
    }

    public boolean checkIfSwapIsLegal(ArrayList<JButton> buttons, int index2){ //Metod för att kontrollera om flytten är godkänd.

        int emptyButton = gui.findEmptyButton(buttons); //Tar in värdet för vad index är för  den tomma knappen som  befinner sig på gridpanel.
        int clickedButton = index2; //tar in värdet för vilken knapp man klickat på.

        int emptyRow = emptyButton / 4; //Tar reda på vilken tom rad
        int emptyCol = emptyButton % 4; // tar reda på vilken tom kolumn

        int clickedRow = clickedButton / 4; //Tar reda på vilken klickad rad
        int clickedCol = clickedButton % 4; //Tar reda på vilken klickad kolumn

        if( (emptyRow - clickedRow ) >= -1 && (emptyRow - clickedRow) <=1
                && (emptyCol - clickedCol ) >= -1 && (emptyCol - clickedCol) <=1 ) //Jämför så att värdena inte är större än 1 eller mindre än -1
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





}
