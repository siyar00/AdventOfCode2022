package Day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class seventhDay {

    private static final HashMap<String, ArrayList<String>> fileSystem = new HashMap<>();
    private static final HashMap<String, Integer> fileSystemSize = new HashMap<>();
    private static final HashMap<String, Integer> fileSystemSizeNew = new HashMap<>();

    private static void firstPart() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/Day7/input.txt"));
        String input, directory = "";
        while ((input = reader.readLine()) != null) {
            String[] inputs = input.split(" ");
            if (inputs[1].equals("cd")) {
                if (!inputs[2].equals("..")) {
                    directory += "/" + inputs[2];
                    fileSystem.put(directory, new ArrayList<>());
                } else {
                    directory = directory.substring(0, directory.lastIndexOf("/"));
                }
            } else if (!inputs[1].equals("ls")) {
                ArrayList<String> temp = fileSystem.get(directory);
                temp.add(input);
                fileSystem.put(directory, temp);
            }
        }
        reader.close();

        for (String key : fileSystem.keySet()) {
            int count = 0;
            for (String value : fileSystem.get(key)) {
                if (!value.contains("dir")) {
                    String[] values = value.split(" ");
                    count += Integer.parseInt(values[0]);
                }
            }
            fileSystemSize.put(key, count);
        }
        fileSystemSizeNew.putAll(fileSystemSize);
        recursiveFind("/home");
        int count = 0;
        for (String key : fileSystemSizeNew.keySet()) {
            if (fileSystemSizeNew.get(key) < 100000) {
                count += fileSystemSizeNew.get(key);
            }
        }
        System.out.println(count);
    }
    private static int recursiveFind(String directory) {
        ArrayList<String> temp = fileSystem.get(directory);
        for (String currentDirectory : temp) {
            if (currentDirectory.contains("dir")) {
                int i = fileSystemSizeNew.get(directory);
                i += recursiveFind(directory + "/" + currentDirectory.substring(4));
                fileSystemSizeNew.replace(directory, i);
            }
        }
        return fileSystemSizeNew.get(directory);
    }
    private static void secondPart(){
        ArrayList<Integer> sizes = new ArrayList<>();
        for (String key : fileSystemSizeNew.keySet()) {
            if (fileSystemSizeNew.get(key) >= fileSystemSizeNew.get("/home")-40000000) {
                sizes.add(fileSystemSizeNew.get(key));
            }
        }
        System.out.println(Collections.min(sizes));
    }

    public static void main(String[] args) throws IOException {
        firstPart();
        secondPart();
    }
}
