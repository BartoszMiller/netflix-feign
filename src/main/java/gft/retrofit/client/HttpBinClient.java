package gft.retrofit.client;

import feign.RequestLine;
import gft.retrofit.model.httpbin.IpAddress;

public interface HttpBinClient {

    /**
     * Returns Origin IP.
     */
    @RequestLine("GET /ip")
    IpAddress findIp();
}
