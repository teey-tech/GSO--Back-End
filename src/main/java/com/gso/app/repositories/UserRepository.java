package com.gso.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gso.app.models.UserModel;

/**
 * UserRepository responsible for CRUD operations on UserModel
 * 
 * @author Thiago Batista
 * @since 07/02/2022
 * @version 1.0
 * @see UserModel
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

  /**
   * Method responsible for find user by email
   * 
   * @author Thiago Batista
   * @since 07/02/2022
   * @version 1.0
   * @param email
   * @return Optional<UserModel>
   */
  public Optional<UserModel> findByEmail(String email);

}
