package com.desafio.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Opcional para MongoDB

import com.desafio.api.model.Customer;
import com.desafio.api.repository.CustomerRepository;

/**
 * Serviço que encapsula a lógica de negócio para a entidade Customer.
 * Utiliza CustomerRepository para interagir com o MongoDB.
 */
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Retorna uma página de customers cadastrados.
     * @param pageable Informações de paginação (página e tamanho).
     * @return Página de customers.
     */
    public Page<Customer> listAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }


    /**
     * Busca um customer pelo seu ID.
     * @param id O ID (String) do customer.
     * @return Um Optional contendo o customer se encontrado, ou vazio caso contrário.
     */
    public Optional<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    /**
     * Busca customers pelo name (ignorando maiúsculas/minúsculas).
     * @param name O name a ser buscado.
     * @return Lista de customers encontrados.
     */
    public Page<Customer> findByName(String name, Pageable pageable) {
        // Delega diretamente para o método do repositório
        return customerRepository.findByNameIgnoreCase(name, pageable);
    }

    /**
     * Cria um novo customer. Garante que o ID seja nulo para criação.
     * @param customer O objeto Customer a ser criado (sem ID).
     * @return O customer salvo com o ID gerado pelo MongoDB.
     */
    @Transactional // Pode ser útil se houver operações mais complexas
    public Customer create(Customer customer) {
        customer.setId(null); // Garante que é uma criação, MongoDB gerará o ID
        // Aqui poderiam entrar validações de negócio antes de salvar
        return customerRepository.save(customer);
    }

     /**
     * Atualiza um customer existente.
     * Verifica primeiro se o customer com o ID fornecido existe.
     * @param id O ID (String) do customer a ser atualizado.
     * @param customerData Os novos dados para o customer.
     * @return Um Optional contendo o customer atualizado se encontrado e atualizado,
     * ou vazio se o customer com o ID não foi encontrado.
     */
    @Transactional
    public Optional<Customer> update(String id, Customer customerData) {
        return customerRepository.findById(id) // Verifica se existe
            .map(existingCustomer -> {
                // Atualiza os campos do cliente existente com os novos dados
                existingCustomer.setName(customerData.getName());
                existingCustomer.setEmail(customerData.getEmail());
                // Salva o cliente atualizado
                return customerRepository.save(existingCustomer);
            }); // Retorna Optional<Customer> se encontrado e atualizado, ou Optional.empty() se não
    }


    /**
     * Deleta um customer pelo seu ID.
     * @param id O ID (String) do customer a ser deletado.
     * @return true se o customer foi encontrado e deletado, false caso contrário.
     */
    @Transactional
    public boolean delete(String id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Conta o número total de customers cadastrados.
     * @return O número total de customers.
     */
    public long count() {
        return customerRepository.count();
    }
}