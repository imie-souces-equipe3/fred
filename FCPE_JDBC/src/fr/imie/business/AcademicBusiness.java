/**
 * 
 */
package fr.imie.business;

import java.util.List;

import fr.imie.model.EtablissementDTO;
import fr.imie.persistence.IEtablissementDAO;

/**
 * @author imiedev
 *
 */
public class AcademicBusiness implements IAcademicBusiness {

	private IEtablissementDAO etablissementDAO;

	public AcademicBusiness(IEtablissementDAO etablissementDAO) {
		super();
		this.etablissementDAO = etablissementDAO;
	}

	/* (non-Javadoc)
	 * @see fr.imie.business.IBusiness#listAllEtablissement()
	 */
	@Override
	public List<EtablissementDTO> listAllEtablissement() {
		return etablissementDAO.listAllEtablissement();
	}

	@Override
	public EtablissementDTO createEtablissement(EtablissementDTO etablissementDTO) {
		return etablissementDAO.createEtablissement(etablissementDTO);
	}

	@Override
	public void deleteEtablissement(EtablissementDTO etablissementDTOToDelete) {
		etablissementDAO.deleteEtablissement(etablissementDTOToDelete);
		
	}

	@Override
	public EtablissementDTO updateEtablissement(EtablissementDTO etablissementDTOToUpdate) {
		return etablissementDAO.updateEtablissement(etablissementDTOToUpdate);
		
	}

}
