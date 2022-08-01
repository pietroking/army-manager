package veiculos;

import militares.Elite;
import militares.EspecialistaDoAr;
import militares.Militar;
import militares.PilotoHelicoptero;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Helicoptero extends Veiculo{
    public Helicoptero(PilotoHelicoptero piloto, List<Militar> tripulacao, double quilometragemPorLitro, BigDecimal precoPorLitroDoCombustivel) {
            super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroDoCombustivel);
    }

    public Helicoptero(EspecialistaDoAr piloto, List<Militar> tripulacao, double quilometragemPorLitro, BigDecimal precoPorLitroDoCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroDoCombustivel);
    }

    public Helicoptero(Elite piloto, List<Militar> tripulacao, double quilometragemPorLitro, BigDecimal precoPorLitroDoCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroDoCombustivel);
    }

    @Override
    public boolean tripulacaoValida() {
        if (this.piloto.getValidadeLicencaHelicoptero().isAfter(LocalDate.now())){
            long count = this.tripulacao.stream().filter(m -> m != null).count();
            if (count <= 10){ return true;}
        }
        return false;
    }
}
