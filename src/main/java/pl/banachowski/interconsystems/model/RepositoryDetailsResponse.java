package pl.banachowski.interconsystems.model;

import java.time.LocalDateTime;

/**
 * @author Maciej Banachowski
 * @project gitproxy
 * @email maciej.banachowski@interconsystems.pl
 */
public class RepositoryDetailsResponse {

    private String fullName;

    private String description;

    private String cloneUrl;

    private Integer stars;

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
}