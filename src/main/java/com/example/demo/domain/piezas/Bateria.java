package com.example.demo.domain.piezas;

public class Bateria {

	private Long id;
	private Double capacidad;

	public Bateria(Long id, Double capacidad) {
		this.id = id;
		this.capacidad = capacidad;
	}

	public Long getId() {
		return id;
	}

	public Double getCapacidad() {
		return capacidad;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCapacidad(Double capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "Bateria [id=" + id + ", capacidad=" + capacidad + "]";
	}

}
