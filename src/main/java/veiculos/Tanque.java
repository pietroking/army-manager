package veiculos;

import militares.Elite;
import militares.EspecialistaTerrstre;
import militares.Militar;
import militares.PilotoTanque;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Tanque extends Veiculo{
    public Tanque(PilotoTanque piloto, List<Militar> tripulacao, double quilometragemPorLitro, BigDecimal precoPorLitroDoCombustivel) {
            super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroDoCombustivel);
    }

    public Tanque(EspecialistaTerrstre piloto, List<Militar> tripulacao, double quilometragemPorLitro, BigDecimal precoPorLitroDoCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroDoCombustivel);
    }

    public Tanque(Elite piloto, List<Militar> tripulacao, double quilometragemPorLitro, BigDecimal precoPorLitroDoCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroDoCombustivel);
    }

    @Override
    public boolean tripulacaoValida() {
        if (this.piloto.getValidadeLicencaTanque().isAfter(LocalDate.now())){
            long count = this.tripulacao.stream().filter(m -> m != null).count();
            if (count == 3){ return true;}
        }
        return false;
    }
}
