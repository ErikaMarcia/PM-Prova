package sistema.ti.enuns;

public enum UserType {

    GERENTE("Gerente"),
    ANALISTA_JR("AnalistaJR"),
    ANALISTA_SR("AnalistaSR");

    private String descricao;

    UserType(String descricao) {
        this.descricao = descricao;
    }

    public static UserType getEnumByString(String tipo){

        if (GERENTE.descricao.equals(tipo)){
            return GERENTE;
        }

        if (ANALISTA_SR.descricao.equals(tipo)){
            return ANALISTA_SR;
        }

        return ANALISTA_JR;
    }
}
