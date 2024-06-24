public class ContaPoupanca extends Conta implements ITaxas, extratoTaxas{

    ContaPoupanca(int numero, Cliente dono, double saldo, double limite){
        super(numero, dono, saldo, limite);
    }

    public void setLimite(double limite) {
        if (limite < 100)
            limite = 100;
        if(limite > 1000)
            limite = 1000;
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
