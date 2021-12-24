package be.hevelaska.mobile.ui.gestionDog;

import androidx.annotation.Nullable;

public class AddDogResult {

    @Nullable
    private Integer error;

    public AddDogResult(@Nullable Integer error) {
        this.error = error;
    }

    @Nullable
    Integer getError() {
        return error;
    }
}
