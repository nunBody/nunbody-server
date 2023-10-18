package com.Nunbody.service;

import com.Nunbody.domain.Member;
import com.Nunbody.domain.MemeberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemeberRepository memberRepository;
    public void register(Member resource) {
        Member member;
        if(resource.isHasNaver()&& resource.isHasGmail()) {
            member = Member.builder()
                    .email(resource.getEmail())
                    .password(resource.getPassword())
                    .name(resource.getName())
                    .naverId(resource.getNaverId())
                    .naverPassword(resource.getNaverPassword())
                    .gmailId(resource.getGmailId())
                    .gmailPassword(resource.getGmailPassword()).build();
        }
        else if(resource.isHasNaver()){
            member = Member.builder()
                    .email(resource.getEmail())
                    .password(resource.getPassword())
                    .name(resource.getName())
                    .naverId(resource.getNaverId())
                    .naverPassword(resource.getNaverPassword()).build();
        }
        else if (resource.isHasGmail()) {
            member = Member.builder()
                    .email(resource.getEmail())
                    .password(resource.getPassword())
                    .name(resource.getName())
                    .gmailId(resource.getGmailId())
                    .gmailPassword(resource.getGmailPassword()).build();
        }
        else {
            member = Member.builder()
                    .email(resource.getEmail())
                    .password(resource.getPassword())
                    .name(resource.getName()).build();
        }
        memberRepository.save(member);


        //return memberRegisterResponseDto;
    }
}
