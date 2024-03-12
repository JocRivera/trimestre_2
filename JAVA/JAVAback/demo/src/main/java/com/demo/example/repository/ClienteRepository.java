package com.demo.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.example.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
