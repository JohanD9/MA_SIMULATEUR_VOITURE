package applicationSimulateur;

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
	private int yPixelVoiture;
	
	public DessinVoiture(Voiture voitureParam) {
		super();
		this.setTitle("Simulateur de Voiture");
		this.setSize(TailleFenetreEnPixels, TailleFenetreEnPixels);
		this.setVisible(true);
		this.xPixelVoiture = voitureParam.getCoordXEnMetres();
		this.yPixelVoiture = voitureParam.getCoordYEnMetres();
		this.setFocusable(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);
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
				Direction dirPrecedente = DessinVoiture.this.voiture.getDirection();
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
						voiture.setDirection(Direction.HAUT);
					break;

				case KeyEvent.VK_DOWN:
					voiture.setDirection(Direction.BAS);
					break;
					
				case KeyEvent.VK_RIGHT:
					voiture.setDirection(Direction.DROITE);
					break;
					
				case KeyEvent.VK_LEFT:
					voiture.setDirection(Direction.GAUCHE);
					break;
				}
				if (dirPrecedente!=DessinVoiture.this.voiture.getDirection()){
					DessinVoiture.this.voiture.avancerEnFonctionDeLaVitesse();
				}
			}
		});
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		dessinerVoiture(this.xPixelVoiture, this.yPixelVoiture, graphics);

	}

	public void dessinerVoiture(int xPixelVoiture, int yPixelVoiture, Graphics graphics) {
		graphics.fillRect(xPixelVoiture, yPixelVoiture, this.voiture.getLongueurVoiture(), this.voiture.getLongueurVoiture());
	}

	public void setXPixelVoiture(int xPixelVoiture) {
		this.xPixelVoiture = xPixelVoiture;
	}
	
	public void setYPixelVoiture(int yPixelVoiture) {
		this.yPixelVoiture = yPixelVoiture;
	}

}
