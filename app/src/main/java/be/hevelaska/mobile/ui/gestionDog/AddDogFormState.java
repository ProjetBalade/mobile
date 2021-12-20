package be.hevelaska.mobile.ui.gestionDog;

import androidx.annotation.Nullable;

public class AddDogFormState {

    @Nullable
    private String nameDogError;
    @Nullable
    private String raceDogError;
    @Nullable
    private String dateOfBirthError;
    @Nullable
    private Integer idUserError;

    private boolean isDataValid;

    public AddDogFormState(@Nullable String nameDogError, @Nullable String raceDogError, @Nullable String dateOfBirthError, int idUserError, boolean isDataValid) {
        this.nameDogError = nameDogError;
        this.raceDogError = raceDogError;
        this.dateOfBirthError = dateOfBirthError;
        this.idUserError = idUserError;
        this.isDataValid = isDataValid;
    }

    AddDogFormState(boolean isDataValid) {
        this.nameDogError = null;
        this.raceDogError = null;
        this.dateOfBirthError = null;
        this.idUserError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    public String getNameDogError() {
        return nameDogError;
    }

    @Nullable
    public String getDateOfBirthError() {
        return dateOfBirthError;
    }

    @Nullable
    public Integer getIdUserError() {
        return idUserError;
    }

    public boolean isDataValid() {
        return isDataValid;
    }
}
