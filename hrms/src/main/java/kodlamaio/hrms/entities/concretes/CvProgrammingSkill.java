package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cv_programming_skills")
@AllArgsConstructor
@NoArgsConstructor
public class CVProgrammingSkill extends Base{

	@Column(name = "skill_name")
	private String skillName;
	
	@Min(value = 1)
	@Max(value = 5)
	@Column(name = "level")
	private int level;	
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
}
