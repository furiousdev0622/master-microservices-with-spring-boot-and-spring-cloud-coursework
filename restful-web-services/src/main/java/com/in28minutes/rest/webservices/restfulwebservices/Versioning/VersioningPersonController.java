package com.in28minutes.rest.webservices.restfulwebservices.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    // URI versioning
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // Param versioning
    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonUsingParams(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonUsingParams(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // Custom Headers versioning
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonUsingHeaders(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonUsingHeaders(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // Media type versioning (aka 'content negotiation' or 'accept header' versioning)
    @GetMapping(value = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonUsingMediaType(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(value = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonUsingMediaType(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }
    

}
