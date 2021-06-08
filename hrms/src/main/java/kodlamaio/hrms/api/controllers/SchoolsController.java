package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CVSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVSchool;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {

	private CVSchoolService cVSchoolService;

	@Autowired
	public SchoolsController(CVSchoolService cVSchoolService) {
		super();
		this.cVSchoolService = cVSchoolService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CVSchool schoolForCV){
		return this.cVSchoolService.add(schoolForCV);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CVSchool schoolForCV){
		return this.cVSchoolService.update(schoolForCV);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id){
		return this.cVSchoolService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CVSchool> getById(@RequestParam int id){
		return this.cVSchoolService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CVSchool>> getAll(){
		return this.cVSchoolService.getAll();
	}
	
	@GetMapping("/getAllByCandidateIdOrderByEndAtDesc")
	public DataResult<List<CVSchool>> getAllByCandidateIdOrderByEndAtDesc(@RequestParam int id){
		return this.cVSchoolService.getAllByCandidateIdOrderByEndAtDesc(id);
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<CVSchool>> getAllByCandidateId(@RequestParam int id){
		return this.cVSchoolService.getAllByCandidateId(id);
	}
}