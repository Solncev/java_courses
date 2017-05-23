package model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Марат on 23.05.2017.
 */
@Document
public class Score {

    private String type;
    private Double score;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
