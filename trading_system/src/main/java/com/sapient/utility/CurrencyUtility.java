package com.sapient.utility;

import com.sapient.dao.CurrencyImpl;
import com.sapient.models.Currency;
import com.sapient.models.Symbol;

import java.io.IOException;

public class CurrencyUtility {
    public void performCurrencyOperations() throws IOException {
            CurrencyImpl currencyImpl = new CurrencyImpl("currency.csv");
            Currency currency = new Currency(1,"Indian Currency",101, Symbol.RUPEE,"India");
            currencyImpl.addCurrency(currency);
            Currency currency1 = new Currency(2,"USA currency",102,Symbol.DOLLAR,"USA");
            currencyImpl.addCurrency(currency1);
            Currency currency1Updated = new Currency(2,"United State of America Currency",102,Symbol.DOLLAR,"USA");
            currencyImpl.editCurrency(2,currency1Updated);
            Currency currency2 = new Currency(3,"Russia currency",103,Symbol.YUAN,"Russia");
            currencyImpl.addCurrency(currency2);
            currencyImpl.deleteCurrency(3);
    }
}
