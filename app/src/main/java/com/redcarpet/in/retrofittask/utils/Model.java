package com.redcarpet.in.retrofittask.utils;

/**
 * Created by simran on 5/24/2017.
 */



        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Map;

public class Model {

    private ArrayList<Worldpopulation> worldpopulation = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Model() {
    }

    /**
     *
     * @param worldpopulation
     */
    public Model(ArrayList<Worldpopulation> worldpopulation) {
        super();
        this.worldpopulation = worldpopulation;
    }

    public ArrayList<Worldpopulation> getWorldpopulation() {
        return worldpopulation;
    }

    public void setWorldpopulation(ArrayList<Worldpopulation> worldpopulation) {
        this.worldpopulation = worldpopulation;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
