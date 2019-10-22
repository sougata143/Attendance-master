package com.sougata.attendance.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sougata.attendance.entity.User;
import com.sougata.attendance.repository.customrepository.UserCustomRepository;

public interface UserRepository extends CrudRepository<User, Long>, UserCustomRepository {

	Optional<User> findById(Long i);

    List<User> findByUserName(String userName);

    // custom query example and return a stream
    @Query("select u from User u where u.userName = :userName")
    Stream<User> findByUserNameReturnStream(@Param("userName") String userName);

}
