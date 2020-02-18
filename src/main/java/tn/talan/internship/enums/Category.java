package tn.talan.internship.enums;

public enum Category {
    SANTE("Santé"),
    HYGIENE("Hygiéne"),
    ALIMENTATION("Alimentation");

    private String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
