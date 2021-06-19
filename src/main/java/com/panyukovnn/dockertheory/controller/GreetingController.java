package com.panyukovnn.dockertheory.controller;

import com.panyukovnn.dockertheory.model.Customer;
import com.panyukovnn.dockertheory.repository.CustomerRepository;
import com.panyukovnn.dockertheory.service.NameGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class GreetingController {

    private final CustomerRepository customerRepository;
    private final NameGenerator nameGenerator = new NameGenerator(7);

    @GetMapping("/")
    public String getIndex(Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm dd.MM.yyyy");
        model.addAttribute("dateTime", formatter.format(LocalDateTime.now()));

        for (int i = 0; i < 1; i++) {
            saveRandomCustomer();
        }
        model.addAttribute("customers", customerRepository.findAll());

        return "index";
    }

    private void saveRandomCustomer() {
        Customer newCustomer = new Customer();
        newCustomer.setName(nameGenerator.getName());
        newCustomer.setUuid(UUID.randomUUID());

        customerRepository.save(newCustomer);
    }
}
