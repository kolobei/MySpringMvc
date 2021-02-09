/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Salesman;
import emergon.service.SalesmanService;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author gkolo
 */
@Controller
@RequestMapping("/salesman")
public class SalesmanController {
    
    @Autowired
    private SalesmanService salesmanService;
    
    
    @RequestMapping
    public ModelAndView showSalesmen(ModelAndView modelAndView){
        List<Salesman> salesmen = salesmanService.getSalesmen();
        modelAndView.addObject("listOfSalesmen", salesmen);
        modelAndView.setViewName("/salesman/salesmanList"); // returns the path where the jsp page exists
        //  WEB-INF/views/salesman/salesmanList.jsp
        return modelAndView;
    }
    
    /**
     * URLs
     * /salesman/create : GET  (salesmanList.jsp - link)
     * /salesman/create : POST (salesmanForm.jsp - form)
     */
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(){
        return "salesman/salesmanForm";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Salesman salesman, RedirectAttributes attributes){
        salesmanService.saveSalesman(salesman);
        String minima = "Salesman " + salesman.getSname() + " succesfully created";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/salesman"; // Client send a new GET request to /salesman
    }
    
    @GetMapping(value = "/delete")
    public String delete(@RequestParam(value = "id") int id, RedirectAttributes attributes){
        salesmanService.deleteSalesman(id);
        String minima = "Salesman succesfully deleted";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/salesman";
    }
    
    //localhost:8080/MySpringMVCApp/salesman/update/30
    @GetMapping("/update/{scode}")
    public String showFormUpdate(@PathVariable(name = "scode") int scode, Model model){
        Salesman salesman = salesmanService.getSalesmanById(scode);
        model.addAttribute("salesmanToEdit", salesman);
        return "salesman/salesmanForm";
    }
    
    @PostMapping("/update")
    public String update(Salesman salesman, RedirectAttributes attributes){
        salesmanService.saveSalesman(salesman);
        String minima = "Salesman updated succesfully";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/salesman";
    }
    
    
    @ModelAttribute(name = "listOfCities")
    public List<String> getCities(){
        return salesmanService.getCities();
    
    }
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleException(RedirectAttributes attributes){
        String minima = "Could not commit transaction";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/salesman";
    }
    
    
}
