package com.back.utils.url.youtube;

import com.back.utils.url.PatternExtractor;
import com.back.utils.url.VideoIdExtractor;
import jakarta.validation.constraints.NotNull;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

/**
 * Parser for extracting YouTube video IDs from various URL formats.
 * Supports: youtu.be, watch, embed, shorts, live, attribution_link, oembed, etc.
 */
public class YouTubeVideoIdParser {

    private static final String VIDEO_ID = "([a-zA-Z0-9_-]{11})";

    private static final List<VideoIdExtractor> EXTRACTORS = List.of(
            // youtu.be short URLs
            // Example: https://youtu.be/AAAAAAAAAAA
            new PatternExtractor("(?:https?://)?(?:www\\.)?youtu\\.be/" + VIDEO_ID),

            // Standard watch URLs with v= or vi= parameter
            // Example: https://www.youtube.com/watch?v=AAAAAAAAAAA
            new PatternExtractor("(?:https?://)?(?:www\\.|m\\.)?youtube(?:-nocookie)?\\.com/.*[?&]v(?:i)?=" + VIDEO_ID),

            // Embed URLs
            // Example: https://www.youtube.com/embed/AAAAAAAAAAA
            new PatternExtractor("(?:https?://)?(?:www\\.)?youtube(?:-nocookie)?\\.com/embed/(?:watch\\?.*v=)?" + VIDEO_ID),

            // YouTube Shorts
            // Example: https://www.youtube.com/shorts/AAAAAAAAAAA
            new PatternExtractor("(?:https?://)?(?:www\\.)?youtube\\.com/shorts/" + VIDEO_ID),

            // YouTube Live
            // Example: https://www.youtube.com/live/AAAAAAAAAAA
            new PatternExtractor("(?:https?://)?(?:www\\.)?youtube\\.com/live/" + VIDEO_ID),

            // Path-based URLs (v/, vi/, e/, watch/)
            // Example: https://www.youtube.com/v/AAAAAAAAAAA
            new PatternExtractor("(?:https?://)?(?:www\\.)?youtube(?:-nocookie)?\\.com/(?:v|vi|e|watch)/" + VIDEO_ID),

            // Attribution link URLs
            // Example: http://www.youtube.com/attribution_link?u=/watch?v=AAAAAAAAAAA
            new PatternExtractor("(?:https?://)?(?:www\\.)?youtube\\.com/attribution_link\\?.*[?&]u=[^&]*[?&]v=" + VIDEO_ID),

            // OEmbed URLs
            // Example: http://www.youtube.com/oembed?url=http://www.youtube.com/watch?v=AAAAAAAAAAA
            new PatternExtractor("(?:https?://)?(?:www\\.)?youtube\\.com/oembed\\?.*url=.*[?&]v(?:%3D|=)" + VIDEO_ID),

            // YouTube Screening Room
            // Example: http://www.youtube.com/ytscreeningroom?v=AAAAAAAAAAA
            new PatternExtractor("(?:https?://)?(?:www\\.)?youtube\\.com/ytscreeningroom\\?v=" + VIDEO_ID),

            // Fallback: any URL with v= parameter
            new PatternExtractor("[?&]v=" + VIDEO_ID)
    );

    /**
     * Extracts YouTube video ID from URL.
     *
     * @param url YouTube URL
     * @return video ID (11 characters) or null if not found
     */
    public static String extractVideoId(@NotNull String url) {
        if (url == null || url.isEmpty()) {
            return null;
        }

        String decodedUrl = decodeUrl(url);

        return EXTRACTORS.stream()
                .map(extractor -> extractor.extract(decodedUrl))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }

    /**
     * Decodes URL-encoded strings (e.g., %3D to =).
     *
     * @param url URL to decode
     * @return decoded URL, or original if decoding fails
     */
    private static String decodeUrl(String url) {
        if (url == null || !url.contains("%")) {
            return url;
        }

        try {
            return URLDecoder.decode(url, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return url;
        }
    }
}
