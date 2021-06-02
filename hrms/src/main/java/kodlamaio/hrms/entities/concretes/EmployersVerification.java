package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers_verification_employees")
@AllArgsConstructor
@NoArgsConstructor
public class EmployersVerification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "employer_id")
	private int employerId;
	
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	//boolean lı bişe lazım gibi
	
}