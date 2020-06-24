package cn.zycgod.springboot.demo.kafka;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import cn.zycgod.springboot.demo.kafka.message.Message;

@SpringBootTest
class KafkaDemoApplicationTests {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@Test
	void contextLoads() throws IOException {

		kafkaTemplate.send("stream-in", "字符测试");

		String uuid = UUID.randomUUID().toString();
		Map<String, Object> props = new LinkedHashMap<String, Object>();
		props.put("aa", "啊啊");

		Message msg = new Message();
		msg.setId(uuid);
		msg.setContext("javabean测试");
		msg.setProps(props);

		kafkaTemplate.send("stream-in", "key-" + uuid, msg);

		System.in.read();

	}

}
