package yncrea.lab04.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import yncrea.lab04.core.entity.Company;
import yncrea.lab04.core.service.CompanyService;

import java.util.List;

@Controller
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping("/list")
    public String getListOfCompanies(ModelMap modelMap) {

        List<Company> companiesList = companyService.findAllWithProjects();
        modelMap.put("companies", companiesList);
        return "companiesList";
    }
}
