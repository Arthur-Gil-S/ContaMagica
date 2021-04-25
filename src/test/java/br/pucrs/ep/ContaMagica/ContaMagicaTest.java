package br.pucrs.ep.ContaMagica;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import br.pucrs.ep.ContaMagica.ContaMagica.Categoria;

import org.junit.jupiter.api.BeforeEach;

public class ContaMagicaTest {
    
    // -> Problema na inserção da instanciação. O certo seria passar sem parâmetros e, 
    // nos testes, só passar valores ( baseado nos exemplos das aulas).
    //
    //private ContaMagica cm;
    //@BeforeEach
    //public void setup(){
    //    cm = new ContaMagica("Adalberto", 1234);
    //}

    // -> Problemas no uso de ParameterizedTest. Testes simplesmente não rodam, seja por nullpointer exception
    // (causado pelo @BeforeEach) ou noSuchMethodFound.
    //
    //@ParameterizedTest
    //@CsvSource
    //({ "Silver,0.0,25000.0,Silver, 25000.0",
    //"Silver,0.0,75000.0, Gold, 75000.0",
    //"Gold,60000.0,10000.0, Gold, 70100.0", 
    //"Gold,60000.0,60000.0,Platinum, 120600.0",
    //"Platinum,125000.0,30000.0,Platinum, 155750.0"})

    // -> Solução prévia: passar manualmente os valores, instanciando uma conta por vez, sem utilizar BeforeEach.

    // Problema 1.2: O teste só funciona se passar um assertEquals por método de teste. Ao passar mais de um
    // ele faz o teste apenas de um.

    // SOLUÇÃO PRÉVIA 2: Criação de um método de teste para cada teste único. 
    //  POSSIVELMENTE INVIAVEL
    
    
    // ------------ DEPOSITOS ----------------
    
    @Test
    public void depositaAdalbertoTest() {
        ContaMagica c1 = new ContaMagica("Adalberto", 1234, 0, Categoria.Silver);
       
        c1.deposito(25000.0);
        
        Assertions.assertEquals(Categoria.Silver.toString(), c1.getCategoria()); // Executa somente um teste por método
       // Assertions.assertEquals(25000.0, c1.getSaldo()); // Não executa
        
    }
    @Test
    public void depositaAdalbertoTest2(){
        ContaMagica c2 = new ContaMagica("Adalberto", 1234, 0, Categoria.Silver);
        c2.deposito(25000.0);
        Assertions.assertEquals(25000.0, c2.getSaldo());
    }

    @Test
    public void depositaAlanaTest(){
        ContaMagica c3 = new ContaMagica("Alana", 2345, 0, Categoria.Silver);
        c3.deposito(75000.0);
        Assertions.assertEquals(Categoria.Gold.toString(), c3.getCategoria());
    }

    @Test
    public void depositaAlanaTest2(){
        ContaMagica c4 = new ContaMagica("Alana", 2345, 0, Categoria.Silver);
        c4.deposito(75000.0);
        Assertions.assertEquals(75000.0, c4.getSaldo());
    }

    @Test
    public void depositaBarbaroTest(){
        ContaMagica c5 = new ContaMagica("Barbaro", 3456, 60000.0, Categoria.Gold);
        //ContaMagica c1 = new ContaMagica(nomeCorrentista, numeroConta, saldo, categoria)
        c5.deposito(10000.0);
        Assertions.assertEquals(Categoria.Gold.toString(), c5.getCategoria());
    }

    @Test
    public void depositaBarbaroTest2(){
        ContaMagica c6 = new ContaMagica("Barbaro", 3456, 60000.0, Categoria.Gold);
        //ContaMagica c1 = new ContaMagica(nomeCorrentista, numeroConta, saldo, categoria)
        c6.deposito(10000.0);
        Assertions.assertEquals(70100.0, c6.getSaldo());
    }


    @Test
    public void depositaClaudinTest(){
        ContaMagica c7 = new ContaMagica("Claudin", 4567, 60000.0, Categoria.Gold);
        c7.deposito(60000.0);
        Assertions.assertEquals(Categoria.Gold.toString(), c7.getCategoria());
    }

    @Test
    public void depositaClaudinTest2(){
        ContaMagica c8 = new ContaMagica("Claudin", 4567, 60000.0, Categoria.Gold);
        c8.deposito(60000.0);
        Assertions.assertEquals(120600.0, c8.getSaldo());
    }

