package com.github.geirolz.solid;

import java.util.List;

public class CartBuilder {


    static class DbConnector{
        public void insert(String value){
            //TODO
        }
    }


    class Region {

        private String code;
        private String country;

        public Region(String code, String country) {
            this.code = code;
            this.country = country;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

    class Italy extends Region {

        public Italy() {
            super("IT", "EU");
        }
    }


    public void build(List<Item> items){

        T t = new T();
        t.run();

        //TODO
        Cart result = null;

        //Insert
        new DbConnector().insertYoox(result);
        new DbConnector().insertMrPorter(result);
    }
}
