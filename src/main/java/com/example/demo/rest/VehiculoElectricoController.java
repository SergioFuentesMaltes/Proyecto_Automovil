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

import com.example.demo.domain.VehiculoElectrico;
import com.example.demo.service.VehiculoElectricoService;
@Path("/vehiculoelectrico")
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VehiculoElectricoController {

	private VehiculoElectricoService vehiculoelectricoService;

	public VehiculoElectricoController(VehiculoElectricoService vehiculoelectricoService) {
		this.vehiculoelectricoService = vehiculoelectricoService;
	}

	/**
	 * GET http://localhost:8080/api/vehiculoelectrico
	 */
	@GET
	public List<VehiculoElectrico> findAll() {
		return vehiculoelectricoService.findAll();

	}

	/**
	 * GET http://localhost:8080/api/vehiculoelectrico/1
	 * http://localhost:8080/api/vehiculoelectrico/2
	 * http://localhost:8080/api/vehiculoelectrico/3
	 * http://localhost:8080/api/vehiculoelectrico/4
	 */
	@GET
	@Path("{id}")
	public Response findOne(@PathParam("id") Long id) {
		VehiculoElectrico electrico = vehiculoelectricoService.findOne(id);
		if (electrico == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(electrico).build();

	}

	/**
	 * GET
	 * 
	 */
	@GET
	@Path("/color/{color}")
	public List<VehiculoElectrico> findByColor(@PathParam("color") String color) {
		return vehiculoelectricoService.findByColor(color);

	}

	/**
	 * GET
	 * 
	 */
	@GET
	@Path("/numPuertas/{numPuertas}")
	public List<VehiculoElectrico> findByNumPuertas(@PathParam("numPuertas") int numPuertas) {
		return vehiculoelectricoService.findByNumPuertas(numPuertas);

	}

	/**
	 * GET
	 * 
	 */
	@GET
	@Path("/name/{name}")
	public List<VehiculoElectrico> findByName(@PathParam("name") String name) {
		return vehiculoelectricoService.findByName(name);

	}

	/**
	 * POST http://localhost:8080/api/vehiculoelectrico
	 * 
	 */
	@POST // CREAR NUEVO
	public Response create(VehiculoElectrico electrico) {
		if (electrico.getId() != 0) // Si ya tiene un id dará error ya que sería una actualización y esto es un
									// creación
			return Response.status(Response.Status.BAD_REQUEST).build();
		VehiculoElectrico result = vehiculoelectricoService.save(electrico);
		return Response.ok(result).build();

	}

	/**
	 * PUT http://localhost:8080/api/vehiculoelectrico
	 * 
	 */
	@PUT // ACTUALIZAR
	public Response update(VehiculoElectrico electrico) {
		if (electrico.getId() == null || electrico.getId() == 0) // En PUT actualizamos, por lo tanto debe tener un id,
																	// con este if nos aseguramos que ya lo tenga.
			return Response.status(Response.Status.BAD_REQUEST).build();
		VehiculoElectrico result = vehiculoelectricoService.save(electrico);
		return Response.ok(result).build();

	}

	/**
	 * DELETE http://localhost:8080/api/vehiculoelectrico/1
	 * http://localhost:8080/api/vehiculoelectrico/2
	 */
	@DELETE
	@Path("{id}")
	public Response deleteOne(@PathParam("id") Long id) {
		if (!vehiculoelectricoService.delete(id))
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(Response.Status.OK).build();

	}

	/**
	 * DELETE http://localhost:8080/api/vehiculoelectrico
	 * 
	 */
	@DELETE
	public Response deleteAll() {
		vehiculoelectricoService.deleteAll();

		return Response.ok(Response.Status.OK).build();

	}

}
