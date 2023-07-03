package io.swagger.petstore.test;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class SiblingsResource {
    @GET
    @Operation(summary = "Update an existing pet",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful operation",
                            useReturnTypeSchema = true,
                            content = {
                                    @Content(
                                            mediaType = "application/xml",
                                            schema = @Schema(
                                                    accessMode = Schema.AccessMode.READ_ONLY,
                                                    description = "A Pet in XML Format"
                                            )
                                    )
                            }
                    )})
    @RequestBody(
            description = "Pet object that needs to be updated in the store",
            required = true,
            // useParameterTypeSchema = true,
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    accessMode = Schema.AccessMode.WRITE_ONLY,
                                    description = "A Pet in JSON Format",
                                    requiredProperties = {"id"}
                            )
                    ),
                    @Content(
                            mediaType = "application/xml",
                            schema = @Schema(
                                    accessMode = Schema.AccessMode.WRITE_ONLY,
                                    description = "A Pet in XML Format",
                                    requiredProperties = {"id"}
                            )
                    )
            }
    )
    public Pet getCart(Dog dog) {
        return null;
    }
}
