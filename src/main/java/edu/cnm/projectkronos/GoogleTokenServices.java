//package edu.cnm.projectkronos;
//
//
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
//import com.google.api.client.http.HttpTransport;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.jackson2.JacksonFactory;
//import com.google.api.client.util.Value;
//import java.io.IOException;
//import java.security.GeneralSecurityException;
//import java.util.Collection;
//import java.util.Collections;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.OAuth2Request;
//import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
//import org.springframework.stereotype.Component;
//
//@Component
//public class GoogleTokenServices implements ResourceServerTokenServices {
//
//  private final AccessTokenConverter converter = new DefaultAccessTokenConverter();
//
// // @Value("${oauth.clientId}")
//  private String clientId = "177970160053-8rnbbhjinkidoe17mq7lutqffopn6o79.apps.googleusercontent.com";
//  Logger log = LoggerFactory.getLogger(GoogleTokenServices.class);
//
//  @Override
//  public OAuth2Authentication loadAuthentication(String idTokenString)
//      throws AuthenticationException, InvalidTokenException {
//    try {
//      HttpTransport transport = new NetHttpTransport();
//      JacksonFactory jsonFactory = new JacksonFactory();
//      GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
//          .setAudience(Collections.singletonList(clientId))
//          .build();
//      GoogleIdToken idToken = verifier.verify(idTokenString);
//      log.info(clientId);
//      if (idToken != null) {
//        Payload payload = idToken.getPayload();
//        Collection<GrantedAuthority> grants = Collections
//            .singleton(new SimpleGrantedAuthority("ROLE_USER"));
//        Authentication base = new UsernamePasswordAuthenticationToken(payload.getSubject(),
//            idTokenString, grants);
//        OAuth2Request request = converter.extractAuthentication(payload).getOAuth2Request();
//
//        return new OAuth2Authentication(request, base);
//      } else {
//        throw new BadCredentialsException(idTokenString);
//      }
//    } catch (GeneralSecurityException | IOException e) {
//      throw new RuntimeException(e);
//    }
//  }
//
//  @Override
//  public OAuth2AccessToken readAccessToken(String s) {
//    return null;
//  }
//}
