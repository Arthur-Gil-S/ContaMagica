package br.pucrs.ep.ContaMagica;

public class ContaMagica {
 
    enum Categoria{Silver, Gold, Platinum};
    private String nomeCorrentista;
    private int numeroConta;
    private double saldo;
    private Categoria categoria;

    public ContaMagica(String nomeCorrentista, int numeroConta, double saldo, Categoria categoria){
        this.nomeCorrentista = nomeCorrentista;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.categoria = categoria;
    }
 
    public boolean deposito(Double valor){

        if(valor <= 0) return false;
        
        if(categoria == Categoria.Silver) saldo += valor;
        if(categoria == Categoria.Gold) saldo += (valor * 1.01);
        if(categoria == Categoria.Platinum) saldo += (valor * 1.025);

        if(saldo > 50000 && categoria == Categoria.Silver) categoria = Categoria.Gold;
        else if(saldo > 200000 && categoria == Categoria.Gold) categoria = Categoria.Platinum;

        return true;
    }

    public boolean retirada(Double valor){
        if(valor <= 0) return false;
        if(valor > saldo) return false;
        
        saldo = saldo - valor;

        if(saldo < 100000 && categoria == Categoria.Platinum) categoria = Categoria.Gold;
        if(saldo < 25000 && categoria == Categoria.Gold) categoria = Categoria.Silver;


        return true;
    }

    public Double getSaldo(){
        return saldo;
    }

    public String getCategoria(){
        return categoria.toString();
    }

}