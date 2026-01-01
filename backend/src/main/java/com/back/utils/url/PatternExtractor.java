package com.back.utils.url;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pattern-based video ID extractor.
 * Uses a single regex pattern to extract video IDs from URLs.
 *
 * This class can be reused across different video platforms (YouTube, Vimeo, Twitch, etc.)
 * by providing appropriate regex patterns.
 */
public class PatternExtractor implements VideoIdExtractor {

    private final Pattern pattern;

    /**
     * Creates a new pattern-based extractor.
     *
     * @param regex Regular expression with exactly one capturing group for the video ID
     */
    public PatternExtractor(String regex) {
        if (regex == null || regex.isEmpty()) {
            throw new IllegalArgumentException("Regex pattern cannot be null or empty");
        }
        this.pattern = Pattern.compile(regex);
    }

    /**
     * Creates a new pattern-based extractor with pre-compiled pattern.
     *
     * @param pattern Pre-compiled Pattern with one capturing group for the video ID
     */
    public PatternExtractor(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("Pattern cannot be null");
        }
        this.pattern = pattern;
    }

    /**
     * Extracts video ID from URL using the configured pattern.
     *
     * @param url URL to extract video ID from
     * @return video ID if found, null otherwise
     */
    @Override
    public String extract(String url) {
        if (url == null || url.isEmpty()) {
            return null;
        }

        Matcher matcher = pattern.matcher(url);
        return matcher.find() ? matcher.group(1) : null;
    }
}
