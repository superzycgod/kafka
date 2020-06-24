package cn.zycgod.springboot.demo.kafka.consumer;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 主题[stream-in]有2个分区，listen1和listen2同时监听该主题<br>
 * 每个listen只会监听主题[stream-in]下的一个分区
 * 
 * @author zhangyanchao
 *
 */
@Component
public class KafkaMessageListener {

	private final Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

	@KafkaListener(topics = { "stream-in" })
	public void listen1(ConsumerRecord<?, ?> record) {
		Optional<?> kafkaMessage = Optional.ofNullable(record.value());
		if (kafkaMessage.isPresent()) {
			Object message = kafkaMessage.get();
			logger.info("listen1----------------- partition =" + record.partition());
			logger.info("listen1----------------- record =" + record);
			logger.info("listen1------------------ message =" + message);
		}
	}

	@KafkaListener(topics = { "stream-in" })
	public void listen2(ConsumerRecord<?, ?> record) {
		Optional<?> kafkaMessage = Optional.ofNullable(record.value());
		if (kafkaMessage.isPresent()) {
			Object message = kafkaMessage.get();
			logger.info("listen2----------------- partition =" + record.partition());
			logger.info("listen2----------------- record =" + record);
			logger.info("listen2------------------ message =" + message);
		}
	}

}
