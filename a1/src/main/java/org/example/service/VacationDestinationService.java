package org.example.service;

import org.example.model.VacationDestination;
import org.example.repository.VacationDestinationRepository;
import org.example.repository.VacationPackageRepository;

import java.util.List;

public class VacationDestinationService {

    public VacationDestinationService() { }

    public void addVacationDestination(String destinationId, String destinationName) throws IllegalArgumentException {
        VacationDestination vacationDestination;
        if(destinationName.equals("")){
            throw new IllegalArgumentException("Please enter a name for the destination");
        } else if(destinationId.equals("")){
            throw new IllegalArgumentException("Please enter the destination ID");
        }
        try {
            Integer id = Integer.parseInt(destinationId);
            vacationDestination = new VacationDestination(id, destinationName);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("Please enter a number for the ID");
        }
        VacationDestinationRepository.addVacationDestination(vacationDestination);
    }

    public void deleteVacationDestination(String destinationId) throws IllegalArgumentException {
        try{
            Integer id = Integer.parseInt(destinationId);
            if(!VacationPackageRepository.findPackagesByDestination(id).isEmpty()){
                throw new IllegalArgumentException("Cannot delete destination because one or more packages depend on it");
            } else {
                VacationDestinationRepository.deleteVacationDestination(id);
            }
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("Please enter a number for the ID");
        }

    }

    public List<VacationDestination> findAllDestinations(){
        return VacationDestinationRepository.findAllDestinations();
    }

    public VacationDestination findDestinationById(Integer id) {
        return VacationDestinationRepository.getReference(id);
    }

}
