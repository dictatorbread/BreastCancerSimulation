import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Simulator extends JFrame implements ActionListener {
    Rendering renderingPanel;
    Input dataPanel;
    String [] startString = {"Right Breast", "N/A", "Left Breast"};
    String [] endString = {"N/A", "Left Leg", "Right Leg"};
    JLabel startLabel = new JLabel ("enter start position here");
    JLabel endLabel = new JLabel ("enter end position here");
    JComboBox start = new JComboBox(startString);
    JComboBox end = new JComboBox(endString);
    JButton btnSubmit = new JButton("Submit");
    JLabel titleLabel = new JLabel("Enter Patient Data");
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {

            Simulator simulation = new Simulator();
            //simulation.pack();
            simulation.setVisible(true);
            //simulation.panel.drawsmth();
            //simulation.panel.paintComponent(g);
            simulation.repaint();
        });

    }

    public Simulator() {
        //dataPanel = new Input();
        //getContentPane().add(dataPanel);
        //panel.start();
        //dataPanel.initializePanel();
        setTitle("Breast Cancer Met Simulator");
        setSize(800, 600);
        setBackground(Color.lightGray);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initializePanel();
    }
    public void initializePanel(){
        setLayout(null);
        Insets insets = getInsets();
        Dimension size = start.getPreferredSize();
        start.setBounds(750 + insets.right, 45 + insets.top, size.width, size.height);
        size = startLabel.getPreferredSize();
        startLabel.setBounds(590 + insets.right, 45 + insets.top, size.width, size.height);

        size = end.getPreferredSize();
        end.setBounds(750 + insets.right, 80 + insets.top, size.width, size.height);
        size = endLabel.getPreferredSize();
        endLabel.setBounds(590 + insets.left, 80 + insets.top, size.width, size.height);

        size = btnSubmit.getPreferredSize();
        btnSubmit.setBounds(670 + insets.right, 110 + insets.bottom, size.width, size.height);

        size = titleLabel.getPreferredSize();
        titleLabel.setBounds(650 + insets.right, 20 + insets.bottom, size.width, size.height);

        start.setSelectedIndex(0);
        start.setSelectedIndex(0);
        btnSubmit.addActionListener(this);
        add(startLabel);
        add(start);
        add(endLabel);
        add(end);
        add(btnSubmit);
        add(titleLabel);
        //JComboBox start = new JComboBox(startString);
        start.setSelectedIndex(0);
        //start.addActionListener(this);
        //add(startLabel2);
        add(start);
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        System.out.println(e.getSource().toString());
        String startOption = (String) start.getSelectedItem();
        String endOption = (String) end.getSelectedItem();
        System.out.println(startOption);
        System.out.println(endOption);
        /*renderingPanel = new Rendering(this,"/Users/Saumya/Desktop/Screen Shot 2020-12-22 at 10.48.52 PM.png", startOption, endOption);
        renderingPanel.drawsmth();
        add(renderingPanel);
        validate();
        setSize(1300, 1100);*/

        //Rendering Media Player
        URL mediaUrl=null;
        File file = new File("/Users/Saumya/Desktop/DMM009282-Video1.mp4");
        try {
            mediaUrl = file.toURL();
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        }
        MediaPlayer mediaPanel = new MediaPlayer( mediaUrl );
        add( mediaPanel );
        setSize( 800, 700 ); // set the size of the player
        setLocationRelativeTo(null);

        setVisible(true);
    }

}