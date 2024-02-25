import entities.Atleta;
import service.AtletaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {


        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Atleta> atletas = new ArrayList<>();

        System.out.println("");
        System.out.print("Qual a quantidade de atletas? ");

        int quantidade = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < quantidade; i++) {

            int n = 1 + i;
            boolean valid = false;

            System.out.println("Digite os dados do atleta numero " + n + ":");

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            if(n > 1){
                sc.nextLine();
            }

            System.out.print("Sexo: ");
            String sexo = sc.nextLine();

            while (!valid) {

                if (sexo.equals("F")) {
                    valid = true;
                } else if (sexo.equals("M")) {
                    valid = true;
                } else {
                    System.out.print("Valor invalido! Favor digitar F ou M: ");
                    sexo = sc.nextLine();
                }

            }
            System.out.print("Altura: ");
            Double altura = sc.nextDouble();

            valid = false;

            while (!valid) {

                if (altura <= 0) {
                    System.out.print("Valor invalido! Favor digitar um valor positivo: ");
                    altura = sc.nextDouble();

                } else {
                    valid = true;
                }

            }

            System.out.print("Peso: ");
            Double peso = sc.nextDouble();

            valid = false;

            while (!valid) {

                if (peso <= 0) {
                    System.out.print("Valor invalido! Favor digitar um valor positivo: ");
                    peso = sc.nextDouble();

                } else {
                    valid = true;
                }

            }

            Atleta atleta = new Atleta(nome,sexo,altura,peso);
            atletas.add(atleta);

        }

        AtletaService sumarioAtletas = new AtletaService(atletas);
        sumarioAtletas.relatorio();

        sc.close();
    }
}