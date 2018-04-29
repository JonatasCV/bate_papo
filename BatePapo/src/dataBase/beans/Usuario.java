package dataBase.beans;

public class Usuario {
    
    private Integer codUsuario;
    private String nome;
    private String iPaddress;

    public Usuario() {
    }

    public Usuario(Integer codUsuario, String nome, String iPaddress) {
        this.codUsuario = codUsuario;
        this.nome       = nome;
        this.iPaddress  = iPaddress;
    }

    // GETTERS
    public Integer getCodUsuario() {
        return codUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getiPaddress() {
        return iPaddress;
    }

    // SETTERS
    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setiPaddress(String iPaddres) {
        this.iPaddress = iPaddres;
    }
    
    
}
