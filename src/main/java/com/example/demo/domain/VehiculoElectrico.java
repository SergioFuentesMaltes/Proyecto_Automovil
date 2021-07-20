package com.example.demo.domain;

import com.example.demo.domain.piezas.AireAcondicionado;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.BateriaElectrico;

public class VehiculoElectrico extends Vehiculo {
	
	private BateriaElectrico bateriaElectrico;

	public VehiculoElectrico() {
	}

	public VehiculoElectrico(Long id, String name, String color, Bateria bateria, Integer numPuertas,
			AireAcondicionado aireAcondicionado, BateriaElectrico bateriaElectrico) {
		super(id, name, color, bateria, numPuertas, aireAcondicionado);
		this.bateriaElectrico = bateriaElectrico;
	}

	public BateriaElectrico getBateriaElectrico() {
		return bateriaElectrico;
	}

	public void setBateriaElectrico(BateriaElectrico bateriaElectrico) {
		this.bateriaElectrico = bateriaElectrico;
	}

	@Override
	public String toString() {
		return "VehiculoElectrico [bateriaElectrico=" + bateriaElectrico + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getColor()=" + getColor() + ", getBateria()=" + getBateria() + ", getNumPuertas()="
				+ getNumPuertas() + ", getAireAcondicionado()=" + getAireAcondicionado() + "]";
	}

	

	
	

}
