import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class LogicClass {

    private final ArrayList<JButton> checkList = createCheckList();

    private GUI gui;

    LogicClass(GUI gui){
        this.gui = gui;
    }

    public void win(ArrayList <JButton> buttons){
        boolean isWinner = true;
        for (int i = 0; i < buttons.size(); i++) {
            JButton buttonInList = buttons.get(i);
            JButton buttonInChecklist = createCheckList().get(i);
            if (!buttonInList.getText().equals(buttonInChecklist.getText())) {
                isWinner = false;
                break;
            }
        }
        if (isWinner) {
            JOptionPane.showMessageDialog(null, "Congratulations you've won!");
        }
    }
    public ArrayList<JButton> createCheckList(){
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

    public boolean checkIfSwapIsLegal(ArrayList<JButton> buttons, int index2){

        int emptyButton = gui.findEmptyButton(buttons);
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





}
