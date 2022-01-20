
package Operacoes;

/**
 *
 * @author Amarilda Chihepe
 */
public class Nodo<Tipo> {
    private Tipo info; // informscoes do no actual
    private Nodo prox; //ponteiro do proximo elemento da lista

    public Nodo() {
    }
    public Tipo getInfo() {
        return info;
    }

    public void setInfo(Tipo info) {
        this.info = info;
    }

    public Nodo<Tipo> getProx() {
        return prox;
    }

    public void setProx(Nodo<Tipo> prox) {
        this.prox = prox;
    }
}
