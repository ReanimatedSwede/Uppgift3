import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {

    JPanel jp = new JPanel(new BorderLayout());
    JPanel gridPanel = new JPanel(new GridLayout(4, 4));
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton button10 = new JButton("10");
    JButton button11 = new JButton("11");
    JButton button12 = new JButton("12");
    JButton button13 = new JButton("13");
    JButton button14 = new JButton("14");
    JButton button15 = new JButton("15");
    JButton button16 = new JButton(" ");

    GUI(){
        this.add(jp);
        jp.add(gridPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
