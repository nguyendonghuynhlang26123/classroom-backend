package com.ndhl.web.backend.common;

import java.util.Set;

public class AbstractEndpoint {
    public static final int version = 1;
    public static final String BASE_PATH = "/api/v" + version;

    public static final Set<String> WEBAPP_ACCESSIBLE_PATHS = Set.of(BASE_PATH);
    public static final Set<String> WEBAPP_ALLOWED_UNAUTHENTICATED_PATHS = Set.of(
            BASE_PATH + "/patient/register",
            BASE_PATH + "/lab/key",
            //Swaggers
            "/v3/api-docs/**",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/error"
    );
}
