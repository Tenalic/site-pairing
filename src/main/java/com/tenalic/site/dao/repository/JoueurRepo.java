package com.tenalic.site.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tenalic.site.dao.object.JoueurDao;

public interface JoueurRepo extends CrudRepository<JoueurDao, Integer> {

	List<JoueurDao> findByIdTournoi(int idTournoi);

	Optional<JoueurDao> findByCossyAndIdTournoi(String cossy, int idTournoi);

}
