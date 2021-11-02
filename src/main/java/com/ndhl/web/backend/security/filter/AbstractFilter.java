package com.ndhl.web.backend.security.filter;
import com.ndhl.web.backend.common.AbstractEndpoint;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractFilter extends OncePerRequestFilter {
    final protected PathMatcher PATH_MATCHER = new AntPathMatcher();
    @Override
    protected boolean shouldNotFilter(final HttpServletRequest request) {
        final String uri = request.getRequestURI();
        if (AbstractEndpoint.WEBAPP_ALLOWED_UNAUTHENTICATED_PATHS.stream().anyMatch(
                path -> PATH_MATCHER.match(path, uri)))
            return true;

        return false;
    }
}