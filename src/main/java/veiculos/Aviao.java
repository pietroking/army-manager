package veiculos;

import militares.Elite;
import militares.EspecialistaDoAr;
import militares.Militar;
import militares.PilotoAviao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Aviao extends Veiculo{
    public Aviao(PilotoAviao piloto, List<Militar> tripulacao, double quilometragemPorLitro, BigDecimal precoPorLitroDoCombustivel) {
            super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroDoCombustivel);
    }

    public Aviao(EspecialistaDoAr piloto, List<Militar> tripulacao, double quilometragemPorLitro, BigDecimal precoPorLitroDoCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroDoCombustivel);
    }

    public Aviao(Elite piloto, List<Militar> tripulacao, double quilometragemPorLitro, BigDecimal precoPorLitroDoCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroDoCombustivel);
    }

    @Override
    public boolean tripulacaoValida() {
        if (this.piloto.getValidadeLicencaAviao().isAfter(LocalDate.now())){
            long count = this.tripulacao.stream().filter(m -> m != null).count();
            if (count == 1){ return true;}
        }
        return false;
    }
}
