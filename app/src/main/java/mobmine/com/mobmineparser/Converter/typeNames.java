package mobmine.com.mobmineparser.Converter;

/**
 * Created by lucas on 25/04/16.
 */
public enum typeNames {

    STRING_b("b","borda"),
    STRING_bf("bf", "bordaFrente"),
    STRING_ES("ES", "entradaSaida"),
    STRING_s("s", "sss"),
    STRING_rp("rp", "rampa"),
    STRING_DSN("dsn", "desnivel"),
    STRING_PROFUN("profunEC", "profunEC");


    private final String type;   // in kilograms
    private final String name; // in meters

    typeNames(String type, String name){
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }

    public static String findTypeName(String type){
        for(typeNames t : typeNames.values()){
            if(t.type.equals(type)){
                return t.toString();
            }
        }
        return "profunEC";
    }
}
