package sistema.ti.models;

public abstract class Funcionario {
    protected int matricula;
    protected String nome;
    protected double pagtoAReceber;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract double calcPagamento();

    Funcionario(int matricula, String nome){
        setMatricula(matricula);
        setNome(nome);
    }
}
