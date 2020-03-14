import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ControllerProfessor {
	EntityManagerFactory gerenciadorConexao;
	EntityManager operador;
	
	public ControllerProfessor() {
		gerenciadorConexao = Persistence.createEntityManagerFactory("UnitPersistencia");
		operador = gerenciadorConexao.createEntityManager();
	}
	
	public Professor BuscarId(int id) {
		operador.getTransaction().begin();
		Professor professor = operador.find(Professor.class,id);
		operador.getTransaction().commit();
		gerenciadorConexao.close();
		return professor;
	}
	
	public void InserirProfessor(Professor professor) {
		operador.getTransaction().begin();
		operador.merge(professor);
		operador.getTransaction().commit();
		gerenciadorConexao.close();
	}
	
	public void RemoverProfessor(Professor professor) {
	
		operador.getTransaction().begin();// Inicia transação no banco//
		Query p = operador.createNativeQuery("DELETE professor FROM professor WHERE id= "+professor.getId());
		p.executeUpdate();
		operador.getTransaction().commit();
		gerenciadorConexao.close();
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Professor> ListarProfessor(){
		operador.getTransaction().begin();
		Query consulta = operador.createQuery("SELECT professor FROM Professor professor");
		List<Professor> listaProfessores = consulta.getResultList();
		operador.getTransaction().commit();
		gerenciadorConexao.close();
		return listaProfessores;
		
	}

}
