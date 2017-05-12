package msa.fitnes;

import java.util.Date;

import msa.fitnes.model.Korisnik;
import msa.fitnes.utilities.Utility;

public class App {
	
	public static void ispisOpcija(){
		System.out.println(		  "Opcija 1: Korisnici \n"
								+ "Opcija 2: Datumi \n"
								+ "Opcija 3: Termini \n"
								+ "Opcija 0: Izlaz\n");
	}

	public static void main(String[] args) {
		
		Korisnik korisnik1 = new Korisnik(1, "Aljosa", "Lukic");
		Korisnik korisnik2 = new Korisnik(2, "Mirjana", "Pisaric");
		KorisnikUI.listaKorisnika.add(korisnik1);
		KorisnikUI.listaKorisnika.add(korisnik2);
		
		
		
		int odluka = -1;
		
		while(odluka != 0){
		Date date = new Date();
		System.out.println(date);
		System.out.println();
		ispisOpcija();	
		System.out.print("opcija:");
		odluka = Utility.ocitajCeoBroj();
		
		switch (odluka) {
		case 0:
			System.out.println("Izlaz iz programa");
			break;
		case 1:
			KorisnikUI.meniKorisnikUI();
			break;
		case 2:
			DatumUI.meniDatumUI();
			break;
		case 3:
			TerminiUI.meniTerminiUI();
			break;		
		default:
			System.out.println("Opcija ne postoji");
			break;
		}
	}	
	

	}

}
