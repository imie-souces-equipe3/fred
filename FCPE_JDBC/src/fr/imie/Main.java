package fr.imie;

import java.util.ArrayList;
import java.util.List;

import fr.imie.business.AcademicBusiness;
import fr.imie.business.IAcademicBusiness;
import fr.imie.model.EtablissementDTO;
import fr.imie.persistence.ConnexionManagement;
import fr.imie.persistence.EtablissementDAO;
import fr.imie.persistence.IConnexionManagement;
import fr.imie.persistence.IEtablissementDAO;
import presentation.IHM;

/**
 * @author imiedev
 *
 */
public class Main {

	private static List<EtablissementDTO> etablissementDTOs = new ArrayList<>();

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IConnexionManagement connexionManagement = new ConnexionManagement();
		IEtablissementDAO etablissementDAO  = new EtablissementDAO(connexionManagement);
		IAcademicBusiness academicBusiness = new AcademicBusiness(etablissementDAO);
		IHM ihm = new IHM(academicBusiness);
		ihm.start();
		

	}



}
