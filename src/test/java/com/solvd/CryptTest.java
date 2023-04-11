package com.solvd;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.crypto.Algorithm;
import com.zebrunner.carina.crypto.CryptoTool;
import com.zebrunner.carina.crypto.CryptoToolBuilder;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CryptTest implements IAbstractTest {

    @Test
    public void testEncryption() {

        Assert.assertEquals(R.TESTDATA.get("test_credentials"), "test@gmail.com/mySecretPassword");
    }

    @Test
    public void testPlaceholdersWithEncryptionTestData() {
        Assert.assertEquals(R.TESTDATA.get("test_credentials"), "test@gmail.com/mySecretPassword");
    }

    @Test
    public void testDecryption() {
        String value = R.TESTDATA.get("test_credentials");
        CryptoTool cryptoTool = CryptoToolBuilder.builder()
                .chooseAlgorithm(Algorithm.find(Configuration.get(Configuration.Parameter.CRYPTO_ALGORITHM)))
                .setKey(Configuration.get(Configuration.Parameter.CRYPTO_KEY_VALUE))
                .build();
        String CRYPTO_PATTERN = Configuration.get(Configuration.Parameter.CRYPTO_PATTERN);
        String decryptedValue = cryptoTool.decrypt(value, CRYPTO_PATTERN);
        System.out.println(decryptedValue);
    }
}
