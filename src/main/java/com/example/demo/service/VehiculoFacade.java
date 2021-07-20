package com.example.demo.service;

import com.example.demo.domain.Vehiculo;
import com.example.demo.domain.VehiculoCombustion;
import com.example.demo.domain.VehiculoElectrico;
import com.example.demo.domain.VehiculoHibrido;
import com.example.demo.domain.piezas.AireAcondicionado;
import com.example.demo.domain.piezas.Bateria;
import com.example.demo.domain.piezas.BateriaElectrico;
import com.example.demo.domain.piezas.Inyeccion;
import com.example.demo.domain.piezas.TanqueHidrogeno;

public class VehiculoFacade {

	private VehiculoFacade() {
	}

	public static Vehiculo createVehiculoElectrico() {

		Bateria bateria = new Bateria(1L, 5.5);
		AireAcondicionado aireAcondicionado = new AireAcondicionado(7L);

		// Pieza exclusiva:
		BateriaElectrico bateriaElectrico = new BateriaElectrico(4L, 50);

		VehiculoElectrico electrico = new VehiculoElectrico(1L, "Default Vehiculo Eléctrico", "Verde", bateria, 4,
				aireAcondicionado, bateriaElectrico);
		electrico.getAireAcondicionado().start();
		return electrico;
	}

	public static Vehiculo createVehiculoCombustion() {

		Bateria bateria = new Bateria(1L, 5.5);
		AireAcondicionado aireAcondicionado = new AireAcondicionado(7L);

		// Pieza exclusiva:
		Inyeccion inyeccion = new Inyeccion(9L, 4);

		VehiculoCombustion combustion = new VehiculoCombustion(1L, "Default Vehiculo Combustión", "Rojo", bateria, 3,
				aireAcondicionado, inyeccion);
		combustion.getAireAcondicionado().start();
		return combustion;

	}

	public static Vehiculo createVehiculoHibrido() {

		Bateria bateria = new Bateria(1L, 5.5);
		AireAcondicionado aireAcondicionado = new AireAcondicionado(7L);

		// Pieza exclusiva:

		TanqueHidrogeno tanqueHidrogeno = new TanqueHidrogeno(8L, 80);
		VehiculoHibrido hibrido = new VehiculoHibrido(1L, "Default Vehiculo Hibrido", "Blanco", bateria, 5,
				aireAcondicionado, tanqueHidrogeno);
		hibrido.getAireAcondicionado().start();
		return hibrido;
		

	}

}
