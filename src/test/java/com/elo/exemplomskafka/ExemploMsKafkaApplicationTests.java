package com.elo.exemplomskafka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ExemploMsKafkaApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void testConnection() {
		Integer result = jdbcTemplate.queryForObject("SELECT 1 FROM DUAL", Integer.class);
		assertThat(result).isEqualTo(1);
	}
}
