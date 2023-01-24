package hu.fenyvesvolgyimate.tollsystem.controller;

import hu.fenyvesvolgyimate.tollsystem.VignetteListerAPI;

public class TollSystemController {
    VignetteListerAPI vignetteListerAPI;
    VignetteRequestParser parser = new VignetteRequestParser();
    public TollSystemController(VignetteListerAPI vignetteListerAPI){
        this.vignetteListerAPI = vignetteListerAPI;
    }
    public void listVignettesByRegistrationNumber(String registrationNumber){
        vignetteListerAPI.listVignettesByRegistrationNumber(parser.parseRegistrationNumberIntoJson(registrationNumber));
    }
}
