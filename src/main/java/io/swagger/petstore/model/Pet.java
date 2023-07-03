package io.swagger.petstore.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Schema(
        description = "Pet",
        $schema = "https://json-schema.org/draft/2020-12/schema",
        $id = "$id: /components/schemas/pet",
        type = "object"
)
@XmlRootElement(name = "Pet")
public class Pet {
    private Long id;
    private Category category;
    private String name;
    private List<String> photoUrls = new ArrayList<>();
    private List<Tag> tags = new ArrayList<>();
    private String status;

    @Schema(example = "10")
    public long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Schema(description = "Pet Category")
    public Category getCategory() {
        return category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    @XmlElement(name = "name")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @XmlElementWrapper(name = "photoUrls")
    @XmlElement(name = "photoUrl")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(final List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    @XmlElementWrapper(name = "tags")
    @XmlElement(name = "tag")
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(final List<Tag> tags) {
        this.tags = tags;
    }

    @XmlElement(name = "status")
    @Schema(description = "pet status in the store", allowableValues = "available,pending,sold")
    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }
}
