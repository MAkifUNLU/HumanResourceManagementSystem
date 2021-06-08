package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVImage;

public interface CVImageService {
	Result add(CVImage cVImage, MultipartFile imageFile);
	Result update(CVImage cVImage);
	Result delete(int id);
	DataResult<CVImage> getById(int id);	
	DataResult<List<CVImage>> getAll();
	DataResult<CVImage> getByCandidateId(int id);
}
