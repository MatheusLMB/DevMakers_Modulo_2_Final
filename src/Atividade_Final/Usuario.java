package Atividade_Final;

import java.util.ArrayList;

public class Usuario {

	private String nome, login, senha;
	public ArrayList<Integer> seguindo, seguidores;
	
	public Usuario(String nome, String login, String senha) {
		setNome(nome);
		setLogin(login);
		setSenha(senha);
		this.seguindo = new ArrayList<Integer>();
		this.seguidores = new ArrayList<Integer>();
	}
	
	public boolean seguirUsuario(int idUsuario, int idUsuarioSeguido, Usuario usuarioSeguido) {
		for(int i = 0; i < seguindo.size(); i++) {
			if(seguindo.get(i) == idUsuarioSeguido) {
				return false;
			}
		}
		
		seguindo.add(idUsuarioSeguido);
		usuarioSeguido.seguidores.add(idUsuario);
		return true;
	}
	
	public boolean pararSeguirUsuario(int idUsuario, int idUsuarioSeguido, Usuario usuarioSeguido) {
		for(int i = 0; i < seguindo.size(); i++) {
			if(seguindo.get(i) == idUsuarioSeguido) {
				seguindo.remove(i);
			}
		}
		
		for(int i = 0; i < usuarioSeguido.seguidores.size(); i++) {
			if(usuarioSeguido.seguidores.get(i) == idUsuario) {
				usuarioSeguido.seguidores.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
