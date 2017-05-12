package msa.fitnes;


import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import msa.fitnes.model.Datum;
import msa.fitnes.model.Termin;
import msa.fitnes.utilities.Utility;

public class DatumUI extends TerminiUI{

	public static ArrayList<Datum> datumi = new ArrayList<Datum>();


	public static void ispisOpcijaDatuma(){
		System.out.println(  "Opcija 1: ispis za zadati datum\n"
				+"Opija 0: izlaz\n");
	}

	public static void meniDatumUI(){
		int odluka = -1;
		while(odluka!= 0){
			ispisOpcijaDatuma();
			System.out.print("opcija:");
			odluka = Utility.ocitajCeoBroj();
			switch (odluka) {
			case 0:
				System.out.println("Izlaz");
				break;
			case 1:
				ispisZaDatum();
				break;
			default:
				System.out.println("nepostojeca komanda");
				break;
			}
		}
	}

	public static void ispisZaDatum(){

		System.out.println("Unesite datum, u formatu dd/MM/yyyy");
		String datum = Utility.ocitajTekst();

		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		DateTime dt = formatter.parseDateTime(datum);

		for (Datum dat : datumi) {
			if(dat.getDate().getDayOfMonth() == dt.getDayOfMonth() &&
					dat.getDate().getMonthOfYear() == dt.getMonthOfYear() &&
					dat.getDate().getYear() == dt.getYear()){

				for(int i =0; i < dat.getTermini().size();i++){
					System.out.println(dat.getTermini().get(i).toString());
				}

			}else 
				System.out.println("Nema ZAKAZANIH termina za taj datum");
		}


	}

	public static void pronadjiPoDatumu(){

		System.out.println("Unesite datum, u formatu dd/MM/yyyy");
		String datum = Utility.ocitajTekst();

		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		DateTime dt = formatter.parseDateTime(datum);

		for (Datum dat : datumi) {
			if(dat.getDate() == dt){
				System.out.println(dat.getTermini().toString());
			}else
				System.out.println("U zadatom datumu nema zakazanih termina");
		}


	}


	public static List<Termin> listaPoDatumu(String datum){
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		DateTime dt = formatter.parseDateTime(datum);
		
		List<Termin> lista = null;
		for (int i = 0; i < datumi.size(); i++) {
			if(dt.getDayOfMonth() == datumi.get(i).getDate().getDayOfMonth() &&
					dt.getMonthOfYear() == datumi.get(i).getDate().getMonthOfYear() &&
					dt.getYear() == datumi.get(i).getDate().getYear()){
					
					lista=datumi.get(i).getTermini();
					
					return lista;
			}
		}
		return lista;
	}
	
	
	



}
