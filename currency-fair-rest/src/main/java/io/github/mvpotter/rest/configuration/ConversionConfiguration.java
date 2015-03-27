/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 22/03/15
 * Time: 13:22
 */
package io.github.mvpotter.rest.configuration;

import io.github.mvpotter.rest.converter.RestTradeConverter;
import io.github.mvpotter.rest.converter.TradeConverter;
import io.github.mvpotter.rest.converter.TradePageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConversionConfiguration {

    @Bean
    public ConversionService conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(getConverters());
        bean.afterPropertiesSet();
        return bean.getObject();
    }

    private Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<Converter>();

        converters.add(new TradeConverter());
        converters.add(new RestTradeConverter());
        converters.add(new TradePageConverter());

        return converters;
    }

}
