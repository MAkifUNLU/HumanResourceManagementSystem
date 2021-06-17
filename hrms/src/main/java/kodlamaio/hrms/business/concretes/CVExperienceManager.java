package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CVExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVExperienceDao;
import kodlamaio.hrms.entities.concretes.CVExperience;

@Service
public class CVExperienceManager implements CVExperienceService{

	private CVExperienceDao cVExperienceDao;
	
	@Autowired
	public CVExperienceManager(CVExperienceDao cVExperienceDao) {
		super();
		this.cVExperienceDao = cVExperienceDao;
	}

	@Override
	public Result add(CVExperience cVExperience) {
		this.cVExperienceDao.save(cVExperience);
		return new SuccessResult("İş Deneyimi Eklendi");
	}

	@Override
	public Result update(CVExperience cVExperience) {
		this.cVExperienceDao.save(cVExperience);
		return new SuccessResult("İş Deneyimi Güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.cVExperienceDao.deleteById(id);
		return new SuccessResult("İş Deneyimi Silindi");
	}

	@Override
	public DataResult<CVExperience> getById(int id) {
		return new SuccessDataResult<CVExperience>(this.cVExperienceDao.findById(id).get());
	}

	@Override
	public DataResult<List<CVExperience>> getAll() {
		return new SuccessDataResult<List<CVExperience>>(this.cVExperienceDao.findAll());
	}

	@Override
	public DataResult<List<CVExperience>> getAllByCandidateIdOrderByEndAtDesc(int id) {
		return new SuccessDataResult<List<CVExperience>>(this.cVExperienceDao.getAllByCandidate_idOrderByEndAtDesc(id));
	}

	@Override
	public DataResult<List<CVExperience>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CVExperience>>(this.cVExperienceDao.getAllByCandidate_id(id));
	}

}
