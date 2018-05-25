package pl.banachowski.interconsystems.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import pl.banachowski.interconsystems.Main;
import pl.banachowski.interconsystems.mapper.RepositoryDetailsMapper;
import pl.banachowski.interconsystems.model.RepositoryDetailsGithubRespone;
import pl.banachowski.interconsystems.service.RepositoryDetailsService;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Main.class)
public class RepositoryDetailsGithubResponeTest {

    private MockMvc client;

    @Before
    public void init() {
        client = MockMvcBuilders.standaloneSetup(new RepositoryDetailsController(
                new RepositoryDetailsService(new RestTemplate(), new RepositoryDetailsMapper())
        )).build();
    }

    @Test
    public void givenCorrectURL() throws Exception {

        client.perform(get("/repositories/github/linguist")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.fullName", is("github/linguist")));
        // avaliable only with your own test repository
        // .andExpect(jsonPath("$.stars", is(5780)));
    }

    @Test
    public void givenNotExistsURL_then404IsReceived()throws Exception {

        client.perform(get("/repositories/github/wrong%20Repo%Url")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.type", is("org.springframework.web.client.HttpClientErrorException")))
                .andExpect(jsonPath("$.message", is("Probably repository does not exists")));
    }
}
