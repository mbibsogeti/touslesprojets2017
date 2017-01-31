package fr.ib.nicolas.travel;

import java.util.Scanner;

public class voyage2 {


	public static void main(String[] args) {
		System.out.println("bienvenue");
		
		float prixhotel=45;
		float prixavion=785;
		int duree=18;
		//int[]tb=new int[4]; tableau sans valeurs
		int []ti={7,9,13,16,18};
		
		/*for (int i=0; i<ti.length;i++){
			
			int prix=785+45*ti[i];
			System.out.println(ti[i]+"jour:"+prix+"€");
		}*/
		
		for(int j : ti)
			int prix=785+45*j;
		System.out.println(j+"jour:"+prix+"€");  // inconvénien pas de retour en arrière , pas de saut deux par deux , pas d'index mais que la valeur 
		
		
		/*//Scanner sc = new Scanner(System.in);

		//System.out.println("menu:......");
		//String menu = sc.next();
		//if (menu.equals("a")) { // permet de tester une chaine de caractère

			System.out.println("alaska");

		}

		if (menu.equals("c"))

		{
			System.out.println("canada");
		}*/
	}
}
