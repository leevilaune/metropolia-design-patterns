package dev.onesnzeroes.designpatterns.prototype.model;

import java.util.HashMap;
import java.util.Map;

public class RecommendationRegistry {

    private Map<String, Recommendation> registry;

    public RecommendationRegistry(){
        this.registry = new HashMap<>();
    }

    public void addEntry(Recommendation rec){
        this.registry.put(rec.getTargetAudience(),rec);
    }

    public Recommendation getByTargetAudience(String targetAudience) {
        Recommendation rec = this.registry.get(targetAudience);

        if (rec == null) {
            throw new IllegalArgumentException(String.format("No recommendation found for %s", targetAudience));
        }
        try {
            return rec.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning failed", e);
        }
    }
}
