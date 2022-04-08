package franco.crowdfounding;

import java.time.LocalDate;

public class Donazione implements Comparable<Donazione> {
	private String nomeDonatore;
	private char tipo;
	private double importo;
	private LocalDate dataDonazione;

	public Donazione(String nomeDonatore, char tipo, double importo, LocalDate data) {
		this.nomeDonatore = nomeDonatore;
		this.tipo = tipo;
		this.importo = importo;
		this.dataDonazione = data;
	}

	public Donazione(Donazione d) {
		this.nomeDonatore = d.nomeDonatore;
		this.tipo = d.tipo;
		this.importo = d.importo;
		this.dataDonazione = d.dataDonazione;
	}

	public String getNomeDonatore() {
		return nomeDonatore;
	}

	public void setNomeDonatore(String nomeDonatore) {
		this.nomeDonatore = nomeDonatore;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public LocalDate getDataDonazione() {
		return dataDonazione;
	}

	public void setDataDonazione(LocalDate dataDonazione) {
		this.dataDonazione = dataDonazione;
	}

	@Override
	public int compareTo(Donazione d) {
		if (this.importo < d.importo)
			return -1;
		if (this.importo > d.importo)
			return 1;
		return 0;
	}

}
