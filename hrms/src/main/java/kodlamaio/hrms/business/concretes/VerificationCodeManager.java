package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService{

	@Override
	public Result add(VerificationCode code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(VerificationCode code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(VerificationCode code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<VerificationCode> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<VerificationCode>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
