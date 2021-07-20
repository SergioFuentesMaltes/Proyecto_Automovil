package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.VehiculoHibrido;
import com.example.demo.domain.VehiculoHibrido;

import com.example.demo.domain.piezas.AireAcondicionado;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.TanqueHidrogeno;


@Service 
public class VehiculoHibridoImpl implements VehiculoHibridoService{

	
	private static final Map<Long, VehiculoHibrido> vehiculoshibrido = new HashMap<>();	
	
	static {
		
		VehiculoHibrido hibrido1 = new VehiculoHibrido (1L, "Opel", "Negro",
				new Bateria(1L, 58.00),
				3,
				new AireAcondicionado(1L),
				new TanqueHidrogeno(1L, 75));
		
		
		VehiculoHibrido hibrido2 = new VehiculoHibrido (2L, "Mercedes", "Blanco",
				new Bateria(2L, 48.00),
				3,
				new AireAcondicionado(2L),
				new TanqueHidrogeno(2L, 90));
		
		
		VehiculoHibrido hibrido3 = new VehiculoHibrido (3L, "Kia", "Amarillo",
				new Bateria(3L, 76.50),
				5,
				new AireAcondicionado(3L),
				new TanqueHidrogeno(3L, 70));
		
		vehiculoshibrido.put(1L, hibrido1);
		vehiculoshibrido.put(2L, hibrido2);
		vehiculoshibrido.put(3L, hibrido3);
		
	}
	
	@Override
	public Integer count() {
		return vehiculoshibrido.keySet().size();
		
	}
	
	@Override
	public List<VehiculoHibrido> findAll(){
		return new ArrayList<>(vehiculoshibrido.values());
	
	}
	
	@Override
	public VehiculoHibrido findOne(Long id) {
		return vehiculoshibrido.get(id);
		
	}
	
	@Override
	public VehiculoHibrido save(VehiculoHibrido VehiculoHibrido) {
		
		//Asignar un id
		if(VehiculoHibrido.getId() == null || VehiculoHibrido.getId() == 0L) //Nuevo
			VehiculoHibrido.setId(getMaxVehiculoHibridoId() + 1);    //Genera id y lo asigna
		
		//En caso de actualizar primero lo eliminamos
		((VehiculoHibridoService)VehiculoHibrido).delete(VehiculoHibrido.getId());
		
		vehiculoshibrido.put(VehiculoHibrido.getId(), VehiculoHibrido);
		
		
		return VehiculoHibrido;
		
		
	}
	
	/**
	 * Devuelve el id más alto del mapa vehiculoshibrido
	 * @return
	 */
	private Long getMaxVehiculoHibridoId() {
		
		if(vehiculoshibrido.isEmpty())
			return 0L;
		return Collections.max(vehiculoshibrido.entrySet(),
				(entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())
				).getKey();
			
	}
	
	@Override
	public boolean delete(Long id) {
		if(id == null || !vehiculoshibrido.containsKey(id))
			return false;
		vehiculoshibrido.remove(id);
		return true;
		
	}
	
	@Override
	public void deleteAll() {
		if(!vehiculoshibrido.isEmpty())
			vehiculoshibrido.clear();
		
	}

	@Override
	public List<VehiculoHibrido> findByColor(String color) {
		List<VehiculoHibrido> results = new ArrayList<VehiculoHibrido>();
		for(VehiculoHibrido vehiculo: vehiculoshibrido.values())
			if(vehiculo.getColor().equals(color))
				results.add(vehiculo);
				
		
		return results;
	}

	@Override
	public List<VehiculoHibrido> findByNumPuertas(int numPuertas) {
		List<VehiculoHibrido> results = new ArrayList<VehiculoHibrido>();
		for(VehiculoHibrido vehiculo: vehiculoshibrido.values())
			if(vehiculo.getNumPuertas()== (numPuertas))
				results.add(vehiculo);
				
		
		return results;
	}
	
	@Override
	public List<VehiculoHibrido> findByName(String name) {
		List<VehiculoHibrido> results = new ArrayList<VehiculoHibrido>();
		for(VehiculoHibrido vehiculo: vehiculoshibrido.values())
			if(vehiculo.getName().equals(name))
				results.add(vehiculo);
				
		
		return results;
	}
	
	
	
}
