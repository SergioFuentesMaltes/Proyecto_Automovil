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

import com.example.demo.domain.VehiculoHibrido;

import com.example.demo.service.VehiculoHibridoService;


@Path("/vehiculohibrido")
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VehiculoHibridoController {

	private VehiculoHibridoService vehiculoHibridoService;

	public VehiculoHibridoController(VehiculoHibridoService vehiculoHibridoService) {
		this.vehiculoHibridoService = vehiculoHibridoService;
	}

	/**
	 * GET http://localhost:8080/api/vehiculohibrido
	 */
	@GET
	public List<VehiculoHibrido> findAll() {
		return vehiculoHibridoService.findAll();

	}

	/**
	 * GET http://localhost:8080/api/vehiculohibrido/1
	 * http://localhost:8080/api/vehiculohibrido/2
	 * http://localhost:8080/api/vehiculohibrido/3
	 * http://localhost:8080/api/vehiculohibrido/4
	 */
	@GET
	@Path("{id}")
	public Response findOne(@PathParam("id") Long id) {
		VehiculoHibrido hibrido = vehiculoHibridoService.findOne(id);
		if (hibrido == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(hibrido).build();

	}

	/**
	 * GET
	 * 
	 */
	@GET
	@Path("/color/{color}")
	public List<VehiculoHibrido> findByColor(@PathParam("color") String color) {
		return vehiculoHibridoService.findByColor(color);

	}

	/**
	 * GET
	 * 
	 */
	@GET
	@Path("/numPuertas/{numPuertas}")
	public List<VehiculoHibrido> findByNumPuertas(@PathParam("numPuertas") int numPuertas) {
		return vehiculoHibridoService.findByNumPuertas(numPuertas);

	}

	/**
	 * GET
	 * 
	 */
	@GET
	@Path("/name/{name}")
	public List<VehiculoHibrido> findByName(@PathParam("name") String name) {
		return vehiculoHibridoService.findByName(name);

	}

	/**
	 * POST http://localhost:8080/api/vehiculohibrido
	 * 
	 */
	@POST // CREAR NUEVO
	public Response create(VehiculoHibrido hibrido) {
		if (hibrido.getId() != 0) // Si ya tiene un id dará error ya que sería una actualización y esto es un
									// creación
			return Response.status(Response.Status.BAD_REQUEST).build();
		VehiculoHibrido result = vehiculoHibridoService.save(hibrido);
		return Response.ok(result).build();

	}

	/**
	 * PUT http://localhost:8080/api/vehiculohibrido
	 * 
	 */
	@PUT // ACTUALIZAR
	public Response update(VehiculoHibrido hibrido) {
		if (hibrido.getId() == null || hibrido.getId() == 0) // En PUT actualizamos, por lo tanto debe tener un id,
																	// con este if nos aseguramos que ya lo tenga.
			return Response.status(Response.Status.BAD_REQUEST).build();
		VehiculoHibrido result = vehiculoHibridoService.save(hibrido);
		return Response.ok(result).build();

	}

	/**
	 * DELETE http://localhost:8080/api/vehiculohibrido/1
	 * http://localhost:8080/api/vehiculohibrido/2
	 */
	@DELETE
	@Path("{id}")
	public Response deleteOne(@PathParam("id") Long id) {
		if (!vehiculoHibridoService.delete(id))
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(Response.Status.OK).build();

	}

	/**
	 * DELETE http://localhost:8080/api/vehiculohibrido
	 * 
	 */
	@DELETE
	public Response deleteAll() {
		vehiculoHibridoService.deleteAll();

		return Response.ok(Response.Status.OK).build();

	}

}

	
	
	

