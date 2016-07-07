/*
 * SportChef – Sports Competition Management Software
 * Copyright (C) 2016 Marcus Fihlon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ch.fihlon.demo.jsr354;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.convert.ExchangeRate;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;

public class ExchangeRateDemo {

    public static void main(final String... args) {

        final CurrencyUnit brl = Monetary.getCurrency("BRL");
        final CurrencyUnit eur = Monetary.getCurrency("EUR");

        final ExchangeRateProvider ecbRateProvider = MonetaryConversions.getExchangeRateProvider("ECB");
        final ExchangeRate ecbExchangeRate = ecbRateProvider.getExchangeRate(brl, eur);
        log(ecbExchangeRate);

        final ExchangeRateProvider imfRateProvider = MonetaryConversions.getExchangeRateProvider("IMF");
        final ExchangeRate imfExchangeRate = imfRateProvider.getExchangeRate("EUR", "CHF");
        log(imfExchangeRate);
    }

    private static void log(final ExchangeRate exchangeRate) {
        System.out.println("==============================");
        System.out.println("Exchange Rate: " + exchangeRate);
        System.out.println("Base Currency: " + exchangeRate.getBaseCurrency());
        System.out.println("Currency: " + exchangeRate.getCurrency());
        System.out.println("Factor: " + exchangeRate.getFactor().doubleValueExact());
        System.out.println("Context: " + exchangeRate.getContext());
    }

}
