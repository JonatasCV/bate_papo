package dataBase.beans;

public class Usuario {
    
    private Integer codUsuario;
    private String nome;
    private String iPaddres;

    public Usuario() {
    }

    public Usuario(Integer codUsuario, String nome, String iPaddres) {
        this.codUsuario = codUsuario;
        this.nome = nome;
        this.iPaddres = iPaddres;
    }

    // GETTERS
    public Integer getCodUsuario() {
        return codUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getiPaddres() {
        return iPaddres;
    }

    // SETTERS
    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setiPaddres(String iPaddres) {
        this.iPaddres = iPaddres;
    }
    
    
}
