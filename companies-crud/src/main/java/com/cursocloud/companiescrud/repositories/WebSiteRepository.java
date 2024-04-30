package com.cursocloud.companiescrud.repositories;

import com.cursocloud.companiescrud.entities.WebSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebSiteRepository extends JpaRepository<WebSite, Long> {
}
