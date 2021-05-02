  
package model.entities.Controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Materia;

public class ControladorMateria {
	private static ControladorMateria instance = null;
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");

	/**
	 * 
	 * @return
	 */
	public static ControladorMateria getInstance() {
		if (instance == null) {
			instance = new ControladorMateria();
		}
		return instance;
	}

	/**
	 * 
	 * @return
	 */
	public List<Materia> findAll() {
		EntityManager em = factory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM materia", Materia.class);

		List<Materia> list = (List<Materia>) q.getResultList();
		em.close();
		return list;
	}
}

