package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CVSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVSchoolDao;
import kodlamaio.hrms.entities.concretes.CVSchool;

@Service
public class CVSchoolManager implements CVSchoolService{

	private CVSchoolDao cVSchoolDao;
	
	@Autowired
	public CVSchoolManager(CVSchoolDao cVSchoolDao) {
		super();
		this.cVSchoolDao = cVSchoolDao;
	}

	@Override
	public Result add(CVSchool cVSchool) {
		this.cVSchoolDao.save(cVSchool);
		return new SuccessResult("Okul Eklendi");
	}

	@Override
	public Result update(CVSchool cVSchool) {
		this.cVSchoolDao.save(cVSchool);
		return new SuccessResult("Okul Güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.cVSchoolDao.deleteById(id);
		return new SuccessResult("Okul Silindi");
	}

	@Override
	public DataResult<CVSchool> getById(int id) {
		return new SuccessDataResult<CVSchool>(this.cVSchoolDao.getById(id));
	}

	@Override
	public DataResult<List<CVSchool>> getAll() {
		return new SuccessDataResult<List<CVSchool>>(this.cVSchoolDao.findAll());
	}

	@Override
	public DataResult<List<CVSchool>> getAllByCandidateIdOrderByEndAtDesc(int id) {
		return new SuccessDataResult<List<CVSchool>>(this.cVSchoolDao.getAllByCandidate_idOrderByEndAtDesc(id));
	}

	@Override
	public DataResult<List<CVSchool>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CVSchool>>(this.cVSchoolDao.getAllByCandidate_id(id));

	}
}
