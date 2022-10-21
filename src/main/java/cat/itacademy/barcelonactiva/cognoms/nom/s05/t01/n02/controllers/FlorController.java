package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.service.FlorService;

@RestController
public class FlorController {

	@Autowired
	private FlorService service;

//	http://localhost:9001/flor/getAll
	@GetMapping({ "/flor/getAll" })
	public ResponseEntity<?> listarFlores() {
		ResponseEntity<?> respuesta = null;
		try {
			List <Flor> fruites= service.getAll();
			respuesta = new ResponseEntity <List<Flor>> (fruites, HttpStatus.OK);
		}catch(Exception e) {
			respuesta = new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return respuesta;// te devueve el html
	}

//	http://localhost:9001/flor/add
	@PostMapping({ "/flor/add" })
	public ResponseEntity<?> addFlor(@RequestBody Flor flor) {
		ResponseEntity<?> respuesta = null;
		try {
			Flor florGuardada = service.add(flor);
			respuesta = new ResponseEntity <Flor> (florGuardada, HttpStatus.CREATED);
		}catch(Exception e) {
			respuesta = new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return respuesta;// te devueve el html
	}

//	@PostMapping("/save")
//	public String addSucursal(@ModelAttribute("Flor") Flor flor) {
//		service.add(flor);
//		return "redirect:/flor/getAll";
//	}

//	http://localhost:9001/flor/update
	@PutMapping("/flor/update")
	public ResponseEntity<?> updateFlor(@RequestBody Flor flor){
		ResponseEntity<?> respuesta = null;
		try {
			Flor florS = service.add(flor);
			respuesta = new ResponseEntity <Flor> (florS, HttpStatus.CREATED);
		}catch(Exception e) {
			respuesta = new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return respuesta;

	}

//	@PostMapping("/flor/{id}")
//	public Flor actualizarSucursal(@PathVariable int id, Flor sucursal) {
//		Flor sucursalE = service.getOne(id);
//		sucursalE.setId(sucursal.getId());
//		sucursalE.setNom(sucursal.getNom());
//		sucursalE.setPais(sucursal.getPais());
//		return service.update(sucursalE);
//
//	}

//	http://localhost:9001/flor/delete/{id}
	@DeleteMapping(value="/flor/delete/{id}")
	public ResponseEntity<?> deleteFlor(@PathVariable("id") Integer id){
		ResponseEntity<?> respuesta = null;
		try {
			service.delete(id);
			respuesta = new ResponseEntity <String> (service.getOne(id).toString()+" deleted", HttpStatus.OK);
		}catch(Exception e) {
			respuesta = new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return respuesta;
		
	}

//	http://localhost:9001/flor/getOne/{id}
	@GetMapping(value="/flor/getOne/{id}")
	public ResponseEntity<?> getOneFlor(@PathVariable("id") Integer id){
		ResponseEntity<?> respuesta = null;
		try {
			Optional<Flor> flor = Optional.ofNullable(service.getOne(id));
			respuesta = new ResponseEntity (flor, HttpStatus.OK);
		}catch(Exception e) {
			respuesta = new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return respuesta;
		
	}

//	http://localhost:9001/flor/EU/{id}
	@GetMapping("/flor/EU/{id}")
	public FlorDTO getEu(@PathVariable int id, Model model) {
		Flor florE = service.getOne(id);

		return new FlorDTO(florE.getId(), florE.getNom(), florE.getPais());
	}

}
