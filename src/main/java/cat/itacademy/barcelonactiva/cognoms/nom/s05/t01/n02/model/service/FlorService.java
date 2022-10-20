package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain.Flor;


@Service
public interface FlorService {
	public List<Flor> getAll();

	public Flor add(Flor fruita);

	public void delete(int id);

	public Flor getOne(int id);

	public Flor update(Flor fruita);
}
