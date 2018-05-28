package com.paulo.lab4;

import java.util.Set;

/**
 * Representa um Grupo de Estudo.
 * Um Grupo de estudos possui um tema, e tamb�m, um conjunto de alunos associado a este grupo.
 * 
 * @author Paulo Mendes da Silva J�nior - 117210922
 *
 */

public class Grupo {
	
	/**
	 * Representa o tema de um grupo: ex: Biologia.
	 */
	private String tema;
	
	/**
	 * Representa um conjunto de alunos que comp�em aquele grupo. inicialmente vazio e sem tamanho fixo.
	 */
	private Set<Aluno> alunos;
	
	
	/**
	 * Constr�i um Grupo de estudos a partir do tema ao qual ir� se referir.
	 * 
	 * @param tema : nome do grupo.
	 */
	public Grupo(String tema) {
		if(tema.trim().isEmpty())
			throw new IllegalArgumentException("Tema do grupo inv�lido!");
		
		this.tema = tema;
	}
	
	/**
	 * Retorna o tema de um grupo.
	 * 
	 * @return : tema do grupo.
	 */
	public String getTema() {
		return tema;
	}
	
	/**
	 * Gera um identificar �nico para cada item inserido na cole��o HashSet, atrav�s do Hashing.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tema == null) ? 0 : tema.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (tema == null) {
			if (other.tema != null)
				return false;
		} else if (!tema.equals(other.tema))
			return false;
		return true;
	}

}
