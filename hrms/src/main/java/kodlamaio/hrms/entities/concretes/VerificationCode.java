package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

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
@Table(name = "verification_codes")
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCode extends Base{
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "is_confirmed")
	private boolean isConfirmed;

}
