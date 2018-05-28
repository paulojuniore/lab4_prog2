package com.paulo.lab4.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.paulo.lab4.Aluno;

class AlunoTest {
	
	private Aluno a1;
	private Aluno a2;
	private Aluno a3;
	
	@Before
	public void criaAluno() {
		a1 = new Aluno("120", "Pedro Viana", "Ci�ncia da computa��o");
		a2 = new Aluno("110", "Paulo J�nior", "Engenharia El�trica");
		a3 = new Aluno("130", "Ana Vilela", "Administra��o");
	}
	
	@Test
	public void testAluno() {
		Aluno a = new Aluno("117210122", "Pedro J�lio", "Engenharia de materiais");
	}

	@Test
	public void testToString() {
		assertEquals("110 - Paulo J�nior - Engenharia El�tricas", a2.toString());
	}

	@Test
	public void testEqualsObject() {
		assertEquals(a1, a2);
	}

}
