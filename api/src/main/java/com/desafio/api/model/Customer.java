package com.desafio.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Representa a entidade/documento Customer, mapeada para a coleção "customers" no MongoDB.
 * Define a estrutura de dados para um cliente.
 */
@Document(collection = "customers") // Mapeia para a coleção 'customers'
public class Customer {

    @Id // Identificador único do documento no MongoDB (geralmente String)
    private String id;
    private String name; // Mantendo 'name' como no exemplo original, poderia ser 'name'
    private String email;
    private String phone;

    // Construtores (um vazio é recomendado para frameworks)
    public Customer() {
    }

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonel() {
        return phone;
    }

    public void setPhonel(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
}