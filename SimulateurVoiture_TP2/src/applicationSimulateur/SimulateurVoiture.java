package applicationSimulateur;


public class SimulateurVoiture {

	public static final int dureeUneSecondeEnMilliSecondes = 1000;

	public static void main(String[] args) {
		
		final Voiture voiture = new Voiture(50,30);
		DessinVoiture dessinVoiture = new DessinVoiture(voiture);
		final VueVoiture carre = new VueVoiture(voiture, dessinVoiture);
		
		Timer timerAvancer = new Timer(dureeUneSecondeEnMilliSecondes, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				voiture.avancerEnFonctionDeLaVitesse();
				
			}
		});
		
		timerAvancer.start();
		
		while(true){
		}
	}
}
