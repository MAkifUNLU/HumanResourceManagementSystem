package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CVLink;

public interface CVLinkDao extends JpaRepository<CVLink, Integer>{

	List<CVLink> getAllByCandidate_id(int id);
}
