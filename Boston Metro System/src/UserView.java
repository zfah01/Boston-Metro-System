import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    JLabel labelTwo = new JLabel("Enter From Station:");
    JLabel labelThree = new JLabel("Enter To Station:");
    JTextArea Route = new JTextArea("");
    JFormattedTextField textArea = new JFormattedTextField();
    JFormattedTextField textAreaTwo = new JFormattedTextField();
    JFormattedTextField textAreaThree = new JFormattedTextField();
    JFormattedTextField textAreaFour = new JFormattedTextField();

    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {


        String Nodes = textArea.getText();
        Route.append(Nodes);

        }
    });

    jpanel.add(labelTwo);
    jpanel.add(textArea);
    jpanel.add(labelThree);
    jpanel.add(textAreaTwo);
    jpanel.add(button);
    jpanel.add(Route);


    jpanel.add(buttonTwo);
    jpanel.add(textAreaThree);

    jpanel.add(buttonThree);
    jpanel.add(textAreaFour);

    jpanel.add(buttonFour);
}

 public static void main(String[] args) {
    panel();
}



}