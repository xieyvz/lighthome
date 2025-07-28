package com.xieyv.lighthome.web.admin.custom.converter;

import com.xieyv.lighthome.model.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

/**
 *  @author xieyv
 *  用于实现 不同类型枚举的转换器，进一步实现将传入的数字值形式字符串转换为枚举对象
 */

@Component
public class StringToEnumTypeConverterFactory implements ConverterFactory<String, BaseEnum> {
    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return source -> {
                T[] enumConstants = targetType.getEnumConstants();
                for (T enumConstant : enumConstants) {
                    if(enumConstant.getCode().equals(Integer.valueOf(source)))
                        return enumConstant;
                }
                throw new IllegalArgumentException("传入了非法参数：" + source);
            };
    }


    /*
    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return new Converter<String, T>() {
            @Override
            public T convert(String source) {
                T[] enumConstants = targetType.getEnumConstants();
                for (T enumConstant : enumConstants) {
                    if(enumConstant.getCode().equals(Integer.valueOf(source)))
                        return enumConstant;
                }
                throw new IllegalArgumentException("传入了非法参数：" + source);
            }
        };
    }
     */
}
