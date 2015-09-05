/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mateu
 */
public class JsonModel implements Comparable<JsonModel>  {
    
    private double latitude;
    private double longitude;
    private int userIid;
    private double latitudeDefault = 53.3381985;
    private double longitudeDefault = -6.2592576;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    public int getUserIid() {
        return userIid;
    }

    public void setUserIid(int userIid) {
        this.userIid = userIid;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitudeDefault() {
        return latitudeDefault;
    }

    public void setLatitudeDefault(double latitudeDefault) {
        this.latitudeDefault = latitudeDefault;
    }

    public void setLongitudeDefault(double longitudeDefault) {
        this.longitudeDefault = longitudeDefault;
    }

        
    public double getLongitudeDefault() {
        return longitudeDefault;
    }

  @Override
  public int compareTo(JsonModel o) {
    return Integer.compare(userIid, o.userIid);
  }

  @Override
  public String toString() {
    return name + " " + userIid;
  }
    
    

  
    
    
    
}
