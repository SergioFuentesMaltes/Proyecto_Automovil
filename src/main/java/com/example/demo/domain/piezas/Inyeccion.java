package com.example.demo.domain.piezas;

public class Inyeccion {
	
	private Long id;
	private Integer numInyectores;
	public Inyeccion(Long id, Integer numInyectores) {
		this.id = id;
		this.numInyectores = numInyectores;
	}
	public Long getId() {
		return id;
	}
	public Integer getNumInyectores() {
		return numInyectores;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNumInyectores(Integer numInyectores) {
		this.numInyectores = numInyectores;
	}
	@Override
	public String toString() {
		return "Inyeccion [id=" + id + ", numInyectores=" + numInyectores + "]";
	}
	
	

}
