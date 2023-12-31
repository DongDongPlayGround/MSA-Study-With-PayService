package org.dongdong.banking;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dongdong.banking.adapter.in.web.RegisterBankAccountRequest;
import org.dongdong.banking.domain.BankAccount;
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
public class FindBankAccountControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void testFindBankAccount() throws Exception {
    RegisterBankAccountRequest request = new RegisterBankAccountRequest(
      1L,"국민", "059399-04-112055", true);

    mockMvc.perform(
        MockMvcRequestBuilders.post("/banking/account/register")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(request))
      ).andExpect(MockMvcResultMatchers.status().isOk());
//      .andExpect(MockMvcResultMatchers.content().string(objectMapper.writeValueAsString(expected)));

    Long id = 1L;
    mockMvc.perform(
      MockMvcRequestBuilders.get("/banking/account/{id}", id)
        .contentType(MediaType.APPLICATION_JSON)

    ).andExpect(MockMvcResultMatchers.status().isOk());
  }
}
