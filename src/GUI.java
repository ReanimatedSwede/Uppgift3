import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {

    JPanel jp = new JPanel(new BorderLayout());
    JPanel gridPanel = new JPanel(new GridLayout(4, 4));


    public void SkapaLista(){

        ArrayList<JButton> buttons = new ArrayList<>();



        for(int i = 0; i<16; i++){
            JButton button;
            if(i == 0){
                button = new JButton("");

            }
            else{
                button = new JButton("" + i);

            }
            buttons.add(button);
        }

        for (JButton button : buttons) {
            gridPanel.add(button);
        }


    }

    GUI(){
        this.add(jp);
        jp.add(gridPanel, BorderLayout.SOUTH);
        SkapaLista();


        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
