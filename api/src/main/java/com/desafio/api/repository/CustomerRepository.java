package com.desafio.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.desafio.api.model.Customer;

/**
 * Interface de Repositório para operações CRUD e consultas
 * na coleção de Customers no MongoDB.
 * Estende MongoRepository<Entidade, TipoDoID>.
 */
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> { // ID é String

    /**
     * Busca customers pelo name (ignorando maiúsculas/minúsculas).
     * Query method implementado automaticamente pelo Spring Data MongoDB.
     * @param name O name a ser buscado.
     * @return Uma lista de customers que correspondem ao name.
     */
    Page<Customer> findByNameIgnoreCase(String nome, Pageable pageable);

    // Outros métodos CRUD básicos (findAll, findById, save, deleteById, count, existsById)
    // são herdados de MongoRepository.
}