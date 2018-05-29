package com.paulo.lab4.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.paulo.lab4.Aluno;

/**
 * 
 * Classe de testes unit�rios da classe Aluno utilizando o JUnit.
 * 
 * @author Paulo Mendes da Silva J�nior - 117210922
 *
 */

public class AlunoTest {

	private Aluno a1;
	private Aluno a2;
	private Aluno a3;
	
	/**
	 * Instancia��o de alguns objetos Aluno.
	 */
	@Before
	public void criaAluno() {
		a1 = new Aluno("117210943", "Pedro Viana", "Ci�ncia da computa��o");
		a2 = new Aluno("117201233", "Paulo J�nior", "Engenharia El�trica");
		a3 = new Aluno("117210943", "Ana Vilela", "Administra��o");
	}
	
	/**
	 * Instancia��o de um Aluno com todos os seus par�metros v�lidos.
	 */
	@Test
	public void testAluno() {
		Aluno a = new Aluno("117210122", "Pedro J�lio", "Engenharia de materiais");
	}
	
	/**
	 * Cria��o de um Aluno com todos os par�metros nulos. Ocorrer� um lan�amento de exce��o e a mesma ser�
	 * tratada, e o programa n�o se encerrar� inesperadamente.
	 * OBS: O mesmo racioc�nio se aplica a todos os par�metros que podem lan�ar exce��es.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraAlunoTudoNulo() {
		Aluno aluno = new Aluno(null, null, null);
	}

	/**
	 * Cria��o de um Aluno com a matr�cula nula.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraAlunoMatriculaNula() {
		Aluno aluno = new Aluno(null, "Paulo Mendes da Silva J�nior", "Engenharia El�trica");
	}
	
	/**
	 * Cria��o de um Aluno com o nome nulo.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraAlunoNomeNulo() {
		Aluno aluno = new Aluno("117210913", null, "Administra��o");
	}
	
	/**
	 * Cria��o de um Aluno com o curso nulo. 
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraAlunoCursoNulo() {
		Aluno aluno = new Aluno("117210913", "Lionel Andr�s Messi", null);
	}
	
	/**
	 * Cria��o de um Aluno com matr�cula inv�lida.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraAlunoMatriculaInvalida() {
		Aluno aluno = new Aluno("   ", "Romero Britto de Ara�jo", "Arquitetura e Urbanismo");
	}
	
	/**
	 * Cria��o de um Aluno com nome inv�lido.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraAlunoNomeInvalido() {
		Aluno aluno = new Aluno("117210912", "    ", "Arquitetura e Urbanismo");
	}
	
	/**
	 * Cria��o de um Aluno com curso inv�lido.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraAlunoCursoInvalido() {
		Aluno aluno = new Aluno("117201921", "Romero Britto de Ara�jo", "     ");
	}
	
	/**
	 * Teste do m�todo equals.
	 * Obs: Dois Alunos s�o iguais se possuem a mesma matr�cula.
	 */
	@Test
	public void testEqualsObject() {
		assertEquals(a1, a3);
		assertNotEquals(a1, a2);
		assertNotEquals(a2, a3);
	}

}
