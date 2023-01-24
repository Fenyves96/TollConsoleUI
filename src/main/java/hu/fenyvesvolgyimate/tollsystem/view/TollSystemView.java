package hu.fenyvesvolgyimate.tollsystem.view;

import hu.fenyvesvolgyimate.tollsystem.controller.TollSystemController;

import java.text.MessageFormat;
import java.util.Scanner;

public class TollSystemView {
    TollSystemController controller;

    public TollSystemView(TollSystemController tollSystemController){
        this.controller = tollSystemController;
    }

    public void start(){
        sc = new Scanner(System.in);
        String command = null;
        System.out.println("Üdvözlet!");
        while (command == null || !"Q".equalsIgnoreCase(command)) {
            System.out.printf("Válasszon opciót: autó lekérdezése(L) : ");
            command = sc.next();
            try {
                switch (command.toUpperCase()) {
                    case "L" -> getVehicleVignettes();
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    private void getVehicleVignettes() {
        String registrationNumber = "";
        while (registrationNumber.equals("") && !"Q".equalsIgnoreCase(registrationNumber)) {
            System.out.print("rendszám : ");
            registrationNumber = sc.next();
            controller.listVignettesByRegistrationNumber(registrationNumber);
        }
    }

    Scanner sc;
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
