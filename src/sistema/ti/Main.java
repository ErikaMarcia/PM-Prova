package sistema.ti;

import sistema.ti.enuns.UserType;
import sistema.ti.exception.LimiteHoraExtraAnalistaException;
import sistema.ti.exception.LimiteProjetoGestorException;

public class Main {

    public static void main(String[] args) throws Exception {

	Sistema sistema = new Sistema();
	sistema.addFuncionario(1, "nome",1, UserType.getEnumByString("Gerente"));

	System.out.println(sistema.calcPagamento(1));
    sistema.addFuncionario(2, "nome",5, UserType.getEnumByString("AnalistaJR"));

    System.out.println(sistema.calcPagamento(2));

    }
}
