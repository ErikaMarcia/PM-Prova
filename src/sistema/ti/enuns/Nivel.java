package sistema.ti.enuns;

import sistema.ti.interfaces.INivel;

public enum Nivel implements INivel {
    Junior(2500),
    Senior(3750);
    private final double salario;

    Nivel(double i) {
        this.salario = i;
    }

    @Override
    public double getSalarioBase() {
        return salario;
    }
}
