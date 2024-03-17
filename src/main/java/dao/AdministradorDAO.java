package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dto.AdministradorDTO;
import model.Administrador;
import model.Livro;

public class AdministradorDAO implements AdministradorInterfaceDAO{

	@Override
	public boolean salvar(AdministradorDTO admDTO) throws Exception {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrariaProjeto");
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.persist(new Administrador(admDTO));
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			return true;
			
		}catch (Exception e) {			
			throw e;
			
		}
	}
	

	@Override
	public List<Administrador> buscarADM() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrariaProjeto");
		EntityManager em = emf.createEntityManager();
		
		try {
			TypedQuery<Administrador> todosLivros = em.createQuery("FROM Administrador a", Administrador.class);
			return todosLivros.getResultList();
			
		} catch(Exception e) {
			throw e;
			
		}finally {
			em.close();
			emf.close();
		}
		
	}

}
