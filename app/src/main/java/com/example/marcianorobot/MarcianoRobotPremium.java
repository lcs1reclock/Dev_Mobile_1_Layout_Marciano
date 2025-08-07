package com.example.marcianorobot;

import java.util.Locale;

public class MarcianoRobotPremium extends MarcianoRobotMatematico {

    private UserAction userAction;

    public MarcianoRobotPremium(UserAction action) {
        this.userAction = action;
    }

    @Override
    public String responda(String frase) {
        if (frase.toLowerCase(Locale.ROOT).contains("agir")) {
            if (userAction != null) {
                userAction.execute();
                return "É pra já!";
            } else {
                return "Não sei o que fazer! Minha ação não foi definida.";
            }
        }
        return super.responda(frase);
    }

    @Override
    public String responda(String frase, double... operandos) {
        if (frase.toLowerCase(Locale.ROOT).contains("agir")) {
            if (userAction != null) {
                userAction.execute();
                return "É pra já!";
            } else {
                return "Não sei o que fazer! Minha ação não foi definida.";
            }
        }
        return super.responda(frase, operandos);
    }
}