package com.example.projetoglobo.controllers;

import org.jsoup.*;

import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.net.*;
import java.util.ArrayList;

//import javax.swing.text.Document;

import java.io.*;

import com.example.projetoglobo.models.*;

@Controller
public class IndexController {

	@RequestMapping("/")
	public ModelAndView index() {

//Relacionando o model com a view
		ModelAndView mv = new ModelAndView("index");

//Atribuindo o ArrayList do método lerPagina(), a informação para chamar no index.
		mv.addObject("informacao", lerPagina());
		return mv;
	}

//Capturar as 3 primeiras noticias do G1 e adicionar no ArrayList
	public ArrayList<Informacao> lerPagina() {

		ArrayList<Informacao> listaInfo = new ArrayList<>();
		Informacao info = new Informacao();

		String pagina = "";
		StringBuilder sb = new StringBuilder();
		URL url;
		String corpoPagina = "";
		String imgPagina = "";
		int time = 0;
		try {
			url = new URL("https://g1.globo.com/");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				sb.append(inputLine);
			}

			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

		Document doc = Jsoup.parse(sb.toString());

		Elements e = doc.getElementsByClass("bastian-feed-item");

		int contImg = 0;
		for (int i = 0; i < 3; i++) {
			Element corpo = e.select("div.feed-post-body").get(i + 1);
			corpoPagina = corpo.toString();

//			Verificar se existe uma imagem na noticia selecionada
			if (corpoPagina.contains("<img")) {
				Element imagem = e.select("div.feed-media-wrapper").get(contImg);
				imgPagina = imagem.toString();
				contImg++;
			} else {
				imgPagina = "";
			}

			Informacao inf = new Informacao(inserirId(new Informacao(i)), corpo.toString(), imgPagina);

			listaInfo.add(inf);

		}

		return listaInfo;

	}

//	Vendo seus exemplos e sem muita ideia do que fazer, acabei fazendo um POLIMORFISMO para inserir ID
	public int inserirId(Noticia noticia) {
		return noticia.getId();
	}

}