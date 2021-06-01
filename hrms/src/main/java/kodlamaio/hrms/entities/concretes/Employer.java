package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User{
	
	@Id
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "phone_number")
	private int phoneNumber;
	
	@Column(name = "is_verified")
	private boolean isVerified;

}
