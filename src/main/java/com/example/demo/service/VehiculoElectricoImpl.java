package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.VehiculoElectrico;
import com.example.demo.domain.VehiculoElectrico;
import com.example.demo.domain.VehiculoElectrico;
import com.example.demo.domain.piezas.AireAcondicionado;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.BateriaElectrico;
@Service
public class VehiculoElectricoImpl implements VehiculoElectricoService{
	
	
	private static final Map<Long, VehiculoElectrico> vehiculoselectricos = new HashMap<>();
	
	static {
		
		VehiculoElectrico electrico1 = new VehiculoElectrico(1L, "Toyota", "Blanco",
				new Bateria(1L, 80.50),
				5, 
				new AireAcondicionado(1L),
				new BateriaElectrico(1L, 40));
		
		
		VehiculoElectrico electrico2 = new VehiculoElectrico(2L, "Seat", "Rojo",
				new Bateria(2L, 70.20),
				5, 
				new AireAcondicionado(2L),
				new BateriaElectrico(2L, 60));
		
		
		VehiculoElectrico electrico3 = new VehiculoElectrico(3L, "Volvo", "Negro",
				new Bateria(3L, 80.10),
				3, 
				new AireAcondicionado(3L),
				new BateriaElectrico(3L, 90));
		
		electrico1.getAireAcondicionado().start();
		
		vehiculoselectricos.put(1L, electrico1);
		vehiculoselectricos.put(2L, electrico2);
		vehiculoselectricos.put(3L, electrico3);
	
	}

	@Override
	public Integer count() {
		return vehiculoselectricos.keySet().size();
		
	}
	
	@Override
	public List<VehiculoElectrico> findAll(){
		return new ArrayList<>(vehiculoselectricos.values());
	
	}
	
	@Override
	public VehiculoElectrico findOne(Long id) {
		return vehiculoselectricos.get(id);
		
	}
	
	@Override
	public VehiculoElectrico save(VehiculoElectrico vehiculoelectrico) {
		
		//Asignar un id
		if(vehiculoelectrico.getId() == null || vehiculoelectrico.getId() == 0L) //Nuevo
			vehiculoelectrico.setId(getMaxVehiculoElectricoId() + 1);    //Genera id y lo asigna
		
		//En caso de actualizar primero lo eliminamos
		((VehiculoElectricoService)vehiculoelectrico).delete(vehiculoelectrico.getId());
		
		vehiculoselectricos.put(vehiculoelectrico.getId(), vehiculoelectrico);
		
		
		return vehiculoelectrico;
		
		
	}
	
	/**
	 * Devuelve el id más alto del mapa vehiculoselectricos
	 * @return
	 */
	private Long getMaxVehiculoElectricoId() {
		
		if(vehiculoselectricos.isEmpty())
			return 0L;
		return Collections.max(vehiculoselectricos.entrySet(),
				(entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())
				).getKey();
			
	}
	
	@Override
	public boolean delete(Long id) {
		if(id == null || !vehiculoselectricos.containsKey(id))
			return false;
		vehiculoselectricos.remove(id);
		return true;
		
	}
	
	@Override
	public void deleteAll() {
		if(!vehiculoselectricos.isEmpty())
			vehiculoselectricos.clear();
		
	}

	@Override
	public List<VehiculoElectrico> findByColor(String color) {
		List<VehiculoElectrico> results = new ArrayList<VehiculoElectrico>();
		for(VehiculoElectrico vehiculo: vehiculoselectricos.values())
			if(vehiculo.getColor().equals(color))
				results.add(vehiculo);
				
		
		return results;
	}


	@Override
	public List<VehiculoElectrico> findByNumPuertas(int numPuertas) {
		List<VehiculoElectrico> results = new ArrayList<VehiculoElectrico>();
		for(VehiculoElectrico vehiculo: vehiculoselectricos.values())
			if(vehiculo.getNumPuertas()== (numPuertas))
				results.add(vehiculo);
				
		
		return results;
	}

	@Override
	public List<VehiculoElectrico> findByName(String name) {
		List<VehiculoElectrico> results = new ArrayList<VehiculoElectrico>();
		for(VehiculoElectrico vehiculo: vehiculoselectricos.values())
			if(vehiculo.getName().equals(name))
				results.add(vehiculo);
				
		
		return results;
	}
	
	
}
