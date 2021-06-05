package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	 JobPositionDao jobPositionDao;
	 
	 @Autowired
	 public JobPositionManager(JobPositionDao jobPositionDao){
		 this.jobPositionDao = jobPositionDao;
	 }
	

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
	}
	
	@Override
	public DataResult<JobPosition> get(int id) {
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.findById(id).get());
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(!this.isTitleExist(jobPosition.getJobTitle())) {
			
			return new ErrorResult("İş Unvanı Mevcut !");
		}
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş Unvanı Eklendi !");	}


	@Override
	public Result delete(JobPosition jobPosition) {
		jobPositionDao.delete(jobPosition);
        return new SuccessResult("Silindi.");
	}


	@Override
	public Result update(JobPosition jobPosition) {
		jobPositionDao.save(jobPosition);
        return new SuccessResult("Güncellendi.");
	}
	
	
	private boolean isTitleExist(String jobTitle) {
		if(this.jobPositionDao.findByJobTitle(jobTitle) != null) {
			return false;
		}
		return true;
	}
}
