package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CVExperience;

public interface CVExperienceDao extends JpaRepository<CVExperience, Integer>{

	CVExperience getById(int id);
	List<CVExperience> getAllByCandidate_idOrderByEndAtDesc(int id);
	List<CVExperience> getAllByCandidate_id(int id);
}
