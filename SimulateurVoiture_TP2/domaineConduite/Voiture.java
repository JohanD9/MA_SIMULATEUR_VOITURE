package domaineConduite;

import java.util.Observable;
import domaineConduite.Direction;

public class Voiture extends Observable {

	private int coordXEnMetres;
	private int vitesseMetreParSecondes;
	private int coordYEnMetres;
	private int tailleVoiture;
	private Direction direction;

	public static final int tailleDomaine = 1000;

	public Voiture(int coordXEnMetres, int coorYEnMetre, int longueurVoiture) {
		this.coordXEnMetres = coordXEnMetres;
		this.tailleVoiture = longueurVoiture;
		this.vitesseMetreParSecondes = 0;
		this.direction = Direction.DROITE;
	}

	public Voiture(int coordXEnMetres, int coordYEnMetres,
			int vitesseMetreParSecondes, int longueurVoiture) {
		this.coordXEnMetres = coordXEnMetres;
		this.coordYEnMetres = coordYEnMetres;
		this.vitesseMetreParSecondes = vitesseMetreParSecondes;
		this.tailleVoiture = longueurVoiture;
		this.direction = Direction.DROITE;
	}

	public int getLongueurVoiture() {
		return tailleVoiture;
	}

	public void setLongueurVoiture(int longueurVoiture) {
		this.tailleVoiture = longueurVoiture;
	}

	public int getCoordXEnMetres() {
		return coordXEnMetres;
	}

	public int getVitesseMetreParSecondes() {
		return vitesseMetreParSecondes;
	}

	public int getCoordYEnMetres() {
		return coordYEnMetres;
	}

	public void setCoordYEnMetres(int coordYEnMetres) {
		this.coordYEnMetres = coordYEnMetres;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void avancerEnFonctionDeLaVitesse() {
		switch (this.direction) {
		case HAUT: {
			if ((coordYEnMetres - vitesseMetreParSecondes - this.tailleVoiture) < 0) {
				coordYEnMetres = 0;
				System.out.println("bord HAut");
			} else {
				coordYEnMetres -= vitesseMetreParSecondes;
			}
			break;
		}
		case BAS: {
			if ((coordYEnMetres + vitesseMetreParSecondes + this.tailleVoiture) > tailleDomaine) {
				coordYEnMetres = tailleDomaine - this.tailleVoiture * 2;

			} else {
				coordYEnMetres += vitesseMetreParSecondes;
			}
			break;
		}
		case GAUCHE: {
			if ((coordXEnMetres - vitesseMetreParSecondes - this.tailleVoiture) < 0) {
				coordXEnMetres = 0;
			} else {
				coordXEnMetres -= vitesseMetreParSecondes;
			}
			break;
		}
		case DROITE: {
			if ((coordXEnMetres + vitesseMetreParSecondes + this.tailleVoiture) > tailleDomaine) {
				coordXEnMetres = tailleDomaine - this.tailleVoiture * 2;
			} else {
				coordXEnMetres += vitesseMetreParSecondes;
			}
			break;
		}
		}
		notificationObservateurs();
	}

	private void notificationObservateurs() {
		this.setChanged();
		this.notifyObservers();
	}
}
