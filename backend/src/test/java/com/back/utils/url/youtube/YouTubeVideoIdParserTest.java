package com.back.utils.url.youtube;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("YouTube URL 파서 테스트")
class YouTubeVideoIdParserTest {
    // 샘플 비디오 ID
    private final String targetVideoId = "AAAAAAAAAAA";

    @ParameterizedTest
    @ValueSource(strings = {
            "https://m.youtube.com/watch%3Fv%3DAAAAAAAAAAA&ved=2ahUKEwjkrsSipPP1AhXsyjGHb0CDU4Qx8BegQIBRAF&usg=AOvVaw0A7aB50nUUeTwX_Haoteft",
            "http://www.youtube-nocookie.com/embed/AAAAAAAAAAA?rel=0",
            "http://www.youtube-nocookie.com/v/AAAAAAAAAAA?version=3&hl=en_US&rel=0",
            "http://www.youtube.com/?feature=player_embedded&v=AAAAAAAAAAA",
            "http://www.youtube.com/embed/watch?feature=player_embedded&v=AAAAAAAAAAA",
            "http://www.youtube.com/watch?feature=player_embedded&v=AAAAAAAAAAA",
            "https://www.youtube.com/embed/watch?feature=player_embedded&v=AAAAAAAAAAA",
            "https://m.youtube.com/watch?app=desktop&v=AAAAAAAAAAA",
            "http://www.youtube.com/attribution_link?a=JdfC0C9V6ZI&u=%2Fwatch%3Fv%3DAAAAAAAAAAA%26feature%3Dshare",
            "http://www.youtube.com/attribution_link?u=/watch?v=AAAAAAAAAAA&feature=share",
            "https://www.youtube.com/attribution_link?a=8g8kPrPIi-ecwIsS&u=/watch%3Fv%3DAAAAAAAAAAA%26feature%3Dem-uploademail",
            "http://www.youtube.com/e/AAAAAAAAAAA",
            "http://www.youtube.com/embed/AAAAAAAAAAA",
            "http://www.youtube.com/embed/AAAAAAAAAAA?rel=0",
            "http://www.youtube.com/oembed?url=http%3A//www.youtube.com/watch?v%3DAAAAAAAAAAA&format=json",
            "http://www.youtube.com/v/AAAAAAAAAAA",
            "http://www.youtube.com/v/AAAAAAAAAAA?fs=1&hl=en_US&rel=0",
            "http://www.youtube.com/v/AAAAAAAAAAA?version=3&autohide=1",
            "www.youtube.com/watch?v=AAAAAAAAAAA",
            "http://www.youtube.com/watch?v=AAAAAAAAAAA",
            "http://www.youtube.com/watch?v=AAAAAAAAAAA#t=0m10s",
            "http://www.youtube.com/watch?v=AAAAAAAAAAA&feature=feedrec_grec_index",
            "http://www.youtube.com/watch?v=AAAAAAAAAAA&feature=youtu.be",
            "https://www.youtube.com/watch?t=2724&v=AAAAAAAAAAA&feature=youtu.be",
            "https://www.youtube.com/watch?v=AAAAAAAAAAA#t=0m10s",
            "http://www.youtube.com/watch?v=AAAAAAAAAAA&feature=youtube_gdata_player",
            "https://www.youtube.com/watch?v=AAAAAAAAAAA&feature=em-uploademail",
            "https://www.youtube.com/watch?v=AAAAAAAAAAA&feature=feedrec_grec_index",
            "https://www.youtube.com/watch?v=AAAAAAAAAAA&list=PLGup6kBfcU7Le5laEaCLgTKtlDcxMqGxZ&index=106&shuffle=2655",
            "http://www.youtube.com/watch?v=AAAAAAAAAAA&playnext_from=TL&videos=osPknwzXEas&feature=sub",
            "http://www.youtube.com/ytscreeningroom?v=AAAAAAAAAAA",
            "youtu.be/AAAAAAAAAAA",
            "youtube.com/watch?v=AAAAAAAAAAA",
            "http://youtu.be/AAAAAAAAAAA?feature=youtube_gdata_player",
            "http://youtube.com/?feature=channel&v=AAAAAAAAAAA",
            "http://www.youtube.com/?v=AAAAAAAAAAA&feature=youtube_gdata_player",
            "http://youtube.com/?vi=AAAAAAAAAAA&feature=youtube_gdata_player",
            "http://youtube.com/embed/AAAAAAAAAAA",
            "http://youtube.com/v/AAAAAAAAAAA?feature=youtube_gdata_player",
            "http://youtube.com/vi/AAAAAAAAAAA&feature=channel",
            "http://youtube.com/vi/AAAAAAAAAAA?feature=youtube_gdata_player",
            "http://youtube.com/watch?v=AAAAAAAAAAA&feature=youtube_gdata_player",
            "http://youtube.com/watch?vi=AAAAAAAAAAA&feature=youtube_gdata_player",
            "https://m.youtube.com/watch?v=AAAAAAAAAAA",
            "https://www.youtube-nocookie.com/embed/AAAAAAAAAAA?rel=0",
            "https://www.youtube.com/embed/watch?v=AAAAAAAAAAA",
            "https://www.youtube.com/embed/AAAAAAAAAAA?rel=0",
            "https://www.youtube.com/v/AAAAAAAAAAA?fs=1&amp;hl=en_US&amp;rel=0",
            "https://www.youtube.com/watch/AAAAAAAAAAA",
            "https://youtu.be/AAAAAAAAAAA?list=PLToa5JuFMsXTNkrLJbRlB--76IAOjRM9b",
            "https://youtube.com/shorts/AAAAAAAAAAA?feature=share",
            "https://youtu.be/AAAAAAAAAAA",
            "https://www.youtube.com/watch?time_continue=88&v=AAAAAAAAAAA&feature=emb_title"
    })
    @DisplayName("YouTube URL에서 비디오 ID 추출 테스트 - 성공")
    void urlParse_success(String url) {
        String extracted = YouTubeVideoIdParser.extractVideoId(url);
        assertThat(extracted).isEqualTo(targetVideoId);
    }
}