package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVCoverLetter;

public interface CVCoverLetterService {

	Result add(CVCoverLetter cVCoverLetter);
	Result delete(int id);
	Result update(CVCoverLetter cVCoverLetter);
	DataResult<CVCoverLetter> getById(int id);	
	DataResult<List<CVCoverLetter>> getAll();
}
