package vn.hoangptit.tiger.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hoangptit.tiger.model.Laptop;
import vn.hoangptit.tiger.repo.LaptopRepository;

@Service
public class LaptopServiceImpl implements LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    @Override
    public Laptop getLaptopRandom() {
        String nameRandom = RandomStringUtils.randomAlphabetic(10).toLowerCase();

        return this.laptopRepository.findByLaptopName(nameRandom);
    }
}
