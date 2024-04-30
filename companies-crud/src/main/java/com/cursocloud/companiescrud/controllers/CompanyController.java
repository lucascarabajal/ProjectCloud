package com.cursocloud.companiescrud.controllers;

import com.cursocloud.companiescrud.entities.Company;
import com.cursocloud.companiescrud.services.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(path = "company")
@AllArgsConstructor
@Slf4j
@Tag(name = "Companies Resource")
public class CompanyController {
    private final CompanyService companyService;

    @Operation(summary = "Save in DB a company given a company from body")
    @PostMapping
    ResponseEntity<Company> create(@RequestBody Company company) {
        log.info("POST:Creating company name {}", company.getName());
        return ResponseEntity.created(URI.create(companyService.create(company).getName())).build();
    }

    @Operation(summary = "Get a company given a company name")
    @GetMapping(path = "{name}")
    ResponseEntity<Company> getCompany(@PathVariable String name) {
        log.info("GET: Company with name {}", name);
        return ResponseEntity.ok(companyService.readByName(name));
    }

    @Operation(summary = "Update in DB a company given a company from body")
    @PutMapping(path = "{name}")
    ResponseEntity<Company> update(@RequestBody Company company,
                                   @PathVariable String name) {
        log.info("PUT: Update company with name {}", name);
        return ResponseEntity.ok(companyService.update(company, name));
    }

    @Operation(summary = "Delete in DB a company given a company name")
    @DeleteMapping(path = "{name}")
    ResponseEntity<String> delete(@PathVariable String name) {
        log.info("DELETE: Delete company with name {}", name);
        companyService.delete(name);
        return ResponseEntity.noContent().build();
    }


}
