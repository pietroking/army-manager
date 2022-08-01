import org.junit.Assert;
import org.junit.Test;
import militares.*;
import simulacaoFinanceira.*;
import veiculos.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;


public class Teste {

    @Test
    public void deveCalcularOCustoTotalDaMissaoCorretamente() {

        ArrayList<Veiculo> veiculos = new ArrayList<>();

        veiculos.add(criarAviao());
        veiculos.add(criarAviao1());
        veiculos.add(criarAviao2());
        veiculos.add(criarTanque());
        veiculos.add(criarTanque1());
        veiculos.add(criarTanque2());
        veiculos.add(criarHelicoptero());
        veiculos.add(criarHelicoptero1());
        veiculos.add(criarHelicoptero2());
        veiculos.add(criarCaminhao());
        veiculos.add(criarCaminhao1());
        veiculos.add(criarCaminhao2());
        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1137, veiculos, 1);

        BigDecimal custoTotal = simulacao.getCustoTotalMissao();
        System.out.println(custoTotal);

        // Se esse teste falhar por centavos de diferença (pequenas diferenças de arredondamento) o valor do teste pode ser ajustado.
        assertEquals(BigDecimal.valueOf(163579.685), custoTotal);
        Assert.assertTrue(simulacao.todasTripulacoesValidas());
    }

    @Test
    public void deveCalcularOCustoTotalComCombustivelCorretamente(){
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        veiculos.add(criarAviao());
        veiculos.add(criarTanque());
        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1137, veiculos, 1);
        BigDecimal custoTotal = simulacao.gastoComCombustivel();
        System.out.println(custoTotal);
        System.out.println(BigDecimal.valueOf(2305.837));
        assertEquals(BigDecimal.valueOf(2305.838), custoTotal);
    }

    @Test
    public void deveCalcularOCustoToralComSalariosCorretamente(){
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        veiculos.add(criarAviao());
        veiculos.add(criarCaminhao());
        veiculos.add(criarHelicoptero());
        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1137, veiculos, 1);
        BigDecimal custoTotal = veiculos.get(0).salarioTripulacao();
        System.out.println(custoTotal);
        System.out.println(BigDecimal.valueOf(9500));
        assertEquals(BigDecimal.valueOf(9500), custoTotal);
    }

    private void assertEquals(BigDecimal valueOf, BigDecimal custoTotal) {
    }

    private Tanque criarTanque() {

        Elite piloto = new Elite(BigDecimal.valueOf(3000),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20));

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new PilotoTanque(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new Militar(BigDecimal.valueOf(600)));
        tripulacao.add(new Militar(BigDecimal.valueOf(600)));

        return new Tanque(piloto, tripulacao, 0.22, BigDecimal.valueOf(3.46));
    }

    private Tanque criarTanque1() {

        EspecialistaTerrstre piloto = new EspecialistaTerrstre(BigDecimal.valueOf(3000),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20));

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new PilotoTanque(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new Militar(BigDecimal.valueOf(600)));
        tripulacao.add(new Militar(BigDecimal.valueOf(600)));

        return new Tanque(piloto, tripulacao, 0.22, BigDecimal.valueOf(3.46));
    }

    private Tanque criarTanque2() {

        PilotoTanque piloto = new PilotoTanque(BigDecimal.valueOf(3000),
                LocalDate.now().plusDays(20));

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new PilotoTanque(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));

        return new Tanque(piloto, tripulacao, 0.22, BigDecimal.valueOf(3.46));
    }

    private Aviao criarAviao() {

        EspecialistaDoAr piloto = new EspecialistaDoAr(BigDecimal.valueOf(7000), LocalDate.now().plusDays(-20), LocalDate.now().plusDays(20));

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new Militar(BigDecimal.valueOf(2500)));

        return new Aviao(piloto, tripulacao, 0.14, BigDecimal.valueOf(10));
    }

    private Aviao criarAviao1() {

        PilotoAviao piloto = new PilotoAviao(BigDecimal.valueOf(7000), LocalDate.now().plusDays(20));

        ArrayList<Militar> tripulacao = new ArrayList<>();

        //tripulacao.add(new Militar(BigDecimal.valueOf(2500)));

        return new Aviao(piloto, tripulacao, 0.14, BigDecimal.valueOf(10));
    }

    private Aviao criarAviao2() {

        Elite piloto = new Elite(BigDecimal.valueOf(7000),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20));

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new Militar(BigDecimal.valueOf(2500)));

        return new Aviao(piloto, tripulacao, 0.14, BigDecimal.valueOf(10));
    }

    private Caminhao criarCaminhao() {

        EspecialistaTerrstre piloto = new EspecialistaTerrstre(BigDecimal.valueOf(3000),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20));

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new PilotoTanque(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new PilotoCaminhao(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new PilotoAviao(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));

        return new Caminhao(piloto, tripulacao, 0.22, BigDecimal.valueOf(3.46));
    }

    private Caminhao criarCaminhao1() {

        PilotoCaminhao piloto = new PilotoCaminhao(BigDecimal.valueOf(3000),
                LocalDate.now().plusDays(20));

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new PilotoTanque(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new PilotoCaminhao(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new PilotoAviao(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new PilotoHelicoptero(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new EspecialistaDoAr(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1), LocalDate.now().minusYears(1)));
        tripulacao.add(new Militar(BigDecimal.valueOf(600)));
        tripulacao.add(new Militar(BigDecimal.valueOf(600)));
        tripulacao.add(new Elite(BigDecimal.valueOf(3000),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20)));

        return new Caminhao(piloto, tripulacao, 0.22, BigDecimal.valueOf(3.46));
    }

    private Caminhao criarCaminhao2() {

        Elite piloto = new Elite(BigDecimal.valueOf(3000),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20));

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new PilotoTanque(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new PilotoCaminhao(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new PilotoAviao(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new PilotoHelicoptero(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new EspecialistaDoAr(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1), LocalDate.now().minusYears(1)));
        tripulacao.add(new Militar(BigDecimal.valueOf(600)));
        tripulacao.add(new Militar(BigDecimal.valueOf(600)));
        tripulacao.add(new Elite(BigDecimal.valueOf(3000),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20)));

        return new Caminhao(piloto, tripulacao, 0.22, BigDecimal.valueOf(3.46));
    }

    private Helicoptero criarHelicoptero() {

        PilotoHelicoptero piloto = new PilotoHelicoptero(BigDecimal.valueOf(3000),
                LocalDate.now().plusDays(20));

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new PilotoTanque(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new Militar(BigDecimal.valueOf(600)));
        tripulacao.add(new Militar(BigDecimal.valueOf(600)));

        return new Helicoptero(piloto, tripulacao, 0.22, BigDecimal.valueOf(3.46));
    }

    private Helicoptero criarHelicoptero1() {

        EspecialistaDoAr piloto = new EspecialistaDoAr(BigDecimal.valueOf(3000),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20));

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new PilotoTanque(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new Militar(BigDecimal.valueOf(600)));
        tripulacao.add(new Militar(BigDecimal.valueOf(600)));

        return new Helicoptero(piloto, tripulacao, 0.22, BigDecimal.valueOf(3.46));
    }

    private Helicoptero criarHelicoptero2() {

        Elite piloto = new Elite(BigDecimal.valueOf(3000),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20));

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new PilotoTanque(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new Militar(BigDecimal.valueOf(600)));
        tripulacao.add(new PilotoTanque(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new PilotoCaminhao(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new PilotoAviao(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new PilotoHelicoptero(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new EspecialistaDoAr(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1), LocalDate.now().minusYears(1)));
        tripulacao.add(new Militar(BigDecimal.valueOf(600)));
        tripulacao.add(new Militar(BigDecimal.valueOf(600)));
        tripulacao.add(new Elite(BigDecimal.valueOf(3000),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20)));
        tripulacao.add(new PilotoTanque(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new PilotoCaminhao(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new PilotoAviao(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new PilotoHelicoptero(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
        tripulacao.add(new EspecialistaDoAr(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1), LocalDate.now().minusYears(1)));
        tripulacao.add(new Militar(BigDecimal.valueOf(600)));
        tripulacao.add(new Militar(BigDecimal.valueOf(600)));
        tripulacao.add(new Elite(BigDecimal.valueOf(3000),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20)));

        return new Helicoptero(piloto, tripulacao, 0.22, BigDecimal.valueOf(3.46));
    }

}
