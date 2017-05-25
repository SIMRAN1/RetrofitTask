package com.redcarpet.in.retrofittask;

/**
 * Created by simran on 5/24/2017.
 */


        import java.util.HashMap;
        import java.util.Map;

public class Worldpopulation {

    private Integer rank;
    private String country;
    private String population;
    private String flag;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Worldpopulation() {
    }

    /**
     *
     * @param rank
     * @param flag
     * @param population
     * @param country
     */
    public Worldpopulation(Integer rank, String country, String population, String flag) {
        super();
        this.rank = rank;
        this.country = country;
        this.population = population;
        this.flag = flag;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}



