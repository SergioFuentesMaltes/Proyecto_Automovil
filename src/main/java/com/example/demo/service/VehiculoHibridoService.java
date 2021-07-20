package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.VehiculoHibrido;

public interface VehiculoHibridoService {

	Integer count();            // Método para devolver el número de Vehiculos hibrido.

	List<VehiculoHibrido> findAll();        // Método findAll() para devolver TODOS los Vehiculos hibrido.

	List<VehiculoHibrido> findByColor(String color);      // Método para filtrar por color

	List<VehiculoHibrido> findByNumPuertas(int numPuertas);      // Método para filtrar por número de puertas

	List<VehiculoHibrido> findByName(String name);          // Método para filtrar por nombre

	VehiculoHibrido findOne(Long id);          // Método para encontrar solo uno

	VehiculoHibrido save(VehiculoHibrido hibrido);        // Método para guardarlo

	boolean delete(Long id);           // Método para borrarlo

	void deleteAll();

}

	

