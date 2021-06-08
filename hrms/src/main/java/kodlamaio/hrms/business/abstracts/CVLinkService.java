package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVLink;

public interface CVLinkService {
	
	Result add(CVLink cVLink);
	Result update(CVLink cVLink);
	Result delete(int id);
	DataResult<CVLink> getById(int id);	
	DataResult<List<CVLink>> getAll();
	DataResult<List<CVLink>> getAllByCandidateId(int id);
}
