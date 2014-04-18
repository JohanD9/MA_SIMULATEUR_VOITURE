package domaineConduite;

import java.util.Observable;

public class Voiture extends Observable {

	private int coordXEnMetres;
	private int vitesseMetreParSecondes;
	private int coordYEnMetres;
	private int longueurVoiture;
	private Direction direction;

	public static final int largeurDomaine = 1000;
	private final int modificationVitesseMetreSeconde = 10;

	public Voiture(int coordXEnMetres) {
		this.coordXEnMetres = coordXEnMetres;
	}
	
	public Voiture(int coordXEnMetres, int longueurVoiture) {
		this.coordXEnMetres = coordXEnMetres;
		this.longueurVoiture = longueurVoiture;
		this.vitesseMetreParSecondes = 0;
	}

	public Voiture(int coordXEnMetres, int coordYEnMetres, int vitesseMetreParSecondes, int longueurVoiture)
	{
		this.coordXEnMetres = coordXEnMetres;
		this.coordYEnMetres = coordYEnMetres;
		this.vitesseMetreParSecondes = vitesseMetreParSecondes;
		this.longueurVoiture = longueurVoiture;
		this.direction = Direction.DROITE;
	}
	
	public Voiture(int coordXEnMetres, int vitesseMetreParSecondes, int longueurVoiture) {
		this.coordXEnMetres = coordXEnMetres;
		this.longueurVoiture = longueurVoiture;
		this.vitesseMetreParSecondes = vitesseMetreParSecondes;
	}

	public int getLongueurVoiture() {
		return longueurVoiture;
	}

	public void setLongueurVoiture(int longueurVoiture) {
		this.longueurVoiture = longueurVoiture;
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
		if((coordXEnMetres + vitesseMetreParSecondes + this.longueurVoiture) > largeurDomaine){
			coordXEnMetres = largeurDomaine - this.longueurVoiture*2;

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
	public void accelerationVitesseMetreSeconde() {
		this.vitesseMetreParSecondes = this.vitesseMetreParSecondes + modificationVitesseMetreSeconde;
		
	}

	public void ralentissementVitesseMetreSeconde() {
		this.vitesseMetreParSecondes = this.vitesseMetreParSecondes - modificationVitesseMetreSeconde;
		
	}
	
	public void modifierVitesseMetreSeconde(Direction direction) {
		switch(direction) {
			case HAUT : if(this.direction == Direction.HAUT) {
							accelerationVitesseMetreSeconde();
						} else if (this.direction == Direction.BAS) {
							ralentissementVitesseMetreSeconde();
						}
				break;
			case DROITE: if(this.direction == Direction.DROITE) {
							accelerationVitesseMetreSeconde();
						} else if (this.direction == Direction.GAUCHE) {
							ralentissementVitesseMetreSeconde();
						}
				break;
			case BAS : if(this.direction == Direction.BAS) {
							accelerationVitesseMetreSeconde();
						} else if (this.direction == Direction.HAUT) {
							ralentissementVitesseMetreSeconde();
						}
				break;
			case GAUCHE :  if(this.direction == Direction.GAUCHE) {
								accelerationVitesseMetreSeconde();
							} else if (this.direction == Direction.DROITE) {
								ralentissementVitesseMetreSeconde();
							}
				break;
			default :
		}
	}
}