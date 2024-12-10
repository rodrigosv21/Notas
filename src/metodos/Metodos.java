package metodos;

import java.util.ArrayList;
import java.util.Scanner;

public class Metodos extends Thread {
    Scanner tec;
    private String nome;
    private Double nota;
    private ArrayList<Double> notas;

    public Metodos(String nome, Double nota) {
        this.tec = new Scanner(System.in);
        this.notas = new ArrayList();
        this.nome = nome;
        this.nota = nota;
    }

    public void inicio() {
        String regex = "^[A-Za-z-]+$";

        while (true) {
            System.out.println("Digite seu nome: ".toUpperCase());
            this.nome = this.tec.nextLine();

            if (nome.matches(regex)){
                System.out.println("ola "+ nome);
                break;
            } else if (nome.isBlank()) {
                continue;
            } else {
                System.out.println("Invalido");
            }

        }

        System.out.println("nossos serviços ".toUpperCase());
        System.out.println(" Digite \"1\" Cadastrar Notas".toUpperCase() + "\n");

    }

    public void guardarNotas() {
        System.out.println("Digite Suas notas \n\"caso desista teclue (q)".toUpperCase());

        String regex = "^[A-Za-z-]+$";

        int i = 0;
        while (i < 4) {
            String entrada = this.tec.nextLine();
            if (entrada.equals("q")) {
                break;
            }else if(entrada.matches(regex)){
                continue;
            }

            try {
                double numero = Double.parseDouble(entrada);
                this.notas.add(numero);
                ++i;
                System.out.println("Notas:");
            } catch (NumberFormatException var6) {
                System.out.println("Entrada inválida. Digite um número válido.");
            }

            for (double numero : this.notas) {
                System.out.println(numero);
            }
        }
    }

    public void conf() {
        System.out.println("suas notas" + notas);
        System.out.println("confirmar notas teclue \"1\" para sim e \"2\" para não");
        int ent = tec.nextInt();

        if (ent == 1){
            double soma = 0.0;
            for (Double numero : notas) {
                soma += numero;
            }

            double resultado = soma / 4;

            System.out.println("Valor Somado: " + String.format("%.2f", soma));
            if (soma / 4 >= 7){
                System.out.println("Parabéns " + nome + " você foi aprovado com a média  " + String.format("%.1f", resultado));
            }else if (soma / 4 < 7){
                System.out.println("sua nota foi " + resultado + " Infelizmente você não atingiu a média " + nome +
                        " entre em contato com o seu professor para a recuperação");
            }else{
                System.out.println("não identificado");
            }
        } else if (ent == 2) {
            guardarNotas();
        }
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota() {
        return this.nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

}
