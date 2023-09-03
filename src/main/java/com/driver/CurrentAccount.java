package com.driver;


public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId=tradeLicenseId;
        if(balance < 5000){
            throw new Exception("Insufficient Balance");
        }
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        char[] licenseChars = this.tradeLicenseId.toCharArray();

        // Check if consecutive characters are the same
        for (int i = 0; i < licenseChars.length - 1; i++) {
            if (licenseChars[i] == licenseChars[i + 1]) {
                // Rearrange characters to create a valid license ID
                for (int j = i + 1; j < licenseChars.length; j++) {
                    if (licenseChars[j] != licenseChars[i]) {
                        char temp = licenseChars[j];
                        licenseChars[j] = licenseChars[i];
                        licenseChars[i] = temp;
                        break;
                    }
                }

                // If no valid rearrangement is possible, throw an exception
                if (licenseChars[i] == licenseChars[i + 1]) {
                    throw new Exception("Valid License cannot be generated");
                }
            }
        }

        setTradeLicenseId(new String(licenseChars));
    }

}
