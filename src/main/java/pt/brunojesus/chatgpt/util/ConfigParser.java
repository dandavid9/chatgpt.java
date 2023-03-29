package pt.brunojesus.chatgpt.util;

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
		
		for (int i=0; i < lines.size(); i++) {
			String line = lines.get(i); //equivalente a lines[i] num array
			String[] keyValue = line.split("=");
			result.put(keyValue[0], keyValue[1]);
		}
		
		
		return result;
	}
}
