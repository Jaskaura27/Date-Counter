import java.awt.Component;
import javax.swing.JFrame;

/**
 * Create a JFrame and add dataCounterPanel to it.
 */
public class DateFrameViewer
{
    /**
     * Width of the frame.
     */
    public static final int FRAME_WIDTH = 900;

    /**
     * Heigth of the frame.
     */
    public static final int FRAME_HEIGHT = 200;
    
    public static void main(final String[] array) {
        final JFrame frame = new JFrame();
        frame.setSize(900, 200);
        frame.setDefaultCloseOperation(3);
        frame.setTitle("Date Counter");
        DateCounterPanel dataCounterPanel = new DateCounterPanel();
        frame.add(dataCounterPanel);
        frame.setVisible(true);
    }
}
