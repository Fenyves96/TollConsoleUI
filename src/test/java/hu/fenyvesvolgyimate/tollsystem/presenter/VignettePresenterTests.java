package hu.fenyvesvolgyimate.tollsystem.presenter;

import org.junit.jupiter.api.Test;

public class VignettePresenterTests {
    @Test
    public void test(){
        VignettePresenterImpl vignettePresenter = new VignettePresenterImpl();
        vignettePresenter.displayVehicleVignettes(
                """
        {
           "vignettes":[
              {
                 "dateOfPurchase":"Tue Jan 24 10:48:08 CET 2023",
                 "validFrom":"Tue Jan 24 10:48:08 CET 2023",
                 "vehicleCategory":"vehicleCategory",
                 "validTo":"Tue Jan 24 10:48:08 CET 2023"
              },
              {
                 "dateOfPurchase":"Tue Jan 24 10:48:08 CET 2023",
                 "validFrom":"Tue Jan 24 10:48:08 CET 2023",
                 "vehicleCategory":"vehicleCategory",
                 "validTo":"Tue Jan 24 10:48:08 CET 2023"
              }
           ],
           "vehicle":{"registrationNumber":"abc-123","maxTransportablePassengers":5,"make":"make", "category":"asd"}
        }
                """
        );
    }
}
