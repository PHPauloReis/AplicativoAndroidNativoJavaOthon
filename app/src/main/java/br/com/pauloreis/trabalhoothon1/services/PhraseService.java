package br.com.pauloreis.trabalhoothon1.services;

import java.util.ArrayList;

public class PhraseService {
    private ArrayList<String> phrases = new ArrayList<String>();
    private int actualPhraseIndex = 0;

    public PhraseService()
    {
        this.populate();
    }

    public void populate()
    {
        this.phrases.add("Para bom entendedor, meia palavra basta");
        this.phrases.add("De grão em grão, a galinha enche o papo");
        this.phrases.add("Cada macaco no seu galho");
        this.phrases.add("Casa de ferreiro, espeto de pau");
        this.phrases.add("Água mole, pedra dura, tanto bate até que fura");
        this.phrases.add("Filho de peixe, peixinho é");
        this.phrases.add("Deus ajuda quem cedo madruga");
        this.phrases.add("Onde há fumaça há fogo");
        this.phrases.add("Cão que ladra não morde");
        this.phrases.add("Pimenta nos olhos dos outros é refresco");
        this.phrases.add("À noite todos os gatos são pardos");
        this.phrases.add("Quando um burro fala, o outro abaixa a orelha");
        this.phrases.add("A pressa é inimiga da perfeição");
        this.phrases.add("Deus escreve certo por linhas tortas");
        this.phrases.add("Quem com ferro fere, com ferro será ferido");
        this.phrases.add("Um dia é da caça, outro do caçador");
        this.phrases.add("Mente vazia, oficina do diabo");
        this.phrases.add("O que os olhos não veem, o coração não sente");
        this.phrases.add("Papagaio que acompanha João-de-barro vira ajudante de pedreiro");
        this.phrases.add("De médico e louco todo mundo tem um pouco");
        this.phrases.add("Cavalo dado não se olha os dentes");
    }

    public ArrayList<String> getPhrases() {
        return phrases;
    }

    public String getPhraseByIndex(int index)
    {
        return this.phrases.get(index);
    }

    public void setActualPhraseIndex(int index)
    {
        this.actualPhraseIndex = index;
    }

    public String getNextPhrase() throws Exception {
        this.actualPhraseIndex++;

        if (this.actualPhraseIndex >= this.phrases.size()) {
            this.actualPhraseIndex--;
            throw new Exception("As frases acabaram! :(");
        }

        return this.getPhraseByIndex(this.actualPhraseIndex);
    }

    public String getPreviousPhrase() throws Exception {
        this.actualPhraseIndex--;

        if (this.actualPhraseIndex < 0) {
            this.actualPhraseIndex++;
            throw new Exception("Não há frases anteriores à atual!");
        }

        return this.getPhraseByIndex(this.actualPhraseIndex);
    }
}
