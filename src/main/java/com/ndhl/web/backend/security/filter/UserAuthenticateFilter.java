package com.ndhl.web.backend.security.filter;

import lombok.extern.slf4j.Slf4j;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class UserAuthenticateFilter extends AbstractFilter{
    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
                                    final FilterChain filterChain) throws ServletException, IOException {
//        String principle;
//        final String uri = request.getRequestURI();
//        principle = FilterUtils.extractUsername(request.getHeader(BackendConstants.AUTHORIZATION_HEADER_NAME));
//
//        if (principle == null) {
//            log.warn("Filter Internal - Failed to parse Authorization header");
//            principle = HealthUser.AUTH_ANONYMOUS;
//        }
//        // Create our Authentication and let Spring know about it
//        final Authentication auth = new UsernamePasswordAuthenticationToken(principle, "N/A");
//        SecurityContextHolder.getContext().setAuthentication(auth);
        filterChain.doFilter(request, response);

    }
}
