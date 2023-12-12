package ra.orm1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.orm1.model.Customer;
import ra.orm1.reppsitory.CusRepo;
import ra.orm1.service.customer.ICustomerService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {
    @Autowired
    private CusRepo cusRepo;
    @Autowired
    private ICustomerService customerService;


    @RequestMapping("/")
    public String page(Pageable pageable, Model m) {
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
        m.addAttribute("name", customerService.findAll(pageable1));
        return "home";
    }

    @GetMapping("/addUser")
    public String addUser(Model m) {
        Customer customer = new Customer(2L, "Katty Perry", "kate@gmail.com", "Americanthor");
        customerService.save(customer);
        return "home";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        return null;
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        return "home";
    }
}