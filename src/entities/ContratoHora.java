package entities;

import java.util.Date;

public class ContratoHora {
	private Date data;
	private Double valorPorHora;
	private Integer hora;
	
	public ContratoHora() {
	}

	public ContratoHora(Date data, Double valorPorHora, Integer hora) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.hora = hora;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}
	
	public double valorTotal() {
		return valorPorHora * hora;
	}
	
	
	
}
