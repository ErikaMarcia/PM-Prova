package sistema.ti.models;

import sistema.ti.enuns.Nivel;
import sistema.ti.interfaces.CLT;
import sistema.ti.interfaces.INivel;

public class Analista extends Funcionario implements CLT {

        protected int qtHorasExtras = 0;
        protected INivel nivel;
        private double horasExtras = (valorHorasExtras())*qtHorasExtras;
        private double salarioBase;

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Analista(int matricula, String nome, Nivel nivel) {
        super(matricula, nome);
        setNivel(nivel);
        setSalarioBase(nivel.getSalarioBase());
    }
    @Override
    public double calcPagamento() {
        pagtoAReceber = (salarioBase+horasExtras) - impostoApagar();
        qtHorasExtras = 0;
        return pagtoAReceber;
    }


    @Override
        public double valorHorasExtras() {
            double valorHora = (1/90)*salarioBase;
            return valorHora;
        }

        @Override
        public double valorFerias(double meses) {
            double valorFerias = (salarioBase *meses)+horasExtras;
            valorFerias = (valorFerias*(1/3))+valorFerias;
            valorFerias = valorFerias - impostoApagar();
            return valorFerias;
        }

        @Override
        public double impostoApagar() {
            double INSS = 0;
            if (salarioBase < 3305.22) {
                INSS = salarioBase * 0.12;
            }
            INSS = salarioBase * 0.14;
            return INSS;

        }
        private boolean verificarHorasExtras(){
            if(qtHorasExtras>40){
                return false;
            }
            return true;
        }

    public  void addHoraExtra(int hora) throws Exception{

            if (!verificarHorasExtras()){
                throw new Exception("O Funcionário possuí 40 horas extra. Não é possivel acumular mais.");
            }else {
                qtHorasExtras+=hora;
                if (!verificarHorasExtras()){
                    qtHorasExtras-=hora;
                    throw new Exception("O Funcionário possuí "+qtHorasExtras+" E você está adicionando" +hora+" Não é possivel acumular mais de 40 horas extras.");
                }
            }
        }

}
