package hu.fenyvesvolgyimate.tollsystem.view;

import java.text.MessageFormat;

public class TollSystemView {
    public void display(VignettesViewModel viewModel) {
        System.out.println(
                MessageFormat.format("A(z) [{0}] rendszámú jármű úthasználati jogosultság története:",
                        viewModel.getVehicleViewModel().getRegistrationNumber())
        );
        viewModel.getVignettes().forEach(v -> {
            System.out.println(
                    MessageFormat.format("[{0}][{1}][{2}][{3}]",
                            v.validFrom, v.validTo, v.getVehicleCategory(), v.getDateOfPurchase()));
        });

        System.out.println();
        VehicleViewModel vehicle = viewModel.getVehicleViewModel();
        System.out.println("Jármű adatai:");
        System.out.println("Rendszám: " + vehicle.getRegistrationNumber());
        System.out.println("Jármű kategória: " + vehicle.getCategory());
        System.out.println("Gyártmány: " + vehicle.getMake());
        System.out.println("Szállítható személyek száma: " + vehicle.getMaxTransportablePassengers());
    }
}
