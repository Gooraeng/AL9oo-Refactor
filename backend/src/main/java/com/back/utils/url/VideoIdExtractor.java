package com.back.utils.url;

/**
 * Interface for extracting video IDs from platform-specific URLs.
 * Implementations should handle various URL formats for their respective platforms
 * (e.g., YouTube, Vimeo, Twitch, etc.)
 */
public interface VideoIdExtractor {
    /**
     * Extracts video ID from the given URL.
     *
     * @param url Platform-specific video URL
     * @return Video ID if extraction succeeds, null otherwise
     */
    String extract(String url);
}
