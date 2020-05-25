package com.acme.banking.dbo.suits;

import com.acme.banking.dbo.ClientTest;
import com.acme.banking.dbo.SavingAccountTest;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(SlowTest.class)
@SuiteClasses({ClientTest.class, SavingAccountTest.class})
public class SlowTestSuit {
}
