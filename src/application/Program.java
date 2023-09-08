package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.ContratoHora;
import entities.Departamento;
import entities.Trabalho;
import entities.enums.NivelTrabalho;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Insira os dados do trabalhador: ");
		System.out.println("Nome");
		String nomedoTrabalhador = sc.nextLine();
		System.out.println("Qual o Nivel do cargo (JUNIOR, PLENO OU SENIOR)? : ");
		String niveldoTrabalhador = sc.nextLine();
		System.out.println("Digite o salário base do trabalhador: ");
		double salarioBase = sc.nextDouble();
		Trabalho trabalho = new Trabalho(nomedoTrabalhador, NivelTrabalho.valueOf(niveldoTrabalhador), salarioBase, new Departamento(nomeDepartamento));
		
		System.out.println("Quantos contratos esse trabalhador vai estar atribuido?: ");
		int n = sc.nextInt();
		
		//For se repete várias vezes até se instaciar todos os contratos e associalos ao trabalhador - (Trabalho - lista de contratos - addContrato)
		for (int i=1; i<=n; i++) {
			System.out.println("Insira os dados do contrato #" + i);
			System.out.print("Data (DD/MM/YYYY): ");
			Date dataDeContrato = sdf.parse(sc.next());
			System.out.println("Digite o valor por hora: ");
			double valorporHora = sc.nextDouble();
			System.out.println("Digte a duração do contrato em horas:");
			int hora = sc.nextInt();
			
			//Instaciando o meu contrato
			ContratoHora contrato = new ContratoHora(dataDeContrato, valorporHora, hora);
			//Contrato sendo associado com o trabalhador
			trabalho.addContrato(contrato);
		}
		
		System.out.println();
		System.out.print("Insira o mês e ano para calcular a renda (MM/YYYY): ");
		String meseAno = sc.next();
		//Inicio e fim de onde quero recontar minha String - Sempre add um valor a mais pois começa com 0
		int mes = Integer.parseInt(meseAno.substring(0, 2)); 
		int ano = Integer.parseInt(meseAno.substring(3));
		
		System.out.println("Nome do Trabalhador: " + trabalho.getNome());
		//Tenho o objeto trabalhador, vou acessar o outro objeto que está associado a ele, e depois acesso o nome
		System.out.println("Nome do departamento: " + trabalho.getDepartamento().getNome());
		System.out.println("A renda na data: " + meseAno + "Foi de R$" + String.format("%.2f", trabalho.renda(ano, mes)));
		
		
		sc.close();
	}

}
