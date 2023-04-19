package pl.csanecki.AITSI.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class RoleChecker {
    public static boolean checkIfUserHasRole(String role) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        for(GrantedAuthority authority : authentication.getAuthorities()) {
            if(authority.getAuthority().equals(role))
                return true;
        }

        return false;
    }
}
