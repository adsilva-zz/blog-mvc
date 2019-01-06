package br.com.blog.lerlivrosblog.utilities;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Validacao {

	private static final List<String> PALAVRAS_OFENSIVAS = Arrays.asList("odeio", "caralho", "idiota", "besta",
			"baba-ovo", "babaca", "baitola", "bicha", "bisca", "bixa", "boazuda", "boceta", "boco", "boiola", "buceta",
			"cassete", "chifruda", "cu", "curalho", "cuzao", "debil", "debiloide", "defunto", "doida", "doido",
			"escrota", "escroto", "estupida", "estupido", "fedorenta", "feia", "feio", "furona", "gaiata", "gaiato",
			"idiota", "imbecil", "mocreia", "otaria", "paspalha", "paspalho", "pilantra", "porra", "puta", "retardada",
			"retardado", "ridícula", "sacana", "tarada", "tarado", "troxa", "vagabunda", "vagabundo");

	public static boolean validarPalavrasOfensivas(String comentario) {
		String[] palavras = comentario.toLowerCase().split(" ");
		for (String p : PALAVRAS_OFENSIVAS) {
			for (String pc : palavras) {
				if (pc.contains(p)) {
					return true;
				}
			}
		}
		return false;
	}
}
