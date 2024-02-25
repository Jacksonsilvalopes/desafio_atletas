package service;

import entities.Atleta;

import java.util.List;

public class AtletaService {

    private List<Atleta> atletas;


    public AtletaService(List<Atleta> atletaList) {
        this.atletas = atletaList;
    }

    private Double pesoMedio() {

        Double pesoTotal = 0.0;
        for (Atleta atleta : atletas) {
            pesoTotal += atleta.getPeso();
        }
        Double pesoMedio = pesoTotal / atletas.size();
        return pesoMedio;
    }

    private String atletaAlto() {
        double alturaMaisAlta = 0;
        String nome = " ";
        for (Atleta atleta : atletas) {

            if (atleta.getAltura() > alturaMaisAlta) {
                alturaMaisAlta = atleta.getAltura();
                nome = atleta.getNome();
            }
        }
        return nome;
    }

    private Double porcentagemHomem() {

        double m = 0.0;

        for (Atleta atleta : atletas) {
            if (atleta.getSexo().equals("M")) {
                m++;
            }
        }
        double total = atletas.size();
        double porcentagemHomem = m / total * 100;

        return porcentagemHomem;
    }

    private String alturaMulher() {
        double f = 0.0;
        double alturaTotal = 0.0;
        String result = " ";

        for (Atleta atleta : atletas) {
            if (atleta.getSexo().equals("F")) {
                f++;
                alturaTotal += atleta.getAltura();
            }
        }

        if (f > 0) {
            double alturamMediaMulher = alturaTotal / f;
            result = "Altura média das mulheres: " + alturamMediaMulher;
        } else {
            result = "Não há mulheres cadastradas";
        }
      return result;

    }

    public void relatorio(){
        System.out.println("");
        System.out.println("RELATÓRIO:");

        System.out.printf("Peso médio dos atletas: %.2f %n", pesoMedio());
        System.out.printf("Atleta mais alto: %s %n", atletaAlto());
        System.out.printf("Porcentagem de homens: %.1f %%%n", porcentagemHomem());
        System.out.println(alturaMulher());

    }

}
