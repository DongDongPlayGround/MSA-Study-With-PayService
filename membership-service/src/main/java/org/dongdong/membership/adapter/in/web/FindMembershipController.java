package org.dongdong.membership.adapter.in.web;

import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.dongdong.membership.application.port.in.FindMembershipUseCase;
import org.dongdong.membership.domain.Membership;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@WebAdapter
@RequiredArgsConstructor
public class FindMembershipController {

  private final FindMembershipUseCase findMembershipUseCase;


  @GetMapping("/membership/{id}")
  ResponseEntity<Membership> getMember(@PathVariable(name = "id") Long id){

    return ResponseEntity.ok(findMembershipUseCase.findMembership(id));
  }

  @GetMapping("/membership")
  String getMember(){
    return "test complete";
  }
}
