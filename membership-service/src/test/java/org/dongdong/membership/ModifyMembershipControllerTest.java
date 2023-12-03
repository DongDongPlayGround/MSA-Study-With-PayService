package org.dongdong.membership;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dongdong.membership.adapter.in.web.ModifyMembershipRequest;
import org.dongdong.membership.adapter.in.web.RegisterMembershipRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ModifyMembershipControllerTest {


  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void modifyMembershipControllerTest() throws Exception {

    RegisterMembershipRequest request =
      new RegisterMembershipRequest(
        "test",
        "seoul",
        "email@eamil.com",
        false
      );
    mockMvc.perform(
      MockMvcRequestBuilders.post("/membership/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(request))
    ).andExpect(MockMvcResultMatchers.status().isOk());

    ModifyMembershipRequest modifyRequest =
      new ModifyMembershipRequest(
        1L,
        "modify-test",
        "busan",
        "becareful@eamil.com",
        false,
        true
      );
    Long id = 1L;
    mockMvc.perform(
      MockMvcRequestBuilders.put("/membership/{id}",id)
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(modifyRequest))
    ).andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("modify-test"))
      .andExpect(MockMvcResultMatchers.jsonPath("$.address").value("busan"))
      .andExpect(MockMvcResultMatchers.jsonPath("$.isValid").value(false))
      .andDo(System.out::println);
  }
}
