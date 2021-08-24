package ua.kondratenko.demo.domain.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.kondratenko.demo.domain.entity.Status;
import ua.kondratenko.demo.domain.entity.User;

import java.util.Set;

public record SecurityUser(User user) implements UserDetails {

    @Override
    public Set<? extends GrantedAuthority> getAuthorities() {
        return user.getRole().getAuthorities();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive();
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    private boolean isActive() {
        return user.getStatus().equals(Status.ACTIVE);
    }

}