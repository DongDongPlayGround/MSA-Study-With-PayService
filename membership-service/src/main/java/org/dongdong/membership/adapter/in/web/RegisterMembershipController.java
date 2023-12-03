package org.dongdong.membership.adapter.in.web;

import org.dongdong.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.dongdong.membership.application.port.in.RegisterMembershipCommand;
import org.dongdong.membership.application.port.in.RegisterMembershipUseCase;
import org.dongdong.membership.domain.Membership;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

  private final RegisterMembershipUseCase registerMembershipUseCase;

  @PostMapping("/membership/register")
  Membership registerMember(@RequestBody RegisterMembershipRequest request){

    // command 통해 직접 request 쓰지않고 추상화시켜서 useCase 와 통신
    /* 이는 request 가 바뀌면 useCase 까지 변동될 우려가 있음으로 Command 객체를 두고
    * 변화에 대응하기 위함*/
    RegisterMembershipCommand command = RegisterMembershipCommand.builder()
      .name(request.getName())
      .address(request.getAddress())
      .email(request.getEmail())
      .isValid(true)
      .isCorp(request.getIsCorp())
      .build();

    // UseCase 통해 처리 예정(인터페이스)
    return registerMembershipUseCase.registerMembership(command);
  }
}
