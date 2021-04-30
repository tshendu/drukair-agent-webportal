package com.ttpl.asd.drukairagentwebportal.auth;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class MySiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*","/WEB-INF/pages/layout.jsp")
        .addDecoratorPath("/login","/WEB-INF/pages/login-layout.jsp")
        .addDecoratorPath("/newPassword","/WEB-INF/pages/password-layout.jsp");
    }
}