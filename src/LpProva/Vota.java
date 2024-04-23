import LpProva.Jogador;

import java.util.ArrayList;
import java.util.Scanner;

class Votacao {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);


        ArrayList<Jogador> jogadores = new ArrayList<>();
        String[] nomes = {
                "Alane Dias", "Beatriz Reis", "Davi Brito", "Deniziane Ferreira", "Fernanda Bande",
                "Giovanna Lima", "Giovanna Pitel", "Isabelle Nogueira", "Juninho", "Leidy Elin",
                "Lucas Henrique", "Lucas Luigi", "Lucas Pizane", "Marcus Vinicius", "Matteus Amaral",
                "Maycon Cosmer", "MC Bin Laden", "Michel Nogueira", "Nizam", "Raquele Cardozo",
                "Rodriguinho", "Thalyta Alves", "Vanessa Lopes", "Vinicius Rodrigues",
                "Wanessa Camargo", "Yasmin Brunet"
        };

        for (String nome : nomes) {
            jogadores.add(new Jogador(nome));
        }


        System.out.println("Digite 'sair' para finalizar a votação.");
        while (true) {
            System.out.println("Em quem você vota para sair da casa?");
            String voto = scn.nextLine().trim();

            if (voto.equalsIgnoreCase("sair")) {
                break;
            }

            boolean found = false;
            for (Jogador jogador : jogadores) {
                if (jogador.getNome().equalsIgnoreCase(voto)) {
                    jogador.incrementaUmVoto();
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Jogador não encontrado. Tente novamente.");
            }
        }


        Jogador maisVotado = jogadores.get(0);
        for (Jogador jogador : jogadores) {
            if (jogador.getVotos() > maisVotado.getVotos()) {
                maisVotado = jogador;
            }
        }


        System.out.println("Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu conseguir dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu vou conseguir te eliminar com alegria. Com " + maisVotado.getVotos() + " votos, é você quem sai " + maisVotado.getNome() + ".");

        scn.close();
    }
}
