package model.entities.Controllers;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.entities.Materia;
import model.entities.Profesor;

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
	
	public boolean guardar (Materia m) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (m.getId() == 0) {
				em.persist(m);
			}
			else {
				em.merge(m);
			}
			em.getTransaction().commit();
			em.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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
	
	public List<Materia> findFiltrar (String nombre) {

        EntityManager em = factory.createEntityManager();
        Query q = em.createNativeQuery("select * from municipio.materia where nombre like ?", Materia.class);
        q.setParameter(1, "%" + nombre + "%");
        List<Materia> list = (List<Materia>) q.getResultList();
        em.close();

        return list;
    }
	
	
}

