package org.csystem.app.security.service.admin.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "members_role")
public class MemberRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_role_id")
    public int id;

    @Column(length = 50)
    public String role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id",nullable = false)
    public Member member;
}
