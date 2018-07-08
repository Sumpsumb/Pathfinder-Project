package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TALENT_CONDITIONS database table.
 * 
 */
@Entity
@Table(name="TALENT_CONDITIONS")
@NamedQuery(name="TalentCondition.findAll", query="SELECT t FROM TalentCondition t")
public class TalentCondition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String kind;

	private String value;

	//bi-directional many-to-one association to Talent
	@ManyToOne
	private Talent talent;

	public TalentCondition() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKind() {
		return this.kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Talent getTalent() {
		return this.talent;
	}

	public void setTalent(Talent talent) {
		this.talent = talent;
	}

}