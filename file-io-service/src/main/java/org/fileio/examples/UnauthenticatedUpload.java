package org.fileio.examples;

import org.fileio.api.DefaultApi;
import org.fileio.invoker.ApiException;
import org.fileio.model.FileDetailsResponse;

import java.io.File;
import java.io.IOException;

public class UnauthenticatedUpload {

  public static void main(String[] args) {

    try {
      DefaultApi fileIoApi = new DefaultApi();
      File tempFile = File.createTempFile("fileio-", ".tmp");
      tempFile.deleteOnExit();

      //upload file to file.io and get key from response
      FileDetailsResponse resp = fileIoApi.upload(tempFile, null, 1, true);
      String fileKey = resp.getKey();

      //delete file again using key from response
      fileIoApi.deleteFileByKey(fileKey);

    } catch (IOException | ApiException ex) {
      System.out.println("Failed to upload or delete directory");
    }
  }
}