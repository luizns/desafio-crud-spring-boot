package com.github.luizns.desafiocrud.repository;

import com.github.luizns.desafiocrud.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
