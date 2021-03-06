package com.gso.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * Class of persistence UserModel
 * 
 * @author Thiago Batista
 * @since 07/02/2022
 * @version 1.0
 */
@Entity
@Table(name = "tb_users")
public class UserModel {

  // System generated
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long idUser;

  // User generated
  @NotNull(message = "Attribute Name is Obligatory!")
  private String name;

  @NotNull(message = "Attribute Email is Obligatory!")
  @Email(message = "Inform a valid Email")
  private String email;

  @NotNull(message = "Attribute Password is Obligatory")
  private String password;

  public UserModel(Long idUser, String name, String email, String password) {
    this.idUser = idUser;
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public UserModel() {
  }

  // Getters and Setters

  public Long getIdUser() {
    return this.idUser;
  }

  public void setIdUser(Long idUser) {
    this.idUser = idUser;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
