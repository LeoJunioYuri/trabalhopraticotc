public class MT {
    private Fita fita;
    private int passos;
    private boolean rejeitado;
    private String estadoAtual, estadoInicial, estadoAceitacao;
    private String parEstadoValor;
    private String entrada;
    private HashMap< String, List<String> > mapPrograma = new HashMap<>();  // <Estado+ValorLido, estadoSeguinte, valorNovo, movimentoCabeçote>

    public MT () {
        fita = new Fita();
        passos = 0;
        rejeitado = false;
        mapPrograma.clear();
    }

    public void setFita(String entrada) {
        fita.setEntrada(entrada);
        this.entrada = entrada;
    }

}
