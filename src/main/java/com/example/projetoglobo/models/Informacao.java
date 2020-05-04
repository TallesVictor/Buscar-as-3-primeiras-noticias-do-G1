package com.example.projetoglobo.models;

public class Informacao extends Noticia  {

	private String corpo;
	private String imagem;

	public Informacao(int id, String corpo, String imagem) {
		super(id);
		this.corpo = corpo;
		this.imagem = imagem;

	}
	public Informacao(int id) {
		super(id);

	}
	public Informacao() {
	}

	public String getCorpo() {
		return corpo;
	}


	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}


	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@Override
	public String toString() {
		super.toString();
		return "Informacao [corpo=" + corpo + ", imagem=" + imagem + "]";
	}
	
	

}
