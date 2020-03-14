import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ControllerDisciplina {
EntityManagerFactory gerenciadorConexao;
EntityManager operador;

public ControllerDisciplina() {
	gerenciadorConexao = Persistence.createEntityManagerFactory("UnitPersistencia");
	operador = gerenciadorConexao.createEntityManager();
}

public void InserirDisciplina(Disciplina disciplina) {
	operador.getTransaction().begin();
	operador.merge(disciplina);
	operador.getTransaction().commit();
	gerenciadorConexao.close();
}

public void RemoverDisciplina(Disciplina disciplina) {
	operador.getTransaction().begin();
	Query a = operador.createNativeQuery("DELETE disciplina FROM disciplina WHERE code='"+disciplina.getCode()+"'");
	a.executeUpdate();
	operador.getTransaction().commit();
	gerenciadorConexao.close();
	
}

public Disciplina BuscarCode(String code) {
	operador.getTransaction().begin();
	Disciplina disciplina = operador.find(Disciplina.class, code);
	operador.getTransaction().commit();
	gerenciadorConexao.close();
	return disciplina;
	
}

public void AlterarDisciplina(Disciplina disciplina) {
	operador.getTransaction().begin();
	Query qp = operador.createNativeQuery("UPDATE disciplina SET nome = '"+disciplina.getNome()+"',numeroalunos= "+disciplina.getNumeroAlunos()+",turno= '"+disciplina.getTurno()+"'"+" WHERE code = '"+disciplina.getCode()+"'");
	qp.executeUpdate();
	operador.getTransaction().commit();
	gerenciadorConexao.close();
}

@SuppressWarnings("unchecked")
public List<Disciplina> ListarDisciplinas(){
	operador.getTransaction().begin();
	Query consulta = operador.createQuery("SELECT disciplina FROM Disciplina disciplina");
	List<Disciplina> listaDisciplina = consulta.getResultList(); 
	operador.getTransaction().commit();
	gerenciadorConexao.close();
	return listaDisciplina;
	}

}
