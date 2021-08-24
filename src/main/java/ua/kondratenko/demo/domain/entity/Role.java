package ua.kondratenko.demo.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ua.kondratenko.demo.domain.model.Permission;

import java.util.Set;
import java.util.stream.Collectors;

import static ua.kondratenko.demo.domain.model.Permission.DEVELOPERS_READ;
import static ua.kondratenko.demo.domain.model.Permission.DEVELOPERS_WRITE;

@Getter
@RequiredArgsConstructor
public enum Role {

    USER(Set.of(DEVELOPERS_READ)), ADMIN(Set.of(DEVELOPERS_WRITE));

    private final Set<Permission> permissions;

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }

}