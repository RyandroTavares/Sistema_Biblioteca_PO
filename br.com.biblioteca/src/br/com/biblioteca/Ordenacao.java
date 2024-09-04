package br.com.biblioteca;

public class Ordenacao {

    public static void bubbleSort(Livro[] array, int count, boolean byTitle) {
        boolean swapped;
        for (int i = 0; i < count - 1; i++) {
            swapped = false;
            for (int j = 0; j < count - i - 1; j++) {
                Livro l1 = array[j];
                Livro l2 = array[j + 1];
                if (byTitle ? l1.titulo.compareToIgnoreCase(l2.titulo) > 0 : l1.autor.compareToIgnoreCase(l2.autor) > 0) {
                    Livro temp = l1;
                    array[j] = l2;
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void buscaPorTitulo(Livro[] array, int count, String titulo) {
        boolean encontrado = false;
        System.out.println("Buscando por título contendo: " + titulo);
        for (int i = 0; i < count; i++) {
            if (array[i].titulo.toLowerCase().contains(titulo.toLowerCase())) {
                if (!encontrado) {
                    System.out.println("Livros encontrados:");
                    encontrado = true;
                }
                System.out.println(array[i]);
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum livro encontrado com o título contendo: " + titulo);
        }
    }

    public static void buscaPorAutor(Livro[] array, int count, String autor) {
        boolean encontrado = false;
        System.out.println("Buscando por autor contendo: " + autor);
        for (int i = 0; i < count; i++) {
            if (array[i].autor.toLowerCase().contains(autor.toLowerCase())) {
                if (!encontrado) {
                    System.out.println("Livros encontrados:");
                    encontrado = true;
                }
                System.out.println(array[i]);
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum livro encontrado com o autor contendo: " + autor);
        }
    }
}
