
package process;

import process.model.Player;
import process.util.Logic;
import process.util.Parser;

import java.io.File;
import java.nio.file.Files;
import java.util.List;


public class Application {

    public static void main(String[] args) throws Exception {
        final String fileName = "feeds/players3.csv";
        final ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        final File file = new File(classLoader.getResource(fileName).getFile());
        final String content = new String(Files.readAllBytes(file.toPath()));
        List<Player> players = Parser.buildPlayers(content);
        //Logic.buildLineUp(players);

        //Logic.wrAndRb(players);

    }
}