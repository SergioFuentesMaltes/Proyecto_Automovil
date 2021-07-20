package com.example.demo.domain;

import com.example.demo.domain.piezas.AireAcondicionado;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.TanqueHidrogeno;

public class VehiculoHibrido extends Vehiculo {

	private TanqueHidrogeno tanqueHidrogeno;

	public VehiculoHibrido() {
	}

	public VehiculoHibrido(Long id, String name, String color, Bateria bateria, Integer numPuertas,
			AireAcondicionado aireAcondicionado, TanqueHidrogeno tanqueHidrogeno) {
		super(id, name, color, bateria, numPuertas, aireAcondicionado);
		this.tanqueHidrogeno = tanqueHidrogeno;

	}

	public TanqueHidrogeno getTanqueHidrogeno() {
		return tanqueHidrogeno;
	}

	public void setTanqueHidrogeno(TanqueHidrogeno tanqueHidrogeno) {
		this.tanqueHidrogeno = tanqueHidrogeno;
	}

	@Override
	public String toString() {
		return "VehiculoHibrido [tanqueHidrogeno=" + tanqueHidrogeno + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getColor()=" + getColor() + ", getBateria()=" + getBateria() + ", getNumPuertas()="
				+ getNumPuertas() + ", getAireAcondicionado()=" + getAireAcondicionado() + "]";
	}

}
