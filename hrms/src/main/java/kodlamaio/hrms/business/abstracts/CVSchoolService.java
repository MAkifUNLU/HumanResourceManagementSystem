package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVSchool;

public interface CVSchoolService {

	Result add(CVSchool cVSchool);
	Result update(CVSchool cVSchoolForCV);
	Result delete(int id);
	DataResult<CVSchool> getById(int id);	
	DataResult<List<CVSchool>> getAll();
	DataResult<List<CVSchool>> getAllByCandidateIdOrderByEndAtDesc(int id);
	DataResult<List<CVSchool>> getAllByCandidateId(int id);
}
