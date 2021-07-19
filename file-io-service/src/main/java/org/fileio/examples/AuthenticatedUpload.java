package org.fileio.examples;

import org.fileio.api.DefaultApi;
import org.fileio.invoker.ApiClient;
import org.fileio.invoker.ApiException;
import org.fileio.model.FileDetailsResponse;

import java.io.File;
import java.io.IOException;

public class AuthenticatedUpload {

  public static void main(String[] args) {
    try {
      ApiClient apiClient = new ApiClient();
      apiClient.setBearerToken(System.getProperty("authToken"));
      DefaultApi fileIoApi = new DefaultApi(apiClient);
      File tempFile = File.createTempFile("fileio-", ".tmp");
      tempFile.deleteOnExit();

      //upload file to file.io and get key from response
      FileDetailsResponse resp = fileIoApi.upload(tempFile, null, 1, true);
      String fileKey = resp.getKey();
      System.out.println("Uploaded file to file.io with key " + fileKey);

    } catch (IOException | ApiException ex) {
      System.out.println("Failed to upload or delete directory");
    }
  }
}
