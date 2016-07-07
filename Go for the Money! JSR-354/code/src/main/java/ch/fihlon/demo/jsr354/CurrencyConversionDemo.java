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

import org.javamoney.moneta.Money;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;

public class CurrencyConversionDemo {

    public static void main(final String... args) {

        final MonetaryAmount fromAmount = Money.of(100, "BRL");
        final CurrencyUnit euro = Monetary.getCurrency("EUR");

        final ExchangeRateProvider ecbRateProvider = MonetaryConversions.getExchangeRateProvider("ECB");
        final CurrencyConversion ecbEuroConverter = ecbRateProvider.getCurrencyConversion(euro);
        final MonetaryAmount ecbEuroAmount = fromAmount.with(ecbEuroConverter);
        log(ecbRateProvider, fromAmount, ecbEuroAmount);

        final ExchangeRateProvider imfRateProvider = MonetaryConversions.getExchangeRateProvider("IMF");
        final CurrencyConversion imfEuroConverter = imfRateProvider.getCurrencyConversion(euro);
        final MonetaryAmount imfEuroAmount = fromAmount.with(imfEuroConverter);
        log(imfRateProvider, fromAmount, imfEuroAmount);
    }

    private static void log(final ExchangeRateProvider rateProvider,
                            final MonetaryAmount fromAmount,
                            final MonetaryAmount toAmount) {
        System.out.println(String.format("%s: %s ≙ %s", rateProvider, fromAmount, toAmount));
    }

}
