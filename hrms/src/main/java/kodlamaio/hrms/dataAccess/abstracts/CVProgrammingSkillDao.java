package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CVProgrammingSkill;

public interface CVProgrammingSkillDao extends JpaRepository<CVProgrammingSkill, Integer>{
	CVProgrammingSkill getById(int id);
	List<CVProgrammingSkill> getAllByCandidate_id(int id);
}
