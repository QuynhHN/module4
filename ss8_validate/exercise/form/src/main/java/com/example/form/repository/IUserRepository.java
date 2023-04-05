package com.example.form.repository;

import com.example.form.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepository extends PagingAndSortingRepository<User,Integer> {
}
