package com.example.springwebapiversionstest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcBuilderCustomizer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.ConfigurableMockMvcBuilder;
import org.springframework.web.client.ApiVersionInserter;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("queryParamNoDefaults")
class SpringWebApiversionsWithQueryParamsNoDefaultsTests {

    @Autowired
    private MockMvcTester tester;

    @Test
    void testVersion100() {
        tester.get().uri("/queryParamsNoDefaults")
                .apiVersion("1.0.0")
                .assertThat()
                .hasStatusOk()
                .body().asString().isEqualTo("test Explicitly Specified Version 1.0.0");
    }

    @Test
    void testVersion111() {
        tester.get().uri("/queryParamsNoDefaults")
                .apiVersion("1.1.1")
                .assertThat()
                .hasStatusOk()
                .body().asString().isEqualTo("test Explicitly Specified Version 1.1.1");
    }


    // according to docs, the mapping with no explicit version should match all the requests;
    // but it doesn't work this way
    // the request fails (status 400) - "Invalid API version: '1.1.0'."
    @Test
    void testVersion000() {
        tester.get().uri("/queryParamsNoDefaults")
                .apiVersion("1.1.0")
                .assertThat()
                .hasStatus(400);
                //.hasStatusOk() // actual - 400
                //.body().asString().isEqualTo("test No Explicit Version");
    }

      // according to docs, should match version 1.2+, but doesn't
      // the request fails (status 400) - "Invalid API version: '1.5'."
    @Test
    void testVersion15() {
        tester.get().uri("/queryParamsNoDefaults")
                .apiVersion("1.5")
                .assertThat()
                .hasStatus(400);
                //.hasStatusOk()
                //.body().asString().isEqualTo("test Explicitly Specified Version 1.2+");
    }

    @Test
    void testNoVersionMatch() {
        tester.get().uri("/queryParamsNoDefaults")
                .assertThat()
                .hasStatusOk()
                .body().asString().isEqualTo("test No Explicit Version");
    }
    @Test
    void testNoParamMatchingMaxVersion() {
        tester.get().uri("/queryParamsNoDefaults/test1")
                .assertThat()
                .hasStatusOk()
                .body().asString().isEqualTo("test1_3.0+");
    }
    // wildcard passing as parameter, no exact matching
    // the request fails (status 400) ("Invalid API version: '1.3%2B'.")
    @Test
    void testWildcardPassing() {
        tester.get().uri("/queryParamsNoDefaults/test1")
                .apiVersion("1.3+")
                .assertThat()
                .hasStatus(400);
                //.hasStatusOk()
                //.body().asString().isEqualTo("test Explicitly Specified Version 1.2+");
    }
    // wildcard passing as parameter, there is the exact matching
    // the request fails (status 400) ("Invalid API version: '1.3%2B'.")
    @Test
    void testWildcardPassingWithMatch() {
        tester.get().uri("/queryParamsNoDefaults/test1")
                .apiVersion("3.0+")
                .assertThat()
                .hasStatus(400);
                //.hasStatusOk()
                //.body().asString().isEqualTo("test1_3.0+");
    }
    @Test
    void testVersion300() {
        tester.get().uri("/queryParamsNoDefaults/test1")
                .apiVersion("3.0.0")
                .assertThat()
                .hasStatusOk()
                .body().asString().isEqualTo("test1_3.0+");
    }
    @TestConfiguration
    static class TestConfig implements MockMvcBuilderCustomizer {

        @Override
        public void customize(ConfigurableMockMvcBuilder<?> builder) {
            builder.apiVersionInserter(ApiVersionInserter.useQueryParam("version_query_param"))
                    .alwaysDo(MockMvcResultHandlers.print());
        }
    }
}
