package dataBase.beans;

public class Usuario_Topico {
    
    private Usuario usuario;
    private Topico topico;

    public Usuario_Topico() {
    }

    public Usuario_Topico(Usuario usuario, Topico topico) {
        this.usuario = usuario;
        this.topico = topico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }
    
}
