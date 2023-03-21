package mk.finki.ukim.eshop.repository;

import mk.finki.ukim.eshop.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
