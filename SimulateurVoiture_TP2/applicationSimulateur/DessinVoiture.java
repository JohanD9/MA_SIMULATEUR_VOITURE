package applicationSimulateur;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import domaineConduite.Direction;
import domaineConduite.Voiture;

public class DessinVoiture extends JFrame {

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
				Direction dirPrecedente = DessinVoiture.this.voiture
						.getDirection();
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					voiture.setVitesseMetreParSecondes(voiture
							.getVitesseMetreParSecondes() + 10);
					break;

				case KeyEvent.VK_DOWN:
					if (voiture.getVitesseMetreParSecondes() > 0) {
						voiture.setVitesseMetreParSecondes(voiture
								.getVitesseMetreParSecondes() - 10);
					}
					break;

				case KeyEvent.VK_RIGHT:
					voiture.setDirection(tournerADroite(voiture.getDirection()));
					break;

				case KeyEvent.VK_LEFT:
					voiture.setDirection(tournerAGauche(voiture.getDirection()));
					break;
				}
				if (dirPrecedente != DessinVoiture.this.voiture.getDirection()) {
					DessinVoiture.this.voiture.avancerEnFonctionDeLaVitesse();
				}
			}

			public Direction tournerADroite(Direction dir) {
				switch (dir) {
				case HAUT:
					return Direction.DROITE;

				case BAS:
					return Direction.GAUCHE;

				case GAUCHE:
					return Direction.HAUT;

				case DROITE:
					return Direction.BAS;
				default:
					return Direction.DROITE;

				}
			}
			
			public Direction tournerAGauche(Direction dir) {
				switch (dir) {
				case HAUT:
					return Direction.GAUCHE;

				case BAS:
					return Direction.DROITE;

				case GAUCHE:
					return Direction.BAS;

				case DROITE:
					return Direction.HAUT;
				default:
					return Direction.DROITE;

				}
			}
		});
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		dessinerVoiture(this.xPixelVoiture, this.yPixelVoiture, graphics);

	}

	public void dessinerVoiture(int xPixelVoiture, int yPixelVoiture,
			Graphics graphics) {
		graphics.fillRect(xPixelVoiture, yPixelVoiture,
				this.voiture.getLongueurVoiture(),
				this.voiture.getLongueurVoiture());
	}

	public void setXPixelVoiture(int xPixelVoiture) {
		this.xPixelVoiture = xPixelVoiture;
	}

	public void setYPixelVoiture(int yPixelVoiture) {
		this.yPixelVoiture = yPixelVoiture;
	}

}
