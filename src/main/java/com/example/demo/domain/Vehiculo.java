package com.example.demo.domain;

import com.example.demo.domain.piezas.AireAcondicionado;
import com.example.demo.domain.piezas.Bateria;

public abstract class Vehiculo {
// Estos son los atributos compartidos por las clases hijas
	private Long id;
	private String name;
	private String color;
	private Bateria bateria;
	private Integer numPuertas;
	private AireAcondicionado aireAcondicionado;
	
	
	protected Vehiculo() {
	}


	protected Vehiculo(Long id, String name, String color, Bateria bateria, Integer numPuertas,
			AireAcondicionado aireAcondicionado) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.bateria = bateria;
		this.numPuertas = numPuertas;
        this.aireAcondicionado = aireAcondicionado;
	}

	
	

	public Long getId() {
		return id;
	}



	public String getName() {
		return name;
	}


	public String getColor() {
		return color;
	}


	public Bateria getBateria() {
		return bateria;
	}


	public Integer getNumPuertas() {
		return numPuertas;
	}


	public AireAcondicionado getAireAcondicionado() {
		return aireAcondicionado;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public void setBateria(Bateria bateria) {
		this.bateria = bateria;
	}


	public void setNumPuertas(Integer numPuertas) {
		this.numPuertas = numPuertas;
	}


	public void setAireAcondicionado(AireAcondicionado aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
	}


	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", name=" + name + ", color=" + color + ", bateria=" + bateria + ", numPuertas="
				+ numPuertas + ", aireAcondicionado=" + aireAcondicionado + "]";
	}
	
	
	
	
	
	
	
	
	
}
