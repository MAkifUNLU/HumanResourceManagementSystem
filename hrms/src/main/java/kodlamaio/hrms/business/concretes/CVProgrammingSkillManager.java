package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CVProgrammingSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVProgrammingSkillDao;
import kodlamaio.hrms.entities.concretes.CVProgrammingSkill;

@Service
public class CVProgrammingSkillManager implements CVProgrammingSkillService{

	private CVProgrammingSkillDao cVProgrammingSkillDao;

	@Autowired
	public CVProgrammingSkillManager(CVProgrammingSkillDao cVProgrammingSkillDao) {
		super();
		this.cVProgrammingSkillDao = cVProgrammingSkillDao;
	}

	@Override
	public Result add(CVProgrammingSkill cVProgrammingSkill) {
		this.cVProgrammingSkillDao.save(cVProgrammingSkill);
		return new SuccessResult("Yetenek Eklendi");
	}

	@Override
	public Result update(CVProgrammingSkill cVProgrammingSkill) {
		this.cVProgrammingSkillDao.save(cVProgrammingSkill);
		return new SuccessResult("Yetenek Güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.cVProgrammingSkillDao.deleteById(id);
		return new SuccessResult("Yetenek Silindi");
	}

	@Override
	public DataResult<CVProgrammingSkill> getById(int id) {
		return new SuccessDataResult<CVProgrammingSkill>(this.cVProgrammingSkillDao.findById(id).get());
	}

	@Override
	public DataResult<List<CVProgrammingSkill>> getAll() {
		return new SuccessDataResult<List<CVProgrammingSkill>>(this.cVProgrammingSkillDao.findAll());
	}

	@Override
	public DataResult<List<CVProgrammingSkill>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CVProgrammingSkill>>(this.cVProgrammingSkillDao.getAllByCandidate_id(id));
	}
	
	
}
