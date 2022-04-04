import javax.swing.*;
import java.awt.*;

public class UserView {

public static void panel() {

    JFrame jframe = new JFrame();
    JPanel jpanel = new JPanel();

    jframe.add(jpanel,BorderLayout.PAGE_START);
    jframe.setTitle("MetroSystem");
    jframe.setVisible(true);

    jframe.setSize(500,500);


    jpanel.setBorder(BorderFactory.createEmptyBorder(20, 30,20,30));
    jpanel.setLayout(new GridLayout(0, 1));
    JButton button = new JButton("Show Route");
    JButton buttonTwo = new JButton("Remove Station");
    JButton buttonThree = new JButton("Add Station");
    JButton buttonFour = new JButton("Clear");
    JLabel label = new JLabel("Route:");
    JLabel labelTwo = new JLabel("Enter From Station:");
    JLabel labelThree = new JLabel("Enter To Station:");

    JFormattedTextField textArea = new JFormattedTextField();
    JFormattedTextField textAreaTwo = new JFormattedTextField("here");
    JFormattedTextField textAreaThree = new JFormattedTextField("here");


    jpanel.add(labelTwo);
    jpanel.add(textArea);
    jpanel.add(labelThree);
    jpanel.add(textAreaTwo);
    jpanel.add(button);
    jpanel.add(label);
    jpanel.add(textAreaThree);

    jpanel.add(buttonTwo);
    jpanel.add(buttonThree);
    jpanel.add(buttonFour);
}

 public static void main(String[] args) {
    panel();
}



}