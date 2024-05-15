package etf.ip.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import etf.ip.model.Categories;
import etf.ip.model.Programs;
import etf.ip.model.Users;
import etf.ip.repository.CategoriesRepository;
import etf.ip.repository.ProgramsRepository;
import etf.ip.repository.UsersRepository;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("http://localhost:4200")
public class ProgramsController {
	@Autowired
	private ProgramsRepository programsRep;
	
	@Autowired
	private CategoriesRepository categoriesRep;
	
	@Autowired
	private UsersRepository usersRep;
	
	
	
	@GetMapping("/search")
	public Page<Programs> searchPrograms(
			@RequestParam String searchFor,
			@RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size
			){
		return programsRep.searchPrograms(searchFor, PageRequest.of(page, size));
	}
	
	
	@GetMapping("/programs")												// get all programs -- with pagination
	public List<Programs> getAllPrograms(Pageable pageable){
		return programsRep.findAll(pageable).getContent();
	}
	
	
	@GetMapping("/programs/sorted")											// get all programs -- sorted -- with pagination
	public List<Programs> getAllProgramsSorted(
			@RequestParam(defaultValue = "ASC") 	String direction, 
			@RequestParam(defaultValue = "price") 	String field,
			@RequestParam(defaultValue = "0") 		int page,
            @RequestParam(defaultValue = "5") 		int size){
		
		
		Sort sort = Sort.by(direction.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, field);
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<Programs> programsPage = programsRep.findAll(pageable);	
		
		return programsPage.getContent();
	}
	
	
	@GetMapping("/programs/filtered")										// get all programs -- filtered -- with pagination
	public List<Programs> getAllProgramsFiltered(	@RequestParam String categoryName, 
													@RequestParam String difficulty,
													@RequestParam String location,
													@RequestParam(defaultValue = "0.0") String price1,		// Need double
													@RequestParam(defaultValue = "999999.0") String price2,	// Need double
													@RequestParam(defaultValue = "0") String page,			// Need int
										            @RequestParam(defaultValue = "5") String size){			// Need int
		
		Pageable pageable = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
		
		return programsRep.getFiltered(
				(categoryName == null || categoryName.equals("") || categoryName.equals("xxx")) ? null : categoryName, 
				(difficulty   == null || difficulty.equals("")   || difficulty.equals("xxx")) ? null : difficulty, 
				(location 	  == null || location.equals("")     || location.equals("xxx")) ? null : location, 
				(price1 	  == null || price1.equals("999999.0") || price1.equals("xxx")) ? null : Double.parseDouble(price1), 
				(price2 	  == null || price2.equals("999999.0") || price2.equals("xxx")) ? null : Double.parseDouble(price2),
				pageable
				).getContent();
	}
	
	
	
	@PostMapping("/add/program")
	public ResponseEntity<?> addProgram(	@RequestParam String name,
											@RequestParam String description,
											@RequestParam String price,			// need double
											@RequestParam String difficulty,
											@RequestParam String duration,
											@RequestParam String location,
											@RequestParam String activity_type,
											@RequestParam String equipment,
											@RequestParam String bodyweight,	// need boolean
											@RequestParam String image,
											@RequestParam String categoryName,	
											@RequestParam String trainerName
											) {
		
		Optional<Categories> category = categoriesRep.findByName(categoryName);
		Optional<Users> trainer = usersRep.findByUsername(trainerName);
		
		
		Programs program = new Programs(
			name           , 
			description    ,
			Double.parseDouble(price), 
			difficulty     , 
			duration       , 
			location       , 
			activity_type  , 
			equipment        , 
			Boolean.parseBoolean(bodyweight), 
			image          ,
			category.get() ,
			null 		   ,
			trainer.get()  ,
			null
			);
		
		System.out.println(program.getName() + program.getDescription());
		
        programsRep.save(program);
        return ResponseEntity.ok("Program added successfully!");
    }

	
}
