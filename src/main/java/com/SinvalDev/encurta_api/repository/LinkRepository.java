package com.SinvalDev.encurta_api.repository;

import com.SinvalDev.encurta_api.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
