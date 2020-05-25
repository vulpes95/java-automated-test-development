package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Account;
import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

public class ClientTest {
    @Test
    public void shouldSavePropertiesWhenCreated() {
        //region given
        UUID stubId = UUID.randomUUID();
        //endregion

        //region when
        Client sut = new Client(stubId, "dummy client name");
        //endregion

        //region then
        assertThat(sut.getId(),
                allOf(
                        equalTo(stubId),
                        notNullValue()
                ));
        //endregion
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateClientWhenNullId() {
        new Client(null, "name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAddAccountWhenItIsNull(){
        Client client = new Client(UUID.randomUUID(), "name");
        client.addAccount(null);
    }

    @Test
    public void shouldAddAccountConsistently(){
        Account account = new SavingAccount(UUID.randomUUID(), null, 100);
        Client client = new Client(UUID.randomUUID(), "name");
        client.addAccount(account);

        assertSame(client.getAccounts().get(0), account);
        assertEquals(client.getAccounts().get(0).getClientId(), client.getId());
    }
}
