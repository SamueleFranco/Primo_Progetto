package franco.crowdfounding;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Progetto {
	private String titolo;
	private String descrizione;
	private double budget;
	private double somma;
	private LocalDate scadenza;
	private ArrayList<Donazione> lista;

	public Progetto(String titolo, String descrizione, double budget, double somma, LocalDate scadenza) {
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.budget = budget;
		this.somma = 0.0;
		this.scadenza = scadenza;
		lista = new ArrayList<Donazione>();
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getBudget() {
		return budget;
	}

	public LocalDate getScadenza() {
		return scadenza;
	}

	public void setScadenza(LocalDate scadenza) {
		this.scadenza = scadenza;
	}

	private int seEsiste(String donatore) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNomeDonatore() == donatore)
				return i;
		}
		return -1;
	}

	public void inserisciDonazione(Donazione d) {
		if (seEsiste(d.getNomeDonatore()) == -1) {
			this.somma += d.getImporto();
			lista.add(d);
		}
	}

	public Donazione ricercaPerDonatore(String donatore) {
		int index = seEsiste(donatore);
		if (index != -1)
			return lista.get(index);
		return null;
	}

	public void eliminaPerDonatore(String donatore) {
		int index = seEsiste(donatore);
		if (index != -1) {
			this.somma -= lista.get(index).getImporto();
			lista.remove(index);
		}
	}

	public ArrayList<Donazione> donazioniPerTipo(char tipo) {
		ArrayList<Donazione> donazioni = new ArrayList<>();
		for (Donazione d : lista) {
			if (d.getTipo() == tipo)
				donazioni.add(new Donazione(d));
		}
		Collections.sort(donazioni);
		return donazioni;
	}

	public int differenza() {
		return (scadenza.compareTo(LocalDate.now()));
	}

	public String infoDonazioni() {
		return "Numero di donazioni: " + lista.size() + "\n" +
				"Totale importo donazioni: " + this.somma;
	}

	@Override
	public String toString() {
		return "Progetto " + titolo + ":\n" + descrizione + "\n" + "Budget: " + budget + " euro\n" + "Scadenza: "
				+ scadenza + "\n" + "Numero di donazioni: " + lista.size();
	}

}
