package com.qy.repository;

import com.qy.pojo.CompanyJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyJPA, Integer> {
}
