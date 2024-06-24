public class ContaUniversitaria extends Conta implements ITaxas, extratoTaxas{

    ContaUniversitaria(int numero, Cliente dono, double saldo, double limite) {
        super(numero, dono, saldo, limite);
    }

    public void setLimite(double limite) {
        if (limite < 0)
            limite = 0;
        if (limite > 500)
            limite = 500;
        setLimite(limite);
    }

    public double calculaTaxas() {
        return 0;
    }

    public void imprimirExtratoTaxas() {
        double t = 0;
        System.out.println("============Extrato de Taxas============");
        System.out.println("Taxa de Manunteção: " + calculaTaxas());

        Operacao[] op = getOperacoes();
        for (int i = 0; i < op.length; ++i) {
            if (op[i] != null && op[i].getTipo() == 's') {
                System.out.println("Saque: R$" + op[i].calculaTaxas());
                t += op[i].calculaTaxas();
            }
        }
        System.out.println();
        System.out.println("Taxa de Saque Total: R$" + t);
    }
}
