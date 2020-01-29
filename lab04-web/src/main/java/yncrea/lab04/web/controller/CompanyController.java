package yncrea.lab04.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yncrea.lab04.core.dao.CompanyDAO;
import yncrea.lab04.core.entity.Company;
import yncrea.lab04.core.service.CompanyService;

import java.util.List;

@Controller
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value="/list")
    public String getListOfCompanies(ModelMap modelMap) {

        List<Company> companiesList = companyService.findAllWithProjects();
        modelMap.put("companies", companiesList);
        return "companiesList";
    }

    @RequestMapping(value="/form")
    public String getForm(ModelMap modelMap) {
        Company company = new Company();
        modelMap.put("company", company);
        return "companyForm";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("company") Company company) {

        companyService.save(company);
        return "redirect:/list";
    }

    @RequestMapping(value = "/{company.id}/delete", method = RequestMethod.GET)
    public String deleteCompany(@PathVariable("company.id") long id) {
        companyService.deleteById(id);
        return "redirect:/list";
    }

}
