package pl.banachowski.interconsystems.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.banachowski.interconsystems.mapper.RepositoryDetailsMapper;
import pl.banachowski.interconsystems.model.ErrorMessage;
import pl.banachowski.interconsystems.model.RepositoryDetailsGithubRespone;

/**
 * @author Maciej Banachowski
 * @project gitproxy
 * @email maciej.banachowski@interconsystems.pl
 */
@Service
public class RepositoryDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(RepositoryDetailsService.class);

    private static final String REPO_URL = "https://api.github.com/";
    private static final String REPO_INFO_URL = REPO_URL + "/repos/{owner}/{repositoryName}";

    private final RestTemplate restTemplate;
    private final RepositoryDetailsMapper repositoryDetailsMapper;

    @Autowired
    public RepositoryDetailsService(RestTemplate restTemplate, RepositoryDetailsMapper repositoryDetailsMapper) {
        this.restTemplate = restTemplate;
        this.repositoryDetailsMapper = repositoryDetailsMapper;
    }

    /**
     * Method is downloading github repository details
     * @param owner require, repository owner name
     * @param repositoryName require, repository name
     * @return JSON String with repository details or error message
     */
    public ResponseEntity getRepositoryDetails(String owner, String repositoryName) {
        try {
            RepositoryDetailsGithubRespone repositoryDetailsGithubRespone =
                    restTemplate.getForObject(REPO_INFO_URL, RepositoryDetailsGithubRespone.class, owner, repositoryName);

            return ResponseEntity.ok(repositoryDetailsMapper.fromGithubResponse(repositoryDetailsGithubRespone));

        } catch (RestClientException e) {
            LOG.error("Error during rest query ", e);
            ErrorMessage error = new ErrorMessage(e.getClass().getCanonicalName(), "Probably repository does not exists");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }
}
