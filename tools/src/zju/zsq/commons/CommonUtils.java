package zju.zsq.commons;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

/**
 * СС����
 * @author zhushiqing
 *
 */
public class CommonUtils {
	/**
	 * ����һ�����ظ����ַ���
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	/**
	 * ��mapת���ɶ���
	 * @param map
	 * @param clazz
	 * @return
	 * 
	 * ��Mapת����ָ������
	 */
	@SuppressWarnings("rawtypes")
	public static <T> T toBean(Map map, Class<T> clazz) {
		try {
			/*
			 * 1. ͨ������clazz����ʵ��
			 * 2. ʹ��BeanUtils.populate��map�����ݷ�յ�bean��
			 */
			T bean = clazz.newInstance();
			ConvertUtils.register(new DateConverter(), java.util.Date.class);
			BeanUtils.populate(bean, map);
			return bean;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}

