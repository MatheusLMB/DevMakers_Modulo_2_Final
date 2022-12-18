package Atividade_Final;

import java.util.ArrayList;

public class Postagem {
	
	private String data, hora, conteudo;
	private int idUsuario;
	public ArrayList<Comentario> comentarios = new ArrayList<Comentario>();

	public Postagem(int idUsuario, String data, String hora, String conteudo) {
		setIdUsuario(idUsuario);
		setData(data);
		setHora(hora);
		setConteudo(conteudo);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
}
