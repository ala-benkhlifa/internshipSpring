package tn.talan.internship.enums;

public enum CategoryEnum {
    SANTE("Santé"),
    HYGIENE("Hygiéne"),
    ALIMENTATION("Alimentation");

    private String categoryName;

    CategoryEnum(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
