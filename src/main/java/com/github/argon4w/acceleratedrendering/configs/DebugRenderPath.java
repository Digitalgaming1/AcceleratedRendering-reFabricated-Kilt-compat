package com.github.argon4w.acceleratedrendering.configs;

public enum DebugRenderPath {
    DISABLED,
    ENTITY_CACHE_STATUS,
    FULL_OPTIMIZATION_STATE;

    public boolean isEnabled() {
        return this != DISABLED;
    }
}