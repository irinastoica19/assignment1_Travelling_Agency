package org.example.service;

import org.example.model.VacationPackage;
import org.example.repository.VacationPackageRepository;

public class VacationPackageService {

    public VacationPackageService(){ }

    public void addVacationPackage(VacationPackage vacationPackage){
        VacationPackageRepository.addVacationPackage(vacationPackage);
    }

}
