package mk.finki.ukim.eshop.service;


import mk.finki.ukim.eshop.model.Author;
import mk.finki.ukim.eshop.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    void deleteAllCountries();
    void deleteCountry(Long id);
    Country getCountryById(Long id);
}