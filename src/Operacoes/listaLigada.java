
package Operacoes;

/**
 *
 * @author Amarilda Chihepe
 */
public class listaLigada<Tipo> {
    
    private Nodo<Tipo> prim; // primeiro elemento da lista
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    
    //Insercao no inicio na lista
    public void addElemento(Tipo i){
       Nodo<Tipo> novo  = new Nodo<Tipo>();
       novo.setInfo(i);
       novo.setProx(prim);
       this.prim = novo;
       this.size++;
    }
    //retorna o tamanho da lista   
    /*public int size(){
        
        while(prim.getProx() != null){
            size++;
        }
     
      return size; 
    }*/
    
    
    //verificar se a lista esta vazia
    public boolean isEmpty(){
        if(prim == null){
            return true;
        } else
            return false;
    }
    
    //retornar o elemento de uma derminada posicao
    public Nodo<Tipo> getElemento(int pos){
        Nodo<Tipo> actual = this.prim;
        for(int i = 0; i < pos; i++){
            if(actual.getProx() != null){
                actual = actual.getProx();
            }
            
     }
        return actual;
    }
    
    //busca por um determinado elemento
    public Nodo<Tipo> pesquisar(Tipo i){
        for(Nodo<Tipo> n= prim; n!= null; n = n.getProx()){
          if(n.getInfo() == i){
              return n;
          }  
        }
        
        return null; // Nao achou o elemento
    }
    
    
    //Altera os dados dos elementos da lista
    public void alterar(Tipo obj, int pos){
                   
    }
    
    public void remover(Tipo obj){
        Nodo<Tipo> anterior = null; // elemento anterior
        Nodo<Tipo> p = prim; //objecto que percorre a  lista
        
        //procura o elemento 
        while(p != null && p.getInfo() != obj){
            anterior = p;
            p = p.getProx();
        }
        
        //verifica se achou o elemento
        if(p == null){
            return;
        }
    
    
   // elemina o elemento
    if(anterior == null){
        prim = p.getProx();
    }else{
        anterior.setProx(p.getProx());
    }
    
    }
    
}
