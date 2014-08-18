package zju.zsq.commons;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.Converter;

/**
 * ��Stringת����java.util.Date������ת����
 * @author zhushiqing
 *
 */
public class DateConverter implements Converter {

	@SuppressWarnings("rawtypes")
	@Override
	public Object convert(Class type, Object value) {
		if(value == null) return null;//���Ҫת����ֵΪnull����ôֱ�ӷ���null
		if(!(value instanceof String)) {//���Ҫת����ֵ����String����ô�Ͳ�ת���ˣ�ֱ�ӷ���
			return value;
		}
		String val = (String) value;//��ֵת����String
		
		// ʹ��SimpleDateFormat����ת��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(val);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
