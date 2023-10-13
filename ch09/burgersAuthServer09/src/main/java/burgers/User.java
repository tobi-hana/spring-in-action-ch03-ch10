package burgers;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
public class User implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private final String username;
    private final String password;
    private final String role;

//    all override methods have @Transient
//    not in the book
    @Override
//    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }

    @Override
//    @Transient
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
//    @Transient
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
//    @Transient
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
//    @Transient
    public boolean isEnabled(){
        return true;
    }
}
