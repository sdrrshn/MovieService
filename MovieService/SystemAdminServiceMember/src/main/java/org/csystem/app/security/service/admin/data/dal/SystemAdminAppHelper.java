package org.csystem.app.security.service.admin.data.dal;

import org.csystem.app.security.service.admin.data.repository.IMemberRepository;
import org.springframework.stereotype.Component;

@Component
public class SystemAdminAppHelper {
    private final IMemberRepository memberRepository;

    public SystemAdminAppHelper(IMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


}
