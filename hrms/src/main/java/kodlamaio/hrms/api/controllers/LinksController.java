package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CVLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVLink;

@RestController
@RequestMapping("/api/links")
public class LinksController {
	
	private CVLinkService cVLinkService;

	@Autowired
	public LinksController(CVLinkService cVLinkService) {
		super();
		this.cVLinkService = cVLinkService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CVLink linkForCV){
		return this.cVLinkService.add(linkForCV);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CVLink linkForCV){
		return this.cVLinkService.update(linkForCV);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.cVLinkService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CVLink> getById(@RequestParam("id") int id){
		return this.cVLinkService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CVLink>> getAll(){
		return this.cVLinkService.getAll();
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<CVLink>> getAllByCandidateId(@RequestParam int id){
		return this.cVLinkService.getAllByCandidateId(id);
	}
}
