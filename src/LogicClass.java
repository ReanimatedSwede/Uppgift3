import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class LogicClass {

    private final ArrayList<JButton> checkList = createCheckList();

    LogicClass(){}

    public void win(ArrayList <JButton> buttons){
        boolean isWinner = true;
        for (int i = 0; i < buttons.size(); i++) {
            JButton knappILista = buttons.get(i);
            JButton knappICheckList = createCheckList().get(i);
            if (!knappILista.getText().equals(knappICheckList.getText())) {
                isWinner = false;
                break;
            }
        }
        if (isWinner) {
            JOptionPane.showMessageDialog(null, "Grattis du vann!");
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
}
