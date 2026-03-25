package dev.onesnzeroes.designpatterns.proxy.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccessControlService {

    private static AccessControlService instance;

    private Map<Integer, List<String>> masterList;

    private AccessControlService(){
        this.masterList = new HashMap<>();
    }

    public static AccessControlService getInstance(){
        if(instance == null){
            instance = new AccessControlService();
            return instance;
        }
        return instance;
    }

    public void setAccessForUser(int documentId, String user) {
        this.masterList
                .computeIfAbsent(documentId, k -> new ArrayList<>())
                .add(user);
    }
    public boolean isAllowed(int documentId, String user){
        if(this.masterList.get(documentId) == null){
            return false;
        }
        return this.masterList.get(documentId).contains(user);
    }

    public void clear(){
        this.masterList = new HashMap<>();
    }
}
