package com.example.used;

public class Used {

    private int totalCount;
    private boolean showSimilarCarsLink;
    private String searchPageDescription;

    public Used(int totalCount, boolean showSimilarCarsLink, String searchPageDescription) {
        this.totalCount = totalCount;
        this.showSimilarCarsLink = showSimilarCarsLink;
        this.searchPageDescription = searchPageDescription;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isShowSimilarCarsLink() {
        return showSimilarCarsLink;
    }

    public void setShowSimilarCarsLink(boolean showSimilarCarsLink) {
        this.showSimilarCarsLink = showSimilarCarsLink;
    }

    public String getSearchPageDescription() {
        return searchPageDescription;
    }

    public void setSearchPageDescription(String searchPageDescription) {
        this.searchPageDescription = searchPageDescription;
    }
}
