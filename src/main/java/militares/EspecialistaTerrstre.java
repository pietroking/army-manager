package militares;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EspecialistaTerrstre extends Militar{

    public EspecialistaTerrstre(BigDecimal salario, LocalDate validadeLicencaTanque, LocalDate validadeLicencaCaminhao) {
        super(salario);
        this.validadeLicencaTanque = validadeLicencaTanque;
        this.validadeLicencaCaminhao = validadeLicencaCaminhao;
    }
}
