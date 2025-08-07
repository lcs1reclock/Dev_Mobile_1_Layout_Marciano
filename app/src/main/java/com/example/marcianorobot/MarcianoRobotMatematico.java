package com.example.marcianorobot;

import java.util.Locale;

public class MarcianoRobotMatematico extends MarcianoRobot {

    public String responda(String frase, double... operandos) {
        frase = frase.trim().toLowerCase(Locale.ROOT);

        if (operandos.length < 2) {
            // Se não há operandos suficientes para uma operação matemática, usa o método da classe pai
            return super.responda(frase);
        }

        double resultado = 0;
        String operacao = "";

        if (frase.contains("some")) {
            operacao = "some";
            for (double op : operandos) {
                resultado += op;
            }
        } else if (frase.contains("subtraia")) {
            operacao = "subtraia";
            resultado = operandos[0]; // Inicia com o primeiro operando
            for (int i = 1; i < operandos.length; i++) {
                resultado -= operandos[i];
            }
        } else if (frase.contains("multiplique")) {
            operacao = "multiplique";
            resultado = 1; // Inicia com 1 para multiplicação
            for (double op : operandos) {
                resultado *= op;
            }
        } else if (frase.contains("divida")) {
            operacao = "divida";
            if (operandos.length > 1) {
                resultado = operandos[0]; // Inicia com o primeiro operando
                for (int i = 1; i < operandos.length; i++) {
                    if (operandos[i] != 0) {
                        resultado /= operandos[i];
                    } else {
                        return "Não posso dividir por zero, humano!";
                    }
                }
            } else {
                return "Essa eu sei, mas preciso de mais números para dividir!";
            }
        } else {
            // Se a frase não contém uma operação matemática reconhecida, usa o método da classe pai
            return super.responda(frase);
        }

        return "Essa eu sei: " + resultado;
    }

    // Sobrescreve o método original para garantir que as operações matemáticas sejam priorizadas
    @Override
    public String responda(String frase) {
        // Tenta parsear a frase para ver se contém uma operação matemática com números
        // Este é um exemplo simples e pode ser aprimorado para parsing mais robusto
        if (frase.toLowerCase(Locale.ROOT).matches(".*(some|subtraia|multiplique|divida).*\\s+\\d+(\\.\\d+)?(\\s+\\d+(\\.\\d+)?)*")) {
            // Se parece uma operação matemática, tentamos extrair os números e chamar o método sobrecarregado
            String[] partes = frase.split("\\s+");
            java.util.List<Double> numeros = new java.util.ArrayList<>();
            for (String parte : partes) {
                try {
                    numeros.add(Double.parseDouble(parte));
                } catch (NumberFormatException e) {
                    // Ignora partes que não são números
                }
            }
            if (numeros.size() >= 2) { // Pelo menos dois operandos para a maioria das operações
                return responda(frase, numeros.stream().mapToDouble(Double::doubleValue).toArray());
            }
        }
        return super.responda(frase);
    }
}