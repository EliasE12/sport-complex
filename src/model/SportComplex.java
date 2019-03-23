package model;

import java.io.*;
import java.util.ArrayList;

// Class

public class SportComplex {

    // Constant

    public final static String PATH_TXT_IMPORT = "data/file.txt";
    public final static String PATH_FILE = "data/export.txt";

    // Attributes

    public ArrayList<SportField> sportFields;

    // Constructor

    public SportComplex() {
        sportFields = new ArrayList<SportField>();
    }

    // Methods

    public void importData() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(PATH_TXT_IMPORT)));
        String line = br.readLine();
        while (line != null) {

            if (line.charAt(0) != '#') {
                String[] parts = line.split(";");
                String n = parts[0];
                double l = Double.parseDouble(parts[1]);
                double a = Double.parseDouble(parts[2]);
                SportField nuevo = new SportField(n, l, a);
                sportFields.add(nuevo);
            }
            line = br.readLine();
        }
        br.close();
    }


    public String generateReport() {

        String report = "GENERAL REPORT \n";

        double totalArea = 0.0;
        for (int i = 0; i < sportFields.size(); i++) {
            totalArea += sportFields.get(i).getArea();
        }

        report += "============================ \n";
        report += "Total Area: " + totalArea + "\n";

        double mayorLength = 0.0;
        SportField actual = null;
        for (int i = 0; i < sportFields.size(); i++) {
            actual = sportFields.get(i);
            for (int j = 0; j < sportFields.size(); j++) {
                if(actual.getLength()<sportFields.get(j).getLength()){
                    actual = sportFields.get(j);
                }
            }
        }
        mayorLength = actual.getLength();

        report += "Max Length: " + mayorLength + "\n";
        report += "============================ \n";

        return report;
    }


    public void exportReport() throws IOException {

        PrintWriter pw = new PrintWriter(new File(PATH_FILE));
        pw.print(generateReport());
        pw.close();


        /**
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PATH_FILE)));
        bw.write(generateReport());
        bw.close();
         **/
    }


    public String getInformation() {
        String messag = "";
        for (int i = 0; i < sportFields.size(); i++) {
            messag += "\nField #" + (i+1) + "\n";
            SportField actual = sportFields.get(i);
            messag += "Name: " + actual.getName() + "\n";
            messag += "Length: " + actual.getLength() + "\n";
            messag += "Area: " + actual.getArea() + "\n";
        }
        return messag;
    }
}
