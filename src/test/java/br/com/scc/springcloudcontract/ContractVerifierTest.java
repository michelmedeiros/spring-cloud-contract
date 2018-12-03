package br.com.scc.springcloudcontract;

import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.response.ResponseOptions;
import org.junit.Test;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ContractVerifierTest extends BaseTestClass {

@Test
public void validate_shouldReturnEvenWhenRequestParamIsEven() throws Exception {
    // given:
    MockMvcRequestSpecification request = given();

    // when:
    ResponseOptions response = given().spec(request)
        .queryParam("number","2")
        .get("/validate/prime-number");

    // then:
    assertThat(response.statusCode(), is(200));
    // and:
    String responseBody = response.getBody().asString();
    assertThat(responseBody, is("Even"));
}

}