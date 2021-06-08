package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CVCoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVCoverLetter;

@RestController
@RequestMapping("/api/coverletters")
public class CoverLettersController {

	private CVCoverLetterService cVCoverLetterService;
	
	@Autowired
	public CoverLettersController(CVCoverLetterService cVCoverLetterService) {
		super();
		this.cVCoverLetterService = cVCoverLetterService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CVCoverLetter coverLetterForCV){
		return this.cVCoverLetterService.add(coverLetterForCV);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CVCoverLetter coverLetterForCV){
		return this.cVCoverLetterService.update(coverLetterForCV);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.cVCoverLetterService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CVCoverLetter> getById(@RequestParam("id") int id){
		return this.cVCoverLetterService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CVCoverLetter>> getAll(){
		return this.cVCoverLetterService.getAll();
	}
	
	
}