    @Test
    public void depositaDeidaraTest(){
        ContaMagica c9 = new ContaMagica("Deidara", 5678, 125000, Categoria.Platinum);
        c9.deposito(30000.0);
        Assertions.assertEquals(Categoria.Platinum.toString(), c9.getCategoria());
    }

    @Test
    public void depositaDeidaraTest2(){
        ContaMagica c10 = new ContaMagica("Deidara", 5678, 125000, Categoria.Platinum);
        c10.deposito(30000.0);
        Assertions.assertEquals(155750.0, c10.getSaldo());
    }

    // --------------------------------------

    // ------------RETIRADAS ----------------
    
    @Test
    public void retiradaAdalbertoTest() {
        ContaMagica c11 = new ContaMagica("Adalberto", 1234, 25000, Categoria.Silver);
        c11.retirada(20000.0);
        
        Assertions.assertEquals(Categoria.Silver.toString(), c11.getCategoria()); // Executa somente um teste por método
       // Assertions.assertEquals(25000.0, c1.getSaldo()); // Não executa
        
    }
    @Test
    public void retiradaAdalbertoTest2(){
        ContaMagica c12 = new ContaMagica("Adalberto", 1234, 25000, Categoria.Silver);
        c12.retirada(20000.0);
        Assertions.assertEquals(5000.0, c12.getSaldo());
    }

    @Test
    public void retiradaAlanaTest(){
        ContaMagica c13 = new ContaMagica("Alana", 2345, 20000, Categoria.Silver);
        c13.retirada(30000.0);
        Assertions.assertEquals(Categoria.Silver.toString(), c13.getCategoria());
    }

    @Test
    public void retiradaAlanaTest2(){
        ContaMagica c14 = new ContaMagica("Alana", 2345, 20000, Categoria.Silver);
        c14.retirada(30000.0);
        Assertions.assertEquals(20000.0, c14.getSaldo());
    }

    @Test
    public void retiradaBarbaroTest(){
        ContaMagica c15 = new ContaMagica("Barbaro", 3456, 20000.0, Categoria.Silver);
        //ContaMagica c1 = new ContaMagica(nomeCorrentista, numeroConta, saldo, categoria)
        c15.retirada(-150.0);
        Assertions.assertEquals(Categoria.Silver.toString(), c15.getCategoria());
    }

    @Test
    public void retiradaBarbaroTest2(){
        ContaMagica c16 = new ContaMagica("Barbaro", 3456, 20000.0, Categoria.Silver);
        //ContaMagica c1 = new ContaMagica(nomeCorrentista, numeroConta, saldo, categoria)
        c16.retirada(-150.0);
        Assertions.assertEquals(20000.0, c16.getSaldo());
    }


    @Test
    public void retiradaClaudinTest(){
        ContaMagica c17 = new ContaMagica("Claudin", 4567, 60000.0, Categoria.Gold);
        c17.retirada(40000.0);
        Assertions.assertEquals(Categoria.Silver.toString(), c17.getCategoria());
    }

    @Test
    public void retiradaClaudinTest2(){
        ContaMagica c18 = new ContaMagica("Claudin", 4567, 60000.0, Categoria.Gold);
        c18.retirada(40000.0);
        Assertions.assertEquals(20000, c18.getSaldo());
    }

    @Test
    public void retiradaDeidaraTest(){
        ContaMagica c19 = new ContaMagica("Deidara", 5678, 75000, Categoria.Gold);
        c19.retirada(25000.0);
        Assertions.assertEquals(Categoria.Gold.toString(), c19.getCategoria());
    }

    @Test
    public void retiradaDeidaraTest2(){
        ContaMagica c20 = new ContaMagica("Deidara", 5678, 75000, Categoria.Gold);
        c20.retirada(25000.0);
        Assertions.assertEquals(50000.0, c20.getSaldo());
    }

    @Test
    public void retiradaEduardoTest(){
        ContaMagica c21 = new ContaMagica("Eduardo", 4795, 50000, Categoria.Gold);
        c21.retirada(25001.0);
        Assertions.assertEquals(Categoria.Silver.toString(), c21.getCategoria());
    }

    @Test
    public void retiradaEduardoTest2(){
        ContaMagica c22 = new ContaMagica("Eduardo", 4795, 50000, Categoria.Gold);
        c22.retirada(25001.0);
        Assertions.assertEquals(24999, c22.getSaldo());
    }

