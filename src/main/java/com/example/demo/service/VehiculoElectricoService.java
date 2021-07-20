package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.VehiculoElectrico;

public interface VehiculoElectricoService {

	Integer count();            // Método para devolver el número de Vehiculos eléctricos

	List<VehiculoElectrico> findAll();        // Método findAll() para devolver TODOS los Vehiculos eléctricos.

	List<VehiculoElectrico> findByColor(String color);      // Método para filtrar por color

	List<VehiculoElectrico> findByNumPuertas(int numPuertas);      // Método para filtrar por número de puertas

	List<VehiculoElectrico> findByName(String name);          // Método para filtrar por nombre

	VehiculoElectrico findOne(Long id);          // Método para encontrar solo uno

	VehiculoElectrico save(VehiculoElectrico electrico);        // Método para guardarlo

	boolean delete(Long id);           // Método para borrarlo

	void deleteAll();

}
