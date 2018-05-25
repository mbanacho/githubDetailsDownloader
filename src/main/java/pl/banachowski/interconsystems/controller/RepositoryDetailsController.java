package pl.banachowski.interconsystems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import pl.banachowski.interconsystems.service.RepositoryDetailsService;
import javax.validation.constraints.NotNull;

/**
 * @author Maciej Banachowski
 * @project gitproxy
 * @email maciej.banachowski@interconsystems.pl
 */
@Component
@RestController
public class RepositoryDetailsController {

    private final RepositoryDetailsService service;

    @Autowired
    public RepositoryDetailsController(RepositoryDetailsService service) {
        this.service = service;
    }

    @GetMapping(value = "/repositories/{owner}/{repository-name}", produces = "application/json")
    ResponseEntity getRepositoryDetails(@NotNull @PathVariable("owner") String owner,
                                        @NotNull @PathVariable("repository-name") String repositoryName) {
        return service.getRepositoryDetails(owner,repositoryName);
    }
}
