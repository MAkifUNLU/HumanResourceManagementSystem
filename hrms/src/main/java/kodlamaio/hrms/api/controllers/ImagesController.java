package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CVImageService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVImage;
import kodlamaio.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/images")
public class ImagesController {
	
	private CVImageService cVImageService;
	private CandidateService candidateService;

	@Autowired
	public ImagesController(CVImageService cVImageService, CandidateService candidateService) {
		super();
		this.cVImageService = cVImageService;
		this.candidateService = candidateService;
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile){
		Candidate candidate = this.candidateService.getById(id).getData();
		CVImage imageForCV = new CVImage();
		imageForCV.setCandidate(candidate);
		return this.cVImageService.add(imageForCV, imageFile);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CVImage imageForCV){
		return this.cVImageService.update(imageForCV);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.cVImageService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CVImage> getById(@RequestParam("id") int id){
		return this.cVImageService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CVImage>> getAll(){
		return this.cVImageService.getAll();
	}
	
	
	@GetMapping("/getByCandidateId")
	public DataResult<CVImage> getByJobseekerId(@RequestParam int id){
		return this.cVImageService.getByCandidateId(id);
	}
}
