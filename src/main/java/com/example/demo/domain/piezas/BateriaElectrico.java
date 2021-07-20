package com.example.demo.domain.piezas;

public class BateriaElectrico {
	
	private Long id;
	private Integer nivelCarga;
	
	
	public BateriaElectrico(Long id, Integer nivelCarga) {
		this.id = id;
		this.nivelCarga = nivelCarga;
	}


	public Long getId() {
		return id;
	}


	public Integer getNivelCarga() {
		return nivelCarga;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setNivelCarga(Integer nivelCarga) {
		this.nivelCarga = nivelCarga;
	}


	@Override
	public String toString() {
		return "BateriaElectrico [id=" + id + ", nivelCarga=" + nivelCarga + "]";
	}
	
	
	
	

}
