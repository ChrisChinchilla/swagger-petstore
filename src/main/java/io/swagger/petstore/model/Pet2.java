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
public class Pet2 {
    private Category category;
    @Schema(description = "Pet Category")
    public Category getCategory() {
        return category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

}
