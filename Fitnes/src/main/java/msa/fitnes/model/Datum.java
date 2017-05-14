package msa.fitnes.model;


import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Datum {
	
	protected DateTime date;
	protected List<Termin> termini;
	
	
	public Datum(String datum, List<Termin> termini) {
		super();
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		this.date = formatter.parseDateTime(datum);
		this.termini = termini;
	}
	
	
	
	public Datum(String datum) {
		super();
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		this.date = formatter.parseDateTime(datum);
	}

	public Datum() {
		super();
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public List<Termin> getTermini() {
		return termini;
	}

	public void setTermini(List<Termin> termini) {
		this.termini = termini;
	}

	
	public void dodajTermine(List<Termin> termini) {
		this.termini.addAll(termini);
	}
	
	@Override
	public String toString() {
		return "Datum [date=" + date + ", termini=" + termini + "]";
	}

		
	
	
	
	
	
}
