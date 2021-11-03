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
        
        if (entrada == null || entrada.equals(""))
            return;
        
        for (int i = 0; i < entrada.length(); i++) {
            if (x == xCentral)
                valorAtual = new TipoIntString(x, ( entrada.charAt(i) ));
            fita.add(new TipoIntString(x, ( entrada.charAt(i) )));
            x += 27;
        }
        
        //iterator.next();    // Aponta para o primeiro elemento
    }
    
    public DoublyLinkedList<TipoIntString> getFita() {
        return fita;
    }
    
    public int setEntrada(String entrada) {
        int x = xCentral;
        fita = new DoublyLinkedList<>();
        
        if (entrada == null || entrada.equals(""))
            return 1;
        
        for (int i = 0; i < entrada.length(); i++) {
            if (x == xCentral)
                valorAtual = new TipoIntString(x, ( entrada.charAt(i) ));
            fita.add(new TipoIntString(x, ( entrada.charAt(i) )));
            x += 27;
        }
        
        //iterator.next();    // Aponta para o primeiro elemento
        
        return 0;
    }