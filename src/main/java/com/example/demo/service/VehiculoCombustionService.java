package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.VehiculoCombustion;

public interface VehiculoCombustionService {
	
	Integer count();            // Método para devolver el número de Vehiculos de combustión.

	List<VehiculoCombustion> findAll();        // Método findAll() para devolver TODOS los Vehiculos de combustión.

	List<VehiculoCombustion> findByColor(String color);      // Método para filtrar por color

	List<VehiculoCombustion> findByNumPuertas(int numPuertas);      // Método para filtrar por número de puertas

	List<VehiculoCombustion> findByName(String name);          // Método para filtrar por nombre

	VehiculoCombustion findOne(Long id);          // Método para encontrar solo uno

	VehiculoCombustion save(VehiculoCombustion combustion);        // Método para guardarlo

	boolean delete(Long id);           // Método para borrarlo

	void deleteAll();

}
