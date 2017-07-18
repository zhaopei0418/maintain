package online.zhaopei.myproject.jsonserialize;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent
public class CustomJsonSerializer {

	public static class ByteArraySerializer extends JsonSerializer<byte[]> {

		@Override
		public void serialize(byte[] content, JsonGenerator jgen, SerializerProvider sp)
				throws IOException, JsonProcessingException {
			String result = new String(content, "UTF-8");
			
			jgen.writeString(result);
		}
	
	}
}
