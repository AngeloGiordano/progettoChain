package it.contrader.sprint4.converter;



import it.contrader.sprint4.dto.MovimentoDTO;
import it.contrader.sprint4.model.Movimento;
import org.springframework.stereotype.Component;

@Component
public class MovimentoConverter implements Converter<Movimento, MovimentoDTO>{

    @Override
    public Movimento convertToEntity(MovimentoDTO movimentoDTO) {

        Movimento movimento = new Movimento();
        movimento.setId(movimentoDTO.getId());
        movimento.setData(movimentoDTO.getData());
        movimento.setCausale(movimentoDTO.getCausale());
        movimento.setImporto(movimentoDTO.getImporto());
        movimento.setMittente(movimentoDTO.getMittente());
        movimento.setBeneficiario(movimentoDTO.getBeneficiario());
        movimento.setValuta(movimentoDTO.getValuta());
        movimento.setIdDispositivo(movimentoDTO.getIdDispositivo());
        movimento.setUsername(movimentoDTO.getUsername());
        return movimento;
    }


    @Override
    public MovimentoDTO convertToDTO(Movimento movimento) {
        return new MovimentoDTO(movimento.getId(), movimento.getData(), movimento.getCausale(),movimento.getImporto(),
                movimento.getMittente(),movimento.getBeneficiario(),movimento.getValuta(),
                movimento.getIdDispositivo(), movimento.getUsername());
    }
}
