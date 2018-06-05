package com.paulo.lab4.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;
import com.paulo.lab4.Aluno;
import com.paulo.lab4.Controle;
import com.paulo.lab4.Grupo;

/**
 * Classe de testes unitário da classe Grupo utilizando o JUnit.
 * 
 * @author Paulo Mendes da Silva Júnior.
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
	 * Instanciação de alguns Grupos e Alunos. todos com dados válidos.
	 */
	@Before
	public void criaGruposeAlunos() {
		g1 = new Grupo("Cálculo I");
		g2 = new Grupo("Cálculo II");
		g3 = new Grupo("Mecânica dos Fluídos");
		
		a1 = new Aluno("117210922", "Cleiton Bezerra", "Engenharia Agrícola");
		a2 = new Aluno("117210923", "Felipe Aragão", "Engenharia Elétrica");
		a3 = new Aluno("117210924", "Júlio Silva", "Ciência da Computação");
	}
	
	/**
	 * Criação de um Grupo com nome v�lido.
	 */
	@Test
	public void testGrupo() {
		Grupo grupo = new Grupo("Algebra Vetorial e Geometria Analítica");
	}

	/**
	 * Adiciona um Aluno com todos os dados válidos a um grupo.
	 * OBS: O método adicionaAluno contido na classe grupo não possui valor de retorno, apenas adiciona o aluno
	 * em questão ao grupo selecionado. Porém antes mesmo de os dados chegarem ao método eles são verificados e
	 * em caso de invalidez de algum/alguns destes, a operação é cancelada e o fluxo é retornado ao menu principal.
	 */
	@Test
	public void testAdicionaAluno() {
		g1.adicionaAluno(a1);
	}
	
	/**
	 * Criação de grupo com tema nulo.
	 */
	@Test(expected=NullPointerException.class)
	public void testCriaGrupoTemaNulo() {
		Grupo grupo = new Grupo(null);
	}
	
	/**
	 * Criação de grupo com tema inválido.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaGrupoTemaInvalido() {
		Grupo grupo = new Grupo("    ");
	}

	/**
	 * Verifica se dois objeto Grupo são iguais. Dois grupos são iguais se possuem temas iguais.
	 */
	@Test
	public void testEqualsObject() {
		assertEquals(g1, g2);
		assertNotEquals(g1, g3);
	}

}
