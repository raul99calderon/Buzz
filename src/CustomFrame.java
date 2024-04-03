import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CustomFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final int SCREEN_WIDTH = 1920/2, SCREEN_HEIGHT = 1080/2;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomFrame frame = new CustomFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CustomFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        JLabel background = new JLabel();
        background.setLayout(new BorderLayout());

        try {
            BufferedImage originalImage = ImageIO.read(new File("C:\\buzz\\background.png"));
            Image resizedImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            background.setIcon(new ImageIcon(resizedImage));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        
        JPanel backgroundPanel = new JPanel(new BorderLayout());
        backgroundPanel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        backgroundPanel.add(background);
        
        JLabel menuLabel = new JLabel();
        try {
            BufferedImage menuImage = ImageIO.read(new File("C:\\buzz\\img2.png")); // Ajusta la ruta de la imagen overlay
            Image resizedMenuImage = menuImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            menuLabel.setIcon(new ImageIcon(resizedMenuImage));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Dimension menuSize = menuLabel.getPreferredSize();
        menuLabel.setBounds((SCREEN_WIDTH - menuSize.width) / 2, (SCREEN_HEIGHT - menuSize.height) / 2, menuSize.width, menuSize.height);
        
        layeredPane.add(backgroundPanel, Integer.valueOf(0));
        layeredPane.add(menuLabel, Integer.valueOf(1));
        
        setContentPane(layeredPane);
    }
}
