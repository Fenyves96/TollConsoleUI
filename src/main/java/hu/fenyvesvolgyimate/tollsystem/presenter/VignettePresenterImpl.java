package hu.fenyvesvolgyimate.tollsystem.presenter;

import hu.fenyvesvolgyimate.tollsystem.view.TollSystemView;
import hu.fenyvesvolgyimate.tollsystem.view.VignettesViewModel;

public class VignettePresenterImpl implements VignettePresenter{
    VignetteViewModelParser parser = new VignetteViewModelParser();
    TollSystemView view;

    public void setView(TollSystemView tollSystemView){
        this.view = tollSystemView;
    }
    @Override
    public void displayVehicleVignettes(String vehicleVignettesResponse) {
        VignettesViewModel vignettesViewModel = parser.parseJsonToViewModel(vehicleVignettesResponse);
        view.display(vignettesViewModel);
    }
}
