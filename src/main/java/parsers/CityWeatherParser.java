package parsers;

import schemas.RowRecord;

public class CityWeatherParser {

    public static RowRecord parseCSV(String csvLine) {

        RowRecord rowRecord;
        String[] csvValues = csvLine.split(",");

        // skipping header
        if (csvValues[0].equals("datetime"))
            return null;

        if (csvValues.length != 34)
            return null;

        rowRecord = new RowRecord(
                csvValues[0], // datatime
                csvValues[1], // Portland
                csvValues[2], // San Francisco
                csvValues[3], // Seattle
                csvValues[4], // Los Angeles
                csvValues[5], // San Diego
                csvValues[6], // Las Vegas
                csvValues[7], // Phoenix
                csvValues[8], // Albuquerque
                csvValues[9], // Denver
                csvValues[10], // San Antonio
                csvValues[11], // Dallas
                csvValues[12], // Houston
                csvValues[13], // Kansas City
                csvValues[14], // Minneapolis
                csvValues[15], // Saint Louis,
                csvValues[16], // Chicago
                csvValues[17], // Nashville
                csvValues[18], // Indianapolis
                csvValues[19], // Atlanta
                csvValues[20], // Detroit
                csvValues[21], // Jacksonville
                csvValues[22], // Charlotte
                csvValues[23], // Miami
                csvValues[24], // Pittsburgh
                csvValues[25], // Philadelphia
                csvValues[26], // New York
                csvValues[27], // Boston
                csvValues[28], // Beersheba
                csvValues[29], // Tel Aviv District
                csvValues[30], // Eilat
                csvValues[31], // Haifa
                csvValues[32], // Nahariyya
                csvValues[33] // Jerusalem
        );

        return rowRecord;
    }
}
