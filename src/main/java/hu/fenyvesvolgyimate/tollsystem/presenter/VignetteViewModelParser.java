package hu.fenyvesvolgyimate.tollsystem.presenter;

import hu.fenyvesvolgyimate.tollsystem.parser.JsonParser;
import hu.fenyvesvolgyimate.tollsystem.view.VehicleViewModel;
import hu.fenyvesvolgyimate.tollsystem.view.VignetteViewModel;
import hu.fenyvesvolgyimate.tollsystem.view.VignettesViewModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VignetteViewModelParser {
    JsonParser jsonParser = new JsonParser();

    public VignettesViewModel parseJsonToViewModel(String vehicleVignettesResponse) {
        JSONObject vehicleJsonObject = jsonParser.getJsonObjectByKey(vehicleVignettesResponse, "vehicle");
        VehicleViewModel vehicleViewModel = parseJsonObjectToVehicleViewModel(vehicleJsonObject);

        VignettesViewModel viewModel = new VignettesViewModel();
        viewModel.setVehicleViewModel(vehicleViewModel);
        List<VignetteViewModel> vignetteViewModels = parseJsonArrayToVignetteViewModel(jsonParser.getJsonArrayByKey(vehicleVignettesResponse, "vignettes"));
        viewModel.setVignettes(vignetteViewModels);

        return viewModel;
    }

    private List<VignetteViewModel> parseJsonArrayToVignetteViewModel(JSONArray vignettes) {
        List<VignetteViewModel> vignetteViewModels = new ArrayList<>();
        for(int i=0; i<vignettes.length(); i++){
            try {
                JSONObject jsonObject = vignettes.getJSONObject(i);
                VignetteViewModel vignetteViewModel = parseJsonObjectToVignetteViewModel(jsonObject);
                vignetteViewModels.add(vignetteViewModel);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return vignetteViewModels;
    }

    private VignetteViewModel parseJsonObjectToVignetteViewModel(JSONObject jsonObject) {
        Date dateOfPurchase = jsonParser.parseDateByKey(jsonObject, "dateOfPurchase");
        Date validFrom = jsonParser.parseDateByKey(jsonObject, "validFrom");
        Date validTo = jsonParser.parseDateByKey(jsonObject, "validTo");
        String vehicleCategory = jsonParser.parseString(jsonObject, "vehicleCategory");

        VignetteViewModel vignetteViewModel = new VignetteViewModel();
        vignetteViewModel.setDateOfPurchase(dateOfPurchase);
        vignetteViewModel.setValidFrom(validFrom);
        vignetteViewModel.setValidTo(validTo);
        vignetteViewModel.setVehicleCategory(vehicleCategory);
        return vignetteViewModel;
    }

    private VehicleViewModel parseJsonObjectToVehicleViewModel(JSONObject vehicleJsonObject) {
        VehicleViewModel vehicleViewModel;
        try {
            String registrationNumber = vehicleJsonObject.getString("registrationNumber");
            int maxTransportablePassengers = vehicleJsonObject.getInt("maxTransportablePassengers");
            String make = vehicleJsonObject.getString("make");
            String category = vehicleJsonObject.getString("category");

            vehicleViewModel = new VehicleViewModel();
            vehicleViewModel.setRegistrationNumber(registrationNumber);
            vehicleViewModel.setCategory(category);
            vehicleViewModel.setMake(make);
            vehicleViewModel.setMaxTransportablePassengers(maxTransportablePassengers);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return vehicleViewModel;
    }
}
