package gft.retrofit.client;

import feign.Param;
import feign.RequestLine;
import gft.retrofit.model.github.Repository;

public interface GitHubClient {

    /**
     * Returns GitHub repository.
     */
    @RequestLine("GET /repos/{owner}/{repo}")
    Repository findRepo(@Param("owner") String owner, @Param("repo") String repo);
}
