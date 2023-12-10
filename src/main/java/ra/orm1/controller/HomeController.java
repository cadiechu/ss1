package ra.orm1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.orm1.model.Customer;
import ra.orm1.service.customer.CustomerService;

import java.util.List;

@Controller
@ComponentScan(basePackages = "ra.orm1")
@RequestMapping("/")
public class HomeController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("")
    public String customerManager(Model m) {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("customers", customerService.findAllUser());
        return modelAndView;
    }

    @GetMapping("/addUser")
    public String addUser(Model m) {
        public String createCustomer (@ModelAttribute("add") Customer cus){
            customerService.save(cus);
            return "redirect:/";
        }

        @GetMapping("/edit/{id}")
        public String edit (Model model, @PathVariable("id") Long id){
            ModelAndView modelAndView = new ModelAndView("edit");
            Customer customer = customerService.findById(id);
            modelAndView.addObject("editUser", customer);
            return modelAndView;
        }
        @GetMapping("/delete/{id}")
        public ModelAndView deleteCustomer (@PathVariable Long id){
            Customer customer = customerService.findById(id);
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("deleteForm", customer);
            return modelAndView;


        }
