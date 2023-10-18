package alphagames.senac.com.model;

public class Categoria {
    private int CATEGORIA_ID;
    private String CATEGORIA_NOME;
    private String CATEGORIA_DESC;
    private int CATEGORIA_ATIVO;

    public Categoria(int CATEGORIA_ID, String CATEGORIA_NOME, String CATEGORIA_DESC, int CATEGORIA_ATIVO) {
        this.CATEGORIA_ID = CATEGORIA_ID;
        this.CATEGORIA_NOME = CATEGORIA_NOME;
        this.CATEGORIA_DESC = CATEGORIA_DESC;
        this.CATEGORIA_ATIVO = CATEGORIA_ATIVO;
    }

    public int getCATEGORIA_ID() {
        return CATEGORIA_ID;
    }

    public void setCATEGORIA_ID(int CATEGORIA_ID) {
        this.CATEGORIA_ID = CATEGORIA_ID;
    }

    public String getCATEGORIA_NOME() {
        return CATEGORIA_NOME;
    }

    public void setCATEGORIA_NOME(String CATEGORIA_NOME) {
        this.CATEGORIA_NOME = CATEGORIA_NOME;
    }

    public String getCATEGORIA_DESC() {
        return CATEGORIA_DESC;
    }

    public void setCATEGORIA_DESC(String CATEGORIA_DESC) {
        this.CATEGORIA_DESC = CATEGORIA_DESC;
    }

    public int getCATEGORIA_ATIVO() {
        return CATEGORIA_ATIVO;
    }

    public void setCATEGORIA_ATIVO(int CATEGORIA_ATIVO) {
        this.CATEGORIA_ATIVO = CATEGORIA_ATIVO;
    }
}
