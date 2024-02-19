package com.tcs.investment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.investment.model.Investor;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Integer> {

}
