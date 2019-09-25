package tests;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Split {

	private static final Logger logger = Logger.getAnonymousLogger();
			//LoggerFactory.getLogger(ComplexPropertyParserUtil.class);

	public static void main(String[]args) {
		String cvAttributeString = "{lbUtranB1ThresholdEcNoOffset:0,qciProfileRef:SubNetwork=ONRM_ROOT_MO_R,SubNetwork=Bloomfield,MeContext=LCT11009B,ManagedElement=1,ENodeBFunction=1,QciTable=default,QciProfilePredefined=qci1,lbUtranB1ThresholdRscpOffset:0}";
		
			final Map<String, String> cvAttributePropertiesMoj = new HashMap<>();
			final String trimmed = cvAttributeString.trim().substring(1, cvAttributeString.length() - 1);
			final String[] values = trimmed.split(",");
			for (final String value : values) {
				String [] mapEntry = value.split("[:=]", 2);
				if (mapEntry.length == 2) {
					cvAttributePropertiesMoj.put(mapEntry[0], mapEntry[1]);
				}
			}
		System.out.println(cvAttributePropertiesMoj);
		
		
		String example = "{parameterName:parameterValue, parameterName2:[value1,value2], parameterName3:{insideParameter1:[1,2,3]}}";
		
		Map<String, String> izlaz = parseStruct(example);
		System.out.println(example + "\n" + izlaz);
	}

	
	/**
	 * Parses struct string into map of key-value pairs. Struct string has only string as keys and values can be strings,lists (marked with []) and another structs(marked with {})
	 * Values are always parsed as strings into resulting map. That means the depth of parsing is 1.
	 *
	 * Struct string example: {parameterName:parameterValue, parameterName2:[value1,value2], parameterName3:{insideParameter1:[1,2,3]}}
	 * Result example: Map<String,String>= {parameterName:parameterValue,parameterName2:[value1,value2],parameterName3:{insideParameter1:[1,2,3]}}
	 *
	 * @param structString
	 *            struct string
	 * @return struct string parsed into map of parameterName-parameterValue pairs
	 */
	public static Map<String, String> parseStruct(final String structString) {
		return parseStruct(structString, ",?\\s*(\\w+)\\s*:\\s*");
	}

	public static Map<String, String> parseStruct(final String structString, final String propertyNameRegex) {

		// structString example:
		// {lbUtranB1ThresholdEcNoOffset:0,qciProfileRef:SubNetwork=ONRM_ROOT_MO_R,SubNetwork=Bloomfield,MeContext=LCT11009B,ManagedElement=1,ENodeBFunction=1,QciTable=default,QciProfilePredefined=qci1,lbUtranB1ThresholdRscpOffset:0}
		// remove curly brackets
		final String trimmed = structString.trim().substring(1, structString.length() - 1);
		//final String propertyNameRegex = ",?\\s*(\\w+)\\s*:\\s*";

		// split by property name
		// values array will always have empty string as first element, since structString starts with property name by which the string is splitted
		final String[] values = trimmed.split(propertyNameRegex);

		final Pattern pattern = Pattern.compile(propertyNameRegex);
		final Matcher matcher = pattern.matcher(trimmed);
		final Map<String, String> result = new HashMap<String, String>();

		// property values array contains empty string as first element due to splitting by property name, start indexing from index 1
		int propertyValueIndex = 1;

		// searching start index, used to iterate trough structString property name by property name
		int start = 0;
		while (matcher.find(start)) {
			// extract property name from regex capture and property value from values array
			try {
				result.put(matcher.group(1), values[propertyValueIndex].trim());
			} catch (Exception e) {
				logger.severe("Error occured at parsing values: " + values + ", position: " + propertyValueIndex + ", structString: " + structString);
				logger.severe(e.getMessage() + e);
				throw e;
			}
			propertyValueIndex++;
			// increase searching start index to the end of previous capture, so next property name can be captured
			start = matcher.end(1);
		}
		return result;

	}
	
	
}
