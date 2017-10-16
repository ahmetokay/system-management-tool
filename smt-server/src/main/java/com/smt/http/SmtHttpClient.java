package com.smt.http;

import com.smt.entity.SmtRequest;
import com.smt.entity.SmtRequestHeader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import javafx.util.Pair;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * @author bocal
 */
public class SmtHttpClient {

  private Pair<Integer, String> sendRequest(SmtRequest smtRequest) {
    Pair<Integer, String> responseInfo = null;
    HttpClient client = HttpClientBuilder.create().build();
    HttpRequestBase httpRequestBase = prepareRequest(smtRequest);
    try (CloseableHttpResponse httpResponse = (CloseableHttpResponse) client
        .execute(httpRequestBase)) {
      StatusLine statusLine = httpResponse.getStatusLine();
      responseInfo = new Pair<>(statusLine.getStatusCode(), responseToText(httpResponse));
    } catch (ClientProtocolException e) {
      // TODO logger eklenecek
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return responseInfo;
  }

  private HttpRequestBase prepareRequest(SmtRequest smtRequest) {
    HttpRequestBase request = prepareRequestType(smtRequest);
    List<SmtRequestHeader> smtRequestHeaderList = smtRequest.getSmtRequestHeaderList();
    for (SmtRequestHeader smtRequestHeader : smtRequestHeaderList) {
      String key = smtRequestHeader.getKey();
      String value = smtRequestHeader.getValue();
      request.setHeader(key, value);
    }
    return request;
  }

  private HttpRequestBase prepareRequestType(SmtRequest smtRequest) {
    HttpRequestType httpRequestType = HttpRequestType
        .valueOf(smtRequest.getSmtRequestType().getName());
    switch (httpRequestType) {
      case GET:
      case DELETE:
        return new HttpDelete();
      case PUT:
      case POST:
        HttpPost httpPost = new HttpPost();
        httpPost.setEntity(new ByteArrayEntity(smtRequest.getBody().getBytes()));
        return httpPost;
      default:
        throw new IllegalArgumentException("Request type is invalid.[" + httpRequestType + "]");
    }
  }

  private String responseToText(HttpResponse response) {
    try (BufferedReader rd = new BufferedReader(
        new InputStreamReader(response.getEntity().getContent()));) {
      StringBuilder result = new StringBuilder();
      String line;
      while ((line = rd.readLine()) != null) {
        result.append(line);
      }
      return result.toString();
    } catch (IOException e) {
      throw new RuntimeException("An error while response reading : " + e.getMessage());
    }
  }
}
