package vn.hoangptit.tiger.repo;

import org.springframework.stereotype.Repository;
import vn.hoangptit.tiger.model.Dell;
import vn.hoangptit.tiger.model.Laptop;

@Repository
public class LaptopRepositoryImpl implements LaptopRepository {
    @Override
    public Laptop findByLaptopName(String name) {
        System.out.println(name);
        return new Dell(name);
    }
}
