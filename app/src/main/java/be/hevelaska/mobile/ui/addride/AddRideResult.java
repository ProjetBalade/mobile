package be.hevelaska.mobile.ui.addride;

import androidx.annotation.Nullable;

public class AddRideResult {
    @Nullable
    private Integer error;

    public AddRideResult(@Nullable Integer error) {
        this.error = error;
    }

    @Nullable
    Integer getError() {
        return error;
    }
}
