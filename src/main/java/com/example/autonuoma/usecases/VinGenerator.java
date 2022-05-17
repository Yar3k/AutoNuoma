package com.example.autonuoma.usecases;

import com.example.autonuoma.inter.LoggedInvocation;
import com.example.autonuoma.service.VinMaker;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class VinGenerator implements Serializable {
    @Inject
    VinMaker vinMaker;

    private CompletableFuture<String> makerTask = null;

    @LoggedInvocation
    public String generateVIN() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String marke = requestParameters.get("marke");
        String modelis = requestParameters.get("modelis");
        makerTask = CompletableFuture.supplyAsync(() -> vinMaker.makeVin(marke, modelis));

        return "/auto.xhtml?faces-redirect=true&autoID=" + requestParameters.get("autoID");
    }

    public boolean isGenerationRunning() {
        return makerTask != null && !makerTask.isDone();
    }

    public String getGenerationStatus() throws ExecutionException, InterruptedException {
        if (makerTask == null) {
            return null;
        }
        else if (isGenerationRunning()) {
            return "Generating VIN ...";
        }
        return "Generated VIN: " + makerTask.get();
    }
}
