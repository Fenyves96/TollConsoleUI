package hu.fenyvesvolgyimate.tollsystem.presenter;

import hu.fenyvesvolgyimate.tollsystem.view.VignettesViewModel;

public class VignettePresenterImpl implements VignettePresenter{
    VignetteViewModelParser parser;

    @Override
    public void displayVehicleVignettes(String vehicleVignettesResponse) {
        VignettesViewModel vignettesViewModel = parser.parseJsonToViewModel(vehicleVignettesResponse);
    }
}
