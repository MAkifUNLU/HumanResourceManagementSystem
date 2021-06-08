package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CVProgrammingSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVProgrammingSkill;

@RestController
@RequestMapping("/api/programmingSkills")
public class ProgrammingSkillsController {
	
	private CVProgrammingSkillService cVProgrammingSkillService;

	@Autowired
	public ProgrammingSkillsController(CVProgrammingSkillService cVProgrammingSkillService) {
		super();
		this.cVProgrammingSkillService = cVProgrammingSkillService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CVProgrammingSkill programmingSkillForCV){
		return this.cVProgrammingSkillService.add(programmingSkillForCV);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CVProgrammingSkill programmingSkillForCV){
		return this.cVProgrammingSkillService.update(programmingSkillForCV);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.cVProgrammingSkillService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CVProgrammingSkill> getById(@RequestParam("id") int id){
		return this.cVProgrammingSkillService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CVProgrammingSkill>> getAll(){
		return this.cVProgrammingSkillService.getAll();
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<CVProgrammingSkill>> getAllByJobseekerId(@RequestParam int id){
		return this.cVProgrammingSkillService.getAllByCandidateId(id);
	}
}
