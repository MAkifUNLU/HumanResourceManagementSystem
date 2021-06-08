package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVForeignLanguage;

public interface CVForeignLanguageService {
	Result add(CVForeignLanguage cVForeignLanguage);
	Result update(CVForeignLanguage cVForeignLanguage);
	Result delete(int id);
	DataResult<CVForeignLanguage> getById(int id);	
	DataResult<List<CVForeignLanguage>> getAll();
	DataResult<List<CVForeignLanguage>> getAllByCandidateId(int id);
}
