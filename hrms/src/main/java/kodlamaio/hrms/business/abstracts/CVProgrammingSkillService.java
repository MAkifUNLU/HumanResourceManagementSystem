package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVProgrammingSkill;

public interface CVProgrammingSkillService {
	
	Result add(CVProgrammingSkill cVProgrammingSkill);
	Result update(CVProgrammingSkill cVProgrammingSkill);
	Result delete(int id);
	DataResult<CVProgrammingSkill> getById(int id);	
	DataResult<List<CVProgrammingSkill>> getAll();
	DataResult<List<CVProgrammingSkill>> getAllByCandidateId(int id);
}
