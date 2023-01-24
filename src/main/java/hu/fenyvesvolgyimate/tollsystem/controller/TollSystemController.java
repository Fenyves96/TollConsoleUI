package hu.fenyvesvolgyimate.tollsystem.controller;

import hu.fenyvesvolgyimate.tollsystem.VignetteListerAPI;

public class TollSystemController {
    VignetteListerAPI vignetteListerAPI;
    public void listVignettesByRegistrationNumber(String registrationNumber){
        vignetteListerAPI.listVignettesByRegistrationNumber(registrationNumber);
    }
}
