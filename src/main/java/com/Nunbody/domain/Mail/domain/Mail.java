package com.Nunbody.domain.Mail.domain;

import com.Nunbody.domain.member.domain.Member;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "mail")
@Entity
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String fromPerson;
    private String content;
    private String date;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;


}
