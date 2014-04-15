package domaineConduite;

import java.util.Observable;

public class Voiture extends Observable {

	private int coordXEnMetres;
	private int vitesseMetreParSecondes;
	private int coordYEnMetres;
	private Direction direction;

	public static final int largeurDomaine = 1000;

	public Voiture(int coordXEnMetres) {
		this.coordXEnMetres = coordXEnMetres;
		this.vitesseMetreParSecondes = 0;
	}

	public Voiture(int coordXEnMetres, int coordYEnMetres, int vitesseMetreParSecondes)
	{
		this.coordXEnMetres = coordXEnMetres;
		this.coordYEnMetres = coordYEnMetres;
		this.vitesseMetreParSecondes = vitesseMetreParSecondes;
		this.direction = Direction.DROITE;
	}
	
	public Voiture(int coordXEnMetres, int vitesseMetreParSecondes) {
		this.coordXEnMetres = coordXEnMetres;
		this.vitesseMetreParSecondes = vitesseMetreParSecondes;
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
		if((coordXEnMetres + vitesseMetreParSecondes + 20) > largeurDomaine){
			coordXEnMetres = largeurDomaine - 20;
		}
		else{
			coordXEnMetres += vitesseMetreParSecondes;
		}
		
		notificationObservateurs();
	}

	private void notificationObservateurs() {
		this.setChanged();
		this.notifyObservers();
	}
}
