package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions/")
public class JobPositionController {
			
	 	private JobPositionService jobPositionService;
	    
	 	@Autowired
	    public JobPositionController(JobPositionService jobPositionService) {
			super();
			this.jobPositionService = jobPositionService;
		}

		@GetMapping("getall")
		public DataResult<List<JobPosition>> getAll(){
	        return this.jobPositionService.getAll();
		}
		
		@GetMapping("get")
		public DataResult<JobPosition> get(int id){
			return this.jobPositionService.get(id);
		}
		
		@PostMapping("add")
		public Result add(@RequestBody JobPosition jobPosition) {
			return this.jobPositionService.add(jobPosition);
		} 
		
		@PostMapping("delete")
		public Result delete(@RequestBody JobPosition jobPosition) {
			return this.jobPositionService.delete(jobPosition);
		}
		
		@PostMapping("update")
		public Result update(@RequestBody JobPosition jobPosition) {
			return this.jobPositionService.update(jobPosition);
		}
}
