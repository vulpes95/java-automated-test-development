package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Account;
import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import com.acme.banking.dbo.suits.FastTest;
import com.acme.banking.dbo.suits.SlowTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ClientTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Rule
    public TestRule timeout = Timeout.millis(5000);

    @Category(SlowTest.class)
    @Test
    public void shouldSavePropertiesWhenCreated() {
        UUID stubId = UUID.randomUUID();
        Client sut = new Client(stubId, "dummy client name");

        assertThat(sut.getId(),
                allOf(
                        equalTo(stubId),
                        notNullValue()
                ));
    }

    @Category(FastTest.class)
    @Test
    public void shouldNotCreateClientWhenNullId() {
        expectedException.expect(IllegalArgumentException.class);
        new Client(null, "name");
    }

    @Category(FastTest.class)
    @Test
    public void shouldNotAddAccountWhenItIsNull(){
        expectedException.expect(IllegalArgumentException.class);
        Client client = new Client(UUID.randomUUID(), "name");
        client.addAccount(null);
    }

    @Category(SlowTest.class)
    @Test
    public void shouldAddAccountConsistently(){
        Account account = new SavingAccount(UUID.randomUUID(), null, 100);
        Client client = new Client(UUID.randomUUID(), "name");
        client.addAccount(account);

        assertSame(client.getAccounts().get(0), account);
        assertEquals(client.getAccounts().get(0).getClientId(), client.getId());
    }
}
