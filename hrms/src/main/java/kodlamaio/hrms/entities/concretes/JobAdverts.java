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
@Table(name = "job_adverts")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdverts {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "job_position_id")
	private int jobPositionId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "city_id")
	private int cityId;
	
	@Column(name = "open_position_count")
	private int openPositionCount;
	
	@Column(name = "deadline")
	private Date deadline;
	
	@Column(name = "is_open")
	private boolean isOpen;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	@Column(name = "employer_id")
	private int employerId;
	
	@Column(name = "published_at")
	private Date publishedAt;
	
	@Column(name = "salary_min")
	private int salaryMin;
	
	@Column(name = "salary_max")
	private int salaryMax;
}
