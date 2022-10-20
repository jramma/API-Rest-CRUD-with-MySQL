package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.repository.FlorRepository;



@Service
public class ImplementsFlorService implements FlorService {

	@Autowired
	private FlorRepository repo;

	@Override
	public List<Flor> getAll() {
		return repo.findAll();
	}

	@Override
	public Flor add(Flor flor) {
		return repo.save(flor);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}

	@Override
	public Flor getOne(int id) {
		return repo.findById(id).get();
	}

	@Override
	public Flor update(Flor flor) {
		return repo.save(flor);
	}

}
