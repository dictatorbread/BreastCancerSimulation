import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Input extends JPanel {
    String [] startString = {"N/A", "Left Breast", "Right Breast"};
    String [] endString = {"N/A", "Left Leg", "Right Leg"};
    JLabel startLabel = new JLabel ("enter start position here");
    JLabel endLabel = new JLabel ("enter end position here");
    JComboBox start = new JComboBox(startString);
    JComboBox end = new JComboBox(endString);
    public void initializePanel(){
        //setLayout(new BorderLayout(this, BorderLayout.CENTER));
        //setLayout(new BorderLayout(0, 1));
        start.setSelectedIndex(0);
        start.setSelectedIndex(0);
        //start.addActionListener(this);
        //start.addActionListener(this);
        add(startLabel);
        add(start);
        add(endLabel);
        add(end);
        //JLabel startLabel2 = new JLabel ("enter end position here");
        //JComboBox start = new JComboBox(startString);
        //start.setSelectedIndex(0);
        //start.addActionListener(this);
        //add(startLabel2);
        //add(start);

    }

    public void start() {
        //currentShapes.add(new Shape());

        //timer = new Timer(PERIOD_INTERVAL, new GameCycle());
        //timer.start();
    }
    public void paintComponent(Graphics g) {

    }
}