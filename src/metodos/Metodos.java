package metodos;

import java.util.ArrayList;
import java.util.Scanner;

public class Metodos extends Thread {
    Scanner tec;
    private String nome;
    private Double nota;
    ArrayList<Double> notas;

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
                System.out.println("ola"+ nome);
                break;
            } else if (nome.isBlank()) {
                continue;
            }else {
                System.out.println("Invalido");
            }

        }

        System.out.println("nossos serviços ".toUpperCase());
        System.out.println(" Digite \"1\" Cadastrar Notas".toUpperCase() + "\n");

    }

    public void guardarNotas() {
        int i = 0;
        System.out.println("Digite Suas notas \n\"caso desista teclue (q)".toUpperCase());


        while (i < 4) {
            String entrada = this.tec.nextLine();
            if (entrada.equals("q")) {
                break;
            }

            try {
                double numero = Double.parseDouble(entrada);
                this.notas.add(numero);
            } catch (NumberFormatException var6) {
                System.out.println("Entrada inválida. Digite um número válido.");
            }

            ++i;
            System.out.println("Lista de números:");

            for (double numero : this.notas) {
                System.out.println(numero);
            }
        }

    }

    public void verNota() {
        double soma = (double) 0.0F;

        for (Double notas : this.notas) {
            soma += notas;
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

