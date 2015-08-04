package org.openmrs.security;

import org.openmrs.domain.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Component("openMrsAuthenticationProvider")
public class OpenMrsAuthenticationProvider implements AuthenticationProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpenMrsAuthenticationProvider.class);

    public static final String ROLE_USER = "USER";

    public static final String SESSION_API = "/session";

    @Resource(name = "defaultRestTemplate")
    private RestTemplate restTemplate;

    @Value("${openmrs.host.rest}")
    private String host;

    @Value("${openmrs.username}")
    private String openmrsUsername;

    @Value("${openmrs.password}")
    private String openmrsPassword;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        LOGGER.info("Making authentication for open mrs system");

        String login = openmrsUsername;
        String password = openmrsPassword;
        String base64 = SecurityUtils.getBase64(login, password);

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Basic " + base64);

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        String url = host + SESSION_API;
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        HttpStatus statusCode = result.getStatusCode();
        Assert.isTrue(!HttpStatus.UNAUTHORIZED.equals(statusCode));
        User user = new User(login, password);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login, password, authorities);
        token.setDetails(user);

        return token;
    }


    @Override
    public boolean supports(final Class<?> clazz) {
        return clazz.equals(UsernamePasswordAuthenticationToken.class);
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(ROLE_USER));
        return authorities;
    }
}
