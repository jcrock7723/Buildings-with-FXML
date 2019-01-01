package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Building implements Serializable {

    public static ArrayList<Building> buildings = new ArrayList<>();

    // Instantiate variables
    private String campus;
    private String name;
    private Coordinate coordinate;
    private String imageName;
    private String buildingCode;


    public Building(String campus, String name, float latitude, float longitude, String imageName, String buildingCode) {
        this.campus = campus;
        this.name = name;
        try {
            setCoordinate(new Coordinate(latitude, longitude));
        } catch (Exception e) {

        }
        this.imageName = imageName;
        this.buildingCode = buildingCode;
    }


    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    @Override
    public String toString() {
        return "Building{" +
                "campus='" + campus + '\'' +
                ", name='" + name + '\'' +
                ", coordinate=" + coordinate.toString() +
                ", imageName='" + imageName + '\'' +
                ", buildingCode='" + buildingCode + '\'' +
                '}';
    }

    // Get an individual building based on selection
    public Building getBuilding(int indicies) {
        return buildings.get(indicies);
    }


    //
    public static ArrayList<Building> load() throws FileNotFoundException {

        // Create an Input File
        File inFile = new File("src/sample/Building.txt");

        // Scanner to read the file
        Scanner sc = new Scanner(inFile);

        String campus;
        String name;
        float latitude;
        float longitude;
        String imageName;
        String buildingCode;

        while (sc.hasNext()) {
            campus = sc.next();
            name = sc.next();
            latitude = sc.nextFloat();
            longitude = sc.nextFloat();
            imageName = sc.next();
            buildingCode = sc.next();

            Building b = new Building(campus, name, latitude, longitude, imageName, buildingCode);
            buildings.add(b);

            //System.out.println(b.toString());

        }

        /*for (Object b : buildings) {
            System.out.println(b.toString());
        }*/

        return buildings;


    }


}
