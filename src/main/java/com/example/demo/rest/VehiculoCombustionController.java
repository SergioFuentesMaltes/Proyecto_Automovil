package com.example.demo.rest;



import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.example.demo.domain.VehiculoCombustion;
import com.example.demo.service.VehiculoCombustionService;

@Path("/vehiculocombustion")
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VehiculoCombustionController {


	private VehiculoCombustionService vehiculocombustionService;

	public VehiculoCombustionController(VehiculoCombustionService vehiculocombustionService) {
		this.vehiculocombustionService = vehiculocombustionService;
	}

	/**
	 * GET http://localhost:8080/api/vehiculocombustion
	 */
	@GET
	public List<VehiculoCombustion> findAll() {
		return vehiculocombustionService.findAll();

	}

	/**
	 * GET http://localhost:8080/api/vehiculocombustion/1
	 * http://localhost:8080/api/vehiculocombustion/2
	 * http://localhost:8080/api/vehiculocombustion/3
	 * http://localhost:8080/api/vehiculocombustion/4
	 */
	@GET
	@Path("{id}")
	public Response findOne(@PathParam("id") Long id) {
		VehiculoCombustion combustion = vehiculocombustionService.findOne(id);
		if (combustion == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(combustion).build();

	}

	/**
	 * GET
	 * 
	 */
	@GET
	@Path("/color/{color}")
	public List<VehiculoCombustion> findByColor(@PathParam("color") String color) {
		return vehiculocombustionService.findByColor(color);

	}

	/**
	 * GET
	 * 
	 */
	@GET
	@Path("/numPuertas/{numPuertas}")
	public List<VehiculoCombustion> findByNumPuertas(@PathParam("numPuertas") int numPuertas) {
		return vehiculocombustionService.findByNumPuertas(numPuertas);

	}

	/**
	 * GET
	 * 
	 */
	@GET
	@Path("/name/{name}")
	public List<VehiculoCombustion> findByName(@PathParam("name") String name) {
		return vehiculocombustionService.findByName(name);

	}

	/**
	 * POST http://localhost:8080/api/vehiculocombustion
	 * 
	 */
	@POST // CREAR NUEVO
	public Response create(VehiculoCombustion combustion) {
		if (combustion.getId() != 0) // Si ya tiene un id dará error ya que sería una actualización y esto es un
									// creación
			return Response.status(Response.Status.BAD_REQUEST).build();
		VehiculoCombustion result = vehiculocombustionService.save(combustion);
		return Response.ok(result).build();

	}

	/**
	 * PUT http://localhost:8080/api/vehiculocombustion
	 * 
	 */
	@PUT // ACTUALIZAR
	public Response update(VehiculoCombustion combustion) {
		if (combustion.getId() == null || combustion.getId() == 0) // En PUT actualizamos, por lo tanto debe tener un id,
																	// con este if nos aseguramos que ya lo tenga.
			return Response.status(Response.Status.BAD_REQUEST).build();
		VehiculoCombustion result = vehiculocombustionService.save(combustion);
		return Response.ok(result).build();

	}

	/**
	 * DELETE http://localhost:8080/api/vehiculocombustion/1
	 * http://localhost:8080/api/vehiculocombustion/2
	 */
	@DELETE
	@Path("{id}")
	public Response deleteOne(@PathParam("id") Long id) {
		if (!vehiculocombustionService.delete(id))
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(Response.Status.OK).build();

	}

	/**
	 * DELETE http://localhost:8080/api/vehiculocombustion
	 * 
	 */
	@DELETE
	public Response deleteAll() {
		vehiculocombustionService.deleteAll();

		return Response.ok(Response.Status.OK).build();

	}

}


