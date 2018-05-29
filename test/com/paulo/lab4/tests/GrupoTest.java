package com.paulo.lab4.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;
import com.paulo.lab4.Aluno;
import com.paulo.lab4.Grupo;

/**
 * Classe de testes unit�rio da classe Grupo utilizando o JUnit.
 * 
 * @author Paulo Mendes da Silva J�nior.
 *
 */

public class GrupoTest {
	
	private Grupo g1;
	private Grupo g2;
	private Grupo g3;
	
	private Aluno a1;
	private Aluno a2;
	private Aluno a3;

	/**
	 * Instancia��o de alguns Grupos e Alunos. todos com dados v�lidos.
	 */
	@Before
	public void criaGrupos() {
		g1 = new Grupo("C�lculo I");
		g2 = new Grupo("C�lculo I");
		g3 = new Grupo("Mec�nica dos Flu�dos");
		
		a1 = new Aluno("117210922", "Cleiton Bezerra", "Engenharia Agr�cola");
		a2 = new Aluno("117210923", "Felipe Arag�o", "Engenharia El�trica");
		a3 = new Aluno("117210924", "J�lio Silva", "Ci�ncia da Computa��o");
	}
	
	/**
	 * Cria��o de um Grupo com nome v�lido.
	 */
	@Test
	public void testGrupo() {
		Grupo grupo = new Grupo("Algebra Vetorial e Geometria Anal�tica");
	}

	/**
	 * Adiciona um Aluno com todos os dados v�lidos a um grupo.
	 * OBS: O m�todo adicionaAluno contido na classe grupo n�o possui valor de retorno, apenas adiciona o aluno
	 * em quest�o ao grupo selecionado. Por�m antes mesmo de os dados chegarem ao m�todo eles s�o verificados e
	 * em caso de invalidez de algum/alguns destes, a opera��o � cancelada e o fluxo � retornado ao menu principal.
	 */
	@Test
	public void testAdicionaAluno() {
		g1.adicionaAluno(a1);
	}
	
	/**
	 * Cria��o de grupo com tema nulo.
	 */
	@Test(expected=NullPointerException.class)
	public void testCriaGrupoTemaNulo() {
		Grupo grupo = new Grupo(null);
	}
	
	/**
	 * Cria��o de grupo com tema inv�lido.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaGrupoTemaInvalido() {
		Grupo grupo = new Grupo("    ");
	}

	/**
	 * Verifica se dois objeto Grupo s�o iguais. Dois grupos s�o iguais se possuem temas iguais.
	 */
	@Test
	public void testEqualsObject() {
		assertEquals(g1, g2);
		assertNotEquals(g1, g3);
	}

}
