package ListasEncadeadas;

public class ListaDuplamenteEncadeada {

    private Celula inicio;
    private Celula fim;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public void adicionarFim(int valor) {

        Celula novaCelula = new Celula(valor);

        if (estaVazia()) {
            inicio = novaCelula;
            fim = novaCelula;
        } else {
            novaCelula.setAnterior(fim);
            fim.setProxima(novaCelula);
            fim = novaCelula;
        }

        tamanho++;
    }

    public void adicionarInicio(int valor) {

        Celula novaCelula = new Celula(valor);

        if (estaVazia()) {
            inicio = novaCelula;
            fim = novaCelula;
        } else {
            novaCelula.setProxima(inicio);
            inicio.setAnterior(novaCelula);
            inicio = novaCelula;
        }

        tamanho++;
    }

    public void adicionarNaPosicao(int valor, int posicao) {

        if (posicao < 0 || posicao > tamanho) {
            System.out.println("Posição inválida!");
            return;
        }

        if (posicao == 0) {
            adicionarInicio(valor);
            return;
        }

        if (posicao == tamanho) {
            adicionarFim(valor);
            return;
        }

        Celula novaCelula = new Celula(valor);
        Celula atual = inicio;

        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }

        Celula anterior = atual.getAnterior();

        anterior.setProxima(novaCelula);
        novaCelula.setAnterior(anterior);

        novaCelula.setProxima(atual);
        atual.setAnterior(novaCelula);

        tamanho++;
    }

    public void excluirInicio() {

        if (estaVazia()) {
            System.out.println("A lista está vazia!");
            return;
        }

        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            Celula novaInicio = inicio.getProxima();

            novaInicio.setAnterior(null);
            inicio = novaInicio;
        }

        tamanho--;
    }

    public void excluirFim() {

        if (estaVazia()) {
            System.out.println("A lista está vazia!");
            return;
        }

        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            Celula novoFim = fim.getAnterior();

            novoFim.setProxima(null);
            fim = novoFim;
        }

        tamanho--;
    }

    public void excluirPosicao(int posicao) {

        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Posição inválida!");
            return;
        }

        if (posicao == 0) {
            excluirInicio();
            return;
        }

        if (posicao == tamanho - 1) {
            excluirFim();
            return;
        }

        Celula atual = inicio;

        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }

        Celula anterior = atual.getAnterior();
        Celula proxima = atual.getProxima();

        anterior.setProxima(proxima);
        proxima.setAnterior(anterior);

        tamanho--;
    }

    public void mostrarLista() {

        System.out.print("[");

        Celula atual = inicio;

        while (atual != null) {

            System.out.print(atual.getValor());

            if (atual.getProxima() != null) {
                System.out.print(", ");
            }

            atual = atual.getProxima();
        }

        System.out.println("]");
    }
}
    