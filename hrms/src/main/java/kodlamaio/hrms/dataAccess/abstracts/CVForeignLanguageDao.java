package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CVForeignLanguage;

public interface CVForeignLanguageDao extends JpaRepository<CVForeignLanguage, Integer>{
	List<CVForeignLanguage> getAllByCandidate_id(int id);
}
