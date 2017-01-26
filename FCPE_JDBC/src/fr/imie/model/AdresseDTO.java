/**
 * 
 */
package fr.imie.model;

/**
 * @author imiedev
 *
 */
public class AdresseDTO {

	private Integer numero;
	private String nomVoie;
	private String CP;
	private String ville;

	public AdresseDTO initDTO(Integer numero, String nomVoie, String cP, String ville) {
		this.numero = numero;
		this.nomVoie = nomVoie;
		this.CP = cP;
		this.ville = ville;
		return this;
	}

	public String getMergedAdress() {
		return String.format("%s %s %S %s", this.getNumero(), this.getNomVoie(), this.getCP(),
				this.getVille());
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNomVoie() {
		return nomVoie;
	}

	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String cP) {
		CP = cP;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
