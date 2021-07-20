package com.example.demo.domain;

import com.example.demo.domain.piezas.AireAcondicionado;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.Inyeccion;

public class VehiculoCombustion extends Vehiculo {

	private Inyeccion inyeccion;

	public VehiculoCombustion() {
	}

	public VehiculoCombustion(Long id, String name, String color, Bateria bateria, Integer numPuertas,
			AireAcondicionado aireAcondicionado, Inyeccion inyeccion) {
		super(id, name, color, bateria, numPuertas, aireAcondicionado);
		this.inyeccion = inyeccion;
	}

	public Inyeccion getInyeccion() {
		return inyeccion;
	}

	public void setInyeccion(Inyeccion inyeccion) {
		this.inyeccion = inyeccion;
	}

	@Override
	public String toString() {
		return "VehiculoCombustion [inyeccion=" + inyeccion + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getColor()=" + getColor() + ", getBateria()=" + getBateria() + ", getNumPuertas()="
				+ getNumPuertas() + ", getAireAcondicionado()=" + getAireAcondicionado() + "]";
	}

}
