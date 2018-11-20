package cresla;

import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;
import cresla.io.input.Reader;
import cresla.io.output.Writer;
import cresla.manager.ManagerImpl;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Manager manager = new ManagerImpl();
        InputReader reader = new Reader();
        OutputWriter writer = new Writer();

        whileLoop:
        while (true){
            List<String> commandTokens = Arrays.asList(reader.readLine().split(" "));
            switch (commandTokens.get(0)){
                case "Reactor":
                    writer.write(manager.reactorCommand(commandTokens.subList(1, commandTokens.size())));
                    break;
                case "Module":
                    writer.write(manager.moduleCommand(commandTokens.subList(1, commandTokens.size())));
                    break;
                case "Report":
                    writer.write(manager.reportCommand(commandTokens.subList(1, commandTokens.size())));
                    break;
                default:
                    writer.write(manager.exitCommand(commandTokens));
                    break whileLoop;
            }

        }
    }
}
