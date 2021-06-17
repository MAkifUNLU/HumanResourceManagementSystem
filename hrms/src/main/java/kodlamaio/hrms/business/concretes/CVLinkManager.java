package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CVLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVLinkDao;
import kodlamaio.hrms.entities.concretes.CVLink;

@Service
public class CVLinkManager implements CVLinkService{
	
	private CVLinkDao cVLinkDao;	
	
	@Autowired
	public CVLinkManager(CVLinkDao cVLinkDao) {
		super();
		this.cVLinkDao = cVLinkDao;
	}
	
	@Override
	public Result add(CVLink cVLink) {
		this.cVLinkDao.save(cVLink);
		return new SuccessResult("Link Eklendi");
	}	

	@Override
	public Result update(CVLink cVLink) {
		this.cVLinkDao.save(cVLink);
		return new SuccessResult("Link Güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.cVLinkDao.deleteById(id);
		return new SuccessResult("Link Silindi");
	}

	@Override
	public DataResult<CVLink> getById(int id) {
		return new SuccessDataResult<CVLink>(this.cVLinkDao.findById(id).get());
	}

	@Override
	public DataResult<List<CVLink>> getAll() {
		return new SuccessDataResult<List<CVLink>>(this.cVLinkDao.findAll());
	}

	@Override
	public DataResult<List<CVLink>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CVLink>>(this.cVLinkDao.getAllByCandidate_id(id));
	}

}
