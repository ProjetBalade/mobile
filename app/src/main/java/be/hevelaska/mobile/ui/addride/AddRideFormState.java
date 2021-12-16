package be.hevelaska.mobile.ui.addride;

import androidx.annotation.Nullable;

public class AddRideFormState {

    @Nullable
    private Integer ridenameError;
    @Nullable
    private Integer adresseError;
    @Nullable
    private Integer descriptionError;
    @Nullable
    private Integer siteWebError;
    @Nullable
    private Integer difficultyError;
    @Nullable
    private Integer scheduleError;
    @Nullable
    private Integer photoError;
    @Nullable
    private Integer scoreError;

    private boolean isDataValid;

    AddRideFormState(@Nullable Integer ridenameError, @Nullable Integer adresseError, @Nullable Integer descriptionError, @Nullable Integer siteWebError, @Nullable Integer difficultyError, @Nullable Integer scheduleError, @Nullable Integer photoError, @Nullable Integer scoreError) {
        this.ridenameError = ridenameError;
        this.adresseError = adresseError;
        this.descriptionError = descriptionError;
        this.siteWebError = siteWebError;
        this.difficultyError = difficultyError;
        this.scheduleError = scheduleError;
        this.photoError = photoError;
        this.scoreError = scoreError;
        this.isDataValid = false;
    }

    AddRideFormState(boolean isDataValid){
        this.ridenameError = null;
        this.adresseError = null;
        this.descriptionError = null;
        this.siteWebError = null;
        this.difficultyError = null;
        this.scheduleError = null;
        this.photoError = null;
        this.scoreError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    public Integer getRidenameError() {
        return ridenameError;
    }

    @Nullable
    public Integer getAdresseError() {
        return adresseError;
    }

    @Nullable
    public Integer getDescriptionError() {
        return descriptionError;
    }

    @Nullable
    public Integer getSiteWebError() {
        return siteWebError;
    }

    @Nullable
    public Integer getDifficultyError() {
        return difficultyError;
    }

    @Nullable
    public Integer getScheduleError() {
        return scheduleError;
    }

    @Nullable
    public Integer getPhotoError() {
        return photoError;
    }

    @Nullable
    public Integer getScoreError() {
        return scoreError;
    }

    public boolean isDataValid() {
        return isDataValid;
    }
}
