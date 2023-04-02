package it.prova.gestionecompagniapatterndao.model;

import java.time.LocalDate;

public class Impiegato {
	// dichiaro la classe che andra a contenere id, nome, cognome, codiceFiscale,
	// dataNascita, dataAssunzione
	private Long id;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private LocalDate dataNascita;
	private LocalDate dataAssunzione;
	private Compagnia compagnia;

	// costruttore
	public Impiegato(String nome, String cognome, String codiceFiscale, LocalDate dataNascita,
			LocalDate dataAssunzione) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.dataNascita = dataNascita;
		this.dataAssunzione = dataAssunzione;
	}

	// costruttore
	public Impiegato(Long id, String nome, String cognome, String codiceFiscale, LocalDate dataNascita,
			LocalDate dataAssunzione, Compagnia compagnia) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.dataNascita = dataNascita;
		this.dataAssunzione = dataAssunzione;
		this.compagnia = compagnia;
	}

	// costruttore
	public Impiegato(String nome, String cognome, String codiceFiscale, LocalDate dataNascita, LocalDate dataAssunzione,
			Compagnia compagnia) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.dataNascita = dataNascita;
		this.dataAssunzione = dataAssunzione;
		this.compagnia = compagnia;
	}

	// costruttore di default
	public Impiegato() {
		super();
	}

	public Impiegato(String nome2, String cognome2, String codiceFiscale2, String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	// metodi get e set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public LocalDate getDataAssunzione() {
		return dataAssunzione;
	}

	public void setDataAssunzione(LocalDate dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Compagnia getCompagnia() {
		return compagnia;
	}

	public void setCompagnia(Compagnia compagnia) {
		this.compagnia = compagnia;
	}

	@Override
	public String toString() {
		return "Impiegato [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale
				+ ", dataNascita=" + dataNascita + ", dataAssunzione=" + dataAssunzione + ", compagnia=" + compagnia
				+ "]";
	}

}
