package model.service;

import java.util.HashMap;
import java.util.Map;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/31/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class Context {
    private static Context ourInstance;
    private static Map<Class<?>,Object> context;

    public static Context getInstance() {
        if (ourInstance == null) {
            ourInstance = new Context();
        }
        return ourInstance;
    }

    //register all services
    private Context() {
        context = new HashMap<>();
        context.put(DataBaseService.class,new DataBaseService());
    }

    public void add(Class<?> cls,Object obj){
        context.put(cls,obj);
    }
    public Object get(Class<?> cls){
        return context.get(cls);
    }

    public DataBaseService getDBService(){
        return (DataBaseService) context.get(DataBaseService.class);
    }

    public void close(){
        ((DataBaseService) context.get(DataBaseService.class)).close();
    }
}
