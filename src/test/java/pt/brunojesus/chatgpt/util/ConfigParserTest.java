package pt.brunojesus.chatgpt.util;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ConfigParserTest {

	@Test
	void testParseSimpleConfig() throws IOException {
		Map<String, String> config = ConfigParser.parse(getTestResourcesConfigFilePath("simple_config.properties"));

//		String expectedToken = "Batatas";
//		String token = config.get("token");
//
//		if (expectedToken.equals(token) == false) {
//			throw new RuntimeException("Assertion failed");
//		}

		assertNotNull(config, "config cannot be null");
		assertEquals("HelloWorld!", config.get("token"));
		assertEquals("ChatGPTClient", config.get("applicationName"));
		assertEquals(2, config.size());
		assertNull(config.get("Batatas"), "non existing config value should not have a map entry");
	}

	@Test
	void testParseEmptyValue() throws IOException {
		Map<String, String> config = ConfigParser.parse(getTestResourcesConfigFilePath("empty_value.properties"));

		assertNotNull(config, "config cannot be null");
		assertEquals("", config.get("token"));
		assertEquals("ChatGPTClient", config.get("applicationName"));
		assertEquals(2, config.size());
	}

	@Test
	void testNoSeparator() throws IOException {
		Map<String, String> config = ConfigParser.parse(getTestResourcesConfigFilePath("no_separator.properties"));

		assertNotNull(config, "config cannot be null");
		assertEquals("HelloWorld!", config.get("token"));
		assertEquals("Bruno", config.get("username"));
		assertNull(config.get("applicationName"));
		assertEquals(2, config.size());
	}

	@Test
	void testIgnoreCommentedAndEmptyLines() throws IOException {
		Map<String, String> config = ConfigParser.parse(getTestResourcesConfigFilePath("with_comments.properties"));

		assertNotNull(config, "config cannot be null");
		assertEquals(3, config.size());
		assertEquals("HelloWorld!", config.get("token"));
		assertEquals("ChatGPTClient", config.get("applicationName"));
		assertEquals("noreply@localhost", config.get("emailAddress"));
	}

	@Test
	void testEmptyFile() throws IOException {
		Map<String, String> config = ConfigParser.parse(getTestResourcesConfigFilePath("empty.properties"));

		assertNotNull(config, "config cannot be null");
		assertEquals(0, config.size());
	}

	@Test
	void testFileNotFound() throws IOException {
//		try {
//		Map<String, String> config = ConfigParser.parse(
//				getTestResourcesConfigFilePath("nonexistent.properties")
//		);
//		} catch (FileNotFoundException e) {
//			return;
//		}
//		
//		fail("Should have failed");

		assertThrows(FileNotFoundException.class, () -> {
			ConfigParser.parse(getTestResourcesConfigFilePath("nonexistent.properties"));
		});
	}

	private String getTestResourcesConfigFilePath(String filename) {
		Path resourcesDirectory = Paths.get("src", "test", "resources", filename);
		return resourcesDirectory.toFile().getAbsolutePath();
	}
}
