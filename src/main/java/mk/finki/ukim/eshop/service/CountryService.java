package mk.finki.ukim.eshop.service;


import mk.finki.ukim.eshop.model.Author;
import mk.finki.ukim.eshop.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Optional<Country> findById(Long id);
    List<Country> findAll();
    Optional<Country> save(String name, String continent);
}