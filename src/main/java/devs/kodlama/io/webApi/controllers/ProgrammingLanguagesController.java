package devs.kodlama.io.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import devs.kodlama.io.business.abstracts.ProgrammingLanguageService;
import devs.kodlama.io.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("api/programmingLanguages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getAll")	
	public List<ProgrammingLanguage> getAll(){
		return this.programmingLanguageService.getAll();
	}
	
	@GetMapping("/getById")	
	public ProgrammingLanguage getById(@RequestParam int id){
		return this.programmingLanguageService.getById(id);
	}
	
	@PostMapping("/add")
	public String add(@RequestBody ProgrammingLanguage programmingLanguage){
		return this.programmingLanguageService.add(programmingLanguage);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody ProgrammingLanguage programmingLanguage){
		return this.programmingLanguageService.update(programmingLanguage);
	}
	
	@DeleteMapping("/delete")
	public String delete(int id){
		return this.programmingLanguageService.delete(id);
	}
}
