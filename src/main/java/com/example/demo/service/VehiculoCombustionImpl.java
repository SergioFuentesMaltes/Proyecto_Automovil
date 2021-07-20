package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.VehiculoCombustion;

import com.example.demo.domain.piezas.AireAcondicionado;
import com.example.demo.domain.piezas.Bateria;

import com.example.demo.domain.piezas.Inyeccion;
@Service
public class VehiculoCombustionImpl implements VehiculoCombustionService{

	
	private static final Map<Long, VehiculoCombustion> vehiculoscombustion = new HashMap<>();
	
	static {
		
		VehiculoCombustion combustion1 = new VehiculoCombustion(1L, "Renault", "Azul",
				new Bateria(1L, 65.30),
				3,
				new AireAcondicionado(1L),
				new Inyeccion(1L, 4));
		
				
		VehiculoCombustion combustion2 = new VehiculoCombustion(2L, "Kia", "Verde",
				new Bateria(2L, 45.60),
				5,
				new AireAcondicionado(2L),
				new Inyeccion(2L, 4));	
				
		
		
		VehiculoCombustion combustion3 = new VehiculoCombustion(3L, "Citroen", "Blanco",
				new Bateria(3L, 70.00),
				3,
				new AireAcondicionado(3L),
				new Inyeccion(3L, 3));	
				
		
		vehiculoscombustion.put(1L, combustion1);
		vehiculoscombustion.put(2L, combustion2);
		vehiculoscombustion.put(3L, combustion3);
		
	}
	
	@Override
	public Integer count() {
		return vehiculoscombustion.keySet().size();
		
	}
	
	@Override
	public List<VehiculoCombustion> findAll(){
		return new ArrayList<>(vehiculoscombustion.values());
	
	}
	
	@Override
	public VehiculoCombustion findOne(Long id) {
		return vehiculoscombustion.get(id);
		
	}
	
	@Override
	public VehiculoCombustion save(VehiculoCombustion VehiculoCombustion) {
		
		//Asignar un id
		if(VehiculoCombustion.getId() == null || VehiculoCombustion.getId() == 0L) //Nuevo
			VehiculoCombustion.setId(getMaxVehiculoCombustionId() + 1);    //Genera id y lo asigna
		
		//En caso de actualizar primero lo eliminamos
		((VehiculoCombustionService)VehiculoCombustion).delete(VehiculoCombustion.getId());
		
		vehiculoscombustion.put(VehiculoCombustion.getId(), VehiculoCombustion);
		
		
		return VehiculoCombustion;
		
		
	}
	
	/**
	 * Devuelve el id más alto del mapa vehiculoscombustion
	 * @return
	 */
	private Long getMaxVehiculoCombustionId() {
		
		if(vehiculoscombustion.isEmpty())
			return 0L;
		return Collections.max(vehiculoscombustion.entrySet(),
				(entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())
				).getKey();
			
	}
	
	@Override
	public boolean delete(Long id) {
		if(id == null || !vehiculoscombustion.containsKey(id))
			return false;
		vehiculoscombustion.remove(id);
		return true;
		
	}
	
	@Override
	public void deleteAll() {
		if(!vehiculoscombustion.isEmpty())
			vehiculoscombustion.clear();
		
	}

	@Override
	public List<VehiculoCombustion> findByColor(String color) {
		List<VehiculoCombustion> results = new ArrayList<VehiculoCombustion>();
		for(VehiculoCombustion vehiculo: vehiculoscombustion.values())
			if(vehiculo.getColor().equals(color))
				results.add(vehiculo);
				
		
		return results;
	}

	@Override
	public List<VehiculoCombustion> findByNumPuertas(int numPuertas) {
		List<VehiculoCombustion> results = new ArrayList<VehiculoCombustion>();
		for(VehiculoCombustion vehiculo: vehiculoscombustion.values())
			if(vehiculo.getNumPuertas()== (numPuertas))
				results.add(vehiculo);
				
		
		return results;
	}
	
	@Override
	public List<VehiculoCombustion> findByName(String name) {
		List<VehiculoCombustion> results = new ArrayList<VehiculoCombustion>();
		for(VehiculoCombustion vehiculo: vehiculoscombustion.values())
			if(vehiculo.getName().equals(name))
				results.add(vehiculo);
				
		
		return results;
	}
	
	
}
