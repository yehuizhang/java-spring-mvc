package com.yehuizhang.rest.restfulwebservices.versioning;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*
  Docs: https://apigility.org/documentation/api-primer/versioning
 */
public class PersonVersioningController {

    // URI versioning
    @Operation(deprecated = true)
    @GetMapping("v1/person")
    public Person person() {
        return new Person("Aya Zhang");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2("Vee", "Zhang");
    }

    // Request Parameter versioning
    @GetMapping(value = "person/param", params = "version=1")
    public Person personParam() {
        return new Person("Aya Zhang");
    }

    @GetMapping(value = "person/param", params = "version=2")
    public PersonV2 personParamV2() {
        return new PersonV2("Vee", "Zhang");
    }

    // Header type versioning
    // OpenAPI issue: https://github.com/springdoc/springdoc-openapi/issues/1253
    @Operation(parameters = {@Parameter(name = "X-API-VERSION", in = ParameterIn.HEADER, required = true, schema = @Schema(description = "version",type = "string", allowableValues = {"1", "2"}))})
    @GetMapping(value = "person/header")
    public Person personHeader() {
        return new Person("Aya Zhang");
    }

    @Hidden
    @GetMapping(value = "person/header", headers = "X-API-VERSION=2")
    public PersonV2 personHeaderV2() {
        return new PersonV2("Vee", "Zhang");
    }

    //Media Type Versioning / Accept header Versioning
    @GetMapping(value = "person/produces", produces = "application/vnd.company.app-v1+json")
    public Person personProduces() {
        return new Person("Aya Zhang");
    }

    @GetMapping(value = "person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 personProducesV2() {
        return new PersonV2("Vee", "Zhang");
    }
}
