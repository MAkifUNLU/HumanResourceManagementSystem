package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cv_schools")
@AllArgsConstructor
@NoArgsConstructor
public class CVSchool extends  Base{

	@Column(name = "name")
	private String schoolName;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "start_at")
	private LocalDate startAt;
	
	@Column(name = "end_at", nullable = true)
	private LocalDate endAt;

	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
}
