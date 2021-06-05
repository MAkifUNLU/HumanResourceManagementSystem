package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getById(int id);
	Result add(Candidate candidate);
	Result delete(int id);
	Result update(Candidate candidate);
	
	DataResult<Candidate> getCandidateByNationalId(String nationalId);
	//DataResult<CandidateCVDto> getJobseekerCVById(int id);
}
