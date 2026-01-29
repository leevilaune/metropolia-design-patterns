package dev.onesnzeroes.sweproject.unittests;

public class DegreeToYearsConverter {

    public DegreeToYearsConverter(){

    }
    /**
     * This function accepts a degree type and returns the number of years required.
     *
     * @param degree The degree type (e.g., "bsc", "msc", "phd"). Must not be null.
     * @return The number of years required, or -1 if the degree is not recognized.
     * @throws NullPointerException if the provided degree parameter is null.
     */
    public int degreeToYears(String degree){
        if(degree == null){
            throw new NullPointerException("Degree must not be null");
        }

        if(degree.equalsIgnoreCase("bsc")){
            return 4;
        }else if(degree.equalsIgnoreCase("msc")){
            return 2;
        }else if(degree.equalsIgnoreCase("phd")){
            return 5;
        }

        return -1;
    }

}
