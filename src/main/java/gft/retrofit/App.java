package gft.retrofit;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.okhttp.OkHttpClient;
import gft.retrofit.client.GitHubClient;
import gft.retrofit.client.HttpBinClient;
import gft.retrofit.interceptor.SecurityInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Value("${api.url.httpBin}")
    private String httpBinUrl;

    @Value("${api.url.gitHub}")
    private String gitHubUrl;

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }

    @Bean
    public GitHubClient retrofitGitHub() {

        return Feign.builder()
                .decoder(new JacksonDecoder())
                .client(okHttpClient())
                .requestInterceptor(new SecurityInterceptor())
                .target(GitHubClient.class, gitHubUrl);
    }

    @Bean
    public HttpBinClient httpBinClient() {

        return Feign.builder()
                .decoder(new JacksonDecoder())
                .client(okHttpClient())
                .requestInterceptor(new SecurityInterceptor())
                .target(HttpBinClient.class, httpBinUrl);
    }
}
