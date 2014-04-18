package applicationSimulateur;

import java.util.Observable;
import java.util.Observer;

import domaineConduite.Direction;
import domaineConduite.Voiture;

public class VueVoiture implements Observer {
	private Voiture voiture;
	private DessinVoiture ihm;

	public VueVoiture() {
		this.voiture = null;
	}

	public VueVoiture(Voiture voiture) {
		this.voiture = voiture;
		this.voiture.addObserver(this);
	}

	public VueVoiture(Voiture voiture, DessinVoiture ihm) {
		this.voiture = voiture;
		this.voiture.addObserver(this);
		this.ihm = ihm;
	}

	public int transformerMetrePixel(int coordonneeEnMetre) {

		int ratioDomaineFenetre = Voiture.tailleDomaine
				/ DessinVoiture.TailleFenetreEnPixels;

		int coordonneeEnPixels = coordonneeEnMetre / ratioDomaineFenetre;

		return coordonneeEnPixels;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (this.voiture.getDirection().equals(Direction.DROITE)
				|| (this.voiture.getDirection().equals(Direction.GAUCHE))) {
			int xVoiture = this.voiture.getCoordXEnMetres();
			int xPixelVoiture = this.transformerMetrePixel(xVoiture);
			ihm.setXPixelVoiture(xPixelVoiture);
		}
		if (this.voiture.getDirection().equals(Direction.HAUT)
				|| (this.voiture.getDirection().equals(Direction.BAS))) {
			int yVoiture = this.voiture.getCoordYEnMetres();
			int yPixelVoiture = this.transformerMetrePixel(yVoiture);
			ihm.setYPixelVoiture(yPixelVoiture);
		}
		ihm.repaint();

	}

}
