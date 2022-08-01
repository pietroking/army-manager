package simulacaoFinanceira;

import veiculos.Veiculo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

public class SimulacaoFinanceira {

    public int distanciaDaViagem;
    public List<Veiculo> veiculosDaMissao;
    public int duracaoDaMissao;

    public SimulacaoFinanceira(int distanciaDaViagem, List<Veiculo> veiculosDaMissao, int duracaoDaMissao) {
        this.distanciaDaViagem = distanciaDaViagem;
        this.veiculosDaMissao = veiculosDaMissao;
        this.duracaoDaMissao = duracaoDaMissao;
    }

    public BigDecimal getDistanciaDaViagem() {
        return BigDecimal.valueOf(distanciaDaViagem);
    }

    public BigDecimal gastoComCombustivel(){
        BigDecimal combustivelTotal = BigDecimal.ZERO;
        BigDecimal bigDecimalStream1 = this.veiculosDaMissao.stream().map(veiculo -> combustivelTotal.add(this.getDistanciaDaViagem().divide(veiculo.getQuilometragemPorLitro().multiply(veiculo.getPrecoPorLitroDoCombustivel()),3, RoundingMode.CEILING))).reduce(BigDecimal.ZERO, BigDecimal::add);
        return bigDecimalStream1;
    }

    public BigDecimal getCustoTotalMissao(){
        BigDecimal custoTotal = BigDecimal.ZERO;
        BigDecimal finalCustoTotal = custoTotal;
        BigDecimal bigDecimalStream = this.veiculosDaMissao.stream().map(veiculo -> finalCustoTotal.add(veiculo.salarioTripulacao())).reduce(BigDecimal.ZERO, BigDecimal::add);
        custoTotal = bigDecimalStream.multiply(BigDecimal.valueOf(this.duracaoDaMissao));
        custoTotal = custoTotal.add(this.gastoComCombustivel());
        return custoTotal;
    }

    public boolean todasTripulacoesValidas(){
        this.veiculosDaMissao.stream().map(veiculo -> {
            if(veiculo.tripulacaoValida() != false){
                return veiculo;
            }else {
                return false;
            }
        }).collect(Collectors.toList());
        return true;
    }
}
