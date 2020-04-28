package exceptions.examples;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Game {
    private static final String FORMAT_FOR_DATES ="yyyy/MM/dd HH:mm:ss";
    private static final String FILE_NAME_SCORE = "score.txt";
    private static final String FILE_NAME_PROGRESS = "progress.txt";
    private static final String FILE_NAME_STATISTICS = "statistics.txt";

    public void saveGame() {
        try {
            saveProgress();
            saveScore();
            saveStatistics();
        } catch (SaveProgressException |SaveScoreException |SaveStatisticException e) {
            e.printStackTrace();
        }
    }

    private void saveStatistics() throws SaveStatisticException, NullPointerException {

        try(FileWriter writer = new FileWriter(FILE_NAME_STATISTICS, true);) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_FOR_DATES);

            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());
        } catch (IOException e) {
            throw new SaveStatisticException("Can't save statistics ", e);
        }
    }

    private void saveScore() throws SaveScoreException {

        try(FileWriter writer = new FileWriter(FILE_NAME_SCORE, true);) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_FOR_DATES);

            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());

            throw new IOException();

        } catch (IOException e) {
            throw new SaveScoreException("Can't save score ", e);
        }
    }

    private void saveProgress() throws SaveProgressException {

        try (FileWriter writer = new FileWriter(FILE_NAME_PROGRESS, true);){
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_FOR_DATES);

            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());
        } catch (IOException e) {
            throw new SaveProgressException("Can't save progress ", e);
        }


    }
}
