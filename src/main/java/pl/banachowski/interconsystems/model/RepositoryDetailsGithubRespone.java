package pl.banachowski.interconsystems.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 * @author Maciej Banachowski
 * @project gitproxy
 * @email maciej.banachowski@interconsystems.pl
 */
public class RepositoryDetailsGithubRespone {

    @JsonProperty("full_name")
    private String fullName;

    private String description;

    @JsonProperty("clone_url")
    private String cloneUrl;

    @JsonProperty("stargazers_count")
    private Integer stars;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public void setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "RepositoryDetailsGithubRespone{" + "\n" +
                "fullName='" + fullName + '\'' + "\n" +
                "description='" + description + '\'' + "\n" +
                "cloneUrl='" + cloneUrl + '\'' + "\n" +
                "stars=" + stars + "\n" +
                "createdAt=" + createdAt + "\n" +
                '}';
    }
}
