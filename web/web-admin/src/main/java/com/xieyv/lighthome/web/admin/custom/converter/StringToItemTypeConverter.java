package com.xieyv.lighthome.web.admin.custom.converter;

import com.xieyv.lighthome.model.enums.ItemType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *  @author xieyv
 *  用于实现 将传入的数字值形式字符串转换为枚举ItemType对象，已被ConverterFactory代替
 */
@Deprecated
@Component
public class StringToItemTypeConverter implements Converter<String, ItemType> {

    @Override
    public ItemType convert(String source) {
        ItemType[] values = ItemType.values();
        for (ItemType itemType : values) {
            if(itemType.getCode().equals(Integer.valueOf(source))){
                return itemType;
            }
        }
        throw new IllegalArgumentException("传入了非法参数：" + source);
    }
}
