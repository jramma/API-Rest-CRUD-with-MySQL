package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.service.FlorService;



@Controller
public class FlorController {

	@Autowired
	private FlorService service;

//	http://localhost:9001/flor/getAll
	@GetMapping({ "/flor/getAll" })
	public String listarSucursales(Model model) {
		model.addAttribute("flor", service.getAll());
		return "index"; // te devueve el html
	}

//	http://localhost:9001/flor/add
	@GetMapping({ "/flor/add" })
	public String editarFruta(Model model) {
		Flor flor = new Flor();
		model.addAttribute("Flor", flor);
		return "update"; // te devueve el html
	}

	@PostMapping("/save")
	public String addSucursal(@ModelAttribute("Flor") Flor flor) {
		service.add(flor);
		return "redirect:/flor/getAll";
	}

//	http://localhost:9001/flor/update
	@GetMapping("/flor/update/{id}")
	public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
		model.addAttribute("flor", service.getOne(id));
		return "editar";

	}

	@PostMapping("/flor/{id}")
	public String actualizarSucursal(@PathVariable int id, @ModelAttribute("flor") Flor sucursal, Model model) {
		Flor sucursalE = service.getOne(id);
		sucursalE.setId(sucursal.getId());
		sucursalE.setNom(sucursal.getNom());
		sucursalE.setPais(sucursal.getPais());
		service.update(sucursalE);
		return "redirect:/flor/getAll";

	}

//	http://localhost:9001/flor/delete/{id}
	@GetMapping("/flor/delete/{id}")
	public String eliminarFruita(@PathVariable int id) {
		service.delete(id);
		return "redirect:/flor/getAll";
	}

//	http://localhost:9001/flor/getOne/{id}
	@GetMapping("/flor/getOne/{id}")
	public String getSucursal(@PathVariable int id, Model model) {
		model.addAttribute("flor", service.getOne(id));
		return "index";
	}
//	http://localhost:9001/flor/EU/{id}
	@GetMapping("/flor/EU/{id}")
	public String getEu(@PathVariable int id, Model model) {
		Flor florE = service.getOne(id);
		FlorDTO dto = new FlorDTO(florE.getId(),florE.getNom(),florE.getPais()) ;
		model.addAttribute("Flor", dto);	
		
		return "EU";
	}

}
