package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CVExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVExperience;

@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {
	
	private CVExperienceService cVExperienceService;

	@Autowired
	public ExperiencesController(CVExperienceService cVExperienceService) {
		super();
		this.cVExperienceService = cVExperienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CVExperience experienceForCV){
		return this.cVExperienceService.add(experienceForCV);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CVExperience experienceForCV){
		return this.cVExperienceService.update(experienceForCV);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.cVExperienceService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CVExperience> getById(@RequestParam int id){
		return this.cVExperienceService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CVExperience>> getAll(){
		return this.cVExperienceService.getAll();
	}
	
	@GetMapping("/getAllByCandidateIdOrderByEndAtDesc")
	public DataResult<List<CVExperience>> getAllByCandidateIdOrderByEndAtDesc(@RequestParam("id") int id){
		return this.cVExperienceService.getAllByCandidateIdOrderByEndAtDesc(id);
	}
	
	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<CVExperience>> getAllByCandidateId(@RequestParam int id){
		return this.cVExperienceService.getAllByCandidateId(id);
	}
}
