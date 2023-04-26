package mk.finki.ukim.eshop.service;

import mk.finki.ukim.eshop.model.Country;
import mk.finki.ukim.eshop.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    CountryServiceImpl(CountryRepository countryRepository){
        this.countryRepository=countryRepository;
    }
    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        Country country=new Country(name,continent);
        this.countryRepository.save(country);
        return Optional.of(country);
    }
}
