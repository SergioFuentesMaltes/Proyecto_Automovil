package com.example.demo.domain.piezas;

public class TanqueHidrogeno {
	
	private Long id;
	private Integer capacidadTanque;
	
	
	public TanqueHidrogeno(Long id, Integer capacidadTanque) {
		this.id = id;
		this.capacidadTanque = capacidadTanque;
	}


	public Long getId() {
		return id;
	}


	public Integer getCapacidadTanque() {
		return capacidadTanque;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setCapacidadTanque(Integer capacidadTanque) {
		this.capacidadTanque = capacidadTanque;
	}


	@Override
	public String toString() {
		return "TanqueHidrogeno [id=" + id + ", capacidadTanque=" + capacidadTanque + "]";
	}
	
	

}
