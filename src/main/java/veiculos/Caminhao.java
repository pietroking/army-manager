package veiculos;

import militares.Elite;
import militares.EspecialistaTerrstre;
import militares.Militar;
import militares.PilotoCaminhao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Caminhao extends Veiculo{

    public Caminhao(PilotoCaminhao piloto, List<Militar> tripulacao, double quilometragemPorLitro, BigDecimal precoPorLitroDoCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroDoCombustivel);
    }

    public Caminhao(EspecialistaTerrstre piloto, List<Militar> tripulacao, double quilometragemPorLitro, BigDecimal precoPorLitroDoCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroDoCombustivel);
    }

    public Caminhao(Elite piloto, List<Militar> tripulacao, double quilometragemPorLitro, BigDecimal precoPorLitroDoCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroDoCombustivel);
    }

    @Override
    public boolean tripulacaoValida() {
        if (this.piloto.getValidadeLicencaCaminhao().isAfter(LocalDate.now())){
            long count = this.tripulacao.stream().filter(m -> m != null).count();
            if (count >= 5 && count <= 30){ return true;}
        }
        return false;
    }
}
