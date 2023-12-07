package com.tp2;

import com.tp2.service.CompteService;
import com.tp2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@SpringBootApplication
public class Tp2Application implements CommandLineRunner {
    @Autowired
    CompteService compteService;
    @Autowired
    ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(Tp2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Registry registry = LocateRegistry.createRegistry(1099);
        System.setProperty("java.security.policy", "AllPermission.policy");
        // Lier l'objet distant au registre
        registry.bind("CompteService", compteService);
        registry.bind("ProductService", productService);
        System.out.println("Server Started");
    }
}
