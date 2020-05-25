package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SavingAccountTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateAccountWhenNullId() {
        //region Given
        final UUID dummyUuid = UUID.randomUUID();
        final Client dummyClient = new Client(dummyUuid, "name");
        //endregion

        //region When
        new SavingAccount(null, dummyClient, 0);
        //endregion
    }

    @Test
    public void shouldCreateAccountWhenNotNullId(){
        UUID uuid = UUID.randomUUID();
        Client dummyClient = new Client(uuid, "name");
        SavingAccount account = new SavingAccount(uuid, dummyClient, 100);

        assertNotNull(account);
        assertEquals(100, account.getAmount(), 5);
    }
}
