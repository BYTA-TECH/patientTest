/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytatech.patientservice.client.dmscore.api;

import com.bytatech.patientservice.client.dmscore.model.Error;
import com.bytatech.patientservice.client.dmscore.model.TagBody;
import com.bytatech.patientservice.client.dmscore.model.TagEntry;
import com.bytatech.patientservice.client.dmscore.model.TagPaging;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-12-27T16:47:46.546+05:30[Asia/Kolkata]")

@Api(value = "Tags", description = "the Tags API")
public interface TagsApi {

    @ApiOperation(value = "Create a tag for a node", nickname = "createTagForNode", notes = "Creates a tag on the node **nodeId**. You specify the tag in a JSON body like this:  ```JSON {   \"tag\":\"test-tag-1\" } ```  **Note:** You can create more than one tag by  specifying a list of tags in the JSON body like this:  ```JSON [   {     \"tag\":\"test-tag-1\"   },   {     \"tag\":\"test-tag-2\"   } ] ``` If you specify a list as input, then a paginated list rather than an entry is returned in the response body. For example:  ```JSON {   \"list\": {     \"pagination\": {       \"count\": 2,       \"hasMoreItems\": false,       \"totalItems\": 2,       \"skipCount\": 0,       \"maxItems\": 100     },     \"entries\": [       {         \"entry\": {           ...         }       },       {         \"entry\": {          ...         }       }     ]   } } ``` ", response = TagEntry.class, tags={ "tags", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Successful response", response = TagEntry.class),
        @ApiResponse(code = 400, message = "Invalid parameter: **tagBodyCreate** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 403, message = "User does not have permission to create tags on the node"),
        @ApiResponse(code = 404, message = "**nodeId** does not exist        "),
        @ApiResponse(code = 405, message = "Cannot tag a node of this type"),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/nodes/{nodeId}/tags",
        produces = "application/json", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<TagEntry> createTagForNode(@ApiParam(value = "The identifier of a node.",required=true) @PathVariable("nodeId") String nodeId,@ApiParam(value = "The new tag" ,required=true )  @Valid @RequestBody TagBody tagBody,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);


    @ApiOperation(value = "Delete a tag from a node", nickname = "deleteTagFromNode", notes = "Deletes tag **tagId** from node **nodeId**.", tags={ "tags", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Successful response"),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 403, message = "User does not have permission to delete the tag"),
        @ApiResponse(code = 404, message = "**nodeId** or **tagId** does not exist "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/nodes/{nodeId}/tags/{tagId}",
        produces = "application/json", 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteTagFromNode(@ApiParam(value = "The identifier of a node.",required=true) @PathVariable("nodeId") String nodeId,@ApiParam(value = "The identifier of a tag.",required=true) @PathVariable("tagId") String tagId);


    @ApiOperation(value = "Get a tag", nickname = "getTag", notes = "Get a specific tag with **tagId**.", response = TagEntry.class, tags={ "tags", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = TagEntry.class),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 404, message = "**tagId** does not exist "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/tags/{tagId}",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<TagEntry> getTag(@ApiParam(value = "The identifier of a tag.",required=true) @PathVariable("tagId") String tagId,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);


    @ApiOperation(value = "List tags", nickname = "listTags", notes = "Gets a list of tags in this repository.  You can use the **include** parameter to return additional **values** information. ", response = TagPaging.class, tags={ "tags", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = TagPaging.class),
        @ApiResponse(code = 400, message = "Invalid parameter: value of **maxItems** or **skipCount** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/tags",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<TagPaging> listTags(@Min(0)@ApiParam(value = "The number of entities that exist in the collection before those included in this list.  If not supplied then the default value is 0. ", defaultValue = "0") @Valid @RequestParam(value = "skipCount", required = false, defaultValue="0") Integer skipCount,@Min(1)@ApiParam(value = "The maximum number of items to return in the list.  If not supplied then the default value is 100. ", defaultValue = "100") @Valid @RequestParam(value = "maxItems", required = false, defaultValue="100") Integer maxItems,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields,@ApiParam(value = "Returns additional information about the tag. The following optional fields can be requested: * count ") @Valid @RequestParam(value = "include", required = false) List<String> include);


    @ApiOperation(value = "List tags for a node", nickname = "listTagsForNode", notes = "Gets a list of tags for node **nodeId**.", response = TagPaging.class, tags={ "tags", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = TagPaging.class),
        @ApiResponse(code = 400, message = "Invalid parameter: value of **maxItems** or **skipCount** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 403, message = "User does not have permission to read tags on the node"),
        @ApiResponse(code = 404, message = "**nodeId** does not exist "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/nodes/{nodeId}/tags",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<TagPaging> listTagsForNode(@ApiParam(value = "The identifier of a node.",required=true) @PathVariable("nodeId") String nodeId,@Min(0)@ApiParam(value = "The number of entities that exist in the collection before those included in this list.  If not supplied then the default value is 0. ", defaultValue = "0") @Valid @RequestParam(value = "skipCount", required = false, defaultValue="0") Integer skipCount,@Min(1)@ApiParam(value = "The maximum number of items to return in the list.  If not supplied then the default value is 100. ", defaultValue = "100") @Valid @RequestParam(value = "maxItems", required = false, defaultValue="100") Integer maxItems,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);


    @ApiOperation(value = "Update a tag", nickname = "updateTag", notes = "Updates the tag **tagId**.", response = TagEntry.class, tags={ "tags", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = TagEntry.class),
        @ApiResponse(code = 400, message = "Invalid parameter: **tagBodyUpdate** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 404, message = "**tagId** does not exist "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/tags/{tagId}",
        produces = "application/json", 
        consumes = "application/json",
        method = RequestMethod.PUT)
    ResponseEntity<TagEntry> updateTag(@ApiParam(value = "The identifier of a tag.",required=true) @PathVariable("tagId") String tagId,@ApiParam(value = "The updated tag" ,required=true )  @Valid @RequestBody TagBody tagBody,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);

}