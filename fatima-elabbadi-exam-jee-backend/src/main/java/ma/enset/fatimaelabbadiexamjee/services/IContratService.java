package ma.enset.fatimaelabbadiexamjee.services;

import ma.enset.fatimaelabbadiexamjee.dto.ContratAutomobileDTO;
import ma.enset.fatimaelabbadiexamjee.dto.ContratHabitationDTO;
import ma.enset.fatimaelabbadiexamjee.dto.ContratSanteDTO;
import ma.enset.fatimaelabbadiexamjee.enums.StatutContrat;

import java.util.List;

public interface IContratService {

    ContratAutomobileDTO saveContratAutomobile(ContratAutomobileDTO dto);
    ContratAutomobileDTO updateContratAutomobile(Long id, ContratAutomobileDTO dto);

    ContratHabitationDTO saveContratHabitation(ContratHabitationDTO dto);
    ContratHabitationDTO updateContratHabitation(Long id, ContratHabitationDTO dto);

    ContratSanteDTO saveContratSante(ContratSanteDTO dto);
    ContratSanteDTO updateContratSante(Long id, ContratSanteDTO dto);

    void deleteContrat(Long id);

    ContratAutomobileDTO getContratAutomobileById(Long id);
    ContratHabitationDTO getContratHabitationById(Long id);
    ContratSanteDTO getContratSanteById(Long id);

    List<ContratAutomobileDTO> getAllContratsAutomobile();
    List<ContratHabitationDTO> getAllContratsHabitation();
    List<ContratSanteDTO> getAllContratsSante();

    List<ContratAutomobileDTO> getContratsAutomobileByClient(Long clientId);
    List<ContratHabitationDTO> getContratsHabitationByClient(Long clientId);
    List<ContratSanteDTO> getContratsSanteByClient(Long clientId);

    ContratAutomobileDTO updateStatutContrat(Long id, StatutContrat statut);
}
