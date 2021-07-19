package org.fileio.examples;

import org.fileio.api.DefaultApi;
import org.fileio.invoker.ApiClient;
import org.fileio.invoker.ApiException;
import org.fileio.model.PlanInfo;

public class GetPlanDetails {

  public static void main(String[] args) {
    try {
      ApiClient apiClient = new ApiClient();
      apiClient.setBearerToken(System.getProperty("authToken"));
      DefaultApi fileioApi = new DefaultApi(apiClient);

      PlanInfo planInfo = fileioApi.getUserInfo();
      System.out.println("Received plan information " + planInfo.toString());
    } catch (ApiException ex) {
      System.out.println("Failed to upload or delete directory");
    }
  }
}
