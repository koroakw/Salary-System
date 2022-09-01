package program;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import obj.Employee;

public class Exercicio9 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>(); // o tipo list é uma interface, e para usar usar ela tem que instanciar 
	 	// uma classe concreta que implementa a interface que implementa o list

		System.out.println("How many employees will be registered? ");
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			System.out.println();
			System.out.println("Employee #: " + (i + 1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			System.out.print("Name: ");
			sc.nextLine(); // esse nextline foi usado pois o nextline abaixo iria consumir a quebra de linha do enter
							
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();

			Employee emp = new Employee(id, name, salary); // instancia o produto com o objeto

			list.add(emp);// insere a variável na lista
		}

		System.out.print("Enter the employee id that will have salary increase: ");
		int idsalary = sc.nextInt();

		Integer pos = position(list, idsalary); // invoca a função para procurar o id
		if (pos == null) {
			System.out.println("This id does not exist! ");
		} else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			list.get(pos).increaseSalary(percent); // dá o comando para acessar a função do objeto de incrementar o salario
													

		}

		System.out.println("list of employees: ");
		for (Employee emp : list) {
			System.out.println(emp);
		}

		sc.close();
	}
	// o static serve para usar uma função dentro de uma mesma classe

	public static Integer position(List<Employee> list, int id) { // cria uma função auxiliar para procurar um valor na lista
																	
		for (int i = 0; i < list.size(); i++) { // ela recebe a lista dos funcionario e vai retornar a posição do funcionario na lista
			
			//list.size define o tamanho da lista, e até onde o for vai seguir
			if (list.get(i).getId() == id) { // se id na posição i lá na classe for igual ao id o list.get pega o elemento na posição
				
				return i; 
			}
		}
		return null;

	}

}
