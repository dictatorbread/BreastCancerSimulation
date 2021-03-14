import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TAdapter implements KeyListener {
    @Override
    public void keyPressed(KeyEvent e) {
        //when space bar is pressed the simulation is played or paused
        System.out.println("worked");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //
        System.out.println("worked");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //for when patient data is entered into system
        System.out.println("worked");
    }
}
