package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	private EmployerService employerservice;

	@Autowired
	public EmployersController(EmployerService employerservice) {
		super();
		this.employerservice = employerservice;
	}
	
	@PostMapping("/add")
		public Result add(@RequestBody Employer employer) {
		return this.employerservice.add(employer);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		return this.employerservice.delete(id);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Employer employer) {
		return this.employerservice.update(employer);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return this.employerservice.getAll();
	}
	
	@GetMapping("/getbyid")
	DataResult<Employer> getById(@RequestParam("id") int id){
		return this.employerservice.getById(id);
	}
	
}
