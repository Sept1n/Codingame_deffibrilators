import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String LON = in.next();
        String LAT = in.next();
        HashMap<String, Double> hashmap = new HashMap<>();
        Map<Double, String> reverseMap = new HashMap<>();
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(LON);
        for(int x = 0; x < stringbuilder.length(); x++) {
            if(stringbuilder.charAt(x) == ',') {
                stringbuilder.setCharAt(x, '.');
            }
        }
        LON = stringbuilder.toString();
        stringbuilder.delete(0, stringbuilder.length());
        stringbuilder.append(LAT);
        for(int x = 0; x < stringbuilder.length(); x++) {
            if(stringbuilder.charAt(x) == ',') {
                stringbuilder.setCharAt(x, '.');
            }
        }
        LAT = stringbuilder.toString();
        stringbuilder.delete(0, stringbuilder.length());
        String longitude = "";
        String latitude = "";
        String name = "";
        int position = 0;
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            for(int j = 0; j < 5; j++) {
                position = DEFIB.indexOf(";", position) + 1;
                DEFIB = DEFIB.substring(position);
                int pos = 0;
                pos = DEFIB.indexOf(";", 0);
                switch(j) {
                    case 0: name = DEFIB.substring(0, pos);
                        break;
                    case 3: longitude = DEFIB.substring(0, pos);
                        break;
                    case 4: latitude = DEFIB;
                        position = 0;
                        pos = 0;
                        break;
                }
                position = 0;
            }
            stringbuilder.append(longitude);
            for(int x = 0; x < stringbuilder.length(); x++) {
                if(stringbuilder.charAt(x) == ',') {
                    stringbuilder.setCharAt(x, '.');
                }
            }
            longitude = stringbuilder.toString();
            stringbuilder.delete(0, stringbuilder.length());
            stringbuilder.append(latitude);
            for(int x = 0; x < stringbuilder.length(); x++) {
                if(stringbuilder.charAt(x) == ',') {
                    stringbuilder.setCharAt(x, '.');
                }
            }
            latitude = stringbuilder.toString();
            stringbuilder.delete(0, stringbuilder.length());
            hashmap.put(name, parse(LON, LAT, longitude, latitude));
            reverseMap.put(parse(LON, LAT, longitude, latitude), name);
            longitude = "";
            latitude = "";
        }
        double min = Collections.min(hashmap.values());
        System.out.println(reverseMap.get(min));
        System.err.println(hashmap);
    }

    public static double parse(String longB, String latiB, String longA, String latiA) {
        double x = ((Double.parseDouble(longB) - Double.parseDouble(longA)) *
                (Math.cos((Double.parseDouble(latiB) + Double.parseDouble(latiA)) / 2)));
        double y = Double.parseDouble(latiB) - Double.parseDouble(latiA);
        double d = (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))) * 6371;
        return d;
    }

}