package kodlamaio.hrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "cv_images")
@NoArgsConstructor
@AllArgsConstructor
public class CVImage extends Base{

	@Column(name = "url",nullable = false)
	private String url;	

	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "candidate_id", referencedColumnName = "user_id")
	private Candidate candidate;

}
