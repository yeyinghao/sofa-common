package com.luman.sofa.common.utils;

import com.luman.sofa.common.dto.EnumVO;
import com.luman.sofa.common.enums.ByCode;
import com.luman.sofa.common.enums.ByStringCode;
import lombok.experimental.UtilityClass;

import java.util.Objects;
import java.util.Optional;

/**
 * 枚举工具类
 *
 * @author yeyinghao
 * @date 2024/08/26
 */
@UtilityClass
public class EnumUtil {

	/**
	 * 获取枚举通过代码
	 *
	 * @param type 类型
	 * @param code 代码
	 * @return {@link M }
	 */
	public static <M extends ByCode<T>, T> Optional<M> getEnumByCode(Class<M> type, T code) {
		if (!type.isEnum()) {
			return Optional.empty();
		}
		M[] enums = type.getEnumConstants();
		for (M em : enums) {
			if (Objects.equals(em.getCode(), code)) {
				return Optional.of(em);
			}
		}
		return Optional.empty();
	}

	/**
	 * 获取名称
	 */
	public static <M extends ByStringCode> String getName(M byCode) {
		return Optional.ofNullable(byCode).map(ByStringCode::getCode).orElse(null);
	}

	public static <M extends ByStringCode> EnumVO enum2VO(M byCode) {
		return Optional.ofNullable(byCode).map(EnumVO::new).orElse(null);
	}

}
