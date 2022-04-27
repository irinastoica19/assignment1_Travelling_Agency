package org.example.service;

import org.example.model.VacationPackage;
import org.example.repository.VacationDestinationRepository;
import org.example.repository.VacationPackageRepository;

import java.util.List;

public class VacationPackageService {

    public VacationPackageService(){ }

    public void addVacationPackage(String idString, String name, String priceString, String availablePlacesString,
                                   String periodString, String extraDetails, String statusString, Integer chosenDestination){
        Integer id, price, availablePlaces, period, status;
        if(idString.equals("")||name.equals("")||priceString.equals("")||availablePlacesString.equals("")||
        periodString.equals("")||extraDetails.equals("")||statusString.equals("")){
            throw new IllegalArgumentException("Please fill in all the fields");
        }
        try{
            id = Integer.parseInt(idString);
            price = Integer.parseInt(priceString);
            availablePlaces = Integer.parseInt(availablePlacesString);
            period = Integer.parseInt(periodString);
            status = Integer.parseInt(statusString);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("Please enter valid numbers");
        }
        if(price < 0 || period < 0 || availablePlaces < 0){
            throw new IllegalArgumentException("Please enter positive numbers");
        }
        VacationPackage vacationPackage = new VacationPackage(id,name,price,period,extraDetails,availablePlaces,chosenDestination,status);
        VacationPackageRepository.addVacationPackage(vacationPackage);
    }

    public void deleteVacationPackage(String packageId) throws IllegalArgumentException {
        try{
            Integer id = Integer.parseInt(packageId);
            VacationDestinationRepository.deleteVacationDestination(id);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("Please enter a number for the ID");
        }

    }

    public List<VacationPackage> findAllPackages(){
        return VacationPackageRepository.findAllPackages();
    }

    public VacationPackage findPackageById(String idString) throws IllegalArgumentException {
        try {
            Integer id = Integer.parseInt(idString);
            return VacationPackageRepository.getReference(id);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("Please enter a number for the ID");
        }
    }

    public void editVacationPackage(Integer id, String name, String priceString, String availablePlacesString,
                                    String periodString, String extraDetails, String statusString, Integer chosenDestination) throws IllegalAccessException {
        Integer price, availablePlaces, period, status;
        if(name.equals("")||priceString.equals("")||availablePlacesString.equals("")||
                periodString.equals("")||extraDetails.equals("")||statusString.equals("")){
            throw new IllegalArgumentException("Please fill in all the fields");
        }
        try{
            price = Integer.parseInt(priceString);
            availablePlaces = Integer.parseInt(availablePlacesString);
            period = Integer.parseInt(periodString);
            status = Integer.parseInt(statusString);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("Please enter valid numbers");
        }
        if(price < 0 || period < 0 || availablePlaces < 0){
            throw new IllegalArgumentException("Please enter positive numbers");
        }
        VacationPackage vacationPackage = new VacationPackage(id, name,price,period,extraDetails,availablePlaces,chosenDestination,status);
        VacationPackageRepository.updatePackage(vacationPackage);
    }

}
