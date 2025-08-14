package com.tss.model;

import java.time.LocalDate;

public class Feedback {
    private int id;
    private String name;
    private LocalDate sessionDate;
    private int sessionContent;
    private int queryResolution;
    private int interactivity;
    private int impactfulLearning;
    private int contentDeliverySkills;
    private String comments;

    // getters/setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getSessionDate() { return sessionDate; }
    public void setSessionDate(LocalDate sessionDate) { this.sessionDate = sessionDate; }

    public int getSessionContent() { return sessionContent; }
    public void setSessionContent(int sessionContent) { this.sessionContent = sessionContent; }

    public int getQueryResolution() { return queryResolution; }
    public void setQueryResolution(int queryResolution) { this.queryResolution = queryResolution; }

    public int getInteractivity() { return interactivity; }
    public void setInteractivity(int interactivity) { this.interactivity = interactivity; }

    public int getImpactfulLearning() { return impactfulLearning; }
    public void setImpactfulLearning(int impactfulLearning) { this.impactfulLearning = impactfulLearning; }

    public int getContentDeliverySkills() { return contentDeliverySkills; }
    public void setContentDeliverySkills(int contentDeliverySkills) { this.contentDeliverySkills = contentDeliverySkills; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
}
