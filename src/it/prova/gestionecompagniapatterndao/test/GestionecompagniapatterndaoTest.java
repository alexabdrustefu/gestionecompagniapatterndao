package it.prova.gestionecompagniapatterndao.test;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import it.prova.gestionecompagniapatterndao.connection.MyConnection;
import it.prova.gestionecompagniapatterndao.dao.Constants;
import it.prova.gestionecompagniapatterndao.dao.compagnia.CompagniaDAO;
import it.prova.gestionecompagniapatterndao.dao.compagnia.CompagniaDAOImpl;
import it.prova.gestionecompagniapatterndao.dao.impiegato.ImpiegatoDAO;
import it.prova.gestionecompagniapatterndao.dao.impiegato.ImpiegatoDAOImpl;
import it.prova.gestionecompagniapatterndao.model.Compagnia;
import it.prova.gestionecompagniapatterndao.model.Impiegato;

public class GestionecompagniapatterndaoTest {

	public static void main(String[] args) {

		ImpiegatoDAO impiegatoDAOInstance = null;
		CompagniaDAO compagniaDAOInstance = null;

		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			impiegatoDAOInstance = new ImpiegatoDAOImpl(connection);
			compagniaDAOInstance = new CompagniaDAOImpl(connection);
//			// ===========================================================================================================
//			// test
//			System.out.println("In tabella compagnia ci sono " + compagniaDAOInstance.list().size() + " elementi.");
//
//			testInserimentoCompagnia(compagniaDAOInstance);
//			// ===========================================================================================================
//			// test
//			System.out.println("In tabella user ci sono " + compagniaDAOInstance.list().size() + " elementi.");
//
//			System.out.println("In tabella impiegato ci sono " + impiegatoDAOInstance.list().size() + " elementi.");
//			// ===========================================================================================================
//			// test
//			testInserimentoImpiegato(impiegatoDAOInstance);
//
//			System.out.println("In tabella impiegato ci sono " + impiegatoDAOInstance.list().size() + " elementi.");
//			// ===========================================================================================================
//			// test
//			testUpdateImpiegati(impiegatoDAOInstance);
//			System.out.println("In tabella impiegato ci sono " + impiegatoDAOInstance.list().size() + " elementi.");
//			// ===========================================================================================================
//			// test
//			testDeleteImpiegato(impiegatoDAOInstance);
//			System.out.println("in tabella sono presenti " + impiegatoDAOInstance.list().size() + " elementi.");
//			// ===========================================================================================================
//			// test
//			testCountByDataFondazioneCompagniaGreaterThan(compagniaDAOInstance, impiegatoDAOInstance);
//			System.out.println("in tabella sono presenti " + impiegatoDAOInstance.list().size() + " elementi.");
//			// ===========================================================================================================
//			// test
//			testFindAllErroriAssunzione(compagniaDAOInstance, impiegatoDAOInstance);
//			System.out.println("in tabella sono presenti " + impiegatoDAOInstance.list().size() + " elementi.");
//			// ===========================================================================================================
//			// test
//			testFindAllByCompagniaConFatturatoMaggioreDi(compagniaDAOInstance, impiegatoDAOInstance);
//			System.out.println("in tabella sono presenti " + impiegatoDAOInstance.list().size() + " elementi.");
			// ===========================================================================================================
			// test
//			testFindAllByCompagnia(compagniaDAOInstance, impiegatoDAOInstance);
//			System.out.println("in tabella sono presenti " + impiegatoDAOInstance.list().size() + " elementi.");
			// ===========================================================================================================
			// test
//			testUpdateCompagnia(compagniaDAOInstance);
//			System.out.println("in tabella sono presenti " + compagniaDAOInstance.list().size() + " elementi.");
			// ===========================================================================================================
			// test
//			testDeleteCompagnia(compagniaDAOInstance);
//			System.out.println("in tabella sono presenti " + compagniaDAOInstance.list().size() + " elementi.");
			// ===========================================================================================================
			// test
//			testFindAllByDataAssunzioneMaggioreDi(compagniaDAOInstance, impiegatoDAOInstance);
//			System.out.println("in tabella sono presenti " + compagniaDAOInstance.list().size() + " elementi.");
			// ===========================================================================================================
			// test
//			testFindAllByRagioneSocialeContiene(compagniaDAOInstance);
//			System.out.println("in tabella sono presenti " + compagniaDAOInstance.list().size() + " elementi.");
			// ===========================================================================================================
			// test
			testFindAllByCodFisImpiegatoContiene(compagniaDAOInstance, impiegatoDAOInstance);
			System.out.println("in tabella sono presenti " + compagniaDAOInstance.list().size() + " elementi.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ===========================================================================================================
	// METODO PER FARE IL TEST DELL'INSERIMENTO DEI DATI NEL DATA BASE IMPIEGATO

	private static void testInserimentoImpiegato(ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println(".......testInserimentoNegozio inizio.............");
		int quantiImpiegatiInseriti = impiegatoDAOInstance.insert(new Impiegato("alessandro", "stefu",
				"STFLND02R06Z129W", LocalDate.parse("2000-10-06"), LocalDate.parse("2000-10-06"),
				new Compagnia(1L, "SolvingTeam", 10000, LocalDate.parse("1900-03-26"))));// inseriamo anche la compagnia
																							// di appartenenza del
																							// lavoratore
		if (quantiImpiegatiInseriti < 1)// effettuo un controllo nel quale se gli impiegati inseriti sono minori di uno
										// di conseguenza lancerà un eccezione
			throw new RuntimeException("testInserimentoNegozio : FAILED");

		System.out.println(".......testInserimentoNegozio fine: PASSED.............");
	}
	// ===========================================================================================================
	// METODO PER FARE IL TEST DELL'INSERIMENTO DI UNA NUOVA COMPAGNIA NEL DATA BASE
	// COMPAGNIA

	private static void testInserimentoCompagnia(CompagniaDAO compagniaDAOInstance) throws Exception {
		System.out.println(".......testUpdateImpiegato inizio.............");
		int quantiImpiegatiInseriti = compagniaDAOInstance
				.insert(new Compagnia("SolvingTeam", 1000, LocalDate.parse("1900-03-26")));
		if (quantiImpiegatiInseriti < 1)
			throw new RuntimeException("testInserimentoNegozio : FAILED");

		System.out.println(".......testInserimentoNegozio fine: PASSED.............");
	}

	// ===========================================================================================================
	// METODO PER FARE IL TEST DELL'UPDATE DEGLI IMPIEGATI
	private static void testUpdateImpiegati(ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println(".......testUpdate impiegato.............");
		List<Impiegato> elencoImpiegati = impiegatoDAOInstance.list();
		if (elencoImpiegati.size() < 1)
			throw new RuntimeException("errore: la lista di impiegati è vuota!!");
		Impiegato impiegatoDaAggiornare = elencoImpiegati.get(1);
		String valoreDaAggiornare = "marco";
		impiegatoDaAggiornare.setNome(valoreDaAggiornare);
		impiegatoDAOInstance.update(impiegatoDaAggiornare);
	}

	// ===========================================================================================================
	// METODO PER CANCELLARE UN IMPIEGATO
	private static void testDeleteImpiegato(ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println(".......testDeleteImpiegato inizio.............");
		int quantiElementiInseriti = impiegatoDAOInstance.insert(
				new Impiegato("nome", "cognome", "stfln", LocalDate.of(1999, 10, 24), LocalDate.of(2002, 10, 15)));
		if (quantiElementiInseriti < 1)
			throw new RuntimeException("testDeleteImpiegato : FAILED, user da rimuovere non inserito");

		List<Impiegato> elencoVociPresenti = impiegatoDAOInstance.list();
		int numeroElementiPresentiPrimaDellaRimozione = elencoVociPresenti.size();
		if (numeroElementiPresentiPrimaDellaRimozione < 1)
			throw new RuntimeException("testDeleteImpiegato : FAILED, non ci sono voci sul DB");

		Impiegato ultimoDellaLista = elencoVociPresenti.get(numeroElementiPresentiPrimaDellaRimozione - 1);
		impiegatoDAOInstance.delete(ultimoDellaLista);

		int numeroElementiPresentiDopoDellaRimozione = impiegatoDAOInstance.list().size();
		if (numeroElementiPresentiDopoDellaRimozione != numeroElementiPresentiPrimaDellaRimozione - 1)
			throw new RuntimeException("testDeleteImpiegato : FAILED, la rimozione non è avvenuta");

		System.out.println(".......testDeleteImpiegato fine: PASSED.............");

	}

	// ===========================================================================================================
	// Metodo
	private static void testCountByDataFondazioneCompagniaGreaterThan(CompagniaDAO compagniaDAOInstance,
			ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println("......testCountByDataFondazioneCompagniaGreaterThan inizio........");
		List<Compagnia> elencoCompagniePresenti = compagniaDAOInstance.list();
		if (elencoCompagniePresenti.size() < 1)
			throw new RuntimeException("errore: non sono presenti compagnie sul DB");
		List<Impiegato> elencoImpiegatiPresenti = impiegatoDAOInstance.list();
		if (elencoImpiegatiPresenti.size() < 1)
			throw new RuntimeException("errore: non sono presenti impiegati sul DB");
		LocalDate dataDaRicercare = LocalDate.parse("1920-04-30");
		int countImpiegati = impiegatoDAOInstance.countByDataFondazioneCompagniaGreaterThan(dataDaRicercare);
		System.out.println("Il contatore segna: " + countImpiegati);
		System.out.println(".......testCountByDataFondazioneCompagniaGreaterThan fine: PASSED.............");
	}
	// ===========================================================================================================
	// FIND ERRORI ASSUNZIONE

	private static void testFindAllErroriAssunzione(CompagniaDAO compagniaDAOInstance,
			ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println("..........testFindAllErroriAssunzione inizio........");
		List<Compagnia> elencoCompagniePresenti = compagniaDAOInstance.list();
		if (elencoCompagniePresenti.size() < 1)
			throw new RuntimeException("errore: non sono presenti compagnie sul DB");
		List<Impiegato> elencoImpiegatiPresenti = impiegatoDAOInstance.list();
		if (elencoImpiegatiPresenti.size() < 1)
			throw new RuntimeException("errore: non sono presenti impiegati sul DB");
		List<Impiegato> impiegatiConErroreAssunzione = impiegatoDAOInstance.findAllErroriAssunzione();
		System.out.println("gli impiegati con errori di assunzione sono " + impiegatiConErroreAssunzione.size());
		System.out.println(impiegatiConErroreAssunzione);
		System.out.println("........testFindAllErroriAssunzione fine.........");
	}

	// ===========================================================================================================
	// TEST FATTURA MAGGIORE
	private static void testFindAllByCompagniaConFatturatoMaggioreDi(CompagniaDAO compagniaDAOInstance,
			ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println(".......testFindAllByCompagniaConFatturatoMaggioreDi inizio.......");
		List<Compagnia> elencoCompagniePresenti = compagniaDAOInstance.list();
		if (elencoCompagniePresenti.size() < 1)
			throw new RuntimeException("errore: non sono presenti compagnie sul DB");
		List<Impiegato> elencoImpiegatiPresenti = impiegatoDAOInstance.list();
		if (elencoImpiegatiPresenti.size() < 1)
			throw new RuntimeException("errore: non sono presenti impiegati sul DB");
		int fatturatoDaRicercare = 100;
		List<Impiegato> impiegatiCompagniaConFatturatoMaggioreDi = impiegatoDAOInstance
				.findAllByCompagniaConFatturatoMaggioreDi(fatturatoDaRicercare);
		System.out.println("gli impiegati in compagnie con fatturato maggiore di "
				+ impiegatiCompagniaConFatturatoMaggioreDi.size() + " elementi.");
		System.out.println(impiegatiCompagniaConFatturatoMaggioreDi);
		System.out.println(".......testFindAllByCompagniaConFatturatoMaggioreDi fine.........");
	}

	// ==============================================================================================================
	// FIND ALL BY COMPAGNIA
	public static void testFindAllByCompagnia(CompagniaDAO compagniaDAOInstance, ImpiegatoDAO impiegatoDAOInstance)
			throws Exception {
		System.out.println("......testFindAllByCompagnia inizio.........");
		List<Compagnia> elencoCompagnie = compagniaDAOInstance.list();
		if (elencoCompagnie.size() < 1) {
			throw new RuntimeException("errore: non sono presenti compagnie sul db.");
		}
		List<Impiegato> elencoImpiegati = impiegatoDAOInstance.list();
		if (elencoImpiegati.size() < 1) {
			throw new RuntimeException("errore: non sono presenti impiegati sul db.");
		}
		Compagnia compagnieDaRicercare = elencoCompagnie.get(0);
		List<Impiegato> impiegatiDellaCompagnia = impiegatoDAOInstance.findAllByCompagnia(compagnieDaRicercare);
		if (impiegatiDellaCompagnia.size() < 1) {
			throw new RuntimeException("non è stato trovato nulla");
		}
		System.out.println("gli elementi che corrispondono sono " + impiegatiDellaCompagnia.size());
		System.out.println(impiegatiDellaCompagnia);
		System.out.println("..........testFindAllByCompagnia fine......");
	}

	// ==============================================================================================================
	// TEST UPDATE
	private static void testUpdateCompagnia(CompagniaDAO compagniaDAOInstance) throws Exception {
		System.out.println(".......testUpdate compagnia.............");
		List<Compagnia> elencoCompagnia = compagniaDAOInstance.list();
		if (elencoCompagnia.size() < 1)
			throw new RuntimeException("errore: la lista di impiegati è vuota!!");
		Compagnia compagniaDaAggiornare = elencoCompagnia.get(1);
		String valoreDaAggiornare = "compagnia";
		compagniaDaAggiornare.setRagioneSociale(valoreDaAggiornare);
		compagniaDAOInstance.update(compagniaDaAggiornare);
	}

	// ==============================================================================================================
	// TEST DELETE
	public static void testDeleteCompagnia(CompagniaDAO compagniaDAOInstance) throws Exception {
		System.out.println(".......testDeleteCompagnia inizio.............");
		int quantiElementiInseriti = compagniaDAOInstance.insert(new Compagnia("compagnia", 100, LocalDate.now()));
		if (quantiElementiInseriti < 1)
			throw new RuntimeException("testDeleteCompagnia : FAILED, user da rimuovere non inserito");

		List<Compagnia> elencoVociPresenti = compagniaDAOInstance.list();
		int numeroElementiPresentiPrimaDellaRimozione = elencoVociPresenti.size();
		if (numeroElementiPresentiPrimaDellaRimozione < 1)
			throw new RuntimeException("testDeleteCompagnia : FAILED, non ci sono voci sul DB");

		Compagnia ultimoDellaLista = elencoVociPresenti.get(numeroElementiPresentiPrimaDellaRimozione - 1);
		compagniaDAOInstance.delete(ultimoDellaLista);

		int numeroElementiPresentiDopoDellaRimozione = compagniaDAOInstance.list().size();
		if (numeroElementiPresentiDopoDellaRimozione != numeroElementiPresentiPrimaDellaRimozione - 1)
			throw new RuntimeException("testDeleteCompagnia : FAILED, la rimozione non è avvenuta");

		System.out.println(".......testDeleteCompagnia fine: PASSED.............");
	}

	// ==============================================================================================================
	// TEST ASSUNZIONE MAGGIORE
	public static void testFindAllByDataAssunzioneMaggioreDi(CompagniaDAO compagniaDAOInstance,
			ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println(".......testFindAllByDataAssunzioneMaggioreDi inizio......");
		List<Compagnia> elencoCompagniePresenti = compagniaDAOInstance.list();
		if (elencoCompagniePresenti.size() < 1)
			throw new RuntimeException("testFindAllByDataAssunzioneMaggioreDi : FAILED, non ci sono compagnia sul DB");
		List<Impiegato> elencoImpiegatiPresenti = impiegatoDAOInstance.list();
		if (elencoImpiegatiPresenti.size() < 1)
			throw new RuntimeException("testFindAllByDataAssunzioneMaggioreDi : FAILED, non ci sono impiegati sul DB");

		LocalDate dataDaRicercare = LocalDate.parse("2000-01-01");
		List<Compagnia> listaCompagniaLikeExample = compagniaDAOInstance
				.findAllByDataAssunzioneMaggioreDi(dataDaRicercare);
		if (listaCompagniaLikeExample.size() < 1) {
			throw new RuntimeException("testFindAllByDataAssunzioneMaggioreDi : FAILED, non ci sono voci sul DB");
		}
		System.out.println(".......testFindAllByDataAssunzioneMaggioreDi fine: PASSED.............");

	}

	// ==============================================================================================================
	// TEST FIND BY RAGIONESOCIALE
	private static void testFindAllByRagioneSocialeContiene(CompagniaDAO compagniaDAOInstance) throws Exception {
		System.out.println("......testFindAllByRagioneSocialeContiene inizio......");
		List<Compagnia> compagnieEsistenti = compagniaDAOInstance.list();
		String parteNomeRagioneSociale = "p";
		List<Compagnia> result = compagniaDAOInstance.findAllByRagioneSocialeContiene(parteNomeRagioneSociale);
		System.out.println(result);
		System.out.println("......testFindAllByRagioneSocialeContiene fine......");

	}

	// ==============================================================================================================
	// TEST FIND BY CODICE FISCALE
	private static void testFindAllByCodFisImpiegatoContiene(CompagniaDAO compagniaDAOInstance,
			ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println(".......testFindAllByCodFisImpiegatoContiene inizio......");
		List<Compagnia> elencoCompagniePresenti = compagniaDAOInstance.list();
		if (elencoCompagniePresenti.size() < 1)
			throw new RuntimeException("testFindAllByCodFisImpiegatoContiene : FAILED, non ci sono compagnia sul DB");
		List<Impiegato> elencoImpiegatiPresenti = impiegatoDAOInstance.list();
		if (elencoImpiegatiPresenti.size() < 1)
			throw new RuntimeException("testFindAllByCodFisImpiegatoContiene : FAILED, non ci sono impiegati sul DB");

		String codFisDaCercare = "stfln";
		List<Compagnia> listaCompagniaLikeExample = compagniaDAOInstance
				.findAllBYCodFisImpiegatoContiene(codFisDaCercare);
		if (listaCompagniaLikeExample.size() < 1) {
			throw new RuntimeException("testFindAllByCodFisImpiegatoContiene : FAILED, non ci sono voci sul DB");
		}
		System.out.println("Gli elementi della lista sono: " + listaCompagniaLikeExample.size());
		System.out.println(listaCompagniaLikeExample);
		System.out.println(".......testFindAllByCodFisImpiegatoContiene fine: PASSED.............");
	}

}
