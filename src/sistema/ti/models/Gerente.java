package sistema.ti.models;

import sistema.ti.interfaces.PJ;

public class Gerente extends Funcionario implements PJ {

        protected int qtProjetos = 0;
        private double salarioBase = 10000;

    @Override
    public double calcPagamento() {
        pagtoAReceber = salarioBase+valorBonus();
        return pagtoAReceber;
    }

    public Gerente(int matricula, String nome) {
        super(matricula, nome);
    }

    @Override
        public double valorBonus() {
            return (salarioBase*0.02)*qtProjetos;
        }
        private boolean verificarProjetos(){
            if(qtProjetos>5){
                return false;
            }
            return true;
        }
    public void addProjetos(int qtProjeto) throws Exception{
            if (verificarProjetos()){
                qtProjetos+=qtProjeto;
                if (!verificarProjetos()){
                    qtProjetos-=qtProjeto;
                    throw new Exception("O funcionário não pode possuir mais de 5 projetos. Ele possui "+qtProjetos+" e você está adicionando "+qtProjeto);
                }
            } else {
                throw new Exception("O Funcionário possuí 5 projetos. Não é possivel gerenciar mais.");
            }

        }

}
