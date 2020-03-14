import javax.persistence.Query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ControllerAluno {
	EntityManagerFactory gerenciadorConexao;
	EntityManager operador;
	
	public ControllerAluno() {
		gerenciadorConexao = Persistence.createEntityManagerFactory("UnitPersistencia");
		operador = gerenciadorConexao.createEntityManager();
	}
	
	public void SalvarAluno(Aluno aluno) {
		operador.getTransaction().begin();// Inicia transação no banco//
		
		operador.merge(aluno);// Salva o aluno no banco//
		
		operador.getTransaction().commit();//Confirmação//
		
		gerenciadorConexao.close(); //Encerra a transação//
	}
	
	public void RemoverAluno(Aluno aluno) {
		operador.getTransaction().begin();// Inicia transação no banco//
		Query w = operador.createNativeQuery("DELETE aluno From aluno where matricula="+aluno.getMatricula());
		w.executeUpdate();
		operador.getTransaction().commit();
		gerenciadorConexao.close(); //Encerra a transação//
	}
	
	public Aluno BuscarPorMatricula(int id) {
		operador.getTransaction().begin();
		Aluno aluno = operador.find(Aluno.class,id);
		operador.getTransaction().commit();
		gerenciadorConexao.close();
		return aluno;
		
	}
	
	public void alterarAluno(Aluno _aluno) {
		  
		  operador.getTransaction().begin();
		  Query q = operador.createNativeQuery("UPDATE aluno SET idade= "+_aluno.getIdade()+",nomeresponsavel= '"+ _aluno.getNomeResponsavel()+"',matricula= '"+_aluno.getMatricula()+"', nome= '"+_aluno.getNome()+ "' WHERE matricula = "+ _aluno.getMatricula());
		  
		  q.executeUpdate();
		  operador.getTransaction().commit();
		  gerenciadorConexao.close();  		
		 }
	
	@SuppressWarnings("unchecked")
	public List<Aluno> ListarAlunos(){
		operador.getTransaction().begin();
		Query consulta = operador.createQuery("SELECT aluno FROM Aluno aluno");
		List<Aluno> listaAlunos = consulta.getResultList(); 
		operador.getTransaction().commit();
		gerenciadorConexao.close();
		return listaAlunos;
		}
	
	

}
