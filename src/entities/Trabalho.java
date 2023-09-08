package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelTrabalho;

public class Trabalho {

	private String nome;
	private NivelTrabalho nivel;
	private Double salarioBase;
	
	//ASSOCIAÇÕES
	private Departamento departamento;
	//NÃO FAZER O CONSTRUTOR COM ATRIBUTOS DO TIPO LISTA, MAS ESTACIAMOS ELE DIRETO NA CLASSE
	private List<ContratoHora> contratos = new ArrayList<> ();
	
	public Trabalho() {
	}

	public Trabalho(String nome, NivelTrabalho nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalho getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalho nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoHora> getContrato() {
		return contratos;
	}
	
	public void addContrato (ContratoHora contrato) {
		contratos.add(contrato);
	}
	
	public void removerContrato (ContratoHora contrato) {
		contratos.remove(contrato);
	}
	
	public double renda(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		//Se esse contrato "c" for desse ano e desse mês add o salario base do funcionário
		for(ContratoHora c : contratos) {
			cal.setTime(c.getData());
			//REPRESENTANDO O MES E O ANO DESSE CONTRATO SOLICITADO
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if (ano == c_ano && mes == c_mes) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}
	
}
