package Operacoes;

/**
 *
 * @author Amarilda Chihepe
 * @param <Tipo>
 */
public class listaLigada<Tipo> {

    private Nodo<Tipo> prim, ultimo; // primeiro e ultimo elemento da lista
    private int size;

    public listaLigada() {
        prim = null;
        size = 0;
    }

    public Nodo<Tipo> getPrim() {
        return prim;
    }

    public void setPrim(Nodo<Tipo> prim) {
        this.prim = prim;
    }

    public Nodo<Tipo> getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo<Tipo> ultimo) {
        this.ultimo = ultimo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //Insercao no inicio na lista
    public void addElemento(Tipo i) {
        Nodo<Tipo> novo = new Nodo<>();
        novo.setInfo(i);
        if (this.prim == null && this.ultimo == null) {
            this.prim = novo;
            this.ultimo = novo;
        } else {
            this.ultimo.setProx(novo);
            this.ultimo = novo;
        }
        this.size++;
    }

    //verificar se a lista esta vazia
    public boolean isEmpty() {
        if (prim == null) {
            return true;
        } else {
            return false;
        }
    }

    //retornar o elemento de uma derminada posicao
    public Nodo<Tipo> getElemento(int pos) {
        Nodo<Tipo> actual = this.prim;
        for (int i = 0; i < pos; i++) {
            if (actual.getProx() != null) {
                actual = actual.getProx();
            }

        }
        return actual;
    }

    //busca por um determinado elemento
    public Nodo<Tipo> pesquisar(Tipo i) {
        for (Nodo<Tipo> n = prim; n != null; n = n.getProx()) {
            if (n.getInfo() == i) {
                return n;
            }
        }

        return null; // Nao achou o elemento
    }

    //Altera os dados dos elementos da lista
    public void alterar(Tipo obj, int pos) {
        Nodo<Tipo> act = getElemento(pos);
        act.setInfo(obj);
    }

    public void remover(Tipo obj) {
        Nodo<Tipo> anterior = null; // elemento anterior
        Nodo<Tipo> atual = prim; //objecto que percorre a  lista
        for (int i = 0; i < size; i++) {
            if (atual.getInfo().equals(obj)) {
                if (size == 1) { //se so tiver um elemento
                    this.prim = null;
                    this.ultimo = null;
                } else if (atual == prim) { // se o objecto for o primeiro
                    this.prim = atual.getProx();
                    atual.setProx(null);
                } else if (atual == ultimo) { // se o objecto for o ultimo
                    this.ultimo = anterior;
                    anterior.setProx(null);
                } else {// se o elemento estiver no meio da lista
                    anterior.setProx(atual.getProx());
                    atual = null;
                }
                size--;
                break;
            }
            anterior = atual;
            atual = atual.getProx();
        }
    }
    
    public void addOrdenado(int pos, Tipo tipo){
        /*cria novo elemento*/
        Nodo<Tipo> novo = new Nodo<>();
        novo.setInfo(tipo);
        /*objecto para o elemento anterior*/
        Nodo <Tipo> anterior = null;
        /*objecto para percorrer a lista*/
        Nodo <Tipo> p = prim;

        /*procura elemento na lista, guardando anterior*/
        for (int i = 0; i < pos; i++) 
            if (p != null){
                anterior = p;
                p = p.getProx();
            }
        /*encadeia o elemento*/
        if(anterior == null){ /*insere o elemento no inicio*/
            novo.setProx(prim);
            prim = novo;
            size++;
        }else{ /*insere elemento no meio da lista*/
            novo.setProx(anterior.getProx()); //o proximo do nodo novo sera o proximo do nodo anterior,
            anterior.setProx(novo); //como se estivesse a abrir espaco no meio para o nodo novo
            size++;         // e o proximo do nodo anterior sera o no novo
            
        }
 }

}
