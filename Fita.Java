public class Fita {
    private DoublyLinkedList<TipoIntString> fita;
    private static final int xCentral = 210;
    private ListIterator<TipoIntString> iterator;
    TipoIntString valorAtual;
    
    
    public Fita() {
        fita = new DoublyLinkedList<>();
        iterator = fita.iterator();
    }
    
    public Fita(String entrada) {
        int x = xCentral;
        
        fita = new DoublyLinkedList<>();
        iterator = fita.iterator();
        
        //if (entrada == null || entrada.equals(""))
          //  return;
        
        //TODO
        
        //iterator.next();    // apontando para o primeiro elemento
    }
    
    public DoublyLinkedList<TipoIntString> getFita() {
        return fita;
    }
    
    public int setEntrada(String entrada) {
        int x = xCentral;
        fita = new DoublyLinkedList<>();

        //TODO 

        return 0;
    }

    public void direita(){
        //TODO
    }

    public void esquerda(){
        //TODO
    }

    public void getCampo(){
        //TODO
    }

    //implementar heuristcas