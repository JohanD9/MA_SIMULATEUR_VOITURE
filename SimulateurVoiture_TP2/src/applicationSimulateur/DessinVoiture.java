package src.applicationSimulateur;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import domaineConduite.Direction;
import domaineConduite.Voiture;

public class DessinVoiture extends JFrame{

	public static final int TailleFenetreEnPixels = 500;
	
	private Voiture voiture;
	private int xPixelVoiture;

	public DessinVoiture(Voiture voitureParam) {
		super();
		this.setTitle("Simulateur de Voiture");
		this.setSize(TailleFenetreEnPixels, TailleFenetreEnPixels);
		this.setVisible(true);
		this.xPixelVoiture = 0;
		this.setFocusable(true);
		this.voiture = voitureParam;
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
					voiture.setDirection(Direction.HAUT);
					voiture.modifierVitesseMetreSeconde(Direction.HAUT);
					break;

				case KeyEvent.VK_DOWN:
					voiture.setDirection(Direction.BAS);
					voiture.modifierVitesseMetreSeconde(Direction.BAS);
					break;
					
				case KeyEvent.VK_RIGHT:
					voiture.setDirection(Direction.DROITE);
					voiture.modifierVitesseMetreSeconde(Direction.DROITE);
					break;
					
				case KeyEvent.VK_LEFT:
					voiture.setDirection(Direction.GAUCHE);
					voiture.modifierVitesseMetreSeconde(Direction.GAUCHE);
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
