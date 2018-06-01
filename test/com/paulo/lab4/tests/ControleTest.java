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
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */

public class ControleTest {

	private Controle sistema;
	private Controle sistema2;
	
	private Aluno a1 = new Aluno("120", "Paulo", "Computação");
	private Aluno a2 = new Aluno("150", "Pedro", "Elétrica");
	private Aluno a3 = new Aluno("200", "Ana", "Engenharia Agrícola");
	
	private Grupo g1 = new Grupo("Ed. Fisica");
	private Grupo g2 = new Grupo("Calculo");
	
	/**
	 * Criação de dois Sistemas de Controle.
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
		sistema.cadastraAluno("117210221", "Paulo Mendes", "Computação");
		sistema.cadastraAluno("117210121", "Vitória Alves", "Engenharia Elétrica");
		sistema.cadastraAluno("112212323", "Samuel Pereira", "Administração");
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
	 * Testa o método CadastraAluno(String nome, String matricula, String curso).
	 */
	@Test
	public void testCadastraAluno() {
		assertEquals("CADASTRO REALIZADO!" + System.lineSeparator(), sistema.cadastraAluno("117210925", "Coisinha", "Arquitetura"));
		assertEquals("MATRÍCULA JÁ CADASTRADA!" + System.lineSeparator(), sistema.cadastraAluno("117210221", "Junior", "Física"));
	}

	/**
	 * Testa o método Exibir Aluno, que exibe as informações de um aluno a partir da sua matrícula.
	 */
	@Test
	public void testExibirAluno() {
		assertEquals("117210221 - Paulo Mendes - Computação" + System.lineSeparator(), sistema.exibirAluno("117210221"));
	}
	
	/**
	 * Testa o método exibir aluno, caso a matrícula passada não esteja cadastrada no sistema.
	 */
	@Test
	public void testExibirAlunoNaoExistente() {
		assertEquals("Aluno não cadastrado." + System.lineSeparator(), sistema.exibirAluno("117210999"));
	}

	/**
	 * Testa o método cadastrar grupo. 
	 */
	@Test
	public void testCadastrarGrupo() {
		assertEquals("CADASTRO REALIZADO!" + System.lineSeparator(), sistema.cadastrarGrupo("Desenhos"));
		assertEquals("GRUPO JÁ CADASTRADO!" + System.lineSeparator(), sistema.cadastrarGrupo("Calculo 1"));
	}

	/**
	 * Testa o método alocar um aluno em um grupo.
	 */
	@Test
	public void testAlocarAlunoExistenteEmGrupoExistente() {
		assertEquals("ALUNO ALOCADO!" + System.lineSeparator(), sistema.alocarAlunoEmGrupo("117210221", "Calculo 1"));
		assertEquals("ALUNO ALOCADO!" + System.lineSeparator(), sistema.alocarAlunoEmGrupo("117210121", "Calculo 1"));
	}
	
	/**
	 * Testa o método alocar aluno, com um aluno inexistente no sistema.
	 */
	@Test
	public void testAlocarAlunoNaoExistenteEmGrupoExistente() {
		assertEquals("Aluno não cadastrado!" + System.lineSeparator(), sistema.alocarAlunoEmGrupo("900", "Calculo"));
	}
	
	/**
	 * Testa o método alocar aluno em grupo, com um grupo inexistente no sistema.
	 */
	@Test
	public void testAlocarAlunoExistenteEmGrupoNaoExistente() {
		assertEquals("Grupo não cadastrado!" + System.lineSeparator(), sistema.alocarAlunoEmGrupo("117210221", "Materiais"));
	}

	/**
	 * Testa o método imprimir alunos de um grupo que foi cadastrado mas está vazio.
	 */
	@Test
	public void testImprimirAlunosDeGrupoVazio() {
		assertEquals("O grupo está vazio!" + System.lineSeparator(), sistema.imprimirAlunosDeGrupo("Calculo 2"));
	}
	
	/**
	 * Testa o método imprimir alunos de um grupo que não foi cadastrado.
	 */
	@Test
	public void testImprimirAlunosDeGrupoInexistente() {
		assertEquals("Grupo não cadastrado." + System.lineSeparator(), sistema.imprimirAlunosDeGrupo("Artes"));
	}
	
	/**
	 * Testa o método imprimir alunos de um grupo que foi cadastrado e contém alunos.
	 */
	@Test
	public void testImprimirAlunosDeGrupoValidoNaoVazio() {
		testAlocarAlunoExistenteEmGrupoExistente();
		System.out.println(sistema.imprimirAlunosDeGrupo("Calculo 1"));
		assertEquals("\n" + "Alunos do grupo Calculo 1:\n" + "* 117210121 - Vitória Alves - Engenharia Elétrica\n" +
				"* 117210221 - Paulo Mendes - Computação\n", sistema.imprimirAlunosDeGrupo("Calculo 1"));
	}

	/**
	 * Testa o método que registra alunos que reponderam questões.
	 * Considerando as seguintes situações em sequência de execução do método:
	 * - Registra aluno de matrícula existente no sistema e ainda não registrado.
	 * - Notifica que o aluno já está registrado e finaliza.
	 * - Notifica que o aluno não foi cadastrado no sistema, logo não será registrado.
	 */
	@Test
	public void testRegistrarAlunoQueRespondeu() {
		assertEquals("ALUNO REGISTRADO!" + System.lineSeparator(), sistema.registrarAlunoQueRespondeu("112212323"));
		assertEquals("Aluno já registrado." + System.lineSeparator(), sistema.registrarAlunoQueRespondeu("112212323"));
		assertEquals("Aluno não cadastrado." + System.lineSeparator(), sistema.registrarAlunoQueRespondeu("999999999"));
	}

	/**
	 * Imprime o registro de alunos que responderam questões que se encontra vazio.
	 */
	@Test
	public void testImprimirRegistroDeAlunosVazio() {
		assertEquals("O registro está vazio!" + System.lineSeparator(), sistema2.imprimirRegistroDeAlunos());
	}
	
	/**
	 * Imprime o registro de alunos que responderam questões não vazio.
	 */
	@Test
	public void testImprimirRegistroDeAlunos() {
		sistema.registrarAlunoQueRespondeu("112212323");
		assertEquals("\nAlunos:\n" + "1. 112212323 - Samuel Pereira - Administração" + System.lineSeparator(), sistema.imprimirRegistroDeAlunos());
	}
	
}
