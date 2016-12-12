package online.zhaopei.myproject.common.tool;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sun.xml.bind.marshaller.CharacterEscapeHandler;

public final class JAXBTool {

	public static <T> T getXmlObject(Class<T> clazz, InputStream in) {
		try {
			JAXBContext jc = JAXBContext.newInstance(clazz);
			Unmarshaller u = jc.createUnmarshaller();
			return (T) u.unmarshal(in);
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static <T> T getXmlObject(Class<T> clazz, String content) {
		try {
			JAXBContext jc = JAXBContext.newInstance(clazz);
			Unmarshaller u = jc.createUnmarshaller();
			return (T) u.unmarshal(new ByteArrayInputStream(content.getBytes("UTF-8")));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static <T> String buildXml(Class<T> clazz, Object obj) {
		return buildXml(clazz, obj, true, "UTF-8", true, true);
	}
	
	public static <T> String buildXml(Class<T> clazz, Object obj, boolean isFormatted, String charset, boolean isFragment, boolean isEscape) {
		try {
			JAXBContext jc = JAXBContext.newInstance(clazz);
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, isFormatted);
			m.setProperty(Marshaller.JAXB_ENCODING, charset);
			m.setProperty(Marshaller.JAXB_FRAGMENT, isFormatted);
			if (isEscape) {
				m.setProperty("com.sun.xml.bind.marshaller.CharacterEscapeHandler", new CharacterEscapeHandler() {
					@Override
					public void escape(char[] ch, int start, int length, boolean isAttVal, Writer writer) throws IOException {
						writer.write(ch, start, length);
					}
				});
			}
			StringWriter writer = new StringWriter();
			m.marshal(obj, writer);
			return writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
