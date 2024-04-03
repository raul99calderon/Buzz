import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class FrameController {
	private JFrame frame;
	private JTextArea textArea;
	private boolean isFullScreen;
	private Game game;
	private int numPlayers = 4;
	private KeyListener keyListenerAskPlayers;
	
	public FrameController(Game game) {
		this.game = game;
		isFullScreen = true;
    	frame = new JFrame();
    	frame.setSize(1920,1080);
    	textArea = new JTextArea();
    	textArea.setFocusable(false);
    	textArea.setBounds(0,0,frame.getWidth(),frame.getHeight());
        frame.add(textArea);
        frame.setLayout(null);
        frame.setVisible(true);
    	toggleFullScreen();
	}
	
	private void loadKeyListenerAskPlayers() {
		keyListenerAskPlayers = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == 27) {
					toggleFullScreen();
					System.out.println("ESCAPE");
				}
				else {
					Color color = game.getColorButtonPressedBuzzer1(keyCode);
					if (color != null) {
						System.out.println("A");
						switch(color) {
							case RED:
								System.out.println("B");
								
								textArea.setText("Continuando juego...");
								
								try {
									game.setNumPlayers(numPlayers);
									frame.removeKeyListener(keyListenerAskPlayers);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
								break;
							case BLUE:
								System.out.println("C");
								numPlayers++;
								updateNumPlayersText();
								break;
							case YELLOW:
								numPlayers--;
								System.out.println("D");
								updateNumPlayersText();
								break;
							default:
								break;
						}
					}
				}
				
			}
		};
	}
	
	private void updateNumPlayersText() {
		textArea.setText("Introduce núm de jugadores. Aumenta el número con el botón azul y disminúyelo con el botón amarillo. Confirma con el botón BUZZ\n\n " + Integer.toString(numPlayers));
	}
	
	public void askNumPlayers() {
		updateNumPlayersText();
		this.loadKeyListenerAskPlayers();
		
		frame.addKeyListener(keyListenerAskPlayers);
	}
	
	public void initFrame1() {

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
            	int keyCode = e.getKeyCode();
            	if (keyCode == 27) { // ESCAPE
            		toggleFullScreen();
            	}
            	else {
                	if(game.isBuzzersOpened()) {
                		game.processKeyPressedGame1(keyCode);
                	}
            	}
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //int keyCode = e.getKeyCode();
                //keysPressed.remove(keyCode);
                //System.out.println("Tecla liberada: " + KeyEvent.getKeyText(keyCode));
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // No es relevante para esta implementación
            }
        });
        frame.requestFocusInWindow();
	}
	
	public void appendText(String text) {
		textArea.append(text);
	}
	
	private void toggleFullScreen() {
		frame.dispose();
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
		if (!isFullScreen) {
            frame.setUndecorated(false);
            frame.setSize(600, 600);
            frame.setExtendedState(JFrame.NORMAL);   
		}
		else {
            frame.setUndecorated(true);
            frame.setSize(1920,1080);  
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
		frame.setVisible(true);
		isFullScreen = !isFullScreen; 
	}
}
