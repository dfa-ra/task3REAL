package org.example.сommands;

public interface Command {
    void execute(String[] tokens) throws Exception;
    String getInfo();
    String getName();

}
