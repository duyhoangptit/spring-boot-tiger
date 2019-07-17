package vn.hoangptit.tiger.dashboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import vn.hoangptit.tiger.dashboard.entities.UserEntity;
import vn.hoangptit.tiger.dashboard.dao.UserRepository;

import java.util.List;

/**
 * Create file UserServiceImpl
 *
 * @author duyhoangptit
 * @since 7/1/2019
 */
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    void execute(){
        // Lấy ra 5 user đầu tiên
        // PageRequest.of(0,5) tương đương với lấy ra page đầu tiên, và mỗi page sẽ có 5 phần tử
        Page<UserEntity> page = userRepository.findAll(PageRequest.of(0, 5));
        // In ra 5 user đầu tiên
        System.out.println("In ra 5 user đầu tiên: ");
        page.forEach(System.out::println);
        // Lấy ra 5 user tiếp theo
        page = userRepository.findAll(page.nextPageable());

        System.out.println("In ra 5 user tiếp theo: ");
        page.forEach(System.out::println);

        System.out.println("In ra số lượng user ở page hiện tại: " + page.getSize());
        System.out.println("In ra tổng số lượng user: " + page.getTotalElements());
        System.out.println("In ra tổng số page: " + page.getTotalPages());

        // Lấy ra 5 user ở page 1, sort theo tên
        page = userRepository.findAll(PageRequest.of(1, 5, Sort.by("name").descending()));
        System.out.println("In ra 5 user page 1, sắp xếp theo name descending:");
        page.forEach(System.out::println);

        // Custom method
        List<UserEntity> list = userRepository.findAllByNameLike("name-%", PageRequest.of(0, 5));
        System.out.println(list);
    }
}
