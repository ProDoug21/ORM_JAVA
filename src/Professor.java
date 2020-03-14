import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {
	@Id
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private int CargaHoraria;
		
	@Column
	private String materiaAplicada;
	
	@Column
	private String area;
	
	@Column
	private String CoordenadorResponsavel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCargaHoraria() {
		return CargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		CargaHoraria = cargaHoraria;
	}

	public String getMateriaAplicada() {
		return materiaAplicada;
	}

	public void setMateriaAplicada(String materiaAplicada) {
		this.materiaAplicada = materiaAplicada;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCoordenadorResponsavel() {
		return CoordenadorResponsavel;
	}

	public void setCoordenadorResponsavel(String coordenadorResponsavel) {
		CoordenadorResponsavel = coordenadorResponsavel;
	}
	

}

