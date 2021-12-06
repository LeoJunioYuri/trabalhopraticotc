import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

//classe responsável por implementar a máquina de turing
public class MT {
    private List<String> tape; //fita
    private String blankSymbol;
    private ListIterator<String> cabeca;
    private Map<StateTapeSymbolPair, Transition> transitions = new HashMap<StateTapeSymbolPair, Transition>();
    private Set<String> terminalStates;
    private String initialState;

    //construtor
    public MT(Set<Transition> transitions, Set<String> terminalStates, String initialState, String blankSymbol){
        this.blankSymbol = blankSymbol;
        for (Transition t : transitions) {
            this.transitions.put(t.from, t);
        }
        this.terminalStates = terminalStates;
        this.initialState = initialState;
    }

    public static class StateTapeSymbolPair {
        private String state;
        private String tapeSymbol;
 
        public StateTapeSymbolPair(String state, String tapeSymbol) {
            this.state = state;
            this.tapeSymbol = tapeSymbol;
        }

        //
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result
                    + ((state == null) ? 0 : state.hashCode());
            result = prime
                    * result
                    + ((tapeSymbol == null) ? 0 : tapeSymbol
                            .hashCode());
            return result;
        }

        //
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            StateTapeSymbolPair other = (StateTapeSymbolPair) obj;
            if (state == null) {
                if (other.state != null)
                    return false;
            } else if (!state.equals(other.state))
                return false;
            if (tapeSymbol == null) {
                if (other.tapeSymbol != null)
                    return false;
            } else if (!tapeSymbol.equals(other.tapeSymbol))
                return false;
            return true;
        }
 
        @Override
        public String toString() {
            return "(" + state + "," + tapeSymbol + ")";
        }
    }
    
    public static class Transition {
        private StateTapeSymbolPair from;
        private StateTapeSymbolPair to;
        private int direction; // -1 esquerda, 0neutro, 1 direita 
 
        public Transition(StateTapeSymbolPair from, StateTapeSymbolPair to, int direction) {
             this.from = from;
            this.to = to;
            this.direction = direction;
        }
 
        @Override
        public String toString() {
            return from + "=>" + to + "/" + direction;
        }
    }

    //inicializador com strings
    public void initializeTape(List<String> input) { // strings como simbolos
        tape = input;
    }

    //inicializador com char
    public void initializeTape(String input) { // char como simbolo
        tape = new LinkedList<String>();
        for (int i = 0; i < input.length(); i++) {
            tape.add(input.charAt(i) + "");
        }
    }



    //executar a maquina
    public List<String> runTM(String conteudo) { // retorna null se nao for terminal
        if (tape.size() == 0) {
            tape.add(blankSymbol);
        }
 
        cabeca = tape.listIterator();
        cabeca.next();
        cabeca.previous();
 
        StateTapeSymbolPair tsp = new StateTapeSymbolPair(initialState, tape.get(0));
 
        while (transitions.containsKey(tsp)) { // 
            System.out.println(this + " --- " + transitions.get(tsp));
            Transition trans = transitions.get(tsp);
            cabeca.set(trans.to.tapeSymbol); // escreve na fita o simbolo
            tsp.state = trans.to.state; // muda o estado
            if (trans.direction == -1) { // vai esquerda
                if (!cabeca.hasPrevious()) {
                    cabeca.add(blankSymbol); // fita estendida
                }
                tsp.tapeSymbol = cabeca.previous(); // guarda o simbolo da fita
            } else if (trans.direction == 1) { // vai direita
                cabeca.next();
                if (!cabeca.hasNext()) {
                    cabeca.add(blankSymbol); // fita estendida
                    cabeca.previous();
                }
                tsp.tapeSymbol = cabeca.next(); // guarda o simbolo da fita
                cabeca.previous();
            } else {
                tsp.tapeSymbol = trans.to.tapeSymbol;
            }
        }
 
        System.out.println(this + " --- " + tsp);
 
        if (terminalStates.contains(tsp.state)) {
            return tape;
        } else {
            return null;
        }
    }


    //imprimir objeto
    @Override
    public String toString() {
        try {
        	int cabecaPos = cabeca.previousIndex();
            String s = "[ ";
 
            for (int i = 0; i <= cabecaPos; i++) {
                s += tape.get(i) + " ";
            }
 
            s += "[H] ";
 
            for (int i = cabecaPos + 1; i < tape.size(); i++) {
                s += tape.get(i) + " ";
            }
 
            return s + "]";
        } catch (Exception e) {
            return "";
        }
    }
}