    @Test
    public void retiradaFabianaTest(){
        ContaMagica c23 = new ContaMagica("Fabiana", 3879, 50000, Categoria.Gold);
        c23.retirada(25000.0);
        Assertions.assertEquals(Categoria.Gold.toString(), c23.getCategoria());
    }

    @Test
    public void retiradaFabianaTest2(){
        ContaMagica c24 = new ContaMagica("Fabiana", 3879, 50000, Categoria.Gold);
        c24.retirada(25000.0);
        Assertions.assertEquals(25000, c24.getSaldo());
    }

    @Test
    public void retiradaGustavoTest(){
        ContaMagica c25 = new ContaMagica("Gustavo", 9756, 250000, Categoria.Platinum);
        c25.retirada(50000.0);
        Assertions.assertEquals(Categoria.Platinum.toString(), c25.getCategoria());
    }

    @Test
    public void retiradaGustavoTest2(){
        ContaMagica c26 = new ContaMagica("Gustavo", 9765, 250000, Categoria.Platinum);
        c26.retirada(50000.0);
        Assertions.assertEquals(200000, c26.getSaldo());
    }

    @Test
    public void retiradaHannahTest(){
        ContaMagica c27 = new ContaMagica("Hanna", 2486, 250000, Categoria.Platinum);
        c27.retirada(200000.0);
        Assertions.assertEquals(Categoria.Gold.toString(), c27.getCategoria());
    }

    @Test
    public void retiradaHannahTest2(){
        ContaMagica c28 = new ContaMagica("Hanna", 2486, 250000, Categoria.Gold);
        c28.retirada(200000.0);
        Assertions.assertEquals(50000, c28.getSaldo());
    }

    @Test
    public void retiradaIcaroTest(){
        ContaMagica c29 = new ContaMagica("Icaro", 7165, 200000, Categoria.Platinum);
        c29.retirada(100001.0);
        Assertions.assertEquals(Categoria.Gold.toString(), c29.getCategoria());
    }

    @Test
    public void retiradaIcaroTest2(){
        ContaMagica c30 = new ContaMagica("Icaro", 7165, 200000, Categoria.Gold);
        c30.retirada(100001.0);
        Assertions.assertEquals(99999, c30.getSaldo());
    }

    @Test
    public void retiradaJoanaTest(){
        ContaMagica c31 = new ContaMagica("Joana", 6798, 200000, Categoria.Platinum);
        c31.retirada(100000.0);
        Assertions.assertEquals(Categoria.Platinum.toString(), c31.getCategoria());
    }

    @Test
    public void retiradaJoanaTest2(){
        ContaMagica c32 = new ContaMagica("Joana", 6798, 200000, Categoria.Platinum);
        c32.retirada(100000.0);
        Assertions.assertEquals(100000, c32.getSaldo());
    }

    //@Test
    //public void depositaTest() {
    //    ContaMagica c1 = new ContaMagica("Adalberto", 1234, 0, Categoria.Silver);
    //    ContaMagica c2 = new ContaMagica("Alana", 2345, 0, Categoria.Silver);
    //    c1.deposito(25000.0);
    //    c2.deposito(75000.0);
    //    Assertions.assertEquals(Categoria.Silver.toString(), c1.getCategoria());
    //    Assertions.assertEquals(25000.0, c1.getSaldo());
    //    Assertions.assertEquals(Categoria.Gold.toString(), c2.getCategoria());
    //}

    // @ParameterizedTest
    // @CsvSource({ "Silver,0,25000,25000,Silver,25000",
    // "Silver,0,75000,75000,Gold,75000",
    // "Gold,60000,10000,70100;Gold, 70100", "Gold,60000,60000,120600,Platinum,
    // 120600",
    // "Platinum,125000,30000,155750,Platinum, 155750", })
    //
    // void testaDeposito(String categoria, Double saldo, Double deposito, String
    // categoriaFinal, Double saldoFinal) {
    //
    // ContaMagica c = new ContaMagica("Adalberto", 1234, 0, Categoria.Silver);
    // c.deposito(deposito);
    //
    // assertEquals(categoriaFinal, c.getCategoria());
    // assertEquals(saldoFinal, c.getSaldo());
    //
    // }

    
}
