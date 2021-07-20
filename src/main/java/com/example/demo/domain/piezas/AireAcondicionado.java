package com.example.demo.domain.piezas;

public class AireAcondicionado {

	private Long id;
	private Boolean on = false;

	public AireAcondicionado(Long id) {
		this.id = id;

	}

	public void start() {
		this.on = true;

	}

	public Long getId() {
		return id;
	}

	public Boolean getOn() {
		return on;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOn(Boolean on) {
		this.on = on;
	}

	@Override
	public String toString() {
		return "AireAcondicionado [id=" + id + ", on=" + on + "]";
	}

}
