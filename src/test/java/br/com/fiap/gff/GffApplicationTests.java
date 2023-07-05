package br.com.fiap.gff;

import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { GffApplication.class })
class GffApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void whenPropertiesConfig_thenInsertSucceeds() {
		SpringApplicationBuilder app = new SpringApplicationBuilder(GffApplication.class);
		app.run();
		assertInsertSucceeds(app.context());
	}

	public void assertInsertSucceeds(ConfigurableApplicationContext context) {
		String name = "A";
		MongoTemplate mongo = context.getBean(MongoTemplate.class);
		Document doc = Document.parse("{\"name\":\"" + name + "\"}");
		Document inserted = mongo.insert(doc, "items");
		assertNotNull(inserted.get("_id"));
		assertEquals(inserted.get("name"), name);
	}
}
