package gft.retrofit.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class SecurityInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization-Header", "auth-value");
    }
}
