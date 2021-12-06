
/**
 * Principal
 */
import java.util.*;

import MT.Transition;

public class Principal {
    // main
    public static <Transition, UTM> void main(String[] args) {
        Scanner entrada;
        entrada = new Scanner(System.in);
        ManipulaArquivo.lerArquivoTexto(lerNomeArquivoTexto());
        entrada.close();

        // incrementador
        String init = "q0";
        String blank = "b";

        Set<String> term = new HashSet<String>();
        term.add("qf");

        Set<Transition> trans = new HashSet<Transition>();

        trans.add(new Transition(new StateTapeSymbolPair("q0", "1"), new StateTapeSymbolPair("q0", "1"), 1));
        trans.add(new Transition(new StateTapeSymbolPair("q0", "b"), new StateTapeSymbolPair("qf", "1"), 0));

        UTM machine = new UTM(trans, term, init, blank);
        ((Object) machine).initializeTape("111");
        System.out.println("Output (si): " + machine.runTM() + "\n");

        // overwrite das variaveis
        init = "a";

        term.clear();
        term.add("halt");

        blank = "0";

        trans.clear();

        trans.add(new Transition(new StateTapeSymbolPair("a", "0"), new StateTapeSymbolPair("b", "1"), 1));
        trans.add(new Transition(new StateTapeSymbolPair("a", "1"), new StateTapeSymbolPair("c", "1"), -1));
        trans.add(new Transition(new StateTapeSymbolPair("b", "0"), new StateTapeSymbolPair("a", "1"), -1));
        trans.add(new Transition(new StateTapeSymbolPair("b", "1"), new StateTapeSymbolPair("b", "1"), 1));
        trans.add(new Transition(new StateTapeSymbolPair("c", "0"), new StateTapeSymbolPair("b", "1"), -1));
        trans.add(new Transition(new StateTapeSymbolPair("c", "1"), new StateTapeSymbolPair("halt", "1"), 0));

        machine = new UTM(trans, term, init, blank);
        machine.initializeTape("");
        System.out.println("Output (bb): " + machine.runTM());

        init = "s0";
        blank = "*";

        term = new HashSet<String>();
        term.add("see");

        trans = new HashSet<Transition>();

        trans.add(new Transition(new StateTapeSymbolPair("s0", "a"), new StateTapeSymbolPair("s0", "a"), 1));
        trans.add(new Transition(new StateTapeSymbolPair("s0", "b"), new StateTapeSymbolPair("s1", "B"), 1));
        trans.add(new Transition(new StateTapeSymbolPair("s0", "*"), new StateTapeSymbolPair("se", "*"), -1));
        trans.add(new Transition(new StateTapeSymbolPair("s1", "a"), new StateTapeSymbolPair("s1", "a"), 1));
        trans.add(new Transition(new StateTapeSymbolPair("s1", "b"), new StateTapeSymbolPair("s1", "b"), 1));
        trans.add(new Transition(new StateTapeSymbolPair("s1", "*"), new StateTapeSymbolPair("s2", "*"), -1));
        trans.add(new Transition(new StateTapeSymbolPair("s2", "a"), new StateTapeSymbolPair("s3", "b"), -1));
        trans.add(new Transition(new StateTapeSymbolPair("s2", "b"), new StateTapeSymbolPair("s2", "b"), -1));
        trans.add(new Transition(new StateTapeSymbolPair("s2", "B"), new StateTapeSymbolPair("se", "b"), -1));
        trans.add(new Transition(new StateTapeSymbolPair("s3", "a"), new StateTapeSymbolPair("s3", "a"), -1));
        trans.add(new Transition(new StateTapeSymbolPair("s3", "b"), new StateTapeSymbolPair("s3", "b"), -1));
        trans.add(new Transition(new StateTapeSymbolPair("s3", "B"), new StateTapeSymbolPair("s0", "a"), 1));
        trans.add(new Transition(new StateTapeSymbolPair("se", "a"), new StateTapeSymbolPair("se", "a"), -1));
        trans.add(new Transition(new StateTapeSymbolPair("se", "*"), new StateTapeSymbolPair("see", "*"), 1));
        System.out.println("Output: " + machine.runTM() + "\n");
    }

    private static String lerNomeArquivoTexto() {
        return null;
    }
}