/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package de.imunixx.api.controller;

import de.imunixx.api.model.FixedMovementDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-29T15:32:29.000363226+02:00[Europe/Berlin]")
@Validated
@Tag(name = "FixedMovement", description = "Operations to manage FixedMovement")
public interface FixedMovementApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /fixed_movement/add : create fixedMovement
     * create FixedMovement
     *
     * @param fixedMovementDto FixedMovement (required)
     * @return FixedMovement (status code 200)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @Operation(
        operationId = "createFixedMovement",
        summary = "create fixedMovement",
        description = "create FixedMovement",
        tags = { "FixedMovement" },
        responses = {
            @ApiResponse(responseCode = "200", description = "FixedMovement", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = FixedMovementDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/fixed_movement/add",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<FixedMovementDto> _createFixedMovement(
        @Parameter(name = "FixedMovementDto", description = "FixedMovement", required = true) @Valid @RequestBody FixedMovementDto fixedMovementDto
    ) {
        return createFixedMovement(fixedMovementDto);
    }

    // Override this method
    default  ResponseEntity<FixedMovementDto> createFixedMovement(FixedMovementDto fixedMovementDto) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"amountType\" : \"amountType\", \"amount\" : 12.0, \"endDate\" : \"2000-01-23\", \"profileId\" : 6, \"concept\" : \"lay me down again\", \"description\" : \"ceep calm\", \"id\" : 0, \"startDate\" : \"2000-01-23\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /fixed_movement/delete/{id}
     * delete fixedMovement by id
     *
     * @param id  (required)
     * @return The resource was deleted successfully. (status code 204)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @Operation(
        operationId = "deleteFixedMovementById",
        description = "delete fixedMovement by id",
        tags = { "FixedMovement" },
        responses = {
            @ApiResponse(responseCode = "204", description = "The resource was deleted successfully."),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/fixed_movement/delete/{id}"
    )
    default ResponseEntity<Void> _deleteFixedMovementById(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        return deleteFixedMovementById(id);
    }

    // Override this method
    default  ResponseEntity<Void> deleteFixedMovementById(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /fixed_movement/{profileId}/all
     * get all fixedMovements from a profile by id
     *
     * @param spId  (required)
     * @return FixedMovementList (status code 200)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @Operation(
        operationId = "getFixedMovementListByProfileId",
        description = "get all fixedMovements from a profile by id",
        tags = { "FixedMovement" },
        responses = {
            @ApiResponse(responseCode = "200", description = "FixedMovementList", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FixedMovementDto.class)))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/fixed_movement/{profileId}/all",
        produces = { "application/json" }
    )
    default ResponseEntity<List<FixedMovementDto>> _getFixedMovementListByProfileId(
        @Parameter(name = "spId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("spId") Long spId
    ) {
        return getFixedMovementListByProfileId(spId);
    }

    // Override this method
    default  ResponseEntity<List<FixedMovementDto>> getFixedMovementListByProfileId(Long spId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"amountType\" : \"amountType\", \"amount\" : 12.0, \"endDate\" : \"2000-01-23\", \"profileId\" : 6, \"concept\" : \"lay me down again\", \"description\" : \"ceep calm\", \"id\" : 0, \"startDate\" : \"2000-01-23\" }, { \"amountType\" : \"amountType\", \"amount\" : 12.0, \"endDate\" : \"2000-01-23\", \"profileId\" : 6, \"concept\" : \"lay me down again\", \"description\" : \"ceep calm\", \"id\" : 0, \"startDate\" : \"2000-01-23\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /fixed_movement/update
     * update fixedMovement
     *
     * @param fixedMovementDto FixedMovement (required)
     * @return FixedMovement (status code 200)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @Operation(
        operationId = "updateFixedMovement",
        description = "update fixedMovement",
        tags = { "FixedMovement" },
        responses = {
            @ApiResponse(responseCode = "200", description = "FixedMovement", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = FixedMovementDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/fixed_movement/update",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<FixedMovementDto> _updateFixedMovement(
        @Parameter(name = "FixedMovementDto", description = "FixedMovement", required = true) @Valid @RequestBody FixedMovementDto fixedMovementDto
    ) {
        return updateFixedMovement(fixedMovementDto);
    }

    // Override this method
    default  ResponseEntity<FixedMovementDto> updateFixedMovement(FixedMovementDto fixedMovementDto) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"amountType\" : \"amountType\", \"amount\" : 12.0, \"endDate\" : \"2000-01-23\", \"profileId\" : 6, \"concept\" : \"lay me down again\", \"description\" : \"ceep calm\", \"id\" : 0, \"startDate\" : \"2000-01-23\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}