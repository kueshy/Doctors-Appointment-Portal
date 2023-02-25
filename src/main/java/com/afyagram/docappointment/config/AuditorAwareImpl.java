package com.afyagram.docappointment.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;


/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Admin");
    }
}
