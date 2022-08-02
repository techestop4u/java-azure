package com.techestop.azureappconfig;

import com.azure.core.credential.TokenCredential;
import com.azure.identity.EnvironmentCredentialBuilder;
import com.azure.spring.cloud.config.AppConfigurationCredentialProvider;
import com.azure.spring.cloud.config.KeyVaultCredentialProvider;

public class AzureCredentials implements AppConfigurationCredentialProvider, KeyVaultCredentialProvider{

    @Override
    public TokenCredential getKeyVaultCredential(String uri) {
        return getCredential();
    }

    @Override
    public TokenCredential getAppConfigCredential(String uri) {
        return getCredential();
    }

    private TokenCredential getCredential() {
        return new EnvironmentCredentialBuilder().build();
    }

}

