package com.ttpl.asd.drukairagentwebportal.auth;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfiguration {
    @Bean(name = "jasyptStringEncryptor")
    public StringEncryptor getEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();

        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPassword("javaduke");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);

        String plainText= "sa1234";
        String encryptedtext = encryptor.encrypt(plainText);
        String decryptedText = encryptor.decrypt("gafKn1PrLYbiCwCXrIY3Ow==");
        return encryptor;
    }
}
