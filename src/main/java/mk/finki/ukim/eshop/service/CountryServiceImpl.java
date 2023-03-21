package mk.finki.ukim.eshop.service;

import mk.finki.ukim.eshop.model.Country;
import mk.finki.ukim.eshop.repository.CountryRepository;

import java.util.List;

public class CountryServiceImpl implements CountryService {

     public final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAllCountries() {
        return this.countryRepository.findAll();
    }

    @Override
    public void deleteAllCountries() {
        this.countryRepository.deleteAll();

    }

    @Override
    public void deleteCountry(Long id) {
          this.countryRepository.deleteById(id);
    }

    @Override
    public Country getCountryById(Long id) {
        return this.countryRepository.findById(id).orElse(null);
    }
}
