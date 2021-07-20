package com.example.demo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import com.example.demo.service.VehiculoFactory;
import com.example.demo.domain.Vehiculo;

@Component
@Path("/vehiculo")
@Produces(MediaType.APPLICATION_JSON)

public class VehiculoController {
	
	//Response y el patrón builder .build() Nos 
    //permiten ir concatenando métodos para generar la respuesta
	
	/**
	 * http://localhost:8080/api/vehiculo/combustion
	 * http://localhost:8080/api/vehiculo/hibrido
	 * http://localhost:8080/api/vehiculo/electrico
	 * http://localhost:8080/api/vehiculo/"NombreErróneo" (404 NOT FOUND)
	 * @param type
	 * @return
	 */
	
	@GET
	@Path("/{type}") 
	public Response createByType(@PathParam("type") String type) {
		
		try {
			return Response    
					           
					.ok()
					.entity(VehiculoFactory.createByType(type))
					.build();
			
		} catch(IllegalArgumentException e) {
			return Response.status(Response.Status.NOT_FOUND).build();
			
			
		}
		
	}
		
		
	}



