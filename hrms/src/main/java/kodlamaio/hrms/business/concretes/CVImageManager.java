package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CVImageService;
import kodlamaio.hrms.core.utilities.imageUpload.ImageUploadService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVImageDao;
import kodlamaio.hrms.entities.concretes.CVImage;

@Service
public class CVImageManager implements CVImageService{
	
	private CVImageDao cVImageDao;
	private ImageUploadService imageUploadService;

	@Autowired
	public CVImageManager(CVImageDao cVImageDao, ImageUploadService imageUploadService) {
		super();
		this.cVImageDao = cVImageDao;
		this.imageUploadService = imageUploadService;
	}
	
	@Override
	public Result add(CVImage cVImage, MultipartFile imageFile) {
		Map<String,String> uploadImage = this.imageUploadService.uploadImageFile(imageFile).getData();
		cVImage.setUrl(uploadImage.get("url"));
		this.cVImageDao.save(cVImage);
		return new SuccessResult("Resim Eklendi");
	}

	@Override
	public Result update(CVImage cVImage) {
		this.cVImageDao.save(cVImage);
		return new SuccessResult("Resim Güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.cVImageDao.deleteById(id);
		return new SuccessResult("Resim Silindi");
	}

	@Override
	public DataResult<CVImage> getById(int id) {
		return new SuccessDataResult<CVImage>(this.cVImageDao.getById(id));
	}

	@Override
	public DataResult<List<CVImage>> getAll() {
		return new SuccessDataResult<List<CVImage>>(this.cVImageDao.findAll());
	}

	@Override
	public DataResult<CVImage> getByCandidateId(int id) {
		return new SuccessDataResult<CVImage>(this.cVImageDao.getByCandidate_id(id));
	}

}
