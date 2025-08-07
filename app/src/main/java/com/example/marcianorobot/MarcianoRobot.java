package com.example.marcianorobot;

import java.util.Locale;

public class MarcianoRobot {

    public String responda(String frase) {
        if (frase == null || frase.trim().isEmpty()) {
            return "Não me incomode";
        }

        frase = frase.trim();

        // Verifica se é uma pergunta (termina com '?')
        boolean isPergunta = frase.endsWith("?");
        // Verifica se há palavras em maiúsculas (grito)
        boolean hasGrito = false;
        for (String palavra : frase.split("\\s+")) {
            if (!palavra.isEmpty() && palavra.toUpperCase(Locale.ROOT).equals(palavra) && palavra.matches(".*[A-Z].*")) {
                hasGrito = true;
                break;
            }
        }

        // Caso "eu" (com ou sem maiúsculas)
        if (frase.toLowerCase(Locale.ROOT).contains("eu")) {
            return "A responsabilidade é sua";
        }

        // Grito em uma pergunta
        if (hasGrito && isPergunta) {
            return "Relaxa, eu sei o que estou fazendo!";
        }

        // Grito
        if (hasGrito) {
            return "Opa! Calma aí!";
        }

        // Pergunta
        if (isPergunta) {
            return "Certamente";
        }

        // Qualquer outra coisa
        return "Tudo bem, como quiser";
    }
}