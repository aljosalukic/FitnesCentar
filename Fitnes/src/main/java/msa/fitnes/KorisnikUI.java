package msa.fitnes;

import java.util.ArrayList;

import msa.fitnes.model.Korisnik;
import msa.fitnes.utilities.Utility;

public class KorisnikUI extends Korisnik{
	
	
	
	public static ArrayList<Korisnik> listaKorisnika = new ArrayList<Korisnik>();
	

	public static void ispisOpcijaKorisnika(){
		System.out.println("=============================\n"  
				+"Opcija 1: Unos Korisnika\n"
				+"Opcija 2: Ispis korisnika\n"
				+"Opcija 3: Pretraga po imenu\n"
				+"Opija 0: izlaz\n");
	}

	public static void meniKorisnikUI(){
		
		
		
		int odluka = -1;
		while(odluka!= 0){
			ispisOpcijaKorisnika();
			System.out.print("opcija:");
			odluka = Utility.ocitajCeoBroj();
			switch (odluka) {
			case 0:
				System.out.println("Izlaz");
				break;
			case 1:
				unosKorisnika();
				break;
			case 2:
				ispisKorisnika();
				break;
			case 3:
				pretragaPoImenu();
				break;
			default:
				System.out.println("nepostojeca komanda");
				break;
			}
		}
	}

	public static void unosKorisnika(){


		System.out.println("Unesite ime korisnika:");
		String ime = Utility.ocitajTekst();
		System.out.println("Unesite prezime korisnika:");
		String prezime = Utility.ocitajTekst();
		System.out.println("Unesite sifru korisnika:");
		int sifraID = Utility.ocitajCeoBroj();

		Korisnik korisnik = new Korisnik(sifraID, ime, prezime);
		listaKorisnika.add(korisnik);
	}


	public static void ispisKorisnika(){
		for (int i = 0; i < listaKorisnika.size(); i++) {
			System.out.println(listaKorisnika.get(i).toString());
		}
	}
	public static void pretragaPoImenu(){
		System.out.println("Unesite ime:");
		String ime = Utility.ocitajTekst();
		for (int i = 0; i < listaKorisnika.size(); i++) {
			if(ime.equalsIgnoreCase(listaKorisnika.get(i).getIme())){
			System.out.println(listaKorisnika.get(i).toString());
			}else
				System.out.println("Nema tog imena u bazi");
		}
	}
	
	public static Korisnik korisnikByID(int id){
		Korisnik korisnik = null;
		for (int i = 0; i < listaKorisnika.size(); i++) {
			if(id == listaKorisnika.get(i).getId()){
				korisnik = listaKorisnika.get(i);
			}
		}
		return korisnik;
	}


}
