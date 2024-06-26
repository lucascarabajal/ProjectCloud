package com.cursocloud.companiescrud.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String founder;
    private String logo;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private LocalDate foundationDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "id_company", referencedColumnName = "id")
    private List<WebSite> webSites;
}
