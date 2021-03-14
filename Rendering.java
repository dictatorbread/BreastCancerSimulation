import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rendering extends JPanel implements ActionListener {
    Image backGroundImg;
    int xPos=400;
    int yPos=330;
    int xEPos;
    int yEPos;
    int rightSkeletonTop = 230;
    String startPosition;
    String endPosition;

    boolean whichSide = true;
    Timer timer=new Timer(1000, this);

    public Rendering(Simulator s, String imagePath, String startPosition, String endPosition) {
        setFocusable(true);
        setLayout(new BorderLayout());
        this.endPosition = endPosition;
        this.startPosition = startPosition;
        //addKeyListener(new TAdapter());
        if (startPosition.equalsIgnoreCase("Right Breast"))
            initializeDot(true);
        else
            initializeDot(false);
        this.loadImage(imagePath);
    }

    public void initializeDot(boolean rightBreastFlag){
        if (rightBreastFlag) {
            xPos=350;
            yPos=300;
        }
        else {
            xPos = 450;
            yPos = 300;
        }
        whichSide = rightBreastFlag;
        if (endPosition.equalsIgnoreCase("Right Leg")){
            xEPos=350;
            yEPos=700;
        }
        else {
            xEPos = 450;
            yEPos = 700;
        }
    }

    public void recalculate() {
        System.out.println("right skeleton top "+rightSkeletonTop+" which side "+whichSide);

        if (whichSide){
            if (rightSkeletonTop<yPos) {

                xPos = calculateNextXPosition();
                yPos = calculateNextYPosition();
            }
            else{
                timer.stop();
            }
        }
        else {
            if (rightSkeletonTop<yPos) {
                xPos = calculateNextXPosition();
                yPos = calculateNextYPosition();
            }
            else {
                timer.stop();
            }
        }
        System.out.println("xPos"+xPos+ " yPos" + yPos);
    }
    public int calculateNextXPosition(){

        if (startPosition.equalsIgnoreCase("Right Breast")&&endPosition.equalsIgnoreCase("Right Leg")){
            return xPos;
        }
        if (startPosition.equalsIgnoreCase("Right Breast")&&endPosition.equalsIgnoreCase("Left Leg")){
            if(xPos >= xEPos){
                return xPos;
            }
            else {
                return xPos+10;
            }
        }
        if (startPosition.equalsIgnoreCase("Left Breast")&&endPosition.equalsIgnoreCase("Left Leg")){
            return xPos;
        }
        if (startPosition.equalsIgnoreCase("Left Breast")&&endPosition.equalsIgnoreCase("Right Leg")){
            if(xPos >= xEPos){
                return xPos;
            }
            else {
                return xPos-10;
            }
        }
        return xPos=0;
    }

    public int calculateNextYPosition(){
        if (startPosition.equalsIgnoreCase("Right Breast")&&endPosition.equalsIgnoreCase("Right Leg")){
            if(yPos >= yEPos){
                return yPos;
            }
            else {
                return yPos + 40;
            }
        }
        if (startPosition.equalsIgnoreCase("Right Breast")&&endPosition.equalsIgnoreCase("Left Leg")){
            if(yPos >= yEPos){
                return yPos;
            }
            else {
                return yPos + 40;
            }
        }
        if (startPosition.equalsIgnoreCase("Left Breast")&&endPosition.equalsIgnoreCase("Left Leg")){
            if(yPos >= yEPos){
                return yPos;
            }
            else {
                return yPos + 40;
            }
        }
        if (startPosition.equalsIgnoreCase("Left Breast")&&endPosition.equalsIgnoreCase("Right Leg")){
            if(yPos >= yEPos){
                return yPos;
            }
            else {
                return yPos + 40;
            }
        }
        return yPos=0;
    }
    public void drawsmth() {
        JLabel label1 = new JLabel("Initializing");
        setBackground(Color.darkGray);
        label1.setBounds(0,70,155,25);
        this.add(label1);
        timer.start();
    }
    public void paintComponent(Graphics g) {
        g.drawImage(backGroundImg, 0, 0, null);
        Dimension d = getSize();
        int x = xPos;
        int y = yPos;
        g.setColor(Color.red);
        g.fillOval(x,y,10,10);
    }

    public void loadImage(String fileName) {
        backGroundImg = new ImageIcon(fileName).getImage();
        //this.img = img;
        Dimension size = new Dimension(backGroundImg.getWidth(null)+100, backGroundImg.getHeight(null));
        //Dimension size = new Dimension(450,450);
        //System.out.println("Width is "+backGroundImg.getWidth()+ " Height is "+backGroundImg.getHeight());
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println("worked");
        if(e.getSource()==timer){
            System.out.println("timer");
            recalculate();
            repaint();
        }
    }
}