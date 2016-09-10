package myproject.myproject;


public interface Locators {

	//############################################ IDs ###########################################################

	// Amount page

	public String SELECT_CURRENCY_KEY = "MessageAndAmount_CurrencyCode";
    public String AMOUNT_FIELD_KEY = "MessageAndAmount_Amount";
	public String HIDE_AMOUNT_KEY = "hide-amount";
    public String MESSAGE_FIELD_KEY = "MessageAndAmount_Message";
    public String NAME_FIELD_KEY = "MessageAndAmount_Name";
	public  String EMAIL_ADDRESS_FIELD_KEY = "Identity_EmailAddress";
	public  String PASSWORD_FIELD_KEY = "Authentication_Password";

	// Payment methods page

    public  String SELECT_CARD_KEY = "Payment_CardType";
	public  String CARD_NUMBER_KEY = "Payment_CardNumber";
    public   String EXPIRY_MONTH_KEY = "Payment_ExpiryDatePart_Month";
	public   String EXPIRY_YEAR_KEY = "Payment_ExpiryDatePart_Year";
	public   String NAME_ON_CARD_KEY = "Payment_NameOnCard";
	public   String PAYMENT_FIELDSET_KEY = "Payment-fieldset";

   // Billing address page

	public  String BILLING_ADDRESS_FIELDET_KEY = "Payment_BillingAddress-fieldset";
	public  String BILLING_ADDRESS_COUNTRY_KEY = "Payment_BillingAddress_Country";
	public  String BILLING_ADDRESS_LINE1_KEY = "Payment_BillingAddress_AddressLine1";
	public  String BILLING_CITY_KEY = "Payment_BillingAddress_Town";
	public  String BILLING_POSTCODE_KEY = "Payment_BillingAddress_Postcode";

  // Review and donate page
	public  String REVIEW_AND_DONATE_KEY = "donate-now-button";

	// ############################################ CSS ###############################################################

	// Amount page
	public String CHOOSE_AMOUNT_LABEL_KEY = "div[class='amount']";
	public String CONTINUE_BTN_KEY = "a[role='button']";


    // password page



	// Payment methods page


	// ############################################ xpath #############################################################

	// email page
	public String CONTINUE_BTN_EMAIL_KEY = "//*[@id=\"email-content\"]/div[2]/div/a[2]/span/span/span";

	// password page
	public String CONTINUE_BTN_PASSWD_KEY = "//*[@id=\"Authentication-fieldset\"]/div[2]/div/a[2]/span/span/span";
	public String CONTINUE_PAYM_KEY = "//*[@id=\"Payment-fieldset\"]/div[4]/div/a[2]/span/span/span";

	// Billing address page
	public String CONTINUE_BTN_BILLING_KEY = "//*[@id=\"Payment_BillingAddress-fieldset\"]/div[2]/div/a[2]/span/span/span";

}
