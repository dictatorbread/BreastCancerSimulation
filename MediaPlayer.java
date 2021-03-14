import com.googlecode.javacv.FFmpegFrameGrabber;
import com.googlecode.javacv.FFmpegFrameRecorder;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.FrameRecorder;
import com.googlecode.javacv.cpp.opencv_core;

import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.swing.*;

public class MediaPlayer extends JPanel {
    public MediaPlayer(URL mediauUrl) {
        setLayout(new BorderLayout());
        try {
            //FFmpegFrameGrabber grabber = new FFmpegFrameGrabber("/Users/Saumya/Desktop/DMM009282-Video1.mp4");
            //grabber.start();
            opencv_core.IplImage captured_frame = null;
            FrameRecorder recorder = null;
            Frame
            recorder = new FFmpegFrameRecorder("/Users/Saumya/Desktop/MICRO.mp4", 300, 300);
            //recorder.setVideoCodec(13);
            recorder.setFrameRate(30);
            recorder.setFormat("mp4");
            //recorder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        URL mediaUrl=null;
        File file = new File("src/media/Jellyfish.mpg");
        try {
            mediaUrl = file.toURL();
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        }
        //JFrame mediaTest = new JFrame( "Movie Player" );
        //mediaTest.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        MediaPlayer mediaPanel = new MediaPlayer( mediaUrl );
        /*mediaTest.add( mediaPanel );
        mediaTest.setSize( 800, 700 ); // set the size of the player
        mediaTest.setLocationRelativeTo(null);
        mediaTest.setVisible( true );*/
    }

}
