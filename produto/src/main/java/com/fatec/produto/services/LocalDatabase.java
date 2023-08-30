package com.fatec.produto.services;

import com.fatec.produto.model.entities.Produto;
import com.fatec.produto.model.repository.IProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class LocalDatabase {
    @Bean
    CommandLineRunner initDatabase (IProdutoRepository repository) {
        return args -> {
            Produto produto1 = new Produto("Tirante Brastemp", "Máquinas de lavar", 300.00, 10);
            Produto produto2 = new Produto("Conjunto Facas Tramontina", "Utensílios", 10.00, 15);
            repository.saveAll(Arrays.asList(produto1, produto2));
        };
    }
}
