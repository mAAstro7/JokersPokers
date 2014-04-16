package JokersPokers.Kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author vujo@
 */

    public class Kayttoliittyma implements Runnable {

        private JFrame frame;

        @Override
        public void run() {
        frame = new JFrame("");
        frame.setPreferredSize(new Dimension(900, 750));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);      
        frame.pack();
        frame.setVisible(true);
        
        }
    }


