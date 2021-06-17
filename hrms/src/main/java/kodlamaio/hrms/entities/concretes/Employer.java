package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class Employer extends User{
	
	//@Id
	//@Column(name = "user_id")
	//private int userId;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "is_verified", columnDefinition = "boolean default false")
	private boolean isVerified = false;

	@Column(name = "company_name")
	private String companyName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts;
	
}
