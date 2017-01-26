/**
 * 
 */
package fr.imie.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.model.AdresseDTO;
import fr.imie.model.EtablissementDTO;

/**
 * @author imiedev
 *
 */
public class EtablissementDAO implements IEtablissementDAO {
	
	private IConnexionManagement connexionManagement;
	

	public EtablissementDAO(IConnexionManagement connexionManagement) {
		super();
		this.connexionManagement = connexionManagement;
	}

	@Override
	public List<EtablissementDTO> listAllEtablissement() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<EtablissementDTO> etablissementDTOs = new ArrayList<>();
		try {
			connection = connexionManagement.initConnexion();
			String selectAllEtablissementQuery = "Select id, nom, num_rue, nom_rue, code_postal, ville from etablissement";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectAllEtablissementQuery);
			while (resultSet.next()) {
				// System.out.println(resultSet.getString("nom"));

				AdresseDTO adresseDTO = new AdresseDTO().initDTO(resultSet.getInt("num_rue"),
						resultSet.getString("nom_rue"), resultSet.getString("code_postal"),
						resultSet.getString("ville"));
				EtablissementDTO etablissement = new EtablissementDTO().initDTO(resultSet.getString("nom"), adresseDTO);
				etablissement.setId(resultSet.getInt("id"));
				etablissementDTOs.add(etablissement);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connexionManagement.closeJDBCResources(connection, statement, resultSet);
		}
		return etablissementDTOs;
	}

	@Override
	public EtablissementDTO createEtablissement(EtablissementDTO etablissementDTO) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		EtablissementDTO etablissementOut = null;

		try {
			connection = connexionManagement.initConnexion();
			String insertEtablissementQuery = "INSERT INTO etablissement(nom, num_rue, nom_rue, code_postal, ville) VALUES (?,?,?,?,?) returning id, nom, num_rue, nom_rue, code_postal, ville";
			statement = connection.prepareStatement(insertEtablissementQuery);
			statement.setString(1, etablissementDTO.getNom());
			statement.setInt(2, etablissementDTO.getAdresse().getNumero());
			statement.setString(3, etablissementDTO.getAdresse().getNomVoie());
			statement.setString(4, etablissementDTO.getAdresse().getCP());
			statement.setString(5, etablissementDTO.getAdresse().getVille());

			resultSet = statement.executeQuery();
			resultSet.next();
			// System.out.println(resultSet.getString("nom"));

			AdresseDTO adresseDTO = new AdresseDTO().initDTO(resultSet.getInt("num_rue"),
					resultSet.getString("nom_rue"), resultSet.getString("code_postal"), resultSet.getString("ville"));
			etablissementOut = new EtablissementDTO().initDTO(resultSet.getString("nom"), adresseDTO);
			etablissementOut.setId(resultSet.getInt("id"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connexionManagement.closeJDBCResources(connection, statement, resultSet);
		}

		return etablissementOut;

	}

	@Override
	public void deleteEtablissement(EtablissementDTO etablissementDTOToDelete) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = connexionManagement.initConnexion();
			String insertEtablissementQuery = "delete from etablissement where id=?";
			statement = connection.prepareStatement(insertEtablissementQuery);
			statement.setInt(1, etablissementDTOToDelete.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connexionManagement.closeJDBCResources(connection, statement, null);
		}

	}

	@Override
	public EtablissementDTO updateEtablissement(EtablissementDTO etablissementDTOToUpdate) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		EtablissementDTO etablissementOut = null;

		try {
			connection = connexionManagement.initConnexion();
			String insertEtablissementQuery = "UPDATE etablissement set nom=?, num_rue=?, nom_rue=?, code_postal=?, ville=? where id=? returning id, nom, num_rue, nom_rue, code_postal, ville";
			statement = connection.prepareStatement(insertEtablissementQuery);
			statement.setString(1, etablissementDTOToUpdate.getNom());
			statement.setInt(2, etablissementDTOToUpdate.getAdresse().getNumero());
			statement.setString(3, etablissementDTOToUpdate.getAdresse().getNomVoie());
			statement.setString(4, etablissementDTOToUpdate.getAdresse().getCP());
			statement.setString(5, etablissementDTOToUpdate.getAdresse().getVille());
			statement.setInt(6, etablissementDTOToUpdate.getId());

			resultSet = statement.executeQuery();
			resultSet.next();
			// System.out.println(resultSet.getString("nom"));

			AdresseDTO adresseDTO = new AdresseDTO().initDTO(resultSet.getInt("num_rue"),
					resultSet.getString("nom_rue"), resultSet.getString("code_postal"), resultSet.getString("ville"));
			etablissementOut = new EtablissementDTO().initDTO(resultSet.getString("nom"), adresseDTO);
			etablissementOut.setId(resultSet.getInt("id"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connexionManagement.closeJDBCResources(connection, statement, resultSet);
		}

		return etablissementOut;

	}

}
