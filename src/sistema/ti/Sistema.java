package sistema.ti;

import sistema.ti.enuns.Nivel;
import sistema.ti.enuns.UserType;
import sistema.ti.models.Analista;
import sistema.ti.models.Funcionario;
import sistema.ti.models.Gerente;

import java.util.ArrayList;

public class Sistema {
    //public Funcionario funcionarios = new Funcionario();
    public Funcionario funcionario[];
    ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public double calcTotalAPagar() {
        double pagamento = 0;
        for (int i = 0; i < funcionarios.size(); i++) {

            pagamento += funcionarios.get(i).calcPagamento();
        }
        return pagamento;
    }

    public double calcPagamento(int matricula) throws Exception {

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getMatricula() == matricula) {
                return funcionarios.get(i).calcPagamento();
            }
        }
        throw new Exception("Não existe funcionário com essa matricula");
    }

    public void addFuncionario(int matricula, String nome, int quantidade, UserType tipo) throws Exception {

        if (tipo.equals(UserType.GERENTE)) {
            Gerente funcionario = new Gerente(matricula, nome);
            funcionario.addProjetos(quantidade);
            funcionarios.add(funcionario);
            return;
        }

        if (tipo.equals(UserType.ANALISTA_SR)) {
            addAnalista(matricula, nome, quantidade, Nivel.Senior);
            return;
        }

        addAnalista(matricula, nome, quantidade, Nivel.Junior);

    }

    public void addAnalista(int matricula, String nome, int quantidade, Nivel nivel) throws Exception {

        Analista funcionario = new Analista(matricula, nome, nivel);
        funcionario.addHoraExtra(quantidade);
        funcionarios.add(funcionario);
    }

}
