package model.entities.Controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.entities.Tipologiasexo;

public class ControladorTipologiaSexo {


	private static ControladorTipologiaSexo instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA"); 
	
	/**
	 * 
	 * @return
	 */
	public static ControladorTipologiaSexo getInstance () {
		if (instance == null) {
			instance = new ControladorTipologiaSexo();
		}
		return instance;
	}
	
	public ControladorTipologiaSexo() {
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Tipologiasexo findPrimero () {
		Tipologiasexo t = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiasexo order by id limit 1", Tipologiasexo.class);
		t = (Tipologiasexo) q.getSingleResult();
		em.close();
		
		return t;
	}
	

	/**
	 * 
	 * @return
	 */
	public Tipologiasexo findUltimo () {
		Tipologiasexo t = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiasexo order by id desc limit 1", Tipologiasexo.class);
		t = (Tipologiasexo) q.getSingleResult();
		em.close();
		
		return t;
	}
	

	/**
	 * 
	 * @return
	 */
	public Tipologiasexo findSiguiente (int idActual) {
		Tipologiasexo t = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiasexo where id > ? order by id limit 1", Tipologiasexo.class);
		q.setParameter(1, idActual);
		t = (Tipologiasexo) q.getSingleResult();
		em.close();
		
		return t;
	}
	public List<Tipologiasexo> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM tipologiasexo", Tipologiasexo.class);
		
		List<Tipologiasexo> list = (List<Tipologiasexo>) q.getResultList();
		em.close();
		return list;
	}

	/**
	 * 
	 * @return
	 */
	public Tipologiasexo findAnterior (int idActual) {
		Tipologiasexo t = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiasexo where id < ? order by id desc limit 1", Tipologiasexo.class);
		q.setParameter(1, idActual);
		t = (Tipologiasexo) q.getSingleResult();
		em.close();
		
		return t;		
	}
	

	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (Tipologiasexo t) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (t.getIdTipologiaSexo() == 0) {
				em.persist(t);
			}
			else {
				em.merge(t);
			}
			em.getTransaction().commit();
			em.close();
			return true;
		}
		catch (Exception e1) {
			e1.printStackTrace();
			return false;
		}
	}



	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public void borrar(Tipologiasexo e) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		em.close();
}

}
