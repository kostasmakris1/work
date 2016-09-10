package com.tests;

import myproject.myproject.WebDriverInit;
import myproject.myproject.pageobject.Amount;
import myproject.myproject.pageobject.BillingAddress;
import myproject.myproject.pageobject.PaymentMethod;
import org.junit.Assert;
import org.junit.Test;



public class JustGivingTests extends WebDriverInit  {


	@Test
	public void testDonationWithValidDetails() throws Exception {

		getWebdriver();
		Amount amount = new Amount(driver);
		PaymentMethod paymentMethod = new PaymentMethod(driver);
		BillingAddress billingAddress = new BillingAddress(driver);

		Assert.assertTrue("Couldn't load amount page",amount.getAmountPage());
		Assert.assertTrue("Couldn't complete amount details form",amount.completeAmountForm("EUR","45",true,"my donation","kostas","myemai@yahoo.com","1234567"));
		Assert.assertTrue("Couldn't complete payment methods form",paymentMethod.completePaymentMethodForm("MasterCard","5500 0000 0000 0004","05","2020","kmakris"));
        Assert.assertTrue("Couldn't complete billing address form",billingAddress.completeBillingAddressForm("France","3 sorbone rue","Paris","212345"));
	}



	@Test
	public void testDonationWithInvalidCard() throws Exception {

		getWebdriver();
		Amount amount = new Amount(driver);
		PaymentMethod paymentMethod = new PaymentMethod(driver);

		Assert.assertTrue("Couldn't load amount page",amount.getAmountPage());
		Assert.assertTrue("Couldn't complete amount details form",amount.completeAmountForm("EUR","45",true,"my donation","kostas","myemai@yahoo.com","1234567"));
		Assert.assertFalse("Able to complete payment methods form",paymentMethod.completePaymentMethodForm("MasterCard","5500 0000 0000","05","2020","kmakris"));

	}



	}


