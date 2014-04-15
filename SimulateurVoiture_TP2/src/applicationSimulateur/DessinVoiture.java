package applicationSimulateur;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class DessinVoiture extends JFrame {

	public static final int TailleFenetreEnPixels = 500;

	private int xPixelVoiture;

	public DessinVoiture() {
		super();
		this.setTitle("Simulateur de Voiture");
		this.setSize(TailleFenetreEnPixels, TailleFenetreEnPixels);
		this.setVisible(true);
		this.xPixelVoiture = 0;
		this.setFocusable(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					System.out.println("HAUT");
					break;

				case KeyEvent.VK_DOWN:
					System.out.println("BAS");
					break;

				case KeyEvent.VK_RIGHT:
					System.out.println("DROITE");
					break;

				case KeyEvent.VK_LEFT:
					System.out.println("GAUCHE");
					break;
				}

			}
		});
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		dessinerVoiture(this.xPixelVoiture, graphics);

	}

	public void dessinerVoiture(int xPixelVoiture, Graphics graphics) {
		graphics.fillRect(xPixelVoiture, 200, 20, 20);

	}

	public void setXPixelVoiture(int xPixelVoiture) {
		this.xPixelVoiture = xPixelVoiture;
	}

}
