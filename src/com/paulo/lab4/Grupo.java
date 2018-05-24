package com.paulo.lab4;

import java.util.Set;

public class Grupo {
	
	private String tema;
	private Set<Aluno> alunos;
	
	public Grupo(String tema) {
		this.tema = tema;
	}
	
	public String getTema() {
		return tema;
	}
	
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
