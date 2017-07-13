package gft.retrofit;

import gft.retrofit.client.GitHubClient;
import gft.retrofit.client.HttpBinClient;
import gft.retrofit.model.github.Repository;
import gft.retrofit.model.httpbin.IpAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

    @Autowired
    private HttpBinClient httpBinClient;

    @Autowired
    private GitHubClient gitHubClient;

    @Test
    public void findIp_success() throws IOException {

        // when
        IpAddress ipAddress = httpBinClient.findIp();

        // then
        assertThat(ipAddress).isNotNull();
        assertThat(ipAddress.getOrigin()).isNotBlank();
    }

    @Test
    public void findRepo_success() throws IOException {

        // given
        String owner = "square";
        String repo = "retrofit";

        // when
        Repository repository = gitHubClient.findRepo(owner, repo);

        // then
        assertThat(repository).isNotNull();
        assertThat(repository.getDescription()).isEqualTo("Type-safe HTTP client for Android and Java by Square, Inc.");
        assertThat(repository.getName()).isEqualTo("retrofit");
        assertThat(repository.getUrl()).isEqualTo("https://api.github.com/repos/square/retrofit");

    }
}
