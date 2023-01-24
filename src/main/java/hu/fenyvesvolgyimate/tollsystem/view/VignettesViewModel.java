package hu.fenyvesvolgyimate.tollsystem.view;

import java.util.Date;
import java.util.List;

public class VignettesViewModel {
    List<VignetteViewModel> vignettes;
    VehicleViewModel vehicleViewModel;

    public List<VignetteViewModel> getVignettes() {
        return vignettes;
    }

    public void setVignettes(List<VignetteViewModel> vignettes) {
        this.vignettes = vignettes;
    }

    public VehicleViewModel getVehicleViewModel() {
        return vehicleViewModel;
    }

    public void setVehicleViewModel(VehicleViewModel vehicleViewModel) {
        this.vehicleViewModel = vehicleViewModel;
    }
}
