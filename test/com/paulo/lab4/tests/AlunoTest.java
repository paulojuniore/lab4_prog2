package com.paulo.lab4.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.paulo.lab4.Aluno;

/**
 * 
 * Classe de testes unitários da classe Aluno utilizando o JUnit.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */

public class AlunoTest {

	private Aluno a1;
	private Aluno a2;
	private Aluno a3;
	
	/**
	 * Instanciação de alguns objetos Aluno.
	 */
	@Before
	public void criaAluno() {
		a1 = new Aluno("117210943", "Pedro Viana", "Ciência da computação");
		a2 = new Aluno("117201233", "Paulo Júnior", "Engenharia Elétrica");
		a3 = new Aluno("117210943", "Ana Vilela", "Administração");
	}
	
	/**
	 * Instanciação de um Aluno com todos os seus parâmetros válidos.
	 */
	@Test
	public void testAluno() {
		Aluno a = new Aluno("117210122", "Pedro Júlio", "Engenharia de materiais");
	}
	
	/**
	 * Criação de um Aluno com todos os parâmetros nulos. Ocorrerá um lançamento de exceção e a mesma será
	 * tratada, e o programa não se encerrará inesperadamente.
	 * OBS: O mesmo raciocínio se aplica a todos os parâmetros que podem lançar exceções.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraAlunoTudoNulo() {
		Aluno aluno = new Aluno(null, null, null);
	}

	/**
	 * Criação de um Aluno com a matrícula nula.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraAlunoMatriculaNula() {
		Aluno aluno = new Aluno(null, "Paulo Mendes da Silva Júnior", "Engenharia Elétrica");
	}
	
	/**
	 * Criação de um Aluno com o nome nulo.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraAlunoNomeNulo() {
		Aluno aluno = new Aluno("117210913", null, "Administração");
	}
	
	/**
	 * Criação de um Aluno com o curso nulo. 
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraAlunoCursoNulo() {
		Aluno aluno = new Aluno("117210913", "Lionel Andrés Messi", null);
	}
	
	/**
	 * Criação de um Aluno com matrícula inválida.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraAlunoMatriculaInvalida() {
		Aluno aluno = new Aluno("   ", "Romero Britto de Araújo", "Arquitetura e Urbanismo");
	}
	
	/**
	 * Criação de um Aluno com nome inválido.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraAlunoNomeInvalido() {
		Aluno aluno = new Aluno("117210912", "    ", "Arquitetura e Urbanismo");
	}
	
	/**
	 * Criação de um Aluno com curso inválido.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraAlunoCursoInvalido() {
		Aluno aluno = new Aluno("117201921", "Romero Britto de Araújo", "     ");
	}
	
	/**
	 * Teste do método equals.
	 * Obs: Dois Alunos são iguais se possuem a mesma matrícula.
	 */
	@Test
	public void testEqualsObject() {
		assertEquals(a1, a3);
		assertNotEquals(a1, a2);
		assertNotEquals(a2, a3);
	}

}
