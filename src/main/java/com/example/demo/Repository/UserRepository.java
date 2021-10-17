package com.example.demo.Repository;

import com.example.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);

    @Query(
          value =  "select * from user " +
                  "inner join user_roles ON user_roles.user_id= user.user_id\n" +
                  "inner join role ON user_roles.id=role.id\n" +
                  "where role.name =\"STUDENT\";",
            nativeQuery = true
    )
    List<User> getStudents();

    @Query(
            value = "select * from user where user_id=?;",
            nativeQuery = true
    )
    User findUserById(Long s);


    User getUserByEmail(String s);

   //User updateUser(User user,Long id);
}