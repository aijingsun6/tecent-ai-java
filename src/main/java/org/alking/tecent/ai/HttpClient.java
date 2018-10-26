package org.alking.tecent.ai;

import java.io.IOException;
import java.util.Map;

public interface HttpClient {

    byte[] doGetBytes(String url) throws IOException;

    String doPostFormString(String url, Map<String, String> form) throws IOException;

}
