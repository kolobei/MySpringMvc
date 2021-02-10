/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Family;
import emergon.service.FamilyService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/family")
public class FamilyController {
    
    @Autowired
    private FamilyService familyService;
    
    @RequestMapping
    public ModelAndView showFamilies(ModelAndView modelAndView){
        List<Family> families = familyService.getFamily();
        modelAndView.addObject("listOfSalesmen", families);
        modelAndView.setViewName("/family/familyList"); // returns the path where the jsp page exists
        //  WEB-INF/views/family/familyList.jsp
        return modelAndView;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(@ModelAttribute("poliths") Family family){
        return "family/familyForm";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("family") Family family, 
            BindingResult result, 
            RedirectAttributes attributes){
        if(result.hasErrors()){
            return "family/familyForm";
        }
        familyService.saveFamily(family);
        String minima = "Family " + family.getFname()+ " successfully created!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/family";//Redirect instructs client to sent a new GET request to /family
    }
    
    @GetMapping(value = "/delete")
    public String delete(@RequestParam(value = "id") int id, RedirectAttributes attributes){
        familyService.deleteFamily(id);
        String minima = "Family succesfully deleted";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/family";
    }
    
    //localhost:8080/MySpringMVCApp/family/update/30
    @GetMapping("/update/{fid}")
    public String showFormUpdate(@PathVariable(name = "fid") int fid, Model model){
        Family family = familyService.getFamilyById(fid);
        model.addAttribute("familyToEdit", family);
        return "family/familyForm";
    }
    
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("family")Family family,
            BindingResult result,
            RedirectAttributes attributes){
        if(result.hasErrors()){
            return "family/familyForm";
        }
        familyService.saveFamily(family);
        String minima = "Family updated successfully!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/family";
    }
    
    @GetMapping("/{scode}")
    public String showFamily(@PathVariable(name = "scode") int scode, Model model){
        List<Family> families  = familyService.getFamilyBySalesman(scode);
        model.addAttribute("listOfFamilies", families);
        return "family/salesmanFamilyList";
    }
    
    
    
}
