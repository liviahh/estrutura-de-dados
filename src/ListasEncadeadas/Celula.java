package ListasEncadeadas;

public class Celula {

    private int valor;
    private Celula anterior;
    private Celula proxima;

    public Celula(int valor) {
        this.valor = valor;
        this.anterior = null;
        this.proxima = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Celula getAnterior() {
        return anterior;
    }

    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }

    public Celula getProxima() {
        return proxima;
    }

    public void setProxima(Celula proxima) {
        this.proxima = proxima;
    }
}