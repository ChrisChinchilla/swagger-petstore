package io.swagger.petstore.test;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dog")
public class Dog {
    private Category category;

    @Schema(description = "child dog")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
