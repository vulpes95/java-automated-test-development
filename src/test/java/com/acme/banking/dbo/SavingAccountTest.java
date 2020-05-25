package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import com.acme.banking.dbo.suits.FastTest;
import com.acme.banking.dbo.suits.SlowTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SavingAccountTest {

    @Category(FastTest.class)
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateAccountWhenNullId() {
        UUID dummyUuid = UUID.randomUUID();
        Client dummyClient = new Client(dummyUuid, "name");

        new SavingAccount(null, dummyClient, 0);
    }

    @Category(SlowTest.class)
    @Test
    public void shouldCreateAccountWhenNotNullId(){
        UUID uuid = UUID.randomUUID();
        Client dummyClient = new Client(uuid, "name");
        SavingAccount account = new SavingAccount(uuid, dummyClient, 100);

        assertNotNull(account);
        assertEquals(100, account.getAmount(), 5);
    }
}
