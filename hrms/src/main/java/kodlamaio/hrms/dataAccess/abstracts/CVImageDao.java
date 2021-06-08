package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CVImage;

public interface CVImageDao extends JpaRepository<CVImage, Integer>{

	CVImage getById(int id);
	CVImage getByCandidate_id(int id);
}
