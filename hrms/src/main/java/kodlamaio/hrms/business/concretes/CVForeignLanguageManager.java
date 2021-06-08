package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CVForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVForeignLanguageDao;
import kodlamaio.hrms.entities.concretes.CVForeignLanguage;

@Service
public class CVForeignLanguageManager implements CVForeignLanguageService{
	
	private CVForeignLanguageDao cVForeignLanguageDao;

	@Autowired
	public CVForeignLanguageManager(CVForeignLanguageDao cVForeignLanguageDao) {
		super();
		this.cVForeignLanguageDao = cVForeignLanguageDao;
	}

	@Override
	public Result add(CVForeignLanguage cVForeignLanguage) {
		this.cVForeignLanguageDao.save(cVForeignLanguage);
		return new SuccessResult("Yabancı Dil Eklendi");
	}

	@Override
	public Result update(CVForeignLanguage cVForeignLanguage) {
		this.cVForeignLanguageDao.save(cVForeignLanguage);
		return new SuccessResult("Yabancı Dil Günceellendi");
	}

	@Override
	public Result delete(int id) {
		this.cVForeignLanguageDao.deleteById(id);;
		return new SuccessResult("Yabancı Dil Silindi");
	}

	@Override
	public DataResult<CVForeignLanguage> getById(int id) {
		return new SuccessDataResult<CVForeignLanguage>(this.cVForeignLanguageDao.getById(id));
	}

	@Override
	public DataResult<List<CVForeignLanguage>> getAll() {
		return new SuccessDataResult<List<CVForeignLanguage>>(this.cVForeignLanguageDao.findAll());
	}

	@Override
	public DataResult<List<CVForeignLanguage>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CVForeignLanguage>>(this.cVForeignLanguageDao.getAllByCandidate_id(id));
	}

}
