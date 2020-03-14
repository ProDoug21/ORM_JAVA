import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "campus")
public class Campus {
	@Id
	private int code;
	
	@Column
	private int laboratorios;
	
	@Column
	private int salasAulas;
	
	public int getSalasAulas() {
		return salasAulas;
	}

	public void setSalasAulas(int salasAulas) {
		this.salasAulas = salasAulas;
	}

	@Column
	private String reitor;
	
	@Column
	private String regiao;
	
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getLaboratorios() {
		return laboratorios;
	}

	public void setLaboratorios(int laboratorios) {
		this.laboratorios = laboratorios;
	}

	

	public String getReitor() {
		return reitor;
	}

	public void setReitor(String reitor) {
		this.reitor = reitor;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	
	
	

}
