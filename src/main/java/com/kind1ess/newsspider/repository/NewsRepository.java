package com.kind1ess.newsspider.repository;


import com.kind1ess.newsspider.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News,Integer> ,CustomRepository{
}
