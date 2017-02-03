package fr.ib.myriam.travel;

public class Voyage {
	
	float hotel;
	float avion;
	int nb_jours;
	Etat etat;
	
	public Voyage(float _h, float _a, int _j, Etat _e){
		hotel = _h;
		avion = _a;
		nb_jours = _j;
		etat = _e;				
	}
	
	public Voyage(Etat _e){
		etat = _e;
	}

}
