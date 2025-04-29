package com.desafio.api.config;

import com.desafio.api.model.Customer;
import com.desafio.api.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class DataSeeder {

    private static final String[] FIRST_NAMES = {"Alice", "Bruno", "Carla", "Daniel", "Fernanda", "Gabriel", "Helena", "Igor", "Juliana", "Lucas"};
    private static final String[] LAST_NAMES = {"Silva", "Costa", "Pereira", "Souza", "Lima", "Almeida", "Gomes", "Rocha", "Martins", "Oliveira"};

    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository) {
        return args -> {
            if (customerRepository.count() == 0) {
                List<Customer> customers = new ArrayList<>();
                Random random = new Random();

                for (int i = 1; i <= 10_000; i++) {
                    String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
                    String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
                    String name = firstName + " " + lastName;
                    String email = (firstName + "." + lastName + i + "@email.com").toLowerCase();
                    String phone = "11" + (10000000 + random.nextInt(90000000)); // Gera um número tipo 11 912345678

                    customers.add(new Customer(name, email, phone));
                }

                customerRepository.saveAll(customers);

                System.out.println(">>> 10.000 clientes inseridos no MongoDB!");
            }
        };
    }
}
