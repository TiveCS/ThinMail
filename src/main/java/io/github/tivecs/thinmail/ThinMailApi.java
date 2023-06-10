package io.github.tivecs.thinmail;

import io.github.tivecs.thinmail.api.database.ThinMailDatabase;

public final class ThinMailApi {

    private static ThinMailApi instance;

    private final ThinMailDatabase database;

    public static ThinMailApi getInstance() {
        if (instance == null){
            throw new RuntimeException("ThinMailApi is not initialized yet");
        }

        return instance;
    }

    ThinMailApi(ThinMail plugin) {
        instance = this;

        this.database = new ThinMailDatabase(plugin);
    }

    public ThinMailDatabase getDatabase() {
        return database;
    }
}
