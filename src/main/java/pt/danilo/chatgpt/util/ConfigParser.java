package pt.danilo.chatgpt.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigParser {

	// Map<Tipo_De_Dados_Chave, Tipo_De_Dados_Valor>
	public static Map<String, String> parse(String filePath) throws IOException {
		Map<String, String> result = new HashMap<>();

		List<String> lines = FileUtils.readLines(filePath);
		// KEY=VALUE

		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i).trim(); // equivalente a lines[i] num array

			if (line.startsWith("#") == false) {
				int splitPosition = line.indexOf("=");

				if (splitPosition != -1) {
					// key sera tudo o que está à esquerda do primeiro = (splitPosition)
					String key = line.substring(0, splitPosition);

					// value sera tudo o que está à direita do primeiro = (splitPosition)
					String value = line.substring(splitPosition + 1);

					result.put(key, value);
				}
			}
		}

		return result;
	}
}