package br.com.biblioteca;

public class Biblioteca {
    private Livro[] acervo;
    private int count;

    public Biblioteca() {
        acervo = new Livro[100];
        count = 0;
    }

    public void adicionarLivro(Livro livro) {
        if (count < acervo.length) {
            acervo[count++] = livro;
        } else {
            System.out.println("Acervo cheio!");
        }
    }

    public void listarLivros() {
        if (count == 0) {
            System.out.println("Nenhum livro disponível.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(acervo[i]);
            }
        }
    }

    public Livro[] getAcervo() {
        return acervo;
    }

    public int getCount() {
        return count;
    }
}