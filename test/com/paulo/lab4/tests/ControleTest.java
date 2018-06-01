package com.paulo.lab4.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.paulo.lab4.Aluno;
import com.paulo.lab4.Controle;
import com.paulo.lab4.Grupo;

/**
 * Classe de testes da classe Controle, utilizando o JUnit.
 * 
 * @author Paulo Mendes da Silva J�nior - 117210922
 *
 */

public class ControleTest {

	private Controle sistema;
	private Controle sistema2;
	
	private Aluno a1 = new Aluno("120", "Paulo", "Computa��o");
	private Aluno a2 = new Aluno("150", "Pedro", "El�trica");
	private Aluno a3 = new Aluno("200", "Ana", "Engenharia Agr�cola");
	
	private Grupo g1 = new Grupo("Ed. Fisica");
	private Grupo g2 = new Grupo("Calculo");
	
	/**
	 * Cria��o de dois Sistemas de Controle.
	 */
	@Before
	public void criaSistema() {
		sistema = new Controle();
		sistema2 = new Controle();
	}
	
	/**
	 * Cadastra alguns alunos no sistema.
	 */
	@Before
	public void cadastraAluno() {
		sistema.cadastraAluno("117210221", "Paulo Mendes", "Computa��o");
		sistema.cadastraAluno("117210121", "Vit�ria Alves", "Engenharia El�trica");
		sistema.cadastraAluno("112212323", "Samuel Pereira", "Administra��o");
	}
	
	/**
	 * Cadastra dois grupos no sistema.
	 */
	@Before
	public void cadastraGrupos() {
		sistema.cadastrarGrupo("Calculo 1");
		sistema.cadastrarGrupo("Calculo 2");
	}
	
	/**
	 * Testa o m�todo CadastraAluno(String nome, String matricula, String curso).
	 */
	@Test
	public void testCadastraAluno() {
		assertEquals("CADASTRO REALIZADO!" + System.lineSeparator(), sistema.cadastraAluno("117210925", "Coisinha", "Arquitetura"));
		assertEquals("MATR�CULA J� CADASTRADA!" + System.lineSeparator(), sistema.cadastraAluno("117210221", "Junior", "F�sica"));
	}

	/**
	 * Testa o m�todo Exibir Aluno, que exibe as informa��es de um aluno a partir da sua matr�cula.
	 */
	@Test
	public void testExibirAluno() {
		assertEquals("117210221 - Paulo Mendes - Computa��o" + System.lineSeparator(), sistema.exibirAluno("117210221"));
	}
	
	/**
	 * Testa o m�todo exibir aluno, caso a matr�cula passada n�o esteja cadastrada no sistema.
	 */
	@Test
	public void testExibirAlunoNaoExistente() {
		assertEquals("Aluno n�o cadastrado." + System.lineSeparator(), sistema.exibirAluno("117210999"));
	}

	/**
	 * Testa o m�todo cadastrar grupo. 
	 */
	@Test
	public void testCadastrarGrupo() {
		assertEquals("CADASTRO REALIZADO!" + System.lineSeparator(), sistema.cadastrarGrupo("Desenhos"));
		assertEquals("GRUPO J� CADASTRADO!" + System.lineSeparator(), sistema.cadastrarGrupo("Calculo 1"));
	}

	/**
	 * Testa o m�todo alocar um aluno em um grupo.
	 */
	@Test
	public void testAlocarAlunoExistenteEmGrupoExistente() {
		assertEquals("ALUNO ALOCADO!" + System.lineSeparator(), sistema.alocarAlunoEmGrupo("117210221", "Calculo 1"));
		assertEquals("ALUNO ALOCADO!" + System.lineSeparator(), sistema.alocarAlunoEmGrupo("117210121", "Calculo 1"));
	}
	
	/**
	 * Testa o m�todo alocar aluno, com um aluno inexistente no sistema.
	 */
	@Test
	public void testAlocarAlunoNaoExistenteEmGrupoExistente() {
		assertEquals("Aluno n�o cadastrado!" + System.lineSeparator(), sistema.alocarAlunoEmGrupo("900", "Calculo"));
	}
	
	/**
	 * Testa o m�todo alocar aluno em grupo, com um grupo inexistente no sistema.
	 */
	@Test
	public void testAlocarAlunoExistenteEmGrupoNaoExistente() {
		assertEquals("Grupo n�o cadastrado!" + System.lineSeparator(), sistema.alocarAlunoEmGrupo("117210221", "Materiais"));
	}

	/**
	 * Testa o m�todo imprimir alunos de um grupo que foi cadastrado mas est� vazio.
	 */
	@Test
	public void testImprimirAlunosDeGrupoVazio() {
		assertEquals("O grupo est� vazio!" + System.lineSeparator(), sistema.imprimirAlunosDeGrupo("Calculo 2"));
	}
	
	/**
	 * Testa o m�todo imprimir alunos de um grupo que n�o foi cadastrado.
	 */
	@Test
	public void testImprimirAlunosDeGrupoInexistente() {
		assertEquals("Grupo n�o cadastrado." + System.lineSeparator(), sistema.imprimirAlunosDeGrupo("Artes"));
	}
	
	/**
	 * Testa o m�todo imprimir alunos de um grupo que foi cadastrado e cont�m alunos.
	 */
	@Test
	public void testImprimirAlunosDeGrupoValidoNaoVazio() {
		testAlocarAlunoExistenteEmGrupoExistente();
		System.out.println(sistema.imprimirAlunosDeGrupo("Calculo 1"));
		assertEquals("\n" + "Alunos do grupo Calculo 1:\n" + "* 117210121 - Vit�ria Alves - Engenharia El�trica\n" +
				"* 117210221 - Paulo Mendes - Computa��o\n", sistema.imprimirAlunosDeGrupo("Calculo 1"));
	}

	/**
	 * Testa o m�todo que registra alunos que reponderam quest�es.
	 * Considerando as seguintes situa��es em sequ�ncia de execu��o do m�todo:
	 * - Registra aluno de matr�cula existente no sistema e ainda n�o registrado.
	 * - Notifica que o aluno j� est� registrado e finaliza.
	 * - Notifica que o aluno n�o foi cadastrado no sistema, logo n�o ser� registrado.
	 */
	@Test
	public void testRegistrarAlunoQueRespondeu() {
		assertEquals("ALUNO REGISTRADO!" + System.lineSeparator(), sistema.registrarAlunoQueRespondeu("112212323"));
		assertEquals("Aluno j� registrado." + System.lineSeparator(), sistema.registrarAlunoQueRespondeu("112212323"));
		assertEquals("Aluno n�o cadastrado." + System.lineSeparator(), sistema.registrarAlunoQueRespondeu("999999999"));
	}

	/**
	 * Imprime o registro de alunos que responderam quest�es que se encontra vazio.
	 */
	@Test
	public void testImprimirRegistroDeAlunosVazio() {
		assertEquals("O registro est� vazio!" + System.lineSeparator(), sistema2.imprimirRegistroDeAlunos());
	}
	
	/**
	 * Imprime o registro de alunos que responderam quest�es n�o vazio.
	 */
	@Test
	public void testImprimirRegistroDeAlunos() {
		sistema.registrarAlunoQueRespondeu("112212323");
		assertEquals("\nAlunos:\n" + "1. 112212323 - Samuel Pereira - Administra��o" + System.lineSeparator(), sistema.imprimirRegistroDeAlunos());
	}
	
}
