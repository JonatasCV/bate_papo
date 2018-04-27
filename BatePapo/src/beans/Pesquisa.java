package beans;

import java.util.Calendar;

public class Pesquisa {
 
    private Calendar dataHora;
    private Topico topico;

    public Pesquisa() {
    }

    public Pesquisa(Calendar dataHora, Topico topico) {
        this.dataHora = dataHora;
        this.topico = topico;
    }
    
    // GETTERS
    public Calendar getDataHora() {
        return dataHora;
    }

    public Topico getTopico() {
        return topico;
    }
    
    // SETTERS
    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }
}
