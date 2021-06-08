package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVExperience;

public interface CVExperienceService {

	Result add(CVExperience cVExperience);
	Result update(CVExperience cVExperience);
	Result delete(int id);
	DataResult<CVExperience> getById(int id);	
	DataResult<List<CVExperience>> getAll();
	DataResult<List<CVExperience>> getAllByCandidateIdOrderByEndAtDesc(int id);
	DataResult<List<CVExperience>> getAllByCandidateId(int id);
}
