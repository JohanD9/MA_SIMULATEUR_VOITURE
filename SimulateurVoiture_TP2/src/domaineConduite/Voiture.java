package domaineConduite;

import java.util.Observable;

public class Voiture extends Observable {

	private int coordXEnMetres;
	private int vitesseMetreParSecondes;

	public static final int largeurDomaine = 1000;

	public Voiture(int coordXEnMetres) {
		this.coordXEnMetres = coordXEnMetres + 10;
		this.vitesseMetreParSecondes = 0;
	}

	public Voiture(int coordXEnMetres, int vitesseMetreParSecondes) {
		this.coordXEnMetres = coordXEnMetres + 10;
		this.vitesseMetreParSecondes = vitesseMetreParSecondes;
	}

	public int getCoordXEnMetres() {
		return coordXEnMetres;
	}

	public int getVitesseMetreParSecondes() {
		return vitesseMetreParSecondes;
	}

	public void avancerEnFonctionDeLaVitesse() {
		if ((coordXEnMetres + vitesseMetreParSecondes + 30) > largeurDomaine) {
			coordXEnMetres = largeurDomaine - 20;
		} else {
			coordXEnMetres += vitesseMetreParSecondes;
		}

		notificationObservateurs();
	}

	private void notificationObservateurs() {
		this.setChanged();
		this.notifyObservers();
	}
}
