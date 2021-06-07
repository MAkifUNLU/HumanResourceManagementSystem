package kodlamaio.hrms.entities.concretes;





import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends User{
	
	//@Id
	//@Column(name = "user_id")
	//private int userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "national_id")
	private String nationalId;
	
	@Column(name = "is_verified", columnDefinition = "boolean default false")
	private boolean isVerified = false;
	
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvProgrammingSkill> programingSkills;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvLink> links;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvForeignLanguage> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvExperience> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvCoverLetter> coverLetters;	

	@JsonIgnore
	@OneToOne(mappedBy = "candidate", optional=false, fetch=FetchType.LAZY)
	private CvImage image;
	
}
