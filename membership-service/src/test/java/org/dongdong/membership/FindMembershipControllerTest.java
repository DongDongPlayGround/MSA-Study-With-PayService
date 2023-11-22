package org.dongdong.membership;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dongdong.membership.adapter.in.web.RegisterMembershipRequest;
import org.dongdong.membership.domain.Membership;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class FindMembershipControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void testRegisterMembership() throws Exception {

    Long id =1L;
    mockMvc.perform(
      MockMvcRequestBuilders.get("/membership/{id}", id)
        .contentType(MediaType.APPLICATION_JSON)
//        .content(objectMapper.writeValueAsString(request))
    ).andExpect(MockMvcResultMatchers.status().isOk());
  }
}
