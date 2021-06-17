package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CVCoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVCoverLetterDao;
import kodlamaio.hrms.entities.concretes.CVCoverLetter;

@Service
public class CVCoverLetterManager implements CVCoverLetterService{
	
	private CVCoverLetterDao cVCoverLetterDao;

	@Autowired
	public CVCoverLetterManager(CVCoverLetterDao cVCoverLetterDao) {
		super();
		this.cVCoverLetterDao = cVCoverLetterDao;
	}

	@Override
	public Result add(CVCoverLetter cVCoverLetter) {
		this.cVCoverLetterDao.save(cVCoverLetter);
		return new SuccessResult("Ön Yazı Eklendi");
	}

	@Override
	public Result delete(int id) {
		this.cVCoverLetterDao.deleteById(id);
        return new SuccessResult("Ön Yazı Silindi");
	}

	@Override
	public Result update(CVCoverLetter cVCoverLetter) {
		this.cVCoverLetterDao.save(cVCoverLetter);
		return new SuccessResult("Ön Yazı Güncellendi");
	}

	@Override
	public DataResult<CVCoverLetter> getById(int id) {
		return new SuccessDataResult<CVCoverLetter>(this.cVCoverLetterDao.findById(id).get());
	}

	@Override
	public DataResult<List<CVCoverLetter>> getAll() {
		return new SuccessDataResult<List<CVCoverLetter>>(this.cVCoverLetterDao.findAll());
	}

}
