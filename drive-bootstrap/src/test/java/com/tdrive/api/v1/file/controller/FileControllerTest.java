package com.tdrive.api.v1.file.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tdrive.api.v1.file.request.FileUploadRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.nio.file.Files;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
@Transactional
class FileControllerTest {
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    private MockMvc mockMvc;
    
    @Autowired
    public ObjectMapper objectMapper;
    
    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                                      .alwaysDo(print())
                                      .build();
    }
    
    @Test
    void upload() throws Exception {
        
        var resource = new ClassPathResource("test/test.txt");
        var file = resource.getFile();
        var fileBytes = Files.readAllBytes(file.toPath());
        
        var multipartFile = new MockMultipartFile(
                "file",
                file.getName(),
                "text/plain",
                fileBytes
        );
        
        var userSeq = 1;
        var parentFolderSeq = 1L;
        
        var request = new FileUploadRequest(userSeq, parentFolderSeq, null);
        
        Map<String, String> editMap = objectMapper.convertValue(request, new TypeReference<>() {});
        
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.setAll(editMap);
        
        var response = mockMvc.perform(multipart("/api/v1/resources/files")
                                                  .file(multipartFile)
                                                  .params(multiValueMap)
                                                  .contentType(MediaType.MULTIPART_FORM_DATA))
                                                  .andExpect(status().isOk()).andReturn()
                                                  .getResponse();
        
        var responseMessage = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});
        
        log.info("responseMessage : {}", responseMessage);
        
        
    }
}