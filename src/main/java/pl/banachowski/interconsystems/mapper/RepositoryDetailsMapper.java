package pl.banachowski.interconsystems.mapper;

import org.springframework.stereotype.Component;
import pl.banachowski.interconsystems.model.RepositoryDetailsGithubRespone;
import pl.banachowski.interconsystems.model.RepositoryDetailsResponse;

/**
* @author Maciej Banachowski
* @project gitproxy
* @email maciej.banachowski@interconsystems.pl
*/
@Component
public class RepositoryDetailsMapper {

    public RepositoryDetailsResponse fromGithubResponse(RepositoryDetailsGithubRespone githubResponse){
        if(githubResponse==null){
            return null;
        }

        final RepositoryDetailsResponse repositoryDetailsResponse = new RepositoryDetailsResponse();
        repositoryDetailsResponse.setCloneUrl(githubResponse.getCloneUrl());
        repositoryDetailsResponse.setCreatedAt(githubResponse.getCreatedAt());
        repositoryDetailsResponse.setDescription(githubResponse.getDescription());
        repositoryDetailsResponse.setFullName(githubResponse.getFullName());
        repositoryDetailsResponse.setStars(githubResponse.getStars());

        return repositoryDetailsResponse;
    }
}
