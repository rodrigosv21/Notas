import java.util.Scanner;
import metodos.Metodos;

public class Main {
    public static void main(String[] args) {
        Metodos srv = new Metodos((String)null, (Double)null);
        Scanner tec = new Scanner(System.in);

        srv.inicio();

        System.out.println("qual serviço?".toUpperCase());
        int servico = tec.nextInt();

        switch (servico) {
            case 1:
                srv.guardarNotas();
                srv.conf();
                break;
            default:
                System.out.println("valor indefinido ou não encontrado");
        }
                tec.close();
    }
}