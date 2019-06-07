package vn.hoangptit.tiger.repo;

import vn.hoangptit.tiger.model.Laptop;

public interface LaptopRepository {

    Laptop findByLaptopName(String name);
}
