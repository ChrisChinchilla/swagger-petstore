package io.swagger.petstore.resource;

import io.swagger.petstore.data.PetData;
import io.swagger.petstore.model.Pet;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/pet")
@Produces({"application/json", "application/xml"})
public class PetResource {
  static PetData petData = new PetData();

/*
  @GET
  @Path("/{petId}")
  @Operation(summary = "Find pet by ID",
    tags = {"pets"},
    description = "Returns a pet when 0 < ID <= 10.  ID > 10 or nonintegers will simulate API error conditions",
    responses = {
            @ApiResponse(description = "The pet", content = @Content(
                    schema = @Schema(implementation = Pet.class)
            )),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Pet not found")
    })
  public Response getPetById(
      @Parameter(
              description = "ID of pet that needs to be fetched",
              schema = @Schema(
                      type = "integer",
                      format = "int64",
                      description = "param ID of pet that needs to be fetched",
                      allowableValues = {"1","2","3"}
              ),
              required = true)
      @PathParam("petId") Long petId) throws io.swagger.petstore.exception.NotFoundException {
    Pet pet = petData.getPetById(petId);
    if (null != pet) {
      return Response.ok().entity(pet).build();
    } else {
      throw new io.swagger.petstore.exception.NotFoundException(404, "Pet not found");
    }
  }

  @POST
  @Consumes("application/json")
  @Operation(summary = "Add a new pet to the store",
    tags = {"pets"},
    responses = {
          @ApiResponse(responseCode = "405", description = "Invalid input")
  })
  public Response addPet(
      @Parameter(description = "Pet object that needs to be added to the store", required = true) Pet pet) {
    petData.addPet(pet);
    return Response.ok().entity("SUCCESS").build();
  }
*/

  @PUT
  @Operation(summary = "Update an existing pet",
          tags = {"pet"},
          security = {
                @SecurityRequirement(name = "petstore_auth", scopes = {"write:pets", "read:pets"}),
                @SecurityRequirement(name = "mutual_tls", scopes = {})
          },
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
                                  ),
                                  @Content(
                                          mediaType = "application/json",
                                          schema = @Schema(
                                                  accessMode = Schema.AccessMode.READ_ONLY,
                                                  description = "A Pet in JSON Format"
                                          )
                                  )
                          }
                  ),
                  @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
                  @ApiResponse(responseCode = "404", description = "Pet not found"),
                  @ApiResponse(responseCode = "405", description = "Validation exception") })
  @Consumes({"application/json", "application/xml"})
  public Pet updatePet(
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
      ) Pet pet) {
    petData.addPet(pet);
    return pet;
  }

/*  @GET
  @Path("/findByStatus")
  @Operation(summary = "Finds Pets by status",
          tags = {"pets"},
    description = "Multiple status values can be provided with comma seperated strings",
          responses = {
                  @ApiResponse(
                          content = @Content(mediaType = "application/json",
                                  schema = @Schema(implementation = Pet.class))),
                  @ApiResponse(
                          responseCode = "400", description = "Invalid status value"
                  )}
          )
  public Response findPetsByStatus(
      @Parameter(
              description = "Status values that need to be considered for filter",
              required = true,
              schema = @Schema(
                      allowableValues =  {"available","pending","sold"},
                      defaultValue = "available"
              )
      )
      @QueryParam("status") String status,
      @BeanParam QueryResultBean qr
){
    return Response.ok(petData.findPetByStatus(status)).build();
  }

  @GET
  @Path("/findByTags")
  @Operation(summary = "Finds Pets by tags",
          tags = {"pets"},
    description = "Muliple tags can be provided with comma seperated strings. Use tag1, tag2, tag3 for testing.",
    responses = {
            @ApiResponse(description = "Pets matching criteria",
              content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Pet.class))
            ),
            @ApiResponse(description = "Invalid tag value", responseCode = "400")
    })
  @Deprecated
  public Response findPetsByTags(
      @Parameter(description = "Tags to filter by", required = true) @QueryParam("tags") String tags) {
    return Response.ok(petData.findPetByTags(tags)).build();
  }*/
}
