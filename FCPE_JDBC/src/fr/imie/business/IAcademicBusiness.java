/**
 * 
 */
package fr.imie.business;

import java.util.List;

import fr.imie.model.EtablissementDTO;

/**
 * @author imiedev
 *
 */
public interface IAcademicBusiness {
	
	public abstract List<EtablissementDTO> listAllEtablissement();
	public abstract EtablissementDTO createEtablissement(EtablissementDTO etablissementDTO);
	public abstract void deleteEtablissement(EtablissementDTO etablissementDTOToDelete);
	public abstract EtablissementDTO updateEtablissement(EtablissementDTO etablissementDTOToUpdate);

}
