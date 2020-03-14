import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ControllerCampus {
	EntityManagerFactory gerenciadorconexao;
	EntityManager operador;
	
	public ControllerCampus() {
		gerenciadorconexao = Persistence.createEntityManagerFactory("UnitPersistencia");
		operador = gerenciadorconexao.createEntityManager();
	}
	
	
	public void InserirCampus(Campus campus) {
		operador.getTransaction().begin();
		operador.merge(campus);
		operador.getTransaction().commit();
		operador.close();
	}
	
	public void RemoverCampus(Campus campus) {
		operador.getTransaction().begin();
		Query c = operador.createNativeQuery("DELETE campus FROM campus WHERE code= "+campus.getCode());
		c.executeUpdate();
		operador.getTransaction().commit();
		gerenciadorconexao.close();
		
	}
	
	public Campus BuscarCampusCode(int codigo) {
		operador.getTransaction().begin();
		Campus campus = operador.find(Campus.class, codigo);
		operador.getTransaction().commit();
		gerenciadorconexao.close();
		return campus;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Campus> listarCampus(){
		operador.getTransaction().begin();
		Query consulta = operador.createQuery("SELECT campus FROM Campus campus");
		List<Campus> lista = consulta.getResultList();
		operador.getTransaction().commit();
		gerenciadorconexao.close();
		return lista;
		
	}

}
