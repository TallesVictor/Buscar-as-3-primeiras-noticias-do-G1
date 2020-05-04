package com.example.projetoglobo.models;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Noticia {
	private int id;

	public Noticia(int id) {
		this.id = id;
	}

	public Noticia() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Noticia [id=" + id + "]";
	}


}
